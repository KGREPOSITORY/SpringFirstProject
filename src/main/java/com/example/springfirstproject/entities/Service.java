package com.example.springfirstproject.entities;

import com.example.springfirstproject.enums.ServiceName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "services")
public class Service extends AbstractEntity {

    @Column(name = "name")
    @NotNull
    private ServiceName serviceName;
    @Column(name = "cost")
    @NotNull
    private double cost;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "service_providers",
            joinColumns = @JoinColumn(name="serviceID"),
            inverseJoinColumns = @JoinColumn(name ="masterID")
    )
    private List<Master> masters;
    @OneToMany(mappedBy = "service",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<ServiceProvider> serviceProviders;

    public Service() {
    }

    public Service(ServiceName serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName=" + serviceName +
                ", cost=" + cost +
                '}';
    }
}
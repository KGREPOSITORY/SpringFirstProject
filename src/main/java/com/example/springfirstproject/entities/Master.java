package com.example.springfirstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "masters")
public class Master extends AbstractEntity{

    @Column(name = "firstName")
    @NotNull
    private String firstName;
    @Column(name = "lastName")
    @NotNull
    private String lastName;
    @Column(name = "phoneNumber")
    @NotNull
    @Pattern(regexp = phoneValidation,
            message = phoneValidationMessage
            )
    private String phoneNumber;
    @ManyToMany(mappedBy = "masters",
            fetch = FetchType.EAGER)
    private List<Service> services;
    @OneToMany(mappedBy = "master",
            fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<ServiceProvider> serviceProviders;

    public Master() {
    }

    public Master(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    @Override
    public String toString() {
        return "Master{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", services=" + services +
                '}';
    }
}
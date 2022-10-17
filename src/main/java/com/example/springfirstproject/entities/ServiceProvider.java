package com.example.springfirstproject.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service_providers")
public class ServiceProvider extends AbstractEntity{

    @Column(name = "serviceID")
    @NotNull
    private int serviceID;
    @Column(name = "masterID")
    @NotNull
    private long masterID;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID",
            nullable = false,
            insertable = false,
            updatable = false)
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterID",
            nullable = false,
            insertable = false,
            updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Master master;


    public ServiceProvider(int serviceID, long masterID) {
        this.serviceID = serviceID;
        this.masterID = masterID;
    }

    public ServiceProvider() {
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public long getMasterID() {
        return masterID;
    }

    public void setMasterID(long masterID) {
        this.masterID = masterID;
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "serviceID=" + serviceID +
                ", masterID=" + masterID +
                '}';
    }
}
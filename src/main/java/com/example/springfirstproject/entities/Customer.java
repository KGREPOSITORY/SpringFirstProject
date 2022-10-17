package com.example.springfirstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity{

    @Column(name = "firstName")
    @NotNull
    private String firstName;
    @Column(name = "lastName")
    @NotNull
    private String lastName;
    @Column(name = "phoneNumber")
    @NotNull
    @Pattern(regexp = phoneValidation,
            message = phoneValidationMessage)
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    @JsonIgnore
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders=" + orders +
                '}';
    }
}

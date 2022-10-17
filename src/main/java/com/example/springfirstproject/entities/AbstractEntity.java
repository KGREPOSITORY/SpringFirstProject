package com.example.springfirstproject.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Transient
    protected final String phoneValidation = "^\\+375(25|29|33|44)\\d{7}$"; //should be moved to .properties file
    @Transient
    protected final String phoneValidationMessage =
            "The phone number must match according to the following pattern: +375(25|29|33|44){7 digits}"; //should be moved to .properties file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

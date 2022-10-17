package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.AbstractService;
import com.example.springfirstproject.dao.interfaces.ServiceRepository;
import com.example.springfirstproject.entities.Service;

@org.springframework.stereotype.Service
public class ServiceService extends AbstractService<Service, ServiceRepository> {

    public ServiceService(ServiceRepository repository) {
        super(repository);
    }
}

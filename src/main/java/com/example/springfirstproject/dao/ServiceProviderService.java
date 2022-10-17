package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.interfaces.ServiceProviderRepository;
import com.example.springfirstproject.entities.ServiceProvider;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService extends AbstractService<ServiceProvider, ServiceProviderRepository> {

    public ServiceProviderService(ServiceProviderRepository repository) {
        super(repository);
    }

}

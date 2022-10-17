package com.example.springfirstproject.controllers;

import com.example.springfirstproject.dao.ServiceProviderService;
import com.example.springfirstproject.entities.ServiceProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/serviceProvider")
public class ServiceProviderController extends AbstractController<ServiceProvider, ServiceProviderService>{

    public ServiceProviderController(ServiceProviderService service) {
        super(service);
    }
}

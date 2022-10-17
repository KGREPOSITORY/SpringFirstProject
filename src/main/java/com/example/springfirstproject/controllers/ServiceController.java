package com.example.springfirstproject.controllers;

import com.example.springfirstproject.dao.ServiceService;
import com.example.springfirstproject.entities.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/service")
public class ServiceController extends AbstractController<Service, ServiceService> {

    public ServiceController(ServiceService service) {
        super(service);
    }
}

package com.example.springfirstproject.controllers;

import com.example.springfirstproject.dao.CustomerService;
import com.example.springfirstproject.entities.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<Customer, CustomerService>{

    public CustomerController(CustomerService service) {
        super(service);
    }
}

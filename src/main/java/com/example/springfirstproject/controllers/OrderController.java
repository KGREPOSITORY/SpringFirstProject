package com.example.springfirstproject.controllers;

import com.example.springfirstproject.dao.OrderService;
import com.example.springfirstproject.entities.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends AbstractController<Order, OrderService> {

    public OrderController(OrderService service) {
        super(service);
    }
}

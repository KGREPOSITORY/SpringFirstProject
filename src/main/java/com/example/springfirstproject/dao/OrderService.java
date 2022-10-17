package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.interfaces.OrderRepository;
import com.example.springfirstproject.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order, OrderRepository>{

    public OrderService(OrderRepository repository) {
        super(repository);
    }
}

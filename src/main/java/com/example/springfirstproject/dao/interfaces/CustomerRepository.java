package com.example.springfirstproject.dao.interfaces;

import com.example.springfirstproject.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CommonRepository<Customer>{

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}

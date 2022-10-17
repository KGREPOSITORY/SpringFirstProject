package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.interfaces.CustomerRepository;
import com.example.springfirstproject.entities.Customer;
import com.example.springfirstproject.exeptions.entityException.EntityAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer, CustomerRepository>{


    public CustomerService(CustomerRepository repository){
        super(repository);
    }

    public boolean isCustomerExistByFirstNameAndLastName(Customer customer){
        return repository.existsByFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
    }

    @Override
    public void save(Customer entity) {
        if(!isCustomerExistByFirstNameAndLastName(entity)){
            super.save(entity);
        } else {
            throw new EntityAlreadyExistException("Customer with this first name and last name already exist");
        }
    }
}

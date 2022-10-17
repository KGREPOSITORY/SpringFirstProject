package com.example.springfirstproject.dao.interfaces;

import com.example.springfirstproject.entities.Master;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends CommonRepository<Master>{

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}

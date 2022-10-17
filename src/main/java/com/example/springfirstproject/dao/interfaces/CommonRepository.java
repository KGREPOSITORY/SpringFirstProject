package com.example.springfirstproject.dao.interfaces;

import com.example.springfirstproject.entities.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E,Long> {
}

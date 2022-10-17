package com.example.springfirstproject.dao.interfaces;

import com.example.springfirstproject.entities.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity>{

    void save(E entity);

    List<E> getAll();

    E getById(long id);

    void delete(E entity);

    void deleteById(long id);
}

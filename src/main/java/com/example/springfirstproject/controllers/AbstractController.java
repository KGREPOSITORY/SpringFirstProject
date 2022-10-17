package com.example.springfirstproject.controllers;

import com.example.springfirstproject.controllers.interfaces.CommonController;
import com.example.springfirstproject.dao.interfaces.CommonService;
import com.example.springfirstproject.entities.AbstractEntity;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<E extends AbstractEntity,
                                S extends CommonService<E>>
                                implements CommonController<E> {
    protected final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<E> save(E entity) {
        service.save(entity);
       return new ResponseEntity<>(entity,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<E>> getAll(){
         return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> getById(long id) {
        return new ResponseEntity<E>(service.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> delete(E entity) {
        throw new NotYetImplementedException("Not implemented");
    }

    @Override
    public ResponseEntity<E> deleteById(long id) {
        throw new NotYetImplementedException("Not implemented");
    }
}

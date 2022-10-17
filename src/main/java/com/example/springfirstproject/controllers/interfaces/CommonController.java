package com.example.springfirstproject.controllers.interfaces;

import com.example.springfirstproject.entities.AbstractEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface CommonController<E extends AbstractEntity>{

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Example, there can be some ResponseDTO as return value
    ResponseEntity<E> save(@Valid @RequestBody E entity);

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //Example, there can be some ResponseDTO as return value
    ResponseEntity<List<E>> getAll();

    @GetMapping(path = "/{id}")
    ResponseEntity<E> getById(@PathVariable("id") long id);

    @DeleteMapping
    ResponseEntity<E> delete(@Valid @RequestBody E entity);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<E> deleteById(@RequestParam long id);

}

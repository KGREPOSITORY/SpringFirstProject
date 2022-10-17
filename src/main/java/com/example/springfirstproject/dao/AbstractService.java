package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.interfaces.CommonRepository;
import com.example.springfirstproject.dao.interfaces.CommonService;
import com.example.springfirstproject.entities.AbstractEntity;
import com.example.springfirstproject.exeptions.entityException.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<E extends AbstractEntity,
                                      R extends CommonRepository<E>>
                                        implements CommonService<E> {
    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Override
    public List<E> getAll(){
        return (List<E>) repository.findAll();
    }
    @Override
    public E getById(long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity with id="+id+" doesn't exist"));
    }

    @Override
    public void delete(E entity) {
        getById(entity.getId());
        repository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        getById(id);
        repository.deleteById(id);
    }
}

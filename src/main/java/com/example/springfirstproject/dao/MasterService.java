package com.example.springfirstproject.dao;

import com.example.springfirstproject.dao.interfaces.MasterRepository;
import com.example.springfirstproject.entities.Master;
import com.example.springfirstproject.exeptions.entityException.EntityAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class MasterService extends AbstractService<Master, MasterRepository> {

    public MasterService(MasterRepository repository) {
        super(repository);
    }

    public boolean isMasterExistByFirstNameAndLastName(Master master){
        return repository.existsByFirstNameAndLastName(master.getFirstName(), master.getLastName());
    }

    @Override
    public void save(Master entity) {
        if(!isMasterExistByFirstNameAndLastName(entity)){
            super.save(entity);
        }
        else {
            throw new EntityAlreadyExistException("Master with this first name and last name already exist");

        }

    }
}

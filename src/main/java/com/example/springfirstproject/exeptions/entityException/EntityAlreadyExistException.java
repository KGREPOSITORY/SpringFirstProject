package com.example.springfirstproject.exeptions.entityException;

public class EntityAlreadyExistException extends RuntimeException{

    public EntityAlreadyExistException(String message){
        super(message);
    }
}

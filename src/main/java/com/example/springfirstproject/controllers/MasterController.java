package com.example.springfirstproject.controllers;

import com.example.springfirstproject.dao.MasterService;
import com.example.springfirstproject.entities.Master;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/master")
public class MasterController extends AbstractController<Master, MasterService>{

    public MasterController(MasterService service) {
        super(service);
    }
}

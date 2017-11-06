package com.springrest.rest_controllers;

import com.springrest.model.EpicQuotes;
import com.springrest.services.GOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stark/")
public class GOTController {

    @Autowired
    GOTService service;

    @RequestMapping("/noone")
    public EpicQuotes jaquen() {
        return service.getEpicQuotes();
    }

}

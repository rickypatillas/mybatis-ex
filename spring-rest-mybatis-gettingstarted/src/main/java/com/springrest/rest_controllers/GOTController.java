package com.springrest.rest_controllers;

import com.springrest.exceptions.InvalidRequestException;
import com.springrest.model.EpicQuotes;
import com.springrest.model.User;
import com.springrest.model.nyt.CustomResponseObject;
import com.springrest.services.GOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/stark/")
public class GOTController {

    @Autowired
    GOTService service;

    @RequestMapping("/noone")
    public EpicQuotes jaquen() {
        return service.getEpicQuotes();
    }

    @RequestMapping("/arya")
    public ArrayList<EpicQuotes> wolf() throws InvalidRequestException {
        try {
            return service.insertMultiGoTQuote();
        } catch (InvalidRequestException e) {
           throw e;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bran")
    public ResponseEntity<CustomResponseObject> insertGotQuote() throws InvalidRequestException{
        try {
            CustomResponseObject ironthrone = new CustomResponseObject();
            ironthrone.setMessage("exito!");
            ironthrone.setStatus_code(200);
            ironthrone.setData(service.insertMultiGoTQuote());
            return new ResponseEntity(ironthrone, HttpStatus.OK);
        } catch (InvalidRequestException ea) {
            throw ea;
        }
    }


    //@RequestMapping(method = RequestMethod.PATCH, value = "/")
    //public User updateById(@RequestBody User user) {
      //  return userService.updateById(user);


    /*
    @RequestMapping(method = RequestMethod.GET, value = "/fn/{firstname}")
    public ResponseEntity<CustomResponseObject> getByName(@PathVariable(value = "firstname") String firstname) throws InvalidRequestException {
        try {
            CustomResponseObject cro = new CustomResponseObject();
            cro.setData(userService.getByName(firstname));
            cro.setMessage("success");
            cro.setStatus_code(200);
            return new ResponseEntity(cro, HttpStatus.OK);
        } catch (InvalidRequestException re) {
            throw re;
        }
     */

}

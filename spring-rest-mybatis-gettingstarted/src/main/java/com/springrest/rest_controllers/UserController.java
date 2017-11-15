package com.springrest.rest_controllers;

import java.util.ArrayList;

import com.springrest.exceptions.InvalidRequestException;
import com.springrest.model.User;
import com.springrest.model.nyt.CustomResponseObject;
import com.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //Get
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ArrayList<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getById(@PathVariable(value = "id") int id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/manual")
    public ArrayList<User> getUsersManually() {
        return userService.getAllUsersManually();
    }

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public User addNew(@RequestBody User user) {
        return userService.addNew(user);
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public User updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public User deleteById(@RequestBody User user) {
        return userService.deleteById(user.getId());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/lastname")
    public ArrayList<User> getLastName(@RequestParam (value = "lastname", required = false, defaultValue = "null") String lastname ) throws InvalidRequestException {
        ArrayList<User> users = new ArrayList<>();
        try {
            users = userService.selectByLastName(lastname);
        } catch (InvalidRequestException USA) {
            throw USA;
        }
        return users;

    }

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
    }

}
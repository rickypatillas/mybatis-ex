package com.springrest.rest_controllers;

import java.util.ArrayList;

import com.springrest.model.User;
import com.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //Get
    @RequestMapping(method = RequestMethod.GET, value ="/")
    public ArrayList<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/{id}")
    public User getById(@PathVariable(value="id")int id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/manual")
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
    @RequestMapping(method= RequestMethod.DELETE, value="/")
    public User deleteById(@RequestBody User user){
        return userService.deleteById(user.getId());
    }
}

package com.springrest.rest_controllers;


import com.springrest.model.nyt.NYT_Top;
import com.springrest.model.nyt.TopStories;
import com.springrest.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/NYT")
public class NYTController {

    @Autowired
    NYTService service;

    @RequestMapping("/topstories/load")
    public NYT_Top loadTopStories() {

        return service.getNYT_Top();
    }

    @RequestMapping("/topstories")
    public ArrayList<TopStories> getTopStories(@RequestParam(value = "query", required = false, defaultValue = "null") String query) {
        return service.getAllTopStories(query);
    }

}

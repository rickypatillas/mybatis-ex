package com.springrest.services;

import com.springrest.mappers.NYTMapper;
import com.springrest.model.nyt.Multimedia;
import com.springrest.model.nyt.NYT_Top;
import com.springrest.model.nyt.TopStories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class NYTService {
    //here we connect the website and map their info onto our intellij class

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NYTMapper mapper;

    public NYT_Top getNYT_Top() {
        NYT_Top top = restTemplate.getForObject(
                "https://api.nytimes.com/svc/topstories/v2/home.json?apikey=e87bbc8db5be47ac9e46bc5838455765"
                , NYT_Top.class);

        insertTopStories(top);

        return top;
    }


    public void insertTopStories(NYT_Top stories) {

        //for every result (story) in teh NYT response
        for (TopStories result : stories.getResults()) {

            int id = 0;


            //check to see if the story already exists in our DB
            try {
                id = mapper.getStoryId(result.getUrl());
            } catch (Exception e) {
                id = 0;
            }

            //if id is 0 means it does not exist in out db -  we can insert it
            if (id == 0) {

                //insert story
                int success = mapper.insertTopStory(result);

                /* insertTopStory  return the number of rows inserted - if that number is greater than 0,
                 that means the story was inserted - now we can insert the associate multimedia
                  */
                if (success > 0) {

                    //get the id of the newly insert story to ues for each multimedia record
                    id = mapper.getStoryId(result.getUrl());

                    //for every multimedia record in teh story
                    for (Multimedia media : result.getMultimedia()) {

                        //set the story_id on the multimedia object (associated it with a story in our DB)
                        media.setTop_story_id(id);

                        //insert multimedia
                        mapper.insertMultimedia(media);
                    }
                }
            }
        }

    }


    public ArrayList<TopStories> getAllTopStories(String query) {

        if (!query.equalsIgnoreCase("null")) {
            return mapper.searchTopStories("%" + query + "%");
        } else {
            return mapper.getAllTopStories();
        }

    }
}

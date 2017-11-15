package com.springrest.services;


import com.springrest.exceptions.InvalidRequestException;
import com.springrest.mappers.Drakaris;
import com.springrest.model.EpicQuotes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class GOTService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Drakaris mapper;

    public EpicQuotes getEpicQuotes() {
        EpicQuotes object = restTemplate.getForObject("https://got-quotes.herokuapp.com/quotes",
                EpicQuotes.class);

        insertQuote(object);
        System.out.println(object.toString());

        return object;

    }

    public ArrayList<EpicQuotes> insertMultiGoTQuote() throws InvalidRequestException {

        ArrayList<EpicQuotes> arrayOfQuotes = new ArrayList<>();
        for( int i = 0; i < 5; i++){
            EpicQuotes quote = restTemplate.getForObject("https://got-quotes.herokuapp.com/quotes", EpicQuotes.class);
            arrayOfQuotes.add(quote);//populating the arraylist
            insertQuote(quote); //will place them on teh db
        }
        return arrayOfQuotes;
    }

    public EpicQuotes insertQuote(EpicQuotes drogo) {

        mapper.insertBadAssQuote(drogo);

        return drogo;
    }

}

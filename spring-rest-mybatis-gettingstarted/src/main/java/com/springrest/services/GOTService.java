package com.springrest.services;


import com.springrest.mappers.Drakaris;
import com.springrest.model.EpicQuotes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

        return object;
    }

    public void insertQuote(EpicQuotes drogo) {
        mapper.insertBadAssQuote(drogo);

    }

}

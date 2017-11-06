package com.springrest.mappers;


import com.springrest.model.EpicQuotes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Drakaris {

    String GET_THE_BEST_QUOTES = "SELECT * FROM `mybatis-test`.game_of_thrones";

    String INSERT_BADASS_QUOTE = "Insert into `mybatis-test`.game_of_thrones( quote, character) values ( #{quote}, #{character})";


    @Select(GET_THE_BEST_QUOTES)
    public EpicQuotes epicQuotes();

    @Insert(INSERT_BADASS_QUOTE)
    public int insertBadAssQuote(EpicQuotes epicQuotes);





}

package com.springrest.mappers;
//
//
import com.springrest.model.EpicQuotes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//
@Mapper
public interface Drakaris {

    String GET_THE_BEST_QUOTES = "SELECT * FROM `first_rds`.game_of_thrones";
    String INSERT_BADASS_QUOTE = "Insert into `first_rds`.game_of_thrones (quote, character) values (#{quote}, #{character})";
    String INSERT_TEST = "INSERT INTO `first_rds`.`game_of_thrones` (`quote`, `character`) VALUES (#{quote}, #{character})";

    @Select(GET_THE_BEST_QUOTES)
    public EpicQuotes epicQuotes();

    @Insert(INSERT_TEST)
    public int insertBadAssQuote(EpicQuotes epicQuotes);

}

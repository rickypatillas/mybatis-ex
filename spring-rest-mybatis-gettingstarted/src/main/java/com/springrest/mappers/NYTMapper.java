package com.springrest.mappers;

import com.springrest.model.nyt.Multimedia;
import com.springrest.model.nyt.TopStories;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NYTMapper {

    //query to know if top story exists in db - using url
    String GET_STORY_ID = "SELECT id FROM `first_rds`.nyt_top_stories where url = #{url}";

    //query to insert new top story
    String INSERT_TOP_STORY = "Insert into `first_rds`.nyt_top_stories (section, subsection, title, url, byline," +
            "item_type, update_date, created_date, published_date, material_type_facet, kicker, short_url)" +
            "values (#{section}, #{subsection}, #{title}, #{url}, #{byline}, #{item_type}, #{update_date}," +
            "#{created_date}, #{published_date}, #{material_type_facet}, #{kicker}, #{short_url})";

    //query to get id of the latest top story to be used to insert multimedia
    String INSERT_MULTIMEDIA = "insert into `first_rds`.multimedia (top_story_id, url, format, height, width, type," +
            "subtype, caption, copyright) values (#{top_story_id}, #{url}, #{format}, #{height}, #{width}, #{type}, #{subtype}," +
            "#{caption}, #{copyright})";


    String SELECT_ALL_TOP_STORIES = "SELECT * FROM `first_rds`.nyt_top_stories";

    String SELECT_WITH_SEARCH_PARAM = "SELECT * FROM `first_rds`.nyt_top_stories where title like #{query}";

    String SELECT_STORIES_BY_SECTION = "Select * FROM `first_rds`.nyt_top_stories  where section =  #{section} " +
            "order by created_date desc limit 10";

    String CHECK_SECTION_EXISTS = "Select id from `first_rds`.nyt_top_stories  where section = #{section}" +
            "limit 1";

    @Select(GET_STORY_ID)
    public int getStoryId(String url);

    @Select(SELECT_ALL_TOP_STORIES)
    public ArrayList<TopStories> getAllTopStories();

    @Select(SELECT_WITH_SEARCH_PARAM)
    public ArrayList<TopStories> searchTopStories(String query);


    @Select(SELECT_STORIES_BY_SECTION)
    public ArrayList<TopStories> searchBySection(String section);

    @Select(CHECK_SECTION_EXISTS)
    public int checkIfSectionExists(String section);


    @Insert(INSERT_TOP_STORY)
    public int insertTopStory(TopStories story);

    @Insert(INSERT_MULTIMEDIA)
    public int insertMultimedia(Multimedia multimedia);


}

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
    String GET_STORY_ID = "SELECT id FROM `mybatis-test`.nyt_top_stories where url = #{url}";

    //query to insert new top story
    String INSERT_TOP_STORY = "Insert into `mybatis-test`.nyt_top_stories (section, subsection, title, url, byline," +
            "item_type, update_date, created_date, published_date, material_type_facet, kicker, short_url)" +
            "values (#{section}, #{subsection}, #{title}, #{url}, #{byline}, #{item_type}, #{update_date}," +
            "#{created_date}, #{published_date}, #{material_type_facet}, #{kicker}, #{short_url})";

    //query to get id of the latest top story to be used to insert multimedia
    String INSERT_MULTIMEDIA = "insert into `mybatis-test`.multimedia (top_story_id, url, format, height, width, type," +
            "subtype, caption, copyright) values (#{top_story_id}, #{url}, #{format}, #{height}, #{width}, #{type}, #{subtype}," +
            "#{caption}, #{copyright})";


    String SELECT_ALL_TOP_STORIES = "SELECT * FROM `mybatis-test`.nyt_top_stories";

    String SELECT_WITH_SEARCH_PARAM = "SELECT * FROM `mybatis-test`.nyt_top_stories where title like #{query}";

    @Select(GET_STORY_ID)
    public int getStoryId(String url);

    @Select(SELECT_ALL_TOP_STORIES)
    public ArrayList<TopStories> getAllTopStories();

    @Select(SELECT_WITH_SEARCH_PARAM)
    public ArrayList<TopStories> searchTopStories(String query);


    @Insert(INSERT_TOP_STORY)
    public int insertTopStory(TopStories story);

    @Insert(INSERT_MULTIMEDIA)
    public int insertMultimedia(Multimedia multimedia);


}

package com.springrest.mappers;

import com.springrest.model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

/**
 * Created by tanerali on 24/07/2017.
 */

@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `first_rds`.users where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `first_rds`.users where id = #{id}";
    String INSERT_USER = "INSERT INTO `first_rds`.users (first_name, last_name, isActive) " +
            "VALUES (#{first_name}, #{last_name}, #{isActive})";
    String UPDATE_USER = "UPDATE `first_rds`.users SET first_name = #{first_name}, " +
            "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";
    String DELETE_USER = "UPDATE `first_rds`.users set isActive = 0 WHERE id = #{id}";
    String GET_BY_NAME = "SELECT * FROM `first_rds`.users where first_name = #{first_name}";
    //exceptiono handling for GET
    String SELECT_LAST_NAMES = "SELECT * FROM `first_rds`.users where last_name = #{last_name}";
    //exception handling for another GEt



    @Select(GET_BY_NAME)
    public User getByName(String name);

    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Insert(INSERT_USER)
    public int insertUser (User user);

    @Update(UPDATE_USER)
    public int updateUser (User user);

    @Delete(DELETE_USER)
    public int deleteUser(int id);

    @Select(SELECT_LAST_NAMES)
    public ArrayList<User> selectByLastName(String lastName);


}
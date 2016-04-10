/**
 * UserMapper
 * 2016/04/06
 * zhangchunming
 */
package com.mybatis.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis.bean.User;

public interface UserMapper {   
    @Select("SELECT * FROM tbl_user WHERE 1=1")
    @Results(
      {
        @Result(id = true, column = "uid", property = "uid"),
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age")
      })  
    public List<User> getAllUser();

    @Select("SELECT * FROM tbl_user WHERE uid=#{uid}")
    @Results(
      {
        @Result(id = true, column = "uid", property = "uid"),
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age")
      })
    public User getUser(int uid);

    @Insert("INSERT INTO tbl_user(name,age) VALUES(#{name},#{age})")
    public void addUser(User user);
}
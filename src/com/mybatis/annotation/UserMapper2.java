/**
 * UserMapper2
 * 2016/04/06
 * zhangchunming
 */
package com.mybatis.annotation;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.mybatis.bean.User;
import com.mybatis.help.UserSqlProvider;

public interface UserMapper2 {   
    @SelectProvider(type = UserSqlProvider.class, method = "getAllUser")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    @ResultMap(value = "UserResult") 
    public List<User> getAllUser();

    @SelectProvider(type = UserSqlProvider.class, method = "getUser")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    @ResultMap(value = "UserResult") 
    public User getUser(@Param("uid") int uid);

    @InsertProvider(type = UserSqlProvider.class, method = "addUser")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    public void addUser(@Param("user") User user);
}
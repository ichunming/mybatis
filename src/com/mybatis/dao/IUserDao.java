/**
 * IUserDao
 * 2016/04/05
 * zhangchunming
 */
package com.mybatis.dao;

import java.util.List;
import com.mybatis.bean.User;

public interface IUserDao {
	public List<User> getAllUser();
	
	public User getUser(int uid);
	
	public void addUser(User user);
}

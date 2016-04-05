/**
 * Test
 * 2016/03/31
 * zhangchunming
 */
package com.mybatis.test;

import java.util.List;

import com.mybatis.bean.User;
import com.mybatis.dao.IUserDao;
import com.mybatis.dao.UserDaoImpl;

public class Test {

	public static void main(String[] args) {
		IUserDao userDao = new UserDaoImpl();
		/*User user = new User();
		user.setName("Jack");
		user.setAge("25");
		userDao.addUser(user);*/
		
		/*User result = userDao.getUser(2);
		System.out.println(result.getName() + "   " + result.getAge());*/
		
		List<User> userList = userDao.getAllUser();
		
		for(int i=0; i<userList.size(); i++) {
			System.out.println(userList.get(i).getName() + "   " + userList.get(i).getAge());
		}
	}

}

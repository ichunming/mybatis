/**
 * Test
 * 2016/03/31
 * zhangchunming
 */
package com.mybatis.test;

import java.util.ArrayList;
import java.util.List;

import com.mybatis.bean.User;
import com.mybatis.dao.IUserDao;
import com.mybatis.dao.UserDaoImpl;

public class Test {

	public static void main(String[] args) {
		IUserDao userDao = new UserDaoImpl();
		// test add user
		/*User user = new User();
		user.setName("Jack");
		user.setAge("25");
		userDao.addUser(user);*/
		
		// test get user
		/*User result = userDao.getUser(2);
		System.out.println(result.getName() + "   " + result.getAge());*/
		
		// test search users by name age
		List<User> sbynauserList = userDao.searchUserByNameAge("im", "");
		System.out.println("search users by name and age:");
		for(int i=0; i<sbynauserList.size(); i++) {
			System.out.println(sbynauserList.get(i).getName() + "   " + sbynauserList.get(i).getAge());
		}
		
		// test search users by ids
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(4);
		List<User> sbyiduserList = userDao.searchUserById(ids);
		System.out.println("search users by ids:");
		for(int i=0; i<sbyiduserList.size(); i++) {
			System.out.println(sbyiduserList.get(i).getName() + "   " + sbyiduserList.get(i).getAge());
		}
		
		// test update user
		User uuser = userDao.getUser(2);
		if(null != uuser){
			uuser.setName("Jack John");
			uuser.setAge("27");
		}
		userDao.updateUser(uuser);
		
		// test delete user
		User duser = new User();
		duser.setName("Test");
		duser.setAge("0");
		userDao.addUser(duser);
		List<User> duserList = userDao.searchUserByNameAge("Test", "0");
		if(null != duserList){
			System.out.println("test data add success!");
			userDao.deleteUser(duserList.get(0).getUid());
		}
		
		// test get all users
		List<User> userList = userDao.getAllUser();
		for(int i=0; i<userList.size(); i++) {
			System.out.println(userList.get(i).getName() + "   " + userList.get(i).getAge());
		}
	}

}

/**
 * UserDaoImpl
 * 2016/03/31
 * zhangchunming
 */
package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.bean.User;
import com.mybatis.db.DBAccess;

public class UserDaoImpl implements IUserDao{
	
	/**
	 * get all users
	 */
	@Override
	public List<User> getAllUser() {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<User> userList = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			userList = sqlSession.selectList("User.getAllUser");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
		return userList;
	}
	
	/**
	 * get user by uid
	 */
	@Override
	public User getUser(int uid) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			return sqlSession.selectOne("User.getUser", uid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
		return null;
	}
	
	/**
	 * add user
	 */
	@Override
	public void addUser(User user) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("User.addUser", user);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
	}
}

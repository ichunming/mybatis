package com.mybatis.annotation.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.bean.User;
import com.mybatis.db.DBAccess;
import com.mybatis.annotation.UserMapper;

public class Test {
	public static void main(String[] args) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		UserMapper userMapper = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			userMapper = sqlSession.getMapper(UserMapper.class);
			
			List<User> userList = userMapper.getAllUser();
			
			for(int i=0; i<userList.size(); i++) {
				System.out.println(userList.get(i).getName() + "   " + userList.get(i).getAge());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(null != sqlSession) {
				sqlSession.close();
			}
		}
	}

}

/**
 * DBAccess
 * 2016/03/31
 * zhangchunming
 */
package com.mybatis.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库
 */
public class DBAccess {
	public SqlSession getSqlSession() throws Exception{
		// 通过配置文件获取数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/mybatis/config/Configuration.xml");
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}

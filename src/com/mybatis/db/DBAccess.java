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
 * �������ݿ�
 */
public class DBAccess {
	public SqlSession getSqlSession() throws Exception{
		// ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader = Resources.getResourceAsReader("com/mybatis/config/Configuration.xml");
		// ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}

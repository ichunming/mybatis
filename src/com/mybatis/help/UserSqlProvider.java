/**
 * UserSqlProvider
 * 2016/04/06
 * zhangchunming
 */
package com.mybatis.help;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;  

public class UserSqlProvider {
    private static final String TABLE_NAME = "tbl_user";

    public String getAllUser() {
        BEGIN();
        SELECT("uid, name, age");
        FROM(TABLE_NAME);
        return SQL();
    }

    public String getUser(Map<String, Object> parameters) {
        BEGIN();
        SELECT("uid, name, age");
        FROM(TABLE_NAME);
        WHERE("uid = #{uid}");
        return SQL();
    }

    public String addUser(Map<String, Object> parameters) {
        BEGIN();
        INSERT_INTO(TABLE_NAME);
        VALUES("name", "#{name}");
        VALUES("age", "#{age}");
        return SQL();
    }
}
package org.ywb.study.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ywb.study.User;
import org.ywb.study.annotation.DataSource;

/**
 * User: yangwenbiao
 * Date: 2017/2/24
 * Time: 15:27
 */
public interface TestMapper {

    @DataSource("master")
    @Insert("insert into user (name, password) values (#{user.name}, #{user.password})")
    void insert(@Param("user") User user);

    @DataSource("slave")
    @Select("select id, name, password from user where id = #{id}")
    User getUser(@Param("id") long id);

}

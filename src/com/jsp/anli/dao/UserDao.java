package com.jsp.anli.dao;

import com.jing.servletanli.domain.User;
import com.jing.servletanli.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName:UserDao
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/29 18:10
 * @Version 1.0
 */
public class UserDao {
    public List<User> getUsers(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getConnection());
        System.out.println(jdbcTemplate);
        String sql="select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
}

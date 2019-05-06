package com.jing.servletanli.services;

import com.jing.servletanli.dao.UserDao;
import com.jing.servletanli.domain.User;

import java.util.List;

/**
 * @ClassName:UserServices
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/29 18:20
 * @Version 1.0
 */
public class UserServices {
    UserDao userDao = new UserDao();
    public List<User> getUser(){
        List<User> userList = userDao.getUsers();
        return userList;
    }
}

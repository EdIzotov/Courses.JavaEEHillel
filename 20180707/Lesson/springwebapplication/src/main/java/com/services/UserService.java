package com.services;


import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService { //композитные модули
    @Autowired
    private UserDao userDao;//new UserDao -> DI

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}

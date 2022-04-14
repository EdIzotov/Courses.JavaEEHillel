package com.services;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void postConstruct() {
        userList = userDao.getAllUsers();
    }

    public List<User> getAllUsers() {
        return userList;
    }
}

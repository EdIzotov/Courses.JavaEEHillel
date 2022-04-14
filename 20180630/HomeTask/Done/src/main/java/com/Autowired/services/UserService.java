package com.Autowired.services;

import com.Autowired.dao.UserDaoI;
import com.Autowired.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDaoI userDao1;

    @Autowired
    private UserDaoI userDao2;

    public List<User> getUserList1() {
        return userDao1.getUserList();
    }
    public List<User> getUserList2() {
        return userDao2.getUserList();
    }
}

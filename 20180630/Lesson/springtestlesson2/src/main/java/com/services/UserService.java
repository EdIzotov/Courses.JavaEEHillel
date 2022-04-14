package com.services;

import com.dao.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Resource
    @Qualifier("userDao1")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserService() {
//    }

//    public UserService(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }


}

package com.AutowiredQualifier.services;

import com.AutowiredQualifier.dao.UserDaoI;
import com.AutowiredQualifier.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDaoI userDao1;
    private UserDaoI userDao2;

    public List<User> getUserList1() {
        return userDao1.getUserList();
    }
    @Autowired
    @Qualifier("userDao1")
    public void setUserList1(UserDaoI userDao) {
        this.userDao1 = userDao;
    }
    public List<User> getUserList2() {
        return userDao2.getUserList();
    }
    @Autowired
    @Qualifier("userDao2")
    public void setUserList2(UserDaoI userDao) {
        this.userDao2 = userDao;
    }
}

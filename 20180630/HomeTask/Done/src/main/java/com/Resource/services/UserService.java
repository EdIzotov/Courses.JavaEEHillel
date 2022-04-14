package com.Resource.services;

import com.Resource.dao.UserDaoI;
import com.Resource.models.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDaoI userDao1;

    @Resource
    private UserDaoI userDao2;

    public List<User> getUserList1() {
        return userDao1.getUserList();
    }
    public List<User> getUserList2() {
        return userDao2.getUserList();
    }
}

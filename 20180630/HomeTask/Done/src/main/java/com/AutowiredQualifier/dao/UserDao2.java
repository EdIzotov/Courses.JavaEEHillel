package com.AutowiredQualifier.dao;

import com.AutowiredQualifier.models.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("userDao2")
public class UserDao2 implements UserDaoI {
    private List<User> userList = Arrays.asList(new User("name3", 14), new User("name4", 15));
    public List<User> getUserList() {
        return userList;
    }
}

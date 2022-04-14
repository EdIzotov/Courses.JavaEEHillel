package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository//("userDAO")
public class UserDao {

    private List userList = Arrays.asList(new User("name1"),
            new User("name2"));

    public List<User> getAllUsers() {
        return userList;
    }
}

package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {
    private List<User> userList = Arrays.asList(new User("aaa@aaa.com", "Vasya", "Pupkin"),
            new User("bbb@aaa.com", "Petya", "Ivanov"),
            new User("ccc@aaa.com", "Sasha", "Olegov"));

    public List<User> getAllUsers() {
        return userList;
    }
}

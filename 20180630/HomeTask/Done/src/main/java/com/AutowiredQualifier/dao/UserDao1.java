package com.AutowiredQualifier.dao;

import com.AutowiredQualifier.models.User;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository("userDao1")
public class UserDao1 implements UserDaoI {
    private List<User> userList = Arrays.asList(new User("name1", 12), new User("name2", 13));
    public List<User> getUserList() {
        return userList;
    }
}

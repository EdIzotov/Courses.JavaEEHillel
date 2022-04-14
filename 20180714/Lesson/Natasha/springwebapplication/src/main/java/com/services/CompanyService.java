package com.services;


import com.dao.UserDao;
import com.model.Company;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class CompanyService { //композитные модули
    @Autowired
    private UserService userService;

    private List<User> users;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
    }

    public List<Company> getAllCompanies() {
        return Arrays.asList(new Company("kldasd"));
    }
}

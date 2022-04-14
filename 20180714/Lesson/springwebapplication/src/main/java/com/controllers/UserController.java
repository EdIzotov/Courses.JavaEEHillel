package com.controllers;

import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user-controller")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

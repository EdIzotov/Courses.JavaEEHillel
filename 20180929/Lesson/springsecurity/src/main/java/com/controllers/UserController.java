package com.controllers;

import com.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String message() {
        return "message from controller";
    }

    @RequestMapping("/current")
    public @ResponseBody
    User getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        return principal;
    }
}

package com.app.socailmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.socailmedia.model.User;
import com.app.socailmedia.services.UserDaoService;

@RestController
public class UserController {

    UserDaoService userDaoService;

    // we have three types of dependency injections
    // constructor dependency injection
    // setter dependency injections
    // field dependency injection
    UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // what is path variable
    // users/path-variable/{name}
    // here the name is a path variable
    // for that you have to do what
    // @GetMapping("/helloworld/{name}")
    // public String helloWorld(@PathVariable String name) {
    // return "hello world "+name;
    // }

    @GetMapping("/users")
    public List<User> getUser() {
        return userDaoService.findAllUsers();
    }

}

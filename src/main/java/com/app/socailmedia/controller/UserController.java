package com.app.socailmedia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.socailmedia.UserNotFoundException;
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
    public List<User> findAllUsers() {
        return userDaoService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findSingleUser(@PathVariable int id) {
        User user = userDaoService.findUserById(id);

        if (user == null)
            throw new UserNotFoundException("id:" + id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}

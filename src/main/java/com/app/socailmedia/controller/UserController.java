package com.app.socailmedia.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {
    

// what is path variable 
//  users/path-variable/{name}
// here the name is a path variable 
// for that you have to do what 
@GetMapping("/helloworld/{name}")
public String helloWorld(@PathVariable String name) {
    return "hello world"+name;
}


}

package com.app.socailmedia.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.socailmedia.model.User;

// this give to spring 
@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    static private int count = 0;

    static {
        userList.add(new User(++count, "farazkhan", LocalDate.now().minusDays(27)));
        userList.add(new User(++count, "umarkhan", LocalDate.now().minusDays(27)));
        userList.add(new User(++count, "faisalkhan", LocalDate.now().minusDays(27)));
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public User findUserById(int id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();

    }

    public User saveUser(User user) {
     
         user.setId(++count);
         userList.add(user);

        return user;

    }

}

package org.example.rest_task.repository;

import org.example.rest_task.model.Authorities;
import org.example.rest_task.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List <User> users = new ArrayList<>();
    {
        users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
    }

    public List<Authorities> getUserAuthorities(String userName, String userPassword) {
        List<Authorities> userAuthorities = new ArrayList<>();
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
                userAuthorities.add(Authorities.WRITE);
                userAuthorities.add(Authorities.READ);
                userAuthorities.add(Authorities.DELETE);
            }
        }
        return userAuthorities;
    }
}

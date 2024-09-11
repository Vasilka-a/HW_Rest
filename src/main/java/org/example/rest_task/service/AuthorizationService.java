package org.example.rest_task.service;

import org.example.rest_task.model.Authorities;
import org.example.rest_task.exception.InvalidCredentials;
import org.example.rest_task.exception.UnauthorizedUser;
import org.example.rest_task.model.User;
import org.example.rest_task.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUserName()) || isEmpty(user.getUserPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUserName(), user.getUserPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUserName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

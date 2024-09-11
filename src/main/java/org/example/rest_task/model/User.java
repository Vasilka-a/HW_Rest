package org.example.rest_task.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private String userName;

    @NotBlank
    @Size(min = 4, max = 10)
    private String userPassword;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}

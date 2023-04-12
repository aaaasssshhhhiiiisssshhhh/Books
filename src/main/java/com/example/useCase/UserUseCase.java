package com.example.useCase;

import com.example.model.User;

import java.util.List;

public interface UserUseCase {
    String addUser (User user);
    boolean updateUser (User user);
    List<User> getUsers();
    boolean deleteUser(String userId, String email);
}

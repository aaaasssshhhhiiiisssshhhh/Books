package com.example.useCase;

import com.example.model.User;

import java.util.List;

public interface UserRepo {
    String addUser(User user);
    boolean updateUser (User user);
    List<User> getUsers ();
    User getUser (String userId ,String email);
    boolean  deleteUser (String userId,String email);
}

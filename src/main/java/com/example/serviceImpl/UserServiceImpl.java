package com.example.serviceImpl;

import com.example.model.User;
import com.example.useCase.UserRepo;
import com.example.useCase.UserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UserServiceImpl implements UserUseCase {
    private final UserRepo repo;
    private final ObjectMapper mapper;

    public UserServiceImpl(UserRepo repo, ObjectMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    @Override
    public String addUser(User user) {
        return repo.addUser(user);
    }
    @Override
    public boolean updateUser(User user) {
        return repo.updateUser(user);
    }
    @Override
    public List<User> getUsers() {
        return repo.getUsers();
    }
    @Override
    public boolean deleteUser(String userId, String email) {
        return repo.deleteUser(userId , email);
    }
}

package com.example.repoImpl;


import com.example.Exception.BookIdAlreadyExistsException;
import com.example.Exception.PrimaryKeyMissingException;
import com.example.FirebaseIdGenerator;
import com.example.Mapper.UserEntityMapper;
import com.example.model.User;
import com.example.useCase.UserDao;
import com.example.useCase.UserRepo;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserRepoImpl implements UserRepo {
    private final UserEntityMapper mapper;
    private final UserDao dao;
    public UserRepoImpl(UserEntityMapper mapper, UserDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    @Override
    public String addUser(User user) {
        var entity = mapper.create(user);
        if (user.getUserId() == null){
            String userId = FirebaseIdGenerator.generateId();
            entity.setUserId(userId);
            dao.create(entity);
            return userId;
        }
        if (doesUserExists(user.getUserId(), user.getName()))
            throw new BookIdAlreadyExistsException("book with "+ user.getUserId() + " with " + user.getName() + " already exit.");
        dao.create(entity);
        return user.getUserId();
    }

    public boolean doesUserExists(String bookId , String name) {
        var book = mapper.getUser(dao.getBook(bookId, name));
        return book != null;
    }

    @Override
    public boolean updateUser(User user) {
        if (StringUtils.isEmpty(user.getUserId()) && StringUtils.isEmpty(user.getEmail())){
            throw new PrimaryKeyMissingException("userId or email is missing");
        }
        return dao.update(mapper.create(user));
    }

    @Override
    public List<User> getUsers() {
        return dao.getAll().all().stream().map(mapper :: getUser).collect(Collectors.toList());
    }

    @Override
    public User getUser(String userId, String email) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId, String email) {
        return dao.delete(userId , email);
    }


}

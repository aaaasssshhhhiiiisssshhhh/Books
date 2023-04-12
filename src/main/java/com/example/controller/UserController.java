package com.example.controller;


import com.example.model.Books;
import com.example.model.User;
import com.example.useCase.UserUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/user")
public class UserController {
    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @Post
    public HttpResponse<String> addBook(User user){
        return HttpResponse.created(useCase.addUser(user));
    }
    @Put
    public HttpResponse<Boolean> updateBook(User user){
        return HttpResponse.ok(useCase.updateUser(user));
    }
    @Get
    public HttpResponse<List<User>> getBook(){
        return HttpResponse.ok().body(useCase.getUsers());
    }
    @Delete("/{bookId}/{name}")
    public HttpResponse <Boolean> delete (String bookId , String name){
        return HttpResponse.ok(useCase.deleteUser(bookId , name));
    }

}

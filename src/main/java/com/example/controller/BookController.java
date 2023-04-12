package com.example.controller;


import com.example.model.Books;
import com.example.useCase.BooksUseCase;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.awt.print.Book;
import java.util.List;

@Controller("/books")
public class BookController{
    private final BooksUseCase booksUseCase;

    public BookController(BooksUseCase booksUseCase) {
        this.booksUseCase = booksUseCase;
    }

    @Post("/addBooks")
    public HttpResponse<String> addBook(Books books){
        return HttpResponse.created(booksUseCase.addBooks(books));
    }
    @Put
    public HttpResponse<Boolean> updateBook(Books books){
        return HttpResponse.ok(booksUseCase.updateBooks(books));
    }
    @Get("/test")
    public HttpResponse<List<Books>> getBook(){
        return HttpResponse.ok().body(booksUseCase.getBooks());
    }
    @Delete("/{bookId}/{name}")
    public HttpResponse <Boolean> delete (String bookId , String name){
        return HttpResponse.ok(booksUseCase.deleteBook(bookId , name));
    }

}

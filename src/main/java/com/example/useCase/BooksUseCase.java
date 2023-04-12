package com.example.useCase;

import com.example.model.Books;

import java.util.List;


public interface BooksUseCase {
    String addBooks (Books book);
    boolean updateBooks (Books books);
    List <Books> getBooks ();
    boolean  deleteBook (String bookId,String name);
}

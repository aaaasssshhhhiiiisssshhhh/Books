package com.example.useCase;

import com.example.model.Books;

import java.util.List;

public interface BooksRepoUseCase {

    String addBooks (Books book);
    boolean updateBooks (Books books);
    List<Books> getBooks ();
    Books getBook (String bookId ,String name);
    boolean  deleteBook (String bookId,String name);
}

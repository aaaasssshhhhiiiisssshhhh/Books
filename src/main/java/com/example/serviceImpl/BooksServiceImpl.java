package com.example.serviceImpl;

import com.example.model.Books;
import com.example.repoImpl.BooksRepoImpl;
import com.example.useCase.BooksUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class BooksServiceImpl implements BooksUseCase {
    private final BooksRepoImpl repo;
    private final ObjectMapper mapper;

    public BooksServiceImpl(BooksRepoImpl repo, ObjectMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public String addBooks(Books book) {
        return repo.addBooks(book);
    }

    @Override
    public boolean updateBooks(Books books) {
        return repo.updateBooks(books);
    }

    @Override
    public List<Books> getBooks() {
        return repo.getBooks();
    }

    @Override
    public boolean deleteBook(String bookId ,String name) {
        return repo.deleteBook(bookId , name);
    }
}

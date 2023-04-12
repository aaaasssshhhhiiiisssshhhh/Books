package com.example.repoImpl;


import com.example.FirebaseIdGenerator;
import com.example.Mapper.BooksEntityMapper;
import com.example.model.Books;
import com.example.useCase.BooksDao;
import com.example.useCase.BooksRepoUseCase;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;


@Singleton
public class BooksRepoImpl implements BooksRepoUseCase {
     private final BooksEntityMapper mapper;
     private final BooksDao dao;

    public BooksRepoImpl(BooksEntityMapper mapper, BooksDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    @Override
    public String addBooks(Books book) {
        var entity = mapper.getBooks(book);
        if (book.getBookId() == null){
            String bookId = FirebaseIdGenerator.generateId();
            entity.setBookId(bookId);
            dao.create(entity);
            return bookId;
        }
        if (doesBookExists(book.getBookId(), book.getName()))
            throw new RuntimeException("book with "+ book.getBookId() + " with " + book.getName() + " already exit.");
        dao.create(entity);
        return book.getBookId();
    }

    public boolean doesBookExists(String bookId , String name) {
        var book = mapper.getBooksDetail(dao.getBook(bookId, name));
        return book != null;
    }

    @Override
    public boolean updateBooks(Books books) {
        return dao.update(mapper.getBooks(books));
    }

    @Override
    public List<Books> getBooks() {
        return dao.getAll().all().stream().map(mapper :: getBooksDetail).collect(Collectors.toList());
    }

    @Override
    public Books getBook(String bookId, String name) {
        var booksEntity = dao.getBook(bookId , name);
        if (booksEntity == null) return null;
        return mapper.getBooksDetail(booksEntity);
    }

    @Override
    public boolean deleteBook(String bookId ,String name) {
        return dao.delete(bookId , name);
    }
}

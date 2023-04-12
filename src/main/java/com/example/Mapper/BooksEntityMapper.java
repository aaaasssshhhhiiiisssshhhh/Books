package com.example.Mapper;

import com.example.model.Books;
import com.example.entity.BooksEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Singleton;


@Singleton
public class BooksEntityMapper {

    //for other use case we need object mapper;
    private final ObjectMapper mapper;

    public BooksEntityMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public BooksEntity getBooks (Books books){
        var builder = BooksEntity.builder();

        return builder
                .bookId(books.getBookId())
                .name(books.getName())
                .price(books.getPrice())
                .description(books.getDescription())
                .category(books.getCategory())
                .build();
    }

    public Books getBooksDetail (BooksEntity entity){
        var builder = Books.builder();

        return builder
                .bookId(entity.getBookId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .build();
    }

}

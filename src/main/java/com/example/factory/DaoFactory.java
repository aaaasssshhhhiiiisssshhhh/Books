package com.example.factory;


import com.datastax.oss.driver.api.core.CqlSession;
import com.example.useCase.BooksDao;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Factory
@Requires (bean = CqlSession.class)
public class DaoFactory {

    @Inject
    DaoMapper mapper;

    @Bean
    @Singleton
    public BooksDao getBooks(){
        return mapper.getBooksDao();
    }
}

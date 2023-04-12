package com.example.useCase;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.*;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;
import com.example.entity.BooksEntity;


@Dao
public interface BooksDao {

    @Select
    PagingIterable<BooksEntity> getAll();

    @Insert(nullSavingStrategy = NullSavingStrategy.DO_NOT_SET)
    boolean create(BooksEntity entity);

    @Update(nullSavingStrategy = NullSavingStrategy.DO_NOT_SET)
    boolean update(BooksEntity entity);

    @Select
    PagingIterable<BooksEntity> getBooks(String bookId , String name);

    @Select
    BooksEntity getBook(String bookId, String name);


    @Delete(entityClass = BooksEntity.class)
    boolean delete(String bookId,String name);
}

package com.example.useCase;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.*;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;
import com.example.entity.UserEntity;

@Dao
public interface UserDao {

    @Select
    PagingIterable<UserEntity> getAll();

    @Insert(nullSavingStrategy = NullSavingStrategy.DO_NOT_SET)
    boolean create(UserEntity entity);

    @Update(nullSavingStrategy = NullSavingStrategy.DO_NOT_SET)
    boolean update(UserEntity entity);

    @Select
    PagingIterable<UserEntity> getBooks(String userId , String email);

    @Select
    UserEntity getBook(String userId, String email);


    @Delete(entityClass = UserEntity.class)
    boolean delete(String userId,String email);
}

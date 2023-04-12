package com.example.factory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import com.datastax.oss.driver.internal.mapper.processor.dao.DaoDeleteMethodGenerator;
import com.datastax.oss.driver.internal.mapper.processor.dao.DaoMethodGenerator;
import com.example.useCase.BooksDao;

import java.util.Locale;

@Mapper
public interface DaoMapper {


//    static MapperBuilder<DaoMapper> builder(CqlSession session) {
//        return new DaoMapperBuilder(session);
//    }



    @DaoFactory
    BooksDao getBooksDao();
}

package com.example.factory;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.example.Constants;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

public class MapperFactory {
    @Factory

        private static final CqlIdentifier UTIL_KEYSPACE_ID = CqlIdentifier.fromCql(Constants.UTIL_KEYSPACE);

        @Inject
        CqlSession session;
//
//        @Bean
//        @Singleton
//        public Object mapper(){
//            return DaoMapper.builder(session).withDefaultKeyspace(UTIL_KEYSPACE_ID).build();
//        }
    }


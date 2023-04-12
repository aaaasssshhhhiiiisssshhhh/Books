package com.example.Enum;

import io.micronaut.core.util.StringUtils;

import java.util.Optional;

public enum Type {
    STUDENT,
    SELLER,
    BUYER;
    public static Optional<Type> get(String value){
        if (StringUtils.isEmpty(value)) return Optional.empty();
        try {
            return Optional.of(Type.valueOf(value.toUpperCase()));
        } catch (IllegalArgumentException e){
            return Optional.empty();
        }
    }
}

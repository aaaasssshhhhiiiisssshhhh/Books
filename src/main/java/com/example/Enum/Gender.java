package com.example.Enum;

import io.micronaut.core.util.StringUtils;

import java.util.Optional;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;
    public static Optional<Gender> get(String value){
        if (StringUtils.isEmpty(value)) return Optional.empty();
        try {
            return Optional.of(Gender.valueOf(value.toUpperCase()));
        } catch (IllegalArgumentException e){
            return Optional.empty();
        }
    }
}

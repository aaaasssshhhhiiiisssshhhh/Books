package com.example.Mapper;

import com.example.Enum.Gender;
import com.example.Enum.Type;
import com.example.entity.UserEntity;
import com.example.model.User;
import jakarta.inject.Singleton;

@Singleton
public class UserEntityMapper {
    public UserEntity create  (User user){
        var builder = UserEntity.builder();
        return builder
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .gender(user.getGender().name())
                .type(user.getType().name())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    public User getUser (UserEntity entity){
        var builder = User.builder();

        if (entity.getGender() != null)
            builder.gender(Gender.get(entity.getGender()).orElse(null));

        if (entity.getType() != null)
            builder.type(Type.get(entity.getType()).orElse(null));

        return builder
                .userId(entity.getUserId())
                .email(entity.getEmail())
                .name(entity.getName())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .dateOfBirth(entity.getDateOfBirth())
                .build();
    }
}

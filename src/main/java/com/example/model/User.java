package com.example.model;

import com.example.Enum.Gender;
import com.example.Enum.Type;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String userId;
    private String email;
    private String name;
    private Gender gender;
    private Type type;
    private String address; // need to break in diff class: (eg: district - city - street )
    private String phoneNumber;
    private String dateOfBirth;
}


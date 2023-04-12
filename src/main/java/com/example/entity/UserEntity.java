package com.example.entity;


import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;

@Builder(toBuilder = true)
@CqlName("user_entity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @PartitionKey(value = 1)
    private String userId;
    @PartitionKey(value = 2)
    private String email;
    private String name;
    private String gender;
    private String type; // student or seller or buyer like wise need to discuss
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
}

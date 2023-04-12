package com.example.entity;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;


@Builder (toBuilder = true)
@CqlName("books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksEntity {
    @PartitionKey(value =1)
    private String bookId;
    @PartitionKey(value = 2)
    private String name;
    private String price;
    private String description;
    private String category;
}

package com.example.model;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Books {
    private String bookId;
    private String name;
    private String price;
    private String description;
    private String category;
}

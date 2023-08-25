package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String name;
    private String tel;
    private String imageUrl;
}

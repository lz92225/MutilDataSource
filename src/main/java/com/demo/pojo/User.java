package com.demo.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;

    private Integer age;

    private String password;

    private Integer sex;

    private String username;

    private Address address;
}
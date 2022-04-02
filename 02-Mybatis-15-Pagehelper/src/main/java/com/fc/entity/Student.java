package com.fc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private String name;
    private Byte age;
    private Date birthday;
    private String gender;
    private String info;
}

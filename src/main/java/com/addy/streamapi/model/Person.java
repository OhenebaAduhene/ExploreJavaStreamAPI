package com.addy.streamapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private int age;

}

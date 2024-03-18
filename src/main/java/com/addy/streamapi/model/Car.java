package com.addy.streamapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private int price;
}

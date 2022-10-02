package com.example.funovahue.constant;

public enum GenderEnum {
    MALE("nam"),
    FEMALE("nu"),
    BOTH("all");
    private String value;
    GenderEnum(String value){
        this.value = value;
    }
}

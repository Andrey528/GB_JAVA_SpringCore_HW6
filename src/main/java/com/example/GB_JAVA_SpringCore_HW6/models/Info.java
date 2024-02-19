package com.example.GB_JAVA_SpringCore_HW6.models;

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
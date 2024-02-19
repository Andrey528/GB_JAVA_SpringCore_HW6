package com.example.GB_JAVA_SpringCore_HW6.models;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    Info info;
    List<Result> results;
}
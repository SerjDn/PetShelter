package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {

    private String type;
    private boolean gender;
    private String name;
    private int age;
}

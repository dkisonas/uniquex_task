package com.example.uniquex_back.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Student implements Comparable<Student> {

    @NotBlank
    private final String name;

    @NotNull
    private final Double performance;

    @Override
    public int compareTo(Student o) {
        int res = 0;
        if (this.performance < o.getPerformance()) {
            res = 1;
        }
        if (this.performance > o.getPerformance()) {
            res = -1;
        }
        return res;
    }
}

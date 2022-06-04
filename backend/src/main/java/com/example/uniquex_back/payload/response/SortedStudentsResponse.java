package com.example.uniquex_back.payload.response;

import com.example.uniquex_back.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SortedStudentsResponse {

    private int studentCount;
    private String sortingTime;
    private List<Student> students;
}

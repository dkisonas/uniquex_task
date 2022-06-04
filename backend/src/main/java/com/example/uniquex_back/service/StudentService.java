package com.example.uniquex_back.service;

import com.example.uniquex_back.enums.SortingMethod;
import com.example.uniquex_back.model.Student;
import com.example.uniquex_back.payload.response.SortedStudentsResponse;

import java.util.List;

public interface StudentService {

    SortedStudentsResponse sortStudentsByPerformance(List<Student> students, String sortingMethod);

}

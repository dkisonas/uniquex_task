package com.example.uniquex_back.controller;

import com.example.uniquex_back.enums.SortingMethod;
import com.example.uniquex_back.payload.request.SortStudentsRequest;
import com.example.uniquex_back.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/sort")
    public ResponseEntity<?> sort(@Valid @RequestBody SortStudentsRequest request) {
        try {
            return ResponseEntity.ok(studentService.sortStudentsByPerformance(
                    request.getStudents(), request.getSortingMethod()));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getSortingMethods() {
        return ResponseEntity.ok(SortingMethod.getNames());
    }
}

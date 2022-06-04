package com.example.uniquex_back.service.impl;

import com.example.uniquex_back.enums.SortingMethod;
import com.example.uniquex_back.exception.SortingMethodNotImplemented;
import com.example.uniquex_back.model.Student;
import com.example.uniquex_back.payload.response.SortedStudentsResponse;
import com.example.uniquex_back.service.StudentService;
import com.example.uniquex_back.utils.student_sorter.ListSorter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ListSorter listSorter;

    @Override
    public SortedStudentsResponse sortStudentsByPerformance(List<Student> students, String sortingMethod) {
        long startTime = System.nanoTime();
        SortingMethod sortMethod = SortingMethod.getMethodEnum(sortingMethod);
        switch (sortMethod) {
            case HEAP_SORT -> listSorter.heapSort(students);
            case MERGE_SORT -> listSorter.mergeSort(students);
            case BUBBLE_SORT -> listSorter.bubbleSort(students);
            default -> throw new SortingMethodNotImplemented(sortMethod.getName());
        }
        long endTime = System.nanoTime();
        String duration = getDuration(startTime, endTime);
        return new SortedStudentsResponse(students.size(), duration, students);
    }

    private String getDuration(long startTime, long endTime) {
        Duration duration = Duration.ofNanos(endTime - startTime);
        return String.format("%s.%s", duration.getSeconds(), duration.getNano());
    }
}

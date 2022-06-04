package com.example.uniquex_back.payload.request;

import com.example.uniquex_back.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SortStudentsRequest {

    @NotBlank(message = "Sorting method can't be blank")
    private final String sortingMethod;

    @Size(min = 2, message = "At least 2 students required for sorting")
    private final List<Student> students;

}

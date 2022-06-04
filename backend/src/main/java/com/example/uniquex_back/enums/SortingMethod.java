package com.example.uniquex_back.enums;

import com.example.uniquex_back.exception.SortingMethodNotImplemented;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SortingMethod {
    BUBBLE_SORT("Bubble sort"),
    MERGE_SORT("Merge sort"),
    HEAP_SORT("Heap sort");

    private final String name;

    SortingMethod(String name) {
        this.name = name;
    }

    public static SortingMethod getMethodEnum(String sortingMethod) {
        for (SortingMethod value : values()) {
            if (value.getName().equalsIgnoreCase(sortingMethod)) {
                return value;
            }
        }
        throw new SortingMethodNotImplemented(sortingMethod);
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
        return Arrays.stream(values()).map(SortingMethod::getName).collect(Collectors.toList());
    }
}

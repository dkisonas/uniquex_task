package com.example.uniquex_back.utils.student_sorter.sorters;

import com.example.uniquex_back.exception.SortingMethodNotImplemented;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSorter implements Sorter {
    @Override
    public <E extends Comparable<E>> void sort(List<E> objects) {
        throw new SortingMethodNotImplemented("Heap sorter");
    }
}

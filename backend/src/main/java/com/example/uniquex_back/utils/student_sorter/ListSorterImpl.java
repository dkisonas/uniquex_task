package com.example.uniquex_back.utils.student_sorter;

import com.example.uniquex_back.utils.student_sorter.sorters.BubbleSorter;
import com.example.uniquex_back.utils.student_sorter.sorters.HeapSorter;
import com.example.uniquex_back.utils.student_sorter.sorters.MergeSorter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListSorterImpl implements ListSorter {

    private final BubbleSorter bubbleSorter;
    private final HeapSorter heapSorter;
    private final MergeSorter mergeSorter;

    @Override
    public <E extends Comparable<E>> void bubbleSort(List<E> objects) {
        bubbleSorter.sort(objects);
    }

    @Override
    public <E extends Comparable<E>> void heapSort(List<E> objects) {
        heapSorter.sort(objects);
    }

    @Override
    public <E extends Comparable<E>> void mergeSort(List<E> objects) {
        mergeSorter.sort(objects);
    }
}

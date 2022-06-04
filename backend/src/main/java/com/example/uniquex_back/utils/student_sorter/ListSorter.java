package com.example.uniquex_back.utils.student_sorter;

import java.util.List;

public interface ListSorter {

    <E extends Comparable<E>> void bubbleSort(List<E> objects);
    <E extends Comparable<E>> void heapSort(List<E> objects);
    <E extends Comparable<E>> void mergeSort(List<E> objects);
}

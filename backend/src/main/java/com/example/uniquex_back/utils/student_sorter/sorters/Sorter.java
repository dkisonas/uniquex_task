package com.example.uniquex_back.utils.student_sorter.sorters;

import java.util.List;

public interface Sorter {

    <E extends Comparable<E>> void sort(List<E> objects);
}

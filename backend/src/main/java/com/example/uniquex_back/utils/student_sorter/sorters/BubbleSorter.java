package com.example.uniquex_back.utils.student_sorter.sorters;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BubbleSorter implements Sorter {

    @Override
    public <E extends Comparable<E>> void sort(List<E> objects) {
        E temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < objects.size()-1; i++) {
                if (objects.get(i).compareTo(objects.get(i + 1)) > 0) {
                    temp = objects.get(i);
                    objects.set(i, objects.get(i + 1));
                    objects.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
}

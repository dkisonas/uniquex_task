package com.example.uniquex_back.utils.student_sorter.sorters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MergeSorter implements Sorter {

    @Override
    public <E extends Comparable<E>> void sort(List<E> objects) {
        mergeSort(objects);
    }

    public <E extends Comparable<E>> List<E> mergeSort(List<E> whole) {
        List<E> left = new ArrayList<>();
        List<E> right = new ArrayList<>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2;

            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }

            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            merge(left, right, whole);
        }
        return whole;
    }

    private <E extends Comparable<E>> void merge(List<E> left, List<E> right, List<E> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        List<E> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}

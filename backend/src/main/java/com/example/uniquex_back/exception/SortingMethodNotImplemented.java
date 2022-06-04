package com.example.uniquex_back.exception;

public class SortingMethodNotImplemented extends RuntimeException {
    public SortingMethodNotImplemented(String message) {
        super(String.format(ErrorMessages.SORTING_METHOD_NOT_IMPLEMENTED, message));
    }
}

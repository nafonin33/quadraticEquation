package com.example.exceptions;

public class EmptyValueException extends Exception {

    private static final long serialVersionUID = 9355648L;
    public EmptyValueException(String message) {
        super(message);
    }
    public EmptyValueException(String message, Throwable cause) {
        super(message, cause);
    }
    @Override
    public String toString() {
        return " can not be empty value. Please enter a number. ";
    }
}


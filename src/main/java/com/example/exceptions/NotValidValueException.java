package com.example.exceptions;

public class NotValidValueException extends Exception {

    private static final long serialVersionUID = 9355648L;
    public NotValidValueException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return " can only be numeric value. Please enter a number. ";
    }
}
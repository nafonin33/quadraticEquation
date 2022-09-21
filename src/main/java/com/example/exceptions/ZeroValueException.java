package com.example.exceptions;

public class ZeroValueException  extends Exception {

        private static final long serialVersionUID = 9355648L;
        public ZeroValueException(String message) {
            super(message);
        }
        public ZeroValueException(String message, Throwable cause) {
            super(message, cause);
        }
        @Override
        public String toString() {
            return " can not be 0 value. Please enter a number. ";
        }
}

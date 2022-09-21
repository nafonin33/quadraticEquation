package com.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.exceptions.EmptyValueException;
import com.example.exceptions.NotValidValueException;
import com.example.exceptions.ZeroValueException;
import org.junit.jupiter.api.*;

public class ValueValidationTests {

    ValueValidation valueValidation;

    @BeforeEach
    void setUp() {
        valueValidation = new ValueValidation();
    }

    @Test
    @DisplayName("Validate different not numeric input")
    void testNotNumeric() {
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("nmb", "a"), "Not numeric a");
        Assertions.assertEquals("Can not calculate the equation: b can only be numeric value. Please enter a number. ", valueValidation.validate("n@mb", "b"), "Not numeric b");
        Assertions.assertEquals("Can not calculate the equation: c can only be numeric value. Please enter a number. ", valueValidation.validate("nm.b", "c"), "Not numeric c");
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("-nmb", "a"), "Not numeric a");
        Assertions.assertEquals("Can not calculate the equation: b can only be numeric value. Please enter a number. ", valueValidation.validate("+n@mb", "b"), "Not numeric b");
        Assertions.assertEquals("Can not calculate the equation: c can only be numeric value. Please enter a number. ", valueValidation.validate("0nm.b", "c"), "Not numeric c");
    }

    @Test
    @DisplayName("Ensure correct handling of zero")
    void testZero() {
        Assertions.assertEquals("Can not calculate the equation: a can not be 0 value. Please enter a number. ", valueValidation.validate("0", "a"), "No zero is allowed for a");
        Assertions.assertEquals("", valueValidation.validate("0", "b"), "zero is allowed for b");
        Assertions.assertEquals("", valueValidation.validate("0", "c"), "zero is allowed for c");
    }

    @RepeatedTest(2)
    @DisplayName("Ensure correct handling of different numbers, only integer values accepted")
    void testMultipleNumbers() {
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("0.10", "a"), "Not integer");
        Assertions.assertEquals("", valueValidation.validate("-10", "a"), "correct number");
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("1.0", "a"), "Not integer");
        Assertions.assertEquals("", valueValidation.validate("10", "b"), "correct numberc");
        Assertions.assertEquals("", valueValidation.validate("+10", "b"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("10", "c"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("-10", "c"), "correct number");

        Assertions.assertEquals("", valueValidation.validate("010", "c"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("-15640", "a"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("+10", "b"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("-123456", "c"), "correct number");
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("10-", "a"), "correct number");
        Assertions.assertEquals("Can not calculate the equation: a can only be numeric value. Please enter a number. ", valueValidation.validate("10+", "a"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("0007", "c"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("2070", "a"), "correct number");
        Assertions.assertEquals("Can not calculate the equation: b can only be numeric value. Please enter a number. ", valueValidation.validate("1+0", "b"), "correct number");
        Assertions.assertEquals("", valueValidation.validate("-10", "c"), "correct number");

    }

    @Test
    @DisplayName("Testing Exception Handling")
    void exceptionTesting() {
        // set up user
        Throwable exception = Assertions.assertThrows(NotValidValueException.class, () -> valueValidation.checkNumber("nfg","a"));
        assertEquals("Can not calculate the equation: ", exception.getMessage());

        Throwable exception2 = Assertions.assertThrows(ZeroValueException.class, () -> valueValidation.checkNumber("0","a"));
        assertEquals("Can not calculate the equation: ", exception2.getMessage());

        Throwable exception3 = Assertions.assertThrows(EmptyValueException.class, () -> valueValidation.checkNumber("","a"));
        assertEquals("Can not calculate the equation: ", exception3.getMessage());
    }


}

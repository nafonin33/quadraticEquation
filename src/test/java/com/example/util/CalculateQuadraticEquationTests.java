package com.example.util;

import org.junit.jupiter.api.*;

public class CalculateQuadraticEquationTests {

    CalculateQuadraticEquation calculateQuadraticEquation;

    @BeforeEach
    void setUp() {
        calculateQuadraticEquation = new CalculateQuadraticEquation();
    }

    @Test
    @DisplayName("Validate different calculation combinations")
    /* Evaluating according online calculator https://www.calculatorsoup.com/calculators/algebra/quadratic-formula-calculator.php */
    void testEquations() {
        Assertions.assertEquals("-1.00+1.41421i, -1.00-1.41421i", calculateQuadraticEquation.calculate("1", "2", "3"), "Calculated wrong");
        Assertions.assertEquals("7.31662, 0.68338", calculateQuadraticEquation.calculate("1", "-8", "5"), "Calculated wrong");
        Assertions.assertEquals("−2.00+1.54919i, −2.00−1.54919i", calculateQuadraticEquation.calculate("5", "20", "32"), "Calculated wrong");

    }
}

package com.example.util;

import com.example.exceptions.EmptyValueException;
import com.example.exceptions.NotValidValueException;
import com.example.exceptions.ZeroValueException;

import java.util.regex.Pattern;

/*  The validation of the input is done according to this quadratic equation description.

    A quadratic equation is an algebraic equation of the second degree in x.
    The quadratic equation in its standard form is ax2 + bx + c = 0, where a and b are the coefficients,
    x is the variable, and c is the constant term.
    The first condition for an equation to be a quadratic equation is the coefficient of x2 is a non-zero term(a ≠ 0).
    For writing a quadratic equation in standard form, the x2 term is written first, followed by the x term,
    and finally, the constant term is written.
    The numeric values of a, b, c are generally not written as fractions or decimals but are written as integral values.
 */

public class ValueValidation {

    private Pattern pattern = Pattern.compile("[+-]?\\d+?");

    public String validate(String strNum, String name) {
       String message = "";

       try{
            checkNumber(strNum, name);
        }
       catch (EmptyValueException e) {
           message = e.getMessage() + name + e.toString();
       }
       catch (NotValidValueException e) {
           message = e.getMessage() + name + e.toString();
       }
       catch (ZeroValueException e) {
           message = e.getMessage() + name + e.toString();
       }

       return message;
    }

    public void checkNumber(String strNum, String name) throws EmptyValueException, ZeroValueException, NotValidValueException {

        if (strNum == null || strNum.isEmpty()) {
            throw new EmptyValueException("Can not calculate the equation: ");
        }

        if (!pattern.matcher(strNum).matches()){
            throw new NotValidValueException("Can not calculate the equation: ");
        }

        if (strNum.equals("0") && name.equals("a")) {
            throw new ZeroValueException("Can not calculate the equation: ");
        }
    }
}

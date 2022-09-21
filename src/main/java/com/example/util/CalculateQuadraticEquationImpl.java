package com.example.util;

public class CalculateQuadraticEquationImpl implements CalculateQuadraticEquation {

    @Override
    public String calculate (String a, String b, String c){

        ValueValidation valueValidation = new ValueValidation();

        String message = valueValidation.validate(a, "a");

        if (message.isEmpty()) {
            message = valueValidation.validate(b, "b");
        }

        if (message.isEmpty()) {
            message = valueValidation.validate(c, "c");
        }

        if (message.isEmpty()) {
            message = findRoots(a,b,c);
        }

        return message;
    }

    private String findRoots(String a, String b, String c){

        double numA, numB, numC;
        try {
            numA = Double.parseDouble(a);
            numB = Double.parseDouble(b);
            numC = Double.parseDouble(c);

        } catch (NumberFormatException nfe){
            return "Invalid numbers. Please enter integer number for each.";
        }

        double discriminant  = numB*numB - 4*numA*numC;
        Double memberOne = (-numB / (2 * numA));

        if (discriminant==0){
            //there is one real root
            return String.format("%.5f", memberOne);
        }
        Double memberTwo = Math.sqrt(Math.abs(discriminant))/(2*numA);

        if (discriminant>0){
            //there are two real roots
            Double first = memberOne + memberTwo;
            Double second = memberOne - memberTwo;

            return String.format("%.5f", first) + ", " + String.format("%.5f", second);
        }

        if (discriminant<0) {
            //there are two complex roots
            String first = String.format("%.2f", memberOne) + "+" + String.format("%.5f", memberTwo) + "i";
            String second = String.format("%.2f", memberOne) + "-" + String.format("%.5f", memberTwo) + "i";

            return first + ", " + second;
        }

        return "";
    }

}

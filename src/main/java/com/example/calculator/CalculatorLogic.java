package com.example.calculator;

public class CalculatorLogic {
    public double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
            {
                return firstNumber + secondNumber;
            }
            case "-":
            {
                return firstNumber - secondNumber;
            }
            case "*":
            {
                return firstNumber * secondNumber;
            }
            case "/":
            {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstNumber / secondNumber;
            }
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }
}

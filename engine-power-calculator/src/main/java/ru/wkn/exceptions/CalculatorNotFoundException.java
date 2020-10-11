package ru.wkn.exceptions;

public class CalculatorNotFoundException extends Exception {

    public CalculatorNotFoundException() {
        super("Calculator not found");
    }
}

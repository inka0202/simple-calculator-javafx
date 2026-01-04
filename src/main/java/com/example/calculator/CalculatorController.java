package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class CalculatorController {
    @FXML
    private TextField displayField;
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private boolean startNew = true;

    private boolean errorState = false;
    private boolean repeatedOnEquals = false;
    private  CalculatorLogic calculatorLogic = new CalculatorLogic();

    @FXML
    private void onDigitClick(ActionEvent event) {
        repeatedOnEquals = false;

        Button btn = (Button) event.getSource();
        if (errorState) {
            displayField.clear();
            errorState = false;
        }
        if (startNew) {
            displayField.clear();
            startNew = false;
        }
        if (btn.getText().equals(".") && displayField.getText().contains(".")) return;

        displayField.appendText(btn.getText());
    }


    @FXML
    private void onOperatorClick(ActionEvent event) {
        repeatedOnEquals = false;
        if (errorState) {
            return;
        }
        Button btn = (Button) event.getSource();
        if(!displayField.getText().isEmpty()) {
            firstNumber = Double.parseDouble(displayField.getText());
            operator = btn.getText();
            startNew = true;
        }else {
            firstNumber = 0;
            operator = btn.getText();
            startNew = true;
        }
    }

    @FXML
    private void onEqualsClick() {
        if (errorState || operator == null) return;
        try {
            if (!repeatedOnEquals) {
                secondNumber = Double.parseDouble(displayField.getText());
                repeatedOnEquals = true;
            }
        double result = calculatorLogic.calculate(firstNumber, secondNumber, operator);
        displayField.setText(String.valueOf(result));
        firstNumber = result;
        startNew = true;
        }
        catch (NumberFormatException e) {
            displayField.setText("Error");
            startNew= true;
            errorState = true;
            firstNumber = 0;
            operator = null;
        }
        catch (ArithmeticException e) {
            displayField.setText("Division by zero");
            startNew = true;
            errorState = true;
            firstNumber = 0;
            operator = null;
        }

    }

    @FXML
    private void onPlusMinus() {
        if (displayField.getText().isEmpty()) return;

        if (displayField.getText().startsWith("-"))
            displayField.setText(displayField.getText().substring(1));
        else
            displayField.setText("-" + displayField.getText());
    }
    @FXML
    private void onClear() {
        displayField.clear();

        firstNumber = 0;
        secondNumber = 0;
        operator = null;

        startNew = true;
        repeatedOnEquals = false;
        errorState = false;
    }
}

package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class CalculatorApplication extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
//    private void handleBtn(String text) {
//        try{
//            if("+/-".equals(text)){
//
//                if (displayTF.getText().isEmpty()) {
//                    return;
//                }
//
//                if (displayTF.getText().startsWith("-")) {
//                    displayTF.setText(displayTF.getText().substring(1));
//                } else {
//                    displayTF.setText("-" + displayTF.getText());
//                }
//                return;
//            }
//
//            if("C".equals(text)){
//                displayTF.clear();
//                firstNumber = 0;
//                operator = "";
//                startNewNumber = true;
//                return;
//            }
//            if("0123456789.".contains(text)) {
//                if (startNewNumber) {
//                    displayTF.clear();
//                    startNewNumber = false;
//                }
//
//                if(text.equals(".") && displayTF.getText().contains(".")){
//                    return;
//                }
//
//
//                displayTF.appendText(text);
//                return;
//            }
//            if ("+-*/".contains(text)) {
//                firstNumber = Double.parseDouble(displayTF.getText());
//                operator = text;
//                startNewNumber = true;
//                return;
//            }
//            if("=".equals(text)) {
//                double secondNumber = Double.parseDouble(displayTF.getText());
//                double result = calculate(firstNumber, secondNumber, operator);
//                displayTF.setText(String.valueOf(result));
//                startNewNumber = true;
//        }
//        }catch(NumberFormatException e) {
//            displayTF.setText("Error");
//            startNewNumber = true;
//        }catch(ArithmeticException e) {
//            displayTF.setText("Math Error");
//            startNewNumber = true;
//        }
//    }
//
//    public double calculate(double firstNumber, double secondNumber, String operator) {
//        return switch (operator) {
//            case "+" -> firstNumber + secondNumber;
//            case "-" -> firstNumber - secondNumber;
//            case "*" -> firstNumber * secondNumber;
//            case "/" -> { if (secondNumber==0) throw  new ArithmeticException();{
//            yield firstNumber / secondNumber;}
//            }
//            default -> 0;
//        };
//    }


package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


import java.io.IOException;

public class HelloApplication extends Application {
    private TextField displayTF;
    private double firstNumber;
    private String operator;
    private boolean startNewNumber = true;

    @Override
    public void start(Stage stage) throws IOException {
        displayTF = new TextField();
        displayTF.setEditable(false);
        displayTF.setPrefHeight(65);
        displayTF.setStyle("-fx-font-size: 20; -fx-background-color: #f5f5f5; -fx-border-color: transparent; ");
        displayTF.setAlignment(Pos.CENTER_RIGHT);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 5, 5, 5));

        String[] buttons ={
                "", "", "C", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="

        };
        int row = 0;
        int col = 0;
        for (String text : buttons) {
            if (text.isEmpty()) {
                col++;
                if (col == 4) {
                    col = 0;
                    row++;
                }
                continue;
            }
            Button btn = new Button(text);
            btn.setPrefSize(78, 60);
            btn.setStyle("-fx-font-size: 16; -fx-background-color: #ffffff; -fx-border-color: #dddddd;");
            btn.setOnAction(e -> handleBtn(text));
            grid.add(btn, col, row);
            col++;

            if (col == 4) {
                col = 0;
                row++;
            }
        }

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().addAll(displayTF, grid);


        Scene scene = new Scene(root, 300, 380);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void handleBtn(String text) {
        try{
            if("+/-".equals(text)){

                if (displayTF.getText().isEmpty()) {
                    return;
                }

                if (displayTF.getText().startsWith("-")) {
                    displayTF.setText(displayTF.getText().substring(1));
                } else {
                    displayTF.setText("-" + displayTF.getText());
                }
                return;
            }

            if("C".equals(text)){
                displayTF.clear();
                firstNumber = 0;
                operator = "";
                startNewNumber = true;
                return;
            }
            if("0123456789.".contains(text)) {
                if (startNewNumber) {
                    displayTF.clear();
                    startNewNumber = false;
                }

                if(text.equals(".") && displayTF.getText().contains(".")){
                    return;
                }


                displayTF.appendText(text);
                return;
            }
            if ("+-*/".contains(text)) {
                firstNumber = Double.parseDouble(displayTF.getText());
                operator = text;
                startNewNumber = true;
                return;
            }
            if("=".equals(text)) {
                double secondNumber = Double.parseDouble(displayTF.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                displayTF.setText(String.valueOf(result));
                startNewNumber = true;
        }
        }catch(NumberFormatException e) {
            displayTF.setText("Error");
            startNewNumber = true;
        }catch(ArithmeticException e) {
            displayTF.setText("Math Error");
            startNewNumber = true;
        }
    }

    public double calculate(double firstNumber, double secondNumber, String operator) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> { if (secondNumber==0) throw  new ArithmeticException();{
            yield firstNumber / secondNumber;}
            }
            default -> 0;
        };
    }
}

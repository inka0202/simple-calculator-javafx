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

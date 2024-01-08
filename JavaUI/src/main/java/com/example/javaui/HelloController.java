package com.example.javaui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML private TextField textField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void onHelloButtonClick() {
        String tField = textField.getText();
        System.out.println(tField);
        welcomeText.setText(tField);
    }
}
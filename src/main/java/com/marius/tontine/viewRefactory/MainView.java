package com.marius.tontine.viewRefactory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainView {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
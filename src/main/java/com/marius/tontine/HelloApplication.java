package com.marius.tontine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        try {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.getIcons().add(icon);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
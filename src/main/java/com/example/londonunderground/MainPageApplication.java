package com.example.londonunderground;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("londonUnderground.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
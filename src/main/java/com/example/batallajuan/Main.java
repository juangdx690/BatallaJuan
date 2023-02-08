package com.example.batallajuan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1535, 768);
        stage.setTitle("Batalla!");



        stage.getIcons().add(new Image(this.getClass().getResource("images/iconoApp.png").toString()));
        stage.setX(0);
        stage.setY(0);

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.batallajuan;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class Inicio {
    @javafx.fxml.FXML
    private Button btnIniciar;
    @javafx.fxml.FXML
    private Button btnCerrar;

    MediaPlayer mediaPlayer;

    MediaPlayer mediaPlayer2;
    @javafx.fxml.FXML
    private Button btnAbout;

    @javafx.fxml.FXML
    public void initialize() {



        Platform.runLater(() -> {


            Stage currentStage = (Stage) btnAbout.getScene().getWindow();

            for (Window window : Window.getWindows()) {
                if (window instanceof Stage && window != currentStage) {
                    ((Stage) window).close();
                }
            }


            Media pick = new Media(this.getClass().getResource("musica/cancionIntro.mp3").toString());
            mediaPlayer = new MediaPlayer(pick);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.37);
            mediaPlayer.play();


        });

    }

    @javafx.fxml.FXML
    public void simular(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        mediaPlayer.stop();
        stage.close();

        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start(new Stage());


    }


    @javafx.fxml.FXML
    public void cerrar(ActionEvent actionEvent) {

        System.exit(0);

    }

    @javafx.fxml.FXML
    public void about(ActionEvent actionEvent) {


        Platform.runLater(() -> {
            mediaPlayer.stop();
            Media media = new Media(this.getClass().getResource("musica/creditosMeme.mp4").toString());

            // Crea un objeto MediaPlayer a partir del objeto Media
            mediaPlayer2 = new MediaPlayer(media);

            // Asocia el objeto MediaPlayer con un objeto MediaView
            MediaView mediaView = new MediaView(mediaPlayer2);

            // Crea un StackPane para contener la MediaView
            StackPane root = new StackPane();
            root.getChildren().add(mediaView);

            // Crea una escena con el StackPane como raíz
            Scene scene = new Scene(root, 1200, 720);


            // Crea un nuevo escenario y asocia la escena con el escenario
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

            // Reproduce el video y cierra el escenario cuando finaliza
            mediaPlayer2.play();
            mediaPlayer2.setOnEndOfMedia(() -> {
                stage.close();
                mediaPlayer.play();
            });


        });

    }
}
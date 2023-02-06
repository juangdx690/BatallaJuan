package com.example.batallajuan;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;


public class ControlDeJuego {
    ArrayList<Barco> barcos;
    String winner = "";
    DialogPane dialog;

    MediaPlayer mediaPlayer;

    public synchronized ArrayList<Barco> getBarcos() {
        return barcos;
    }


    public ControlDeJuego() {
        barcos = new ArrayList<Barco>();
        dialog = new DialogPane();

    }

    public synchronized void addBarco(Barco barco) {
        barcos.add(barco);
    }

    Timeline ganador;

    boolean gameover = false;

    public void ganador() {


        ganador = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {

            int barcosEsp = 0;
            int barcosFr = 0;
            for (Barco barco : barcos) {

                if (barco.getVida() > 0) {

                    if (barco.getEquipo().equals("España")) {

                        barcosEsp++;
                    }

                    if (barco.getEquipo().equals("Francia")) {

                        barcosFr++;
                    }

                }


            }
            if (barcosEsp == 0 && barcosFr >= 1) {
                winner = "Francia";
                mostrarEquipoGanador(winner);
                ganador.stop();


            }

            if (barcosFr == 0 && barcosEsp >= 1) {

                winner = "España";
                mostrarEquipoGanador(winner);
                ganador.stop();
            }


        }));
        ganador.setCycleCount(Timeline.INDEFINITE);
        ganador.play();

        ganador.setOnFinished(o -> {
            System.out.println("Ganador: " + winner);

            System.exit(0);

        });


    }


    public void mostrarEquipoGanador(String nombreEquipo) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Equipo ganador");
        alert.setHeaderText(null);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("images/iconoApp.png").toString()));


        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            Platform.runLater(() -> {


                dialog = alert.getDialogPane();

                if (nombreEquipo.equals("España")) {
                    dialog.getStylesheets().add(this.getClass().getResource("css/DialogoWinnerEspana.css").toString());
                    ImageView imageView = new ImageView(new Image(this.getClass().getResource("images/banderaEspana.png").toString()));
                    imageView.setFitHeight(70);
                    imageView.setFitWidth(80);
                    dialog.setGraphic(imageView);
                    Media pick = new Media(this.getClass().getResource("musica/espanaWin.mp3").toString());
                    mediaPlayer = new MediaPlayer(pick);
                    mediaPlayer.play();

                } else {
                    dialog.getStylesheets().add(this.getClass().getResource("css/DialogoWinnerFrancia.css").toString());
                    dialog.getStyleClass().add("dialog");
                    ImageView imageView = new ImageView(new Image(this.getClass().getResource("images/banderaFrancia.png").toString()));
                    imageView.setFitHeight(70);
                    imageView.setFitWidth(80);
                    dialog.setGraphic(imageView);
                    Media pick = new Media(this.getClass().getResource("musica/franciaWin.mp3").toString());
                    mediaPlayer = new MediaPlayer(pick);
                    mediaPlayer.play();

                }

                dialog.getStyleClass().add("dialog");
                alert.setContentText("El equipo ganador es: " + nombreEquipo);
                Main main = new Main();
                alert.showAndWait().ifPresent(response -> {
                            try {
                                mediaPlayer.stop();
                                main.start(new Stage());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                );
            });
        });
        pause.play();





    }


}

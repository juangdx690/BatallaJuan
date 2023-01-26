package com.example.batallajuan;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class PestañaRojo extends Stage {
    ControlDeJuego control;

    ProgressBar destructor;
    ProgressBar acorazado;
    ProgressBar lancha;
    ProgressBar submarino;
    Label txtVidaDestructor;
    Label txtVidaAcorazado;
    Label txtVidaLancha;
    Label txtVidaSubmarino;

    Label txtBarcosRestantes;

    ImageView destructorDisImg;
    ImageView acorazadoDisImg;
    ImageView submarinoDisImg;
    ImageView lanchaDisImg;

    public PestañaRojo() {
        this.control = control;
        cargarInterfaz();

        destructor.progressProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() == 1.0d) {
                destructor.getStyleClass().add("green-progress-bar");
            } else if (newValue.doubleValue() <= 0.99d && newValue.doubleValue() >= 0.50d) {

                destructor.getStyleClass().add("orange-progress-bar");

            } else {
                destructor.getStyleClass().add("red-progress-bar");
            }
        });

        acorazado.progressProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() == 1.0d) {
                acorazado.getStyleClass().add("green-progress-bar");
            } else if (newValue.doubleValue() <= 0.99d && newValue.doubleValue() >= 0.50d) {

                acorazado.getStyleClass().add("orange-progress-bar");

            } else {
                acorazado.getStyleClass().add("red-progress-bar");
            }
        });

        submarino.progressProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() == 1.0d) {
                submarino.getStyleClass().add("green-progress-bar");
            } else if (newValue.doubleValue() <= 0.99d && newValue.doubleValue() >= 0.50d) {

                submarino.getStyleClass().add("orange-progress-bar");

            } else {
                submarino.getStyleClass().add("red-progress-bar");
            }
        });

        lancha.progressProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() == 1.0d) {
                lancha.getStyleClass().add("green-progress-bar");
            } else if (newValue.doubleValue() <= 0.99d && newValue.doubleValue() >= 0.50d) {

                lancha.getStyleClass().add("orange-progress-bar");

            } else {
                lancha.getStyleClass().add("red-progress-bar");
            }
        });


        this.destructor.setProgress(1);
        this.lancha.setProgress(1);
        this.submarino.setProgress(1);
        this.acorazado.setProgress(1);

        Timeline moverse = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            cambiarBarcosRestantes();
            for (Barco barco : this.control.getBarcos()) {

                if (barco.getNombre().equals("destructor") && barco.getEquipo().equals("España")) {
                    if (barco.getVida()<=0){

                        destructorDisImg.setImage(new Image(((getClass().getResourceAsStream("images/muerto2.png")))));

                    }else{

                        if (barco.recargando()){

                            destructorDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargadaS.png")))));

                        }else{

                            destructorDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargada.png")))));
                        }

                    }
                    txtVidaDestructor.setText(String.valueOf(barco.getVida()));
                    destructor.setProgress((barco.getVida() / 80f));

                }

                if (barco.getNombre().equals("acorazado") && barco.getEquipo().equals("España")) {
                    if (barco.getVida()<=0){

                        acorazadoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/muerto2.png")))));

                    }else{

                        if (barco.recargando()){

                            acorazadoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargadaS.png")))));

                        }else{

                            acorazadoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargada.png")))));
                        }

                    }
                    txtVidaAcorazado.setText(String.valueOf(barco.getVida()));
                    acorazado.setProgress((barco.getVida() / 120f));

                }

                if (barco.getNombre().equals("lancha") && barco.getEquipo().equals("España")) {
                    if (barco.getVida()<=0){

                        lanchaDisImg.setImage(new Image(((getClass().getResourceAsStream("images/muerto2.png")))));

                    }else{

                        if (barco.recargando()){

                            lanchaDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargadaS.png")))));

                        }else{

                            lanchaDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargada.png")))));
                        }

                    }
                    txtVidaLancha.setText(String.valueOf(barco.getVida()));
                    lancha.setProgress((barco.getVida() / 10f));

                }

                if (barco.getNombre().equals("submarino") && barco.getEquipo().equals("España")) {
                    if (barco.getVida()<=0){

                        submarinoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/muerto2.png")))));

                    }else{

                        if (barco.recargando()){

                            submarinoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargadaS.png")))));

                        }else{

                            submarinoDisImg.setImage(new Image(((getClass().getResourceAsStream("images/pistolaRecargada.png")))));
                        }

                    }
                    txtVidaSubmarino.setText(String.valueOf(barco.getVida()));
                    submarino.setProgress((barco.getVida() / 30f));

                }

            }


        }));
        moverse.setCycleCount(Timeline.INDEFINITE);
        moverse.play();


    }


    public void cambiarBarcosRestantes() {

        Platform.runLater(() -> {

            int barcos = 0;

            if (Integer.parseInt(txtVidaAcorazado.getText()) > 0) {

                barcos++;
            }
            if (Integer.parseInt(txtVidaDestructor.getText()) > 0) {

                barcos++;
            }
            if (Integer.parseInt(txtVidaLancha.getText()) > 0) {

                barcos++;
            }
            if (Integer.parseInt(txtVidaSubmarino.getText()) > 0) {

                barcos++;
            }

            txtBarcosRestantes.setText(String.valueOf(barcos));


        });

    }

    public synchronized void getControl(ControlDeJuego control) {

        this.control = control;

    }

    private void barraPr(int vidaActual) {

        int vidaDestructor = 80;


    }

    private void cargarInterfaz() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("equipoRojo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 255, 768);

            destructor = (ProgressBar) loader.getNamespace().get("pbVidaDestructor");
            txtVidaDestructor = (Label) loader.getNamespace().get("vidaDestructor");
            txtVidaDestructor.setText("80");

            acorazado = (ProgressBar) loader.getNamespace().get("pbVidaAcorazado");
            txtVidaAcorazado = (Label) loader.getNamespace().get("vidaAcorazado");
            txtVidaAcorazado.setText("120");

            lancha = (ProgressBar) loader.getNamespace().get("pbVidaLancha");

            txtVidaLancha = (Label) loader.getNamespace().get("vidaLancha");
            txtVidaLancha.setText("10");

            submarino = (ProgressBar) loader.getNamespace().get("pbVidaSubmarino");
            ;
            txtVidaSubmarino = (Label) loader.getNamespace().get("vidaSubmarino");
            txtVidaSubmarino.setText("30");

            destructor = (ProgressBar) loader.getNamespace().get("pbVidaDestructor");
            txtVidaDestructor = (Label) loader.getNamespace().get("vidaDestructor");
            txtVidaDestructor.setText("80");

            txtBarcosRestantes = (Label) loader.getNamespace().get("barcosrestantes");

            destructorDisImg = (ImageView) loader.getNamespace().get("disparoDestructor");
            acorazadoDisImg = (ImageView) loader.getNamespace().get("disparoAcorazado");
            submarinoDisImg = (ImageView) loader.getNamespace().get("disparoSubmarino");
            lanchaDisImg = (ImageView) loader.getNamespace().get("disparoLancha");

            setScene(scene);
            setX(0);
            setY(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


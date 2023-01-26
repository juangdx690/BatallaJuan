package com.example.batallajuan;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VentanaJuego extends Stage {

    Barco barcoDesEsp;
    Barco barcoLanEsp;
    Barco barcoAcoEsp;
    Barco barcoSubEsp;
    Barco barcoDesFr;
    Barco barcoLanFr;
    Barco barcoAcoFr;
    Barco barcoSubFr;

    ControlDeJuego control;

    PestañaRojo pestanaEspana;
    PestañaAzul pestanaFrancia;

    List<Integer> numbers = new ArrayList<>();
    @javafx.fxml.FXML
    private AnchorPane ventana;

    public VentanaJuego(PestañaRojo espana, PestañaAzul francia) {

        Image fondo = new Image(getClass().getResourceAsStream("images/background.png"));
        ImageView back = new ImageView(fondo);


        ventana.setBackground(new Background(new BackgroundImage(back.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        instanciarBarcos();

    }

    public void asignarPos(ImageView imagen, int num) {

        if (num == 1) {

            imagen.setLayoutX(28);
            imagen.setLayoutY(371);

        }

        if (num == 2) {

            imagen.setLayoutX(28);
            imagen.setLayoutY(75);

        }

        if (num == 3) {
            imagen.setLayoutX(28);
            imagen.setLayoutY(149);

        }

        if (num == 4) {

            imagen.setLayoutX(28);
            imagen.setLayoutY(575);
        }

    }

    public void asignarPosFr(ImageView imagen, int num) {

        if (num == 1) {

            imagen.setLayoutX(882);
            imagen.setLayoutY(371);

        }

        if (num == 2) {

            imagen.setLayoutX(876);
            imagen.setLayoutY(75);

        }

        if (num == 3) {
            imagen.setLayoutX(876);
            imagen.setLayoutY(147);

        }

        if (num == 4) {

            imagen.setLayoutX(876);
            imagen.setLayoutY(575);
        }

    }

    public void instanciarBarcos() {


        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Collections.shuffle(numbers);
        control = new ControlDeJuego();

        ImageView bola = new ImageView(new Image((getClass().getResourceAsStream("images/disparo.png"))));
        bola.setFitWidth(30);
        bola.setFitHeight(30);


        ImageView destructorImg = new ImageView();
        destructorImg.setImage(new Image(getClass().getResourceAsStream("images/destructorEsp.png")));
        asignarPos(destructorImg, numbers.remove(0));
        control.addBarco(barcoDesEsp = new Barco("destructor", "España", destructorImg, control.getBarcos(), bola, ventana));


        ImageView acorazadoImg = new ImageView();
        acorazadoImg.setImage(new Image(getClass().getResourceAsStream("images/acorazadoEsp.png")));
        asignarPos(acorazadoImg, numbers.remove(0));
        control.addBarco(barcoAcoEsp = new Barco("acorazado", "España", acorazadoImg, control.getBarcos(), bola, ventana));

        ImageView lanchaImg = new ImageView();
        lanchaImg.setImage(new Image(getClass().getResourceAsStream("images/barcoEsp.png")));
        asignarPos(lanchaImg, numbers.remove(0));
        control.addBarco(barcoLanEsp = new Barco("lancha", "España", lanchaImg, control.getBarcos(), bola, ventana));

        ImageView submarinoImg = new ImageView();
        submarinoImg.setImage(new Image(getClass().getResourceAsStream("images/submarinoEsp.png")));
        asignarPos(submarinoImg, numbers.remove(0));
        control.addBarco(barcoSubEsp = new Barco("submarino", "España", submarinoImg, control.getBarcos(), bola, ventana));

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Collections.shuffle(numbers);

        ImageView destructorImg2 = new ImageView();
        destructorImg2.setImage(new Image(getClass().getResourceAsStream("images/destructorFr.png")));

        asignarPosFr(destructorImg2, numbers.remove(0));
        control.addBarco(barcoDesFr = new Barco("destructor", "Francia", destructorImg2, control.getBarcos(), bola, ventana));


        ImageView acorazadoImg2 = new ImageView();
        acorazadoImg2.setImage(new Image(getClass().getResourceAsStream("images/acorazadoFr.png")));
        asignarPosFr(acorazadoImg2, numbers.remove(0));
        control.addBarco(barcoAcoFr = new Barco("acorazado", "Francia", acorazadoImg2, control.getBarcos(), bola, ventana));

        ImageView lanchaImg2 = new ImageView();
        lanchaImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoFr.png")));
        asignarPosFr(lanchaImg2, numbers.remove(0));
        control.addBarco(barcoLanFr = new Barco("lancha", "Francia", lanchaImg2, control.getBarcos(), bola, ventana));


        ImageView submarinoImg2 = new ImageView();
        submarinoImg2.setImage(new Image(getClass().getResourceAsStream("images/submarinoFr.png")));
        asignarPosFr(submarinoImg2, numbers.remove(0));
        control.addBarco(barcoSubFr = new Barco("submarino", "Francia", submarinoImg2, control.getBarcos(), bola, ventana));


        pestanaEspana.getControl(control);
        pestanaFrancia.getControl(control);


        ventana.getChildren().addAll(barcoDesEsp.getImagenBarco(), barcoDesFr.getImagenBarco(), barcoAcoEsp.getImagenBarco(), barcoAcoFr.getImagenBarco(),
                barcoLanEsp.getImagenBarco(), barcoLanFr.getImagenBarco(), barcoSubEsp.getImagenBarco(), barcoSubFr.getImagenBarco(), bola);

        control.ganador();

    }
}

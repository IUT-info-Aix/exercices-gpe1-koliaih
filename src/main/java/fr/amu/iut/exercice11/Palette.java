package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private Label label;

    private Label texteDuBas;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label("Cliquez sur un bouton");
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");


        /* VOTRE CODE ICI */
        vert.setOnAction(event -> {
            nbVert++;
            panneau.setStyle("-fx-background-color: green");
            texteDuBas.setText("Le vert c'est cool");
            texteDuBas.setStyle("-fx-text-fill: green");
            texteDuHaut.setText("Vert choisi " + nbVert + " fois");
        });

        rouge.setOnAction(event -> {
            nbRouge++;
            panneau.setStyle("-fx-background-color: red");
            texteDuBas.setText("Le rouge c'est la meilleur couleur !!");
            texteDuBas.setStyle("-fx-text-fill: red");
            texteDuHaut.setText("Rouge choisi " + nbRouge + " fois");
        });

        bleu.setOnAction(event -> {
            nbBleu++;
            panneau.setStyle("-fx-background-color: blue");
            texteDuBas.setText("Le bleu c'est pas mal...");
            texteDuBas.setStyle("-fx-text-fill: blue");
            texteDuHaut.setText("Bleu choisi " + nbBleu + " fois");
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


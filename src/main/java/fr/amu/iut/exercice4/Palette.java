package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();

        //Création Pane
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: rgb(" + nbVert + "," + nbRouge + "," + nbBleu + ");");

        //Texte en haut
        label = new Label();
        bas = new HBox(label);
        bas.setAlignment(Pos.BASELINE_CENTER);

        //Création des boutons
        rouge = new Button("Rouge");
        vert= new Button("Vert");
        bleu = new Button("Bleu");
        HBox boutons = new HBox(rouge, vert, bleu);
        boutons.setAlignment( Pos.CENTER );

        //Action des boutons
        vert.setOnMouseClicked(event -> { nbVert++; label.setText("Vert choisit " + nbVert + " fois");
            int r = Math.min(nbRouge * 50, 255);
            int g = Math.min(nbVert * 50, 255);
            int b = Math.min(nbBleu * 50, 255);
            panneau.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
        });
        rouge.setOnMouseClicked(event -> { nbRouge++;  label.setText("Rouge choisit " + nbRouge + " fois");
            int r = Math.min(nbRouge * 50, 255);
            int g = Math.min(nbVert * 50, 255);
            int b = Math.min(nbBleu * 50, 255);
            panneau.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
        });
        bleu.setOnMouseClicked(event -> { nbBleu++; label.setText("Bleu choisit " + nbBleu + " fois");
            int r = Math.min(nbRouge * 50, 255);
            int g = Math.min(nbVert * 50, 255);
            int b = Math.min(nbBleu * 50, 255);
            panneau.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
        });

        root = new BorderPane();
        root.setBottom(boutons);
        root.setTop(bas);
        root.setCenter(panneau);

        // Création de la scene
        Scene scene = new Scene( root );
        primaryStage.setScene( scene );
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}


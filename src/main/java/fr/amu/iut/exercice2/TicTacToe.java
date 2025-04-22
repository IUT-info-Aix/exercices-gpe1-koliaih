package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {



    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label();
        label1.setGraphic( new ImageView("/exercice2/Croix.png"));
        Label label2 = new Label();
        label2.setGraphic( new ImageView("/exercice2/Rond.png"));
        Label label3 = new Label();
        label3.setGraphic( new ImageView("/exercice2/Vide.png"));
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label1, label2, label3);

        GridPane grid = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Label label = new Label();
                Random random = new Random();
                int nombre = random.nextInt(3);
                switch (nombre) { case 0: label.setGraphic( new ImageView("/exercice2/Croix.png")); break;
                case 1: label.setGraphic( new ImageView("/exercice2/Rond.png")); break;
                case 2: label.setGraphic( new ImageView("/exercice2/Vide.png")); break;}
                grid.add(label, i, j);
            }
        }

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setWidth( 150 );
        primaryStage.setHeight( 200 );
        primaryStage.setTitle("Tic Tac Toe");

        // Affichage de la fenêtre
        primaryStage.show();
    }
}


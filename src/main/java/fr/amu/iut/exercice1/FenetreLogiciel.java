package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();


        // Création de la Barre de menu
        Menu menu1 = new Menu("File");
        menu1.getItems().addAll(new MenuItem("New"), new MenuItem("Open"), new MenuItem("Save"), new MenuItem("Close")) ;
        Menu menu2 = new Menu("Edit");
        menu2.getItems().addAll(new MenuItem("Cut"), new MenuItem("Copy"), new MenuItem("Paste")) ;
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);

        //Création des boutons
        Label titre = new Label("Boutons :");
        Button bouton1 = new Button("bouton1");
        Button bouton2 = new Button("bouton2");
        Button bouton3 = new Button("bouton3");
        VBox colonne = new VBox(titre, bouton1, bouton2, bouton3);
        Separator separator = new Separator(Orientation.VERTICAL);
        colonne.setAlignment( Pos.CENTER );

        colonne.setPadding(new Insets(10));
        HBox hbox = new HBox(colonne, separator);

        //Création du milieu
        Label name = new Label("Nom : ");
        TextField nameText = new TextField();
        Label email = new Label("Adresse Email : ");
        TextField emailText = new TextField();
        Label password = new Label("Mot de passe : ");
        Button okay = new Button("okay");
        Button cancel = new Button("cancel");
        PasswordField passwordText = new PasswordField( );
        GridPane grid = new GridPane();
        grid.setHgap(1);
        grid.setVgap(3);
        grid.add(name, 0, 0);
        grid.add(nameText, 1, 0);
        grid.add(email, 0, 1);
        grid.add(emailText, 1, 1);
        grid.add(password, 0, 2);
        grid.add(passwordText, 1, 2);
        grid.add(okay, 0, 3);
        grid.add(cancel, 1, 3);
        grid.setAlignment(Pos.CENTER);

        Label bas = new Label ("Je sais pas quoi écrire X)");
        VBox basBox = new VBox(new Separator(), bas);
        basBox.setPadding(new Insets(5));
        basBox.setAlignment(Pos.BASELINE_CENTER);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(hbox);
        root.setCenter(grid);
        root.setBottom(basBox);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 400 );
        primaryStage.setHeight( 300 );
        primaryStage.setTitle("Exercice 1");

        // Affichage de la fenêtre
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
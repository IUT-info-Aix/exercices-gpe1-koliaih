package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //rectangle
        Rectangle rec = new Rectangle();
        rec.setX(60);
        rec.setY(60);
        rec.setWidth(200);
        rec.setHeight(100);
        rec.setArcWidth(20);
        rec.setArcHeight(20);

        ArrayList<Obstacles> Rectangle = new ArrayList<>();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(rec);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);



        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, primaryStage);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Stage stage) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                        j1.deplacerEnHaut();
                        break;
                case DOWN:
                    j1.deplacerEnBas(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                        j2.deplacerEnBas(scene.getWidth());
                        break;
                case Q:
                    j2.deplacerAGauche();
                    break;

            }


            if (j1.estEnCollision(j2)) {
                stage.close();
            }
        });
    }
}

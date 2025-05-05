package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private Timer timer;
    ArrayList<Obstacle> rectangles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setResizable(false);

        root = new BorderPane();

        //rectangle
        Obstacle rec = new Obstacle(0,260,240,40);
        Obstacle rec2 = new Obstacle(380,300,200,40);
        Obstacle rec3 = new Obstacle(300,160,200,40);
        Obstacle rec4 = new Obstacle(0,100,200,40);


        rectangles.add(rec);
        rectangles.add(rec2);
        rectangles.add(rec3);
        rectangles.add(rec4);

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(60 * 10);
        fantome.setLayoutY(40 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(630, 440);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        for (int i = 0; i < rectangles.size(); i++) {
            jeu.getChildren().add(rectangles.get(i));
        }


        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> alertmaker(primaryStage, "Joueur 2"));
            }
        }, 20000);


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
            if (j1.contactMur(rectangles) == true) {
                switch (event.getCode()) {
                    case LEFT:
                        j1.deplacerADroite(scene.getWidth());
                        break;
                    case RIGHT:
                        j1.deplacerAGauche();
                        break;
                    case UP:
                        j1.deplacerEnBas(scene.getWidth());
                        break;
                    case DOWN:
                        j1.deplacerEnHaut();
                        break;
                }
            }

            if (j2.contactMur(rectangles) == true) {
                switch (event.getCode()) {
                    case Q:
                        j2.deplacerADroite(scene.getWidth());
                        break;
                    case D:
                        j2.deplacerAGauche();
                        break;
                    case Z:
                        j2.deplacerEnBas(scene.getWidth());
                        break;
                    case S:
                        j2.deplacerEnHaut();
                        break;
                }
            }

            if (j1.estEnCollision(j2)) {
                alertmaker(stage, "Joueur 1");
            }
        });
    }
    public void alertmaker(Stage stage, String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de partie");
        alert.setHeaderText(null);
        alert.setContentText(string + " a gagné !");
        alert.showAndWait();
        stage.close();
    }
}


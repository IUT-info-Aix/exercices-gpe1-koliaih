package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class IHMPendu extends Application {

    private String mot;         // Le mot à deviner
    private StringBuilder motCache; // Représentation cachée (ex: ***e*)
    private int vies = 7;       // Nombre de vies

    private TextField motText;  // Affiche le mot caché
    private Label vieLabel;
    private ImageView pendu;// Affiche les vies restantes

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Dico dico = new Dico();
        mot = dico.getMot().toLowerCase();
        motCache = new StringBuilder("*".repeat(mot.length()));
        pendu = new ImageView(new Image("exercice6/pendu" + vies +".png"));
        motText = new TextField(motCache.toString());
        motText.setEditable(false);
        motText.setAlignment(Pos.CENTER);
        motText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");


        vieLabel = new Label("Nombre de vies : " + vies);
        vieLabel.setAlignment(Pos.CENTER);
        vieLabel.setStyle("-fx-font-size: 16px;");

        root.setTop(vieLabel);
        root.setCenter(motText);
        root.setBottom(creerClavier());
        root.setRight(pendu);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du Pendu");
        primaryStage.show();
    }

    private GridPane creerClavier() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int row = 0;
        int col = 0;

        for (char lettre : alphabet.toCharArray()) {
            Button boutonLettre = new Button(String.valueOf(lettre).toUpperCase());
            boutonLettre.setPrefWidth(40);

            final char lettreCliquee = lettre;

            boutonLettre.setOnAction(event -> {
                boutonLettre.setDisable(true);
                gererLettreCliquee(lettreCliquee);
            });

            gridPane.add(boutonLettre, col, row);
            col++;
            if (col > 6) {
                col = 0;
                row++;
            }
        }
        return gridPane;
    }

    private void gererLettreCliquee(char lettre) {
        boolean trouve = false;

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == lettre) {
                motCache.setCharAt(i, lettre);
                trouve = true;
            }
        }

        if (!trouve) {
            vies--;
        }

        pendu.setImage((new Image("exercice6/pendu" + vies + ".png")));


        motText.setText(motCache.toString());
        vieLabel.setText("Nombre de vies : " + vies);

        if (motCache.toString().equals(mot)) {
            pendu.setImage((new Image("exercice6/penduWin.png")));
            afficherMessage("Gagné !", "Félicitations, vous avez trouvé le mot : " + mot);
        } else if (vies == 0) {
            afficherMessage("Perdu !", "Désolé, vous avez perdu. Le mot était : " + mot);
        }
    }

    private void afficherMessage(String titre, String contenu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(contenu);
        alert.showAndWait();
        System.exit(0); // Ferme le jeu après victoire/défaite
    }

    public static void main(String[] args) {
        launch(args);
    }
}

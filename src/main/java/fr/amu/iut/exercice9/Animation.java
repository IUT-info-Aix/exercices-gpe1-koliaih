package fr.amu.iut.exercice9;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        CustomButton customButton = new CustomButton();
        root.setCenter(customButton);
        Scene scene = new Scene(root, 400, 400);

        Duration duration = Duration.millis(500);
        TranslateTransition transition1 = new TranslateTransition(duration, customButton);
        transition1.setByX(150);
        transition1.setByY(-150);

        TranslateTransition transition2 = new TranslateTransition(duration, customButton);
        transition2.setByX(-300);
        transition2.setByY(0);

        TranslateTransition transition3 = new TranslateTransition(duration, customButton);
        transition3.setByX(0);
        transition3.setByY(300);

        TranslateTransition transition4 = new TranslateTransition(duration, customButton);
        transition4.setByX(300);
        transition4.setByY(0);

        TranslateTransition transition5 = new TranslateTransition(duration, customButton);
        transition5.setByX(0);
        transition5.setByY(-300);

        SequentialTransition st = new SequentialTransition(transition1, transition2, transition3, transition4, transition5);
        st.setAutoReverse(true);
        st.setCycleCount(2);

        customButton.setOnMousePressed(mouseEvent -> st.play());

        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
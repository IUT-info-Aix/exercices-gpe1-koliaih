package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {
    @FXML
    private Label counterLabel;

    int counter = 0;

    public void increment() {
        counter = counter + 1;
        counterLabel.setText("" + counter);
    }

    public void decrement() {
        counter = counter - 1;
        counterLabel.setText("" + counter);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}

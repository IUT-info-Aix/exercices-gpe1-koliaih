package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField name;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        StringBuilder pw = new StringBuilder();
        System.out.println(name.getText() + " ");
        for (int i = 0 ; i < pwd.getText().length(); i++) {
            pw.append('*');
        }
        System.out.println(pw);

    }

    @FXML
    private void cancelClicked() {
        name.setText("");
        pwd.setText("");
    }
}
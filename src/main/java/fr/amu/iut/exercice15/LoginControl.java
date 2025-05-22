package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    public void initialize() {
        createBindings();
    }

    private void createBindings() {

        pwd.editableProperty().bind(userId.textProperty().length().greaterThanOrEqualTo(6));

        cancelBtn.disableProperty().bind(
                Bindings.or(
                        userId.textProperty().isEmpty(),
                        pwd.textProperty().isEmpty()
                )
        );


        BooleanBinding passwordValid = Bindings.createBooleanBinding(() -> {
            String passwordText = pwd.getText();
            boolean hasUpperCase = !passwordText.equals(passwordText.toLowerCase());
            boolean hasDigit = passwordText.matches(".*\\d.*");
            return passwordText.length() >= 8 && hasUpperCase && hasDigit;
        }, pwd.textProperty());

        okBtn.disableProperty().bind(passwordValid.not());
    }


    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
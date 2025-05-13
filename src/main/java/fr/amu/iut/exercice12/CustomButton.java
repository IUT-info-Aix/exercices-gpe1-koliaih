package fr.amu.iut.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {

    private String couleur;
    private IntegerProperty nbClics;

    public CustomButton(String texte, String couleur) {
        super(texte);
        this.couleur = couleur;
    }
}

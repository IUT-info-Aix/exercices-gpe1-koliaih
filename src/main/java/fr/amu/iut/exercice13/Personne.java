package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {

    private String nom;
    private IntegerProperty age;
    private StringProperty villeDeNaissance;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = new SimpleIntegerProperty(age);
        this.villeDeNaissance = new SimpleStringProperty("Paris");
    }

    public String getNom() {
        return nom;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }
}

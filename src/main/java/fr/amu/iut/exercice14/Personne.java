package fr.amu.iut.exercice14;

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

    public void setAge(int age) {
        this.age.setValue(age);
    }

    public int getAge(){
        return age.getValue();
    }

    public void setVilleDeNaissance(String ville) {
        villeDeNaissance.setValue(ville);
    }

    public String getVilleDeNaissance(){
        return villeDeNaissance.getValue();
    }
}
package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setHeight(300);
        HBox root = new HBox(10);
        Scene scene = new Scene(root, 200, 400);

        // Créer les propriétés pour les températures
        DoubleProperty celsius = new SimpleDoubleProperty(0);
        DoubleProperty fahrenheit = new SimpleDoubleProperty(32);

        Slider celsiusSlider = new Slider(0, 100, 0);
        Slider fahrenheitSlider = new Slider(0, 212, 0);

        celsiusSlider.setShowTickLabels(true);
        celsiusSlider.setShowTickMarks(true);
        celsiusSlider.setShowTickMarks(true);
        celsiusSlider.setMajorTickUnit(10);
        celsiusSlider.setMinorTickCount(1);
        celsiusSlider.setBlockIncrement(10);

        fahrenheitSlider.setShowTickLabels(true);
        fahrenheitSlider.setShowTickMarks(true);
        fahrenheitSlider.setShowTickMarks(true);
        fahrenheitSlider.setMajorTickUnit(10);
        fahrenheitSlider.setMinorTickCount(1);
        fahrenheitSlider.setBlockIncrement(10);

        fahrenheitSlider.prefHeightProperty().bind(scene.heightProperty().subtract(80));
        celsiusSlider.prefHeightProperty().bind(scene.heightProperty().subtract(80));


        celsiusSlider.setOrientation(Orientation.VERTICAL);
        fahrenheitSlider.setOrientation(Orientation.VERTICAL);

        TextField celsiusTextField = new TextField("0.00");
        TextField fahrenheitTextField = new TextField("32.00");

        celsius.bindBidirectional(celsiusSlider.valueProperty());
        fahrenheit.bindBidirectional(fahrenheitSlider.valueProperty());

        Bindings.bindBidirectional(celsiusTextField.textProperty(), celsius, new NumberStringConverter("0.00"));
        Bindings.bindBidirectional(fahrenheitTextField.textProperty(), fahrenheit, new NumberStringConverter("0.00"));

        // Conversion entre Celsius et Fahrenheit
        celsius.addListener((obs, oldVal, newVal) -> {
            double celsiusValue = newVal.doubleValue();
            double fahrenheitValue = celsiusValue * 9 / 5 + 32;
            fahrenheit.set(fahrenheitValue);
        });

        fahrenheit.addListener((obs, oldVal, newVal) -> {
            double fahrenheitValue = newVal.doubleValue();
            double celsiusValue = (fahrenheitValue - 32) * 5 / 9;
            celsius.set(celsiusValue);
        });

        Label celsiusLabel = new Label("Celsius");
        Label fahrenheitLabel = new Label("Fahrenheit");

        // Disposition des éléments
        VBox celsiusVbox = new VBox(10,celsiusLabel, celsiusSlider,celsiusTextField );
        celsiusVbox.setMinWidth(primaryStage.getWidth()/2);
        celsiusVbox.setMinHeight(primaryStage.getHeight());
        VBox fahrenheitVbox = new VBox(10, fahrenheitLabel ,fahrenheitSlider, fahrenheitTextField);
        fahrenheitVbox.setMinWidth(primaryStage.getWidth()/2);
        fahrenheitVbox.setMinHeight(primaryStage.getHeight());




        root.getChildren().add(celsiusVbox);
        root.getChildren().add(fahrenheitVbox);

        root.setMinHeight(400);
        root.setPadding(new Insets(10));



        primaryStage.setTitle("Conversion de Température");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
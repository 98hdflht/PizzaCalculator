// Quincy Yarbrough
// 7/19/2024
// app to calculate the price of a pizza

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import java.text.NumberFormat;

public class Main extends Application {
    // declare variables so they can be used throughout
    private ToggleGroup sizeToggle = new ToggleGroup();
    private TextField priceField = new TextField();
    private double total = 0.0;
    private final double meat = 1.49;
    private final double veg = .99;
    private CheckBox sausage = new CheckBox("Sausage");
    private CheckBox pepperoni = new CheckBox("Pepperoni");
    private CheckBox salami = new CheckBox("Salami");
    private CheckBox olives = new CheckBox("Olives");
    private CheckBox mushrooms = new CheckBox("Mushrooms");
    private CheckBox anchovies = new CheckBox("Anchovies");

    @Override
    public void start(Stage stage) {
        // the pizza selection gui header
        stage.setTitle("Pizza Price Calculator");
        VBox vbox = new VBox(10);
        // size selection
        VBox sizeCont = new VBox(5);
        Label sizeLabel = new Label("Size");
        HBox sizeBox = new HBox(10);
        RadioButton smallButton = new RadioButton("Small");
        smallButton.setToggleGroup(sizeToggle);
        smallButton.setSelected(true);
        RadioButton mediumButton = new RadioButton("Medium");
        mediumButton.setToggleGroup(sizeToggle);
        RadioButton largeButton = new RadioButton("Large");
        largeButton.setToggleGroup(sizeToggle);
        sizeBox.getChildren().add(smallButton);
        sizeBox.getChildren().add(mediumButton);
        sizeBox.getChildren().add(largeButton);
        sizeCont.getChildren().add(sizeLabel);
        sizeCont.getChildren().add(sizeBox);
        vbox.getChildren().add(sizeCont);
        // toppings area of gui
        GridPane toppingGrid = new GridPane();
        toppingGrid.setHgap(10);
        toppingGrid.setVgap(10);
        Label toppingLabel = new Label("Toppings");
        toppingGrid.add(toppingLabel, 0, 0, 2, 1);
        toppingGrid.add(sausage, 0, 1);
        toppingGrid.add(pepperoni, 0, 2);
        toppingGrid.add(salami, 0, 3);
        toppingGrid.add(olives, 1, 1);
        toppingGrid.add(mushrooms, 1, 2);
        toppingGrid.add(anchovies, 1, 3);
        vbox.getChildren().add(toppingGrid);
        // price field
        HBox priceBox = new HBox(10);
        Label priceLabel = new Label("Price: ");
        priceField.setMinWidth(150);
        priceBox.getChildren().add(priceLabel);
        priceBox.getChildren().add(priceField);
        vbox.getChildren().add(priceBox);
        // calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculateButtonClicked());
        vbox.getChildren().add(calculateButton);

        vbox.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
    // calculate price
    public void calculateButtonClicked() {
        RadioButton selectedSize = (RadioButton) sizeToggle.getSelectedToggle();
        total = 0.0;
        // price per size
        String size = selectedSize.getText();
        if (size.equals("Small")) {
            total += 6.99;
        } else if (size.equals("Medium")) {
            total += 8.99;
        } else {
            total += 10.99;
        }
        // price per topping
        if (sausage.isSelected()) {
            total += meat;
        }
        if (pepperoni.isSelected()) {
            total += meat;
        }
        if (salami.isSelected()) {
            total += meat;
        }
        if (olives.isSelected()) {
            total += veg;
        }
        if (mushrooms.isSelected()) {
            total += veg;
        }
        if ( anchovies.isSelected()) {
            total += veg;
        }
        // output the price
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        priceField.setText(currency.format(total));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;

public class Main extends Application {

    private ToggleGroup sizeToggle = new ToggleGroup();
    private CheckBox toppingBox = new CheckBox();
    private TextField priceField = new TextField();
    private double total = 0.0;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pizza Price Calculator");
        VBox vbox = new VBox(10);

        HBox sizeBox = new HBox(10);
        Label sizeLabel = new Label("Size");
        RadioButton smallButton = new RadioButton("Small");
        smallButton.setToggleGroup(sizeToggle);
        smallButton.setSelected(true);
        RadioButton mediumButton = new RadioButton("Medium");
        mediumButton.setToggleGroup(sizeToggle);
        RadioButton largeButton = new RadioButton("Large");
        largeButton.setToggleGroup(sizeToggle);
        sizeBox.getChildren().add(sizeLabel);
        sizeBox.getChildren().add(smallButton);
        sizeBox.getChildren().add(mediumButton);
        sizeBox.getChildren().add(largeButton);
        vbox.getChildren().add(sizeBox);

        HBox toppingBox = new HBox(10);
        Label toppingLabel = new Label("Toppings");
        CheckBox sausage = new CheckBox("Sausage");
        CheckBox pepperoni = new CheckBox("Pepperoni");
        CheckBox salami = new CheckBox("Salami");
        CheckBox olives = new CheckBox("Olives");
        CheckBox mushrooms = new CheckBox("Mushrooms");
        CheckBox anchovies = new CheckBox("Anchovies");
        toppingBox.getChildren().add(toppingLabel);
        toppingBox.getChildren().add(sausage);
        toppingBox.getChildren().add(pepperoni);
        toppingBox.getChildren().add(salami);
        toppingBox.getChildren().add(olives);
        toppingBox.getChildren().add(mushrooms);
        toppingBox.getChildren().add(anchovies);

        HBox priceBox = new HBox(10);
        Label priceLabel = new Label("Price: ");
        priceField.setMinWidth(150);
        priceBox.getChildren().add(priceLabel);
        priceBox.getChildren().add(priceField);
        vbox.getChildren().add(priceBox);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculateButtonClicked());
        vbox.getChildren().add(calculateButton);

        vbox.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public void calculateButtonClicked() {
        RadioButton selectedSize = (RadioButton) sizeToggle.getSelectedToggle();
        if (selectedSize.equals("Small")) {
            total += 6.99;
        } else if (selectedSize.equals("Medium")) {
            total += 8.99;
        } else {
            total += 10.99;
        }

        if (toppingBox.isSelected()) {

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


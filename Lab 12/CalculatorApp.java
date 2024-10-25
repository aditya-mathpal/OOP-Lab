import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));

        HBox inputFields = new HBox(15);
        inputFields.setAlignment(Pos.CENTER);

        VBox num1Box = new VBox(5);
        Label num1Label = new Label("Number 1:");
        TextField num1Field = new TextField();
        num1Field.setPrefWidth(100);
        num1Box.getChildren().addAll(num1Label, num1Field);

        VBox num2Box = new VBox(5);
        Label num2Label = new Label("Number 2:");
        TextField num2Field = new TextField();
        num2Field.setPrefWidth(100);
        num2Box.getChildren().addAll(num2Label, num2Field);

        inputFields.getChildren().addAll(num1Box, num2Box);

        Canvas resultCanvas = new Canvas(280, 60);
        GraphicsContext gc = resultCanvas.getGraphicsContext2D();

        StackPane calculatorContainer = new StackPane();
        Image calculatorImage = new Image(getClass().getResourceAsStream("calculator.webp"));
        ImageView calculatorImageView = new ImageView(calculatorImage);
        calculatorImageView.setFitWidth(300);
        calculatorImageView.setFitHeight(400);

        Button computeButton = new Button("=");
        computeButton.setStyle("-fx-background-color: #ff7f50; -fx-text-fill: white; -fx-font-size: 18px;");
        StackPane.setAlignment(resultCanvas, Pos.TOP_CENTER);
        StackPane.setMargin(resultCanvas, new Insets(60, 0, 0, 0));
        StackPane.setAlignment(computeButton, Pos.CENTER);
        StackPane.setMargin(computeButton, new Insets(180, -180, 0, 0));

        calculatorContainer.getChildren().addAll(calculatorImageView, resultCanvas, computeButton);
        mainLayout.getChildren().addAll(inputFields, calculatorContainer);

        computeButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                gc.clearRect(0, 0, resultCanvas.getWidth(), resultCanvas.getHeight());
                gc.fillText(String.format("Sum: %.2f", num1 + num2), 10, 15);
                gc.fillText(String.format("Product: %.2f", num1 * num2), 10, 30);
                gc.fillText(String.format("Difference: %.2f", num1 - num2), 10, 45);
                gc.fillText(String.format("Quotient: %.2f", num1 / num2), 10, 60);
            } catch (Exception ex) {
                gc.clearRect(0, 0, resultCanvas.getWidth(), resultCanvas.getHeight());
                gc.fillText("Error!", 10, 30);
            }
        });

        Scene scene = new Scene(mainLayout, 400, 650);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

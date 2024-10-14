import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class MultiplicationTables extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multiplication Table");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter an integer");

        Button generateButton = new Button("Generate Table");
        Label resultLabel = new Label();
        generateButton.setOnAction(e -> {
            try {
                int number = Integer.parseInt(inputField.getText());
                StringBuilder table = new StringBuilder();
                for (int i = 1; i <= 10; i++) {
                    table.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
                }
                resultLabel.setText(table.toString());
            }
            catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid integer.");
            }
        });

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.getChildren().addAll(inputField, generateButton, resultLabel);

        Scene scene = new Scene(flowPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*
compile with:
javac --module-path "/home/ooplab/Desktop/OOP/230905232/OOP-Lab/Lab 11/openjfx-23_linux-x64_bin-sdk/javafx-sdk-23/lib" --add-modules javafx.controls MultiplicationTables.java

run with:
java --module-path "/home/ooplab/Desktop/OOP/230905232/OOP-Lab/Lab 11/openjfx-23_linux-x64_bin-sdk/javafx-sdk-23/lib" --add-modules javafx.controls MultiplicationTables
*/

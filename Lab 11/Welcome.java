import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.paint.*;

public class Welcome extends Application {
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));

        Label label = new Label("Welcome to JavaFX programming");
        label.setTextFill(Color.MAGENTA);
        root.getChildren().add(label);

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setTitle("This is the first JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
compile with:
javac --module-path "/home/ooplab/Desktop/OOP/230905232/OOP-Lab/Lab 11/openjfx-23_linux-x64_bin-sdk/javafx-sdk-23/lib" --add-modules javafx.controls Welcome.java

run with:
java --module-path "/home/ooplab/Desktop/OOP/230905232/OOP-Lab/Lab 11/openjfx-23_linux-x64_bin-sdk/javafx-sdk-23/lib" --add-modules javafx.controls Welcome
*/
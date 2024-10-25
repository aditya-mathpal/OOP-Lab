import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ResumeApp extends Application {
    private Canvas previewCanvas;
    private GraphicsContext gc;
    private final int CANVAS_WIDTH = 400;  
    private final int CANVAS_HEIGHT = 600;
    private final int MARGIN = 40;
    private final int LINE_HEIGHT = 25;
    private TextField nameField;
    private TextArea educationArea, experienceArea, skillsArea;
    private VBox languagesBox;

    @Override
    public void start(Stage primaryStage) {
        HBox mainLayout = new HBox(20);
        mainLayout.setPadding(new Insets(20));
        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.TOP_LEFT);

        nameField = createTextField(300);
        educationArea = createTextArea(300, 3);
        experienceArea = createTextArea(300, 3);
        languagesBox = createLanguagesBox();
        skillsArea = createTextArea(300, 2);

        formGrid.addRow(0, new Label("Full Name:"), nameField);
        formGrid.addRow(1, new Label("Education:"), educationArea);
        formGrid.addRow(2, new Label("Experience:"), experienceArea);
        formGrid.addRow(3, new Label("Languages:"), languagesBox);
        formGrid.addRow(4, new Label("Skills:"), skillsArea);

        Button submitButton = new Button("Submit Resume");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        formGrid.add(submitButton, 0, 5, 2, 1);

        ScrollPane scrollPane = new ScrollPane(formGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(600);

        previewCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        gc = previewCanvas.getGraphicsContext2D();

        submitButton.setOnAction(e -> drawResume());
        mainLayout.getChildren().addAll(scrollPane, previewCanvas);

        primaryStage.setScene(new Scene(mainLayout, CANVAS_WIDTH + 500, CANVAS_HEIGHT + 40));
        primaryStage.setTitle("Resume Builder");
        primaryStage.show();
    }

    private TextField createTextField(int width) {
        TextField tf = new TextField();
        tf.setPrefWidth(width);
        return tf;
    }

    private TextArea createTextArea(int width, int rows) {
        TextArea ta = new TextArea();
        ta.setPrefRowCount(rows);
        ta.setPrefWidth(width);
        return ta;
    }

    private VBox createLanguagesBox() {
        VBox vb = new VBox(5);
        vb.getChildren().addAll(
            new CheckBox("English"),
            new CheckBox("Spanish"),
            new CheckBox("French"),
            new CheckBox("German"),
            new CheckBox("Chinese")
        );
        return vb;
    }

    private void drawResume() {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        double y = MARGIN;
        gc.fillText("RESUME", MARGIN, y);
        y += LINE_HEIGHT;
        gc.fillText("Name: " + nameField.getText(), MARGIN, y);
        y += LINE_HEIGHT;

        gc.fillText("Education:", MARGIN, y);
        y += LINE_HEIGHT;
        gc.setFont(Font.font("Arial", 12));
        for(String line : educationArea.getText().split("\n")) {
            gc.fillText(line, MARGIN + 10, y);
            y += LINE_HEIGHT;
        }
        
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gc.fillText("Experience:", MARGIN, y);
        y += LINE_HEIGHT;
        gc.setFont(Font.font("Arial", 12));
        for(String line : experienceArea.getText().split("\n")) {
            gc.fillText(line, MARGIN + 10, y);
            y += LINE_HEIGHT;
        }

        gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gc.fillText("Languages:", MARGIN, y);
        y += LINE_HEIGHT;
        gc.setFont(Font.font("Arial", 12));
        StringBuilder langs = new StringBuilder();
        languagesBox.getChildren().forEach(node -> {
            if(node instanceof CheckBox && ((CheckBox)node).isSelected()) {
                if(langs.length() > 0) langs.append(", ");
                langs.append(((CheckBox)node).getText());
            }
        });
        gc.fillText(langs.toString(), MARGIN + 10, y);
        y += LINE_HEIGHT;

        gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gc.fillText("Skills:", MARGIN, y);
        y += LINE_HEIGHT;
        gc.setFont(Font.font("Arial", 12));
        for(String line : skillsArea.getText().split("\n")) {
            gc.fillText(line, MARGIN + 10, y);
            y += LINE_HEIGHT;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
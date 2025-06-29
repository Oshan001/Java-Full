import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXUIForCollegeProject extends Application {

    // Emoji + Text labels
    private final String[][] items = {
            {"📆", "Upcoming Event"},         // calendar page for events
            {"💻", "My Classroom"},           // laptop for virtual classroom
            {"  📝", "Exam & Result"},          // writing for exam
            {"🧑‍🤝‍🧑", "My Classmates"},     // people together
            {"    🗒️", "My Notes"},              // notepad for notes
            {"🧑‍🏫", "Ask Teacher"},         // teacher figure
            {"     🗨️", "Chat with Mates"},       // speech bubble
            {"    🗓️", "Calendar"},              // tear-off calendar
            {"📘", "Syllabus"},              // blue book
            {"🧑‍💻", "About Developer"}      // developer
    };


    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Top menu bar
        HBox topBar = new HBox();
        topBar.setStyle("-fx-background-color: goldenrod;");
        topBar.setPadding(new Insets(15));
        Label menuLabel = new Label("📚 Menu");
        menuLabel.setTextFill(Color.WHITE);
        menuLabel.setFont(Font.font("Arial", 20));
        topBar.getChildren().add(menuLabel);
        root.setTop(topBar);

        // Grid layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setAlignment(Pos.CENTER);

        int col = 0, row = 0;
        for (int i = 0; i < items.length; i++) {
            VBox tile = createTile(items[i][0], items[i][1]);
            grid.add(tile, col, row);
            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        root.setCenter(grid);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("JavaFX UI for College Project");
        stage.setScene(scene);
        stage.show();
    }

    // Creates a tile with emoji icon and label
    private VBox createTile(String emoji, String text) {
        Label icon = new Label(emoji);
        icon.setFont(Font.font(36));
        Label label = new Label(text);
        label.setFont(Font.font("Arial", 14));
        VBox box = new VBox(10, icon, label);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(160, 100);
        box.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #cccccc; -fx-border-radius: 4; -fx-background-radius: 4;");
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

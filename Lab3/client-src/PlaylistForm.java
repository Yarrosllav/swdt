import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlaylistForm {
    private static String playlistName = null;

    public static String display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Створити новий плейлист");
        window.setMinWidth(300);

        Label label = new Label("Введіть назву плейлиста:");
        TextField nameInput = new TextField();
        Button saveButton = new Button("Зберегти");

        saveButton.setOnAction(e -> {
            playlistName = nameInput.getText();
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(label, nameInput, saveButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return playlistName;
    }
}

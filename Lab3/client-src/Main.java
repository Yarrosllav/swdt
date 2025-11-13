import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
public class Main extends Application {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String serverUrl = "http://localhost:8080/api/playlists";

    private ListView<Playlist> playlistListView = new ListView<>();
    private ObservableList<Playlist> playlists = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Музичний програвач");

        Button createButton = new Button("Створити новий плейлист");
        createButton.setOnAction(e -> handleCreatePlaylist());

        Button refreshButton = new Button("Оновити список");
        refreshButton.setOnAction(e -> loadPlaylists());

        playlistListView.setItems(playlists);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(new Label("Мої плейлисти:"), playlistListView, createButton, refreshButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        loadPlaylists(); // Завантажуємо дані при першому запуску
    }

    private void loadPlaylists() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl))
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Playlist> serverPlaylists = objectMapper.readValue(response.body(), new TypeReference<>() {});
            playlists.setAll(serverPlaylists);
        } catch (Exception e) {
            showAlert("Помилка завантаження", "Не вдалося завантажити плейлисти з сервера.");
            e.printStackTrace();
        }
    }

    private void handleCreatePlaylist() {
        String name = PlaylistForm.display();

        if (name != null && !name.trim().isEmpty()) {
            // Створюємо тіло запиту
            String json = String.format("{\"name\":\"%s\"}", name);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    loadPlaylists();
                } else {
                    showAlert("Помилка", "Не вдалося створити плейлист. Статус: " + response.statusCode());
                }
            } catch (Exception e) {
                showAlert("Помилка з'єднання", "Не вдалося відправити дані на сервер.");
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
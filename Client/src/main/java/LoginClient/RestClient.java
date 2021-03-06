package LoginClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RestClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
        primaryStage.setTitle("AquariumOnline");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void changeScene(String fxml,Stage primaryStage) throws IOException
    {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));

        primaryStage.getScene().setRoot(pane);
    }
}

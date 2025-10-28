package hotelmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Главен клас на системата „Хотел“ – стартира JavaFX приложението.
 */
public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login-view.fxml"));
        Scene scene = new Scene(loader.load(), 800, 500);
        stage.setTitle("Hotel Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

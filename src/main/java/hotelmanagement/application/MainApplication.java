package hotelmanagement.application;

import hotelmanagement.model.*;
import hotelmanagement.service.RoomService;
import hotelmanagement.service.UserService;
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

        UserService userService = UserService.getInstance();
        userService.registerUser(new Admin("Admin User", "admin@hotel.com", "1234"));
        userService.registerUser(new Manager("Manager User", "manager@hotel.com", "1234"));
        userService.registerUser(new Receptionist("Receptionist User", "recept@hotel.com", "1234"));
        userService.registerUser(new Client("Client User", "client@hotel.com", "1234"));


        RoomService roomService = RoomService.getInstance();
        roomService.addRoom(new Room("101", "Single", 50.0, "Available"));
        roomService.addRoom(new Room("102", "Double", 70.0, "Occupied"));
        roomService.addRoom(new Room("201", "Suite", 120.0, "Available"));


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

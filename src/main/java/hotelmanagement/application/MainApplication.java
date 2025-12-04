package hotelmanagement.application;

import hotelmanagement.model.*;
import hotelmanagement.service.ReservationService;
import hotelmanagement.service.RoomService;
import hotelmanagement.service.ServiceService;
import hotelmanagement.service.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

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



        ReservationService reservationService = ReservationService.getInstance();

        reservationService.addReservation(
                new Reservation(
                        1,
                        userService.getUserByEmail("client@hotel.com"),
                        null,
                        roomService.getRoomByNumber("101"),
                        LocalDate.of(2025, 1, 10),
                        LocalDate.of(2025, 1, 15),
                        "Confirmed"
                )
        );

        reservationService.addReservation(
                new Reservation(
                        2,
                        userService.getUserByEmail("client@hotel.com"),
                        null,
                        roomService.getRoomByNumber("201"),
                        LocalDate.of(2025, 3, 5),
                        LocalDate.of(2025, 3, 9),
                        "Pending"
                )
        );

        reservationService.addReservation(
                new Reservation(
                        3,
                        userService.getUserByEmail("recept@hotel.com"),
                        null,
                        roomService.getRoomByNumber("102"),
                        LocalDate.of(2025, 2, 1),
                        LocalDate.of(2025, 2, 5),
                        "Cancelled"
                )
        );


        ServiceService serviceService = ServiceService.getInstance();
        serviceService.addService(new Service("1", "Room Cleaning", 20.0, "Basic daily cleaning"));
        serviceService.addService(new Service("2", "Laundry", 15.0, "Wash and fold"));
        serviceService.addService(new Service("3", "Airport Shuttle", 30.0, "Transport from and to airport"));


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

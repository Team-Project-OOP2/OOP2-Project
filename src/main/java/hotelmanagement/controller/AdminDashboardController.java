package hotelmanagement.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnRooms;

    @FXML
    private Button btnReservations;

    @FXML
    private Button btnServices;

    @FXML
    private Button btnLogout;

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        btnUsers.setOnAction(e -> loadView("/view/manage-users.fxml"));
        btnRooms.setOnAction(e -> loadView("/view/manage-rooms.fxml"));
        btnReservations.setOnAction(e -> loadView("/view/manage-reservations.fxml"));
        btnServices.setOnAction(e -> loadView("/view/manage-services.fxml"));
        btnLogout.setOnAction(e -> logout());
    }

    private void loadView(String path) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(path));
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logout() {
        System.out.println("LOGOUT CLICKED");
    }
}

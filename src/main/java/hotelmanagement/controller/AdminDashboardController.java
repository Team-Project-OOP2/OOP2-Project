package hotelmanagement.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class AdminDashboardController {

    @FXML
    private StackPane contentArea;

    private void loadView(String fxml) {
        try {
            Parent view = FXMLLoader.load(
                    getClass().getResource("/view/" + fxml)
            );
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void openManageUsers() {
        loadView("manage-users.fxml");
    }

    @FXML
    private void openManageRooms() {
        loadView("manage-rooms-view.fxml");
    }

    @FXML
    private void openManageReservations() {
        loadView("manage-reservations-view.fxml");
    }

    @FXML
    private void openManageServices() {
        loadView("manage-services-view.fxml");
    }

    @FXML
    private void logout() {
        loadView("login-view.fxml");
    }
}

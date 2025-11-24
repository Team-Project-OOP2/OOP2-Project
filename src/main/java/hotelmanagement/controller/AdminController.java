package hotelmanagement.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private Button btnManageUsers;

    private void loadView(String viewName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + viewName));
            Parent root = loader.load();
            Stage stage = (Stage) btnManageUsers.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openManageUsers() {
        loadView("manage-users.fxml");
    }

    public void openManageRooms() {
        loadView("manage-rooms-view.fxml");
    }

    public void openManageReservations() {
        loadView("manage-reservations-view.fxml");
    }

    public void openManageServices() {
        loadView("manage-services-view.fxml");
    }

    public void logout() {
        loadView("login-view.fxml");
    }
}

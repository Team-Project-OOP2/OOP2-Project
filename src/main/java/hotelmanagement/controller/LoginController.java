package hotelmanagement.controller;

import hotelmanagement.model.User;
import hotelmanagement.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final UserService userService = UserService.getInstance();

    @FXML
    public void onLoginClick() {
        String email = emailField.getText();
        String password = passwordField.getText();

        User user = userService.login(email, password);

        if (user == null) {
            errorLabel.setText("Invalid email or password!");
            return;
        }
        System.out.println("LOGIN SUCCESSFUL: " + user.getRole());

        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            loadView("/view/admin-dashboard.fxml");
            return;
        }

        if (user.getRole().equalsIgnoreCase("MANAGER")) {
            loadView("/view/manager-view.fxml");
            return;
        }

        if (user.getRole().equalsIgnoreCase("RECEPTIONIST")) {
            loadView("/view/reception-view.fxml");
            return;
        }

        if (user.getRole().equalsIgnoreCase("CLIENT")) {
            loadView("/view/client-view.fxml");
        }
    }

    private void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load(), 800, 500);
            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package hotelmanagement.controller;

import hotelmanagement.model.User;
import hotelmanagement.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    }
}

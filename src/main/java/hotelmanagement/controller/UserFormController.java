package hotelmanagement.controller;

import hotelmanagement.model.*;
import hotelmanagement.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserFormController {

    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> cmbRole;

    private final UserService userService = UserService.getInstance();
    private User user;

    @FXML
    public void initialize() {
        if (cmbRole != null && cmbRole.getItems().isEmpty()) {
            cmbRole.getItems().addAll("ADMIN", "MANAGER", "RECEPTIONIST", "CLIENT");
        }
        if (cmbRole != null) {
            cmbRole.getSelectionModel().selectFirst();
        }
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            txtName.setText(user.getName());
            txtEmail.setText(user.getEmail());
            txtPassword.setText(user.getPassword());
            if (cmbRole != null) {
                cmbRole.setValue(user.getRole());
            }
        }
    }

    @FXML
    private void onSave() {
        String name = txtName.getText() == null ? "" : txtName.getText().trim();
        String email = txtEmail.getText() == null ? "" : txtEmail.getText().trim();
        String password = txtPassword.getText() == null ? "" : txtPassword.getText().trim();
        String roleRaw = (cmbRole == null || cmbRole.getValue() == null) ? "" : cmbRole.getValue().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || roleRaw.isEmpty()) {
            showAlert("Please fill in all fields!");
            return;
        }

        String role = roleRaw.toUpperCase();

        if (user == null) {
            User newUser = createUserByRole(role, name, email, password);
            if (newUser == null) {
                showAlert("Cannot create user for role: " + roleRaw);
                return;
            }
            userService.addUser(newUser);
        } else {
            user.nameProperty().set(name);
            user.emailProperty().set(email);
            user.passwordProperty().set(password);
            user.roleProperty().set(role);
            userService.updateUser(user);
        }

        closeWindow();
    }

    private User createUserByRole(String role, String name, String email, String password) {
        switch (role) {
            case "ADMIN": return new Admin(name, email, password);
            case "MANAGER": return new Manager(name, email, password);
            case "RECEPTIONIST": return new Receptionist(name, email, password);
            case "CLIENT": return new Client(name, email, password);
            default: return null;
        }
    }

    @FXML
    private void onCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) txtName.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}

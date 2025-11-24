package hotelmanagement.controller;

import hotelmanagement.model.User;
import hotelmanagement.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManageUsersController {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> colId;

    @FXML
    private TableColumn<User, String> colName;

    @FXML
    private TableColumn<User, String> colEmail;

    @FXML
    private TableColumn<User, String> colRole;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    private final UserService userService = UserService.getInstance();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> c.getValue().idProperty());
        colName.setCellValueFactory(c -> c.getValue().nameProperty());
        colEmail.setCellValueFactory(c -> c.getValue().emailProperty());
        colRole.setCellValueFactory(c -> c.getValue().roleProperty());

        userTable.setItems(FXCollections.observableArrayList(userService.getAllUsers()));

        btnDelete.setOnAction(e -> deleteUser());
    }

    private void deleteUser() {
        User selected = userTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a user!");
            return;
        }

        userService.deleteUser(selected.getId());
        userTable.getItems().remove(selected);
        showAlert("User removed successfully.");
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

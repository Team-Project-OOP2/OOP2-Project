package hotelmanagement.controller;

import hotelmanagement.model.User;
import hotelmanagement.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageUsersController {

    @FXML private TableView<User> userTable;

    @FXML private TableColumn<User, String> colId;
    @FXML private TableColumn<User, String> colName;
    @FXML private TableColumn<User, String> colEmail;
    @FXML private TableColumn<User, String> colRole;

    @FXML private Button btnAdd;
    @FXML private Button btnEdit;
    @FXML private Button btnDelete;

    private final UserService userService = UserService.getInstance();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> c.getValue().idProperty());
        colName.setCellValueFactory(c -> c.getValue().nameProperty());
        colEmail.setCellValueFactory(c -> c.getValue().emailProperty());
        colRole.setCellValueFactory(c -> c.getValue().roleProperty());

        refreshTable();

        if (btnAdd != null) btnAdd.setOnAction(e -> onAddUser());
        if (btnEdit != null) btnEdit.setOnAction(e -> onEditUser());
        if (btnDelete != null) btnDelete.setOnAction(e -> onDeleteUser());
    }

    @FXML
    private void onAddUser() {
        openUserForm(null);
    }

    @FXML
    private void onEditUser() {
        User selected = userTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a user to edit!");
            return;
        }
        openUserForm(selected);
    }

    @FXML
    private void onDeleteUser() {
        User selected = userTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a user!");
            return;
        }

        userService.deleteUser(selected.getId());
        refreshTable();
        showAlert("User removed successfully.");
    }

    private void refreshTable() {
        userTable.setItems(FXCollections.observableArrayList(userService.getAllUsers()));
    }

    private void openUserForm(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user-form.fxml"));
            Parent root = loader.load();

            UserFormController controller = loader.getController();
            controller.setUser(user);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("User Form");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unable to open user form!");
        }
    }

    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}

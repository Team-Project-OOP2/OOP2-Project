package hotelmanagement.controller;

import hotelmanagement.model.Room;
import hotelmanagement.service.RoomService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ManageRoomsController {

    @FXML private TableView<Room> roomTable;

    @FXML private TableColumn<Room, String> colNumber;
    @FXML private TableColumn<Room, String> colType;
    @FXML private TableColumn<Room, Double> colPrice;
    @FXML private TableColumn<Room, String> colStatus;

    private final RoomService roomService = RoomService.getInstance();

    @FXML
    public void initialize() {
        colNumber.setCellValueFactory(c -> c.getValue().numberProperty());
        colType.setCellValueFactory(c -> c.getValue().typeProperty());
        colPrice.setCellValueFactory(c -> c.getValue().priceProperty().asObject());
        colStatus.setCellValueFactory(c -> c.getValue().statusProperty());

        loadRooms();
    }

    private void loadRooms() {
        roomTable.setItems(FXCollections.observableArrayList(roomService.getAllRooms()));
    }

    @FXML
    private void onAddRoom() {
        openRoomForm(null);
    }

    @FXML
    private void onEditRoom() {
        Room selected = roomTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a room to edit!");
            return;
        }

        openRoomForm(selected);
    }

    @FXML
    private void onDeleteRoom() {
        Room selected = roomTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a room to delete!");
            return;
        }

        roomService.deleteRoom(selected.getNumber());
        loadRooms();
        showAlert("Room deleted successfully!");
    }

    private void openRoomForm(Room room) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/room-form.fxml"));
            Parent root = loader.load();

            RoomFormController controller = loader.getController();
            if (room != null) {
                controller.setRoom(room);
            }

            Stage stage = new Stage();
            stage.setTitle("Room Form");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Refresh after closing form
            loadRooms();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unable to open room form!");
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

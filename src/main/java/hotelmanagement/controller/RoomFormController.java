package hotelmanagement.controller;

import hotelmanagement.model.Room;
import hotelmanagement.service.RoomService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RoomFormController {

    @FXML private Label titleLabel;
    @FXML private TextField txtNumber;
    @FXML private TextField txtType;
    @FXML private TextField txtPrice;
    @FXML private ComboBox<String> comboStatus;

    private Room editingRoom;
    private final RoomService roomService = RoomService.getInstance();

    @FXML
    public void initialize() {
        comboStatus.getItems().addAll("Available", "Occupied", "Maintenance");
    }


    public void setRoom(Room room) {
        this.editingRoom = room;

        if (room != null) {
            titleLabel.setText("Edit Room");
            txtNumber.setText(room.getNumber());
            txtType.setText(room.getType());
            txtPrice.setText(String.valueOf(room.getPrice()));
            comboStatus.setValue(room.getStatus());
        }
    }

    @FXML
    private void onSave() {
        String number = txtNumber.getText();
        String type = txtType.getText();
        String priceText = txtPrice.getText();
        String status = comboStatus.getValue();

        if (number.isEmpty() || type.isEmpty() || priceText.isEmpty() || status == null) {
            showAlert("All fields are required!");
            return;
        }

        double price;

        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            showAlert("Invalid price!");
            return;
        }

        if (editingRoom == null) {
            // ADD new room
            Room newRoom = new Room(number, type, price, status);
            roomService.addRoom(newRoom);
        } else {

            editingRoom.setNumber(number);
            editingRoom.setType(type);
            editingRoom.setPrice(price);
            editingRoom.setStatus(status);
        }

        closeWindow();
    }

    @FXML
    private void onCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) txtNumber.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

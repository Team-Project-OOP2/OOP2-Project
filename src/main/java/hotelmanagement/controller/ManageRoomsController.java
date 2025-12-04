package hotelmanagement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import hotelmanagement.model.Room;
import hotelmanagement.service.RoomService;
import javafx.collections.FXCollections;

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

        roomTable.setItems(FXCollections.observableArrayList(roomService.getAllRooms()));
    }
}

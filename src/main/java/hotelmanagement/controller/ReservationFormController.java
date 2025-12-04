package hotelmanagement.controller;

import hotelmanagement.model.Reservation;
import hotelmanagement.model.Room;
import hotelmanagement.model.User;
import hotelmanagement.service.ReservationService;
import hotelmanagement.service.RoomService;
import hotelmanagement.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ReservationFormController {

    @FXML private Label titleLabel;
    @FXML private ComboBox<User> comboClient;
    @FXML private ComboBox<Room> comboRoom;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox<String> comboStatus;

    private Reservation editingReservation = null;
    private final ReservationService reservationService = ReservationService.getInstance();

    @FXML
    public void initialize() {
        comboClient.getItems().setAll(UserService.getInstance().getAllUsers());
        comboRoom.getItems().setAll(RoomService.getInstance().getAllRooms());

        comboStatus.getItems().addAll("ACTIVE", "CANCELLED", "COMPLETED");
    }

    public void setReservation(Reservation reservation) {
        this.editingReservation = reservation;
        titleLabel.setText("Edit Reservation");

        comboClient.setValue(reservation.getClient());
        comboRoom.setValue(reservation.getRoom());
        startDatePicker.setValue(reservation.getStartDate());
        endDatePicker.setValue(reservation.getEndDate());
        comboStatus.setValue(reservation.getStatus());
    }

    @FXML
    private void onSave() {
        User client = comboClient.getValue();
        Room room = comboRoom.getValue();
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();
        String status = comboStatus.getValue();

        if (client == null || room == null || start == null || end == null || status == null) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields!").showAndWait();
            return;
        }

        if (editingReservation == null) {
            // Add
            Reservation reservation = new Reservation(
                    reservationService.getAllReservations().size() + 1,
                    client,
                    null,
                    room,
                    start,
                    end,
                    status
            );
            reservationService.addReservation(reservation);
        } else {
            editingReservation.setClient(client);
            editingReservation.setRoom(room);
            editingReservation.setStartDate(start);
            editingReservation.setEndDate(end);
            editingReservation.setStatus(status);
        }

        closeWindow();
    }

    @FXML
    private void onCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }
}

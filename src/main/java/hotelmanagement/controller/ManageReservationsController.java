package hotelmanagement.controller;

import hotelmanagement.model.Reservation;
import hotelmanagement.service.ReservationService;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ManageReservationsController {

    @FXML private TableView<Reservation> reservationTable;

    @FXML private TableColumn<Reservation, Number> colId;
    @FXML private TableColumn<Reservation, String> colClient;
    @FXML private TableColumn<Reservation, String> colRoom;
    @FXML private TableColumn<Reservation, String> colStartDate;
    @FXML private TableColumn<Reservation, String> colEndDate;
    @FXML private TableColumn<Reservation, String> colStatus;

    private final ReservationService reservationService = ReservationService.getInstance();


    @FXML
    public void initialize() {

        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()));
        colClient.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getClient() != null ? c.getValue().getClient().getName() : "N/A"
        ));
        colRoom.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getRoom() != null ? c.getValue().getRoom().getNumber() : "N/A"
        ));
        colStartDate.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getStartDate().toString()
        ));
        colEndDate.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getEndDate().toString()
        ));
        colStatus.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getStatus()
        ));

        reservationTable.setItems(FXCollections.observableArrayList(
                reservationService.getAllReservations()
        ));
    }


    @FXML
    private void onAdd() {
        openForm(null);
    }

    @FXML
    private void onEdit() {
        Reservation selected = reservationTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a reservation to edit!");
            return;
        }
        openForm(selected);
    }

    @FXML
    private void onDelete() {
        Reservation selected = reservationTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a reservation to delete!");
            return;
        }

        reservationService.removeReservation(selected.getId());
        reservationTable.getItems().remove(selected);

        showAlert("Reservation deleted successfully.");
    }



    private void openForm(Reservation reservation) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/reservation-form.fxml"));
            Parent root = loader.load();

            ReservationFormController controller = loader.getController();
            if (reservation != null) {
                controller.setReservation(reservation);
            }

            Stage stage = new Stage();
            stage.setTitle("Reservation Form");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            reservationTable.getItems().setAll(reservationService.getAllReservations());

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unable to open reservation form!");
        }
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

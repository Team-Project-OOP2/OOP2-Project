package hotelmanagement.controller;

import hotelmanagement.model.Service;
import hotelmanagement.service.ServiceService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManageServicesController {

    @FXML private TableView<Service> serviceTable;

    @FXML private TableColumn<Service, String> colId;
    @FXML private TableColumn<Service, String> colName;
    @FXML private TableColumn<Service, Double> colPrice;
    @FXML private TableColumn<Service, String> colDescription;

    private final ServiceService serviceService = ServiceService.getInstance();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> c.getValue().idProperty());
        colName.setCellValueFactory(c -> c.getValue().nameProperty());
        colPrice.setCellValueFactory(c -> c.getValue().priceProperty().asObject());
        colDescription.setCellValueFactory(c -> c.getValue().descriptionProperty());

        serviceTable.setItems(FXCollections.observableArrayList(serviceService.getAllServices()));
    }
}

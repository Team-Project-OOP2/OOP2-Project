package hotelmanagement.controller;

import hotelmanagement.model.Service;
import hotelmanagement.service.ServiceService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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

        refreshTable();
    }

    private void refreshTable() {
        serviceTable.setItems(FXCollections.observableArrayList(serviceService.getAllServices()));
    }


    @FXML
    private void onAddService() {
        openServiceForm(null);
    }

    @FXML
    private void onEditService() {
        Service selected = serviceTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a service to edit!");
            return;
        }

        openServiceForm(selected);
    }


    @FXML
    private void onDeleteService() {
        Service selected = serviceTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a service to delete!");
            return;
        }

        serviceService.deleteService(selected.getId());
        refreshTable();
        showAlert("Service deleted successfully!");
    }


    private void openServiceForm(Service service) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/service-form.fxml"));
            Parent root = loader.load();


            ServiceFormController controller = loader.getController();

            if (service != null) {
                controller.setService(service);
            }

            Stage stage = new Stage();
            stage.setTitle("Service Form");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            refreshTable();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unable to open service form!");
        }
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

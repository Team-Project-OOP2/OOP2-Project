package hotelmanagement.controller;

import hotelmanagement.model.Service;
import hotelmanagement.service.ServiceService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServiceFormController {

    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtDescription;

    private final ServiceService serviceService = ServiceService.getInstance();
    private Service service;

    public void setService(Service service) {
        this.service = service;
        txtName.setText(service.getName());
        txtPrice.setText(String.valueOf(service.getPrice()));
        txtDescription.setText(service.getDescription());
    }

    @FXML
    private void onSave() {

        String name = txtName.getText();
        String priceText = txtPrice.getText();
        String description = txtDescription.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            showAlert("Please fill in all required fields!");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            showAlert("Price must be a valid number!");
            return;
        }

        if (service == null) {
            Service newService = new Service(
                    serviceService.generateId(),
                    name,
                    price,
                    description
            );
            serviceService.addService(newService);
        } else {
            service.nameProperty().set(name);
            service.priceProperty().set(price);
            service.descriptionProperty().set(description);
        }

        closeWindow();
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

package hotelmanagement.model;

import javafx.beans.property.*;

public class Service {

    private final StringProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final StringProperty description;

    public Service(String id, String name, double price, String description) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.description = new SimpleStringProperty(description);
    }

    public String getId() { return id.get(); }
    public StringProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public double getPrice() { return price.get(); }
    public DoubleProperty priceProperty() { return price; }

    public String getDescription() { return description.get(); }
    public StringProperty descriptionProperty() { return description; }
}

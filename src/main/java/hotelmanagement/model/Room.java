package hotelmanagement.model;

import javafx.beans.property.*;

public class Room {

    private final StringProperty number;
    private final StringProperty type;
    private final DoubleProperty price;
    private final StringProperty status;

    public Room(String number, String type, double price, String status) {
        this.number = new SimpleStringProperty(number);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleDoubleProperty(price);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getNumber() {
        return number.get();
    }

    public String getType() {
        return type.get();
    }

    public double getPrice() {
        return price.get();
    }

    public String getStatus() {
        return status.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}

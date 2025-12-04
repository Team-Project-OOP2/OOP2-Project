package hotelmanagement.model;

import javafx.beans.property.*;
import java.time.LocalDate;

/**
 * Клас Reservation – представя резервация в хотел.
 */
public class Reservation {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final ObjectProperty<User> client = new SimpleObjectProperty<>();
    private final ObjectProperty<Hotel> hotel = new SimpleObjectProperty<>();
    private final ObjectProperty<Room> room = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> endDate = new SimpleObjectProperty<>();
    private final StringProperty status = new SimpleStringProperty();

    public Reservation() {}

    public Reservation(int id, User client, Hotel hotel, Room room,
                       LocalDate startDate, LocalDate endDate, String status) {
        this.id.set(id);
        this.client.set(client);
        this.hotel.set(hotel);
        this.room.set(room);
        this.startDate.set(startDate);
        this.endDate.set(endDate);
        this.status.set(status);
    }

    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }

    public User getClient() { return client.get(); }
    public void setClient(User client) { this.client.set(client); }
    public ObjectProperty<User> clientProperty() { return client; }

    public Hotel getHotel() { return hotel.get(); }
    public void setHotel(Hotel hotel) { this.hotel.set(hotel); }
    public ObjectProperty<Hotel> hotelProperty() { return hotel; }

    public Room getRoom() { return room.get(); }
    public void setRoom(Room room) { this.room.set(room); }
    public ObjectProperty<Room> roomProperty() { return room; }

    public LocalDate getStartDate() { return startDate.get(); }
    public void setStartDate(LocalDate startDate) { this.startDate.set(startDate); }
    public ObjectProperty<LocalDate> startDateProperty() { return startDate; }

    public LocalDate getEndDate() { return endDate.get(); }
    public void setEndDate(LocalDate endDate) { this.endDate.set(endDate); }
    public ObjectProperty<LocalDate> endDateProperty() { return endDate; }

    public String getStatus() { return status.get(); }
    public void setStatus(String status) { this.status.set(status); }
    public StringProperty statusProperty() { return status; }
}

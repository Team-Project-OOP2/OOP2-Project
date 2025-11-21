package hotelmanagement.model;

import java.time.LocalDate;

/**
 * Клас Reservation – представя резервация в хотел.
 */
public class Reservation {

    private int id;
    private User client;
    private Hotel hotel;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public Reservation() {}

    public Reservation(int id, User client, Hotel hotel, Room room,
                       LocalDate startDate, LocalDate endDate, String status) {
        this.id = id;
        this.client = client;
        this.hotel = hotel;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getClient() { return client; }
    public void setClient(User client) { this.client = client; }

    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
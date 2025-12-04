package hotelmanagement.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Hotel – представя информация за хотел в системата.
 * Всеки хотел има собственик (User), адрес, рейтинг и списък от стаи.
 */
public class Hotel {

    private int id;
    private String name;
    private String address;
    private double rating;
    private User owner;
    private List<Room> rooms;
    private List<Service> services;

    /**
     * Конструктор по подразбиране.
     */
    public Hotel() {
        rooms = new ArrayList<>();
        services = new ArrayList<>();
    }

    /**
     * Конструктор с параметри.
     */
    public Hotel(int id, String name, String address, double rating, User owner) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", owner=" + (owner != null ? owner.getName() : "N/A") +
                ", rooms=" + rooms.size() +
                ", services=" + services.size() +
                '}';
    }
}

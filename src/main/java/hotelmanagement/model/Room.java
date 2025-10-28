package hotelmanagement.model;

/**
 * Клас Room – представя хотелска стая в системата.
 */
public class Room {

    private int roomNumber;
    private String type;
    private double price;
    private int capacity;
    private boolean occupied;

    /**
     * Конструктор по подразбиране.
     */
    public Room() {}

    /**
     * Конструктор с параметри.
     */
    public Room(int roomNumber, String type, double price, int capacity, boolean occupied) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", occupied=" + occupied +
                '}';
    }
}

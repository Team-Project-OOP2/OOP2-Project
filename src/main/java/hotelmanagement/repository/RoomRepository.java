package hotelmanagement.repository;

import hotelmanagement.model.Room;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository за работа със стаи.
 */
public class RoomRepository {

    private static RoomRepository instance;

    private List<Room> rooms = new ArrayList<>();

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}
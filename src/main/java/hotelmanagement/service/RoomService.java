package hotelmanagement.service;

import hotelmanagement.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private static RoomService instance;

    private final List<Room> rooms = new ArrayList<>();

    private RoomService() {}

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public void deleteRoom(String number) {
        rooms.removeIf(r -> r.getNumber().equals(number));
    }
}

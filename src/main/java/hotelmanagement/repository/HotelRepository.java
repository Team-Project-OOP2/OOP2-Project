package hotelmanagement.repository;

import hotelmanagement.model.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository за работа с хотели.
 * Съхранява списък с хотели и ще бъде разширен с файлово записване.
 */
public class HotelRepository {

    private static HotelRepository instance;

    private List<Hotel> hotels = new ArrayList<>();

    public static HotelRepository getInstance() {
        if (instance == null) {
            instance = new HotelRepository();
        }
        return instance;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotels;
    }
}
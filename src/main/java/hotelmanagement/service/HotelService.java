package hotelmanagement.service;

import hotelmanagement.model.Hotel;
import hotelmanagement.repository.HotelRepository;

import java.util.List;

/**
 * Сервизен клас за работа с хотели.
 */
public class HotelService {

    private static HotelService instance;

    private final HotelRepository hotelRepository = HotelRepository.getInstance();

    public static HotelService getInstance() {
        if (instance == null) {
            instance = new HotelService();
        }
        return instance;
    }

    public void addHotel(Hotel hotel) {
        hotelRepository.addHotel(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }
}

package hotelmanagement.repository;

import hotelmanagement.model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    private static ReservationRepository instance;

    private final List<Reservation> reservations = new ArrayList<>();

    private ReservationRepository() {}

    public static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void updateReservation(Reservation reservation) {
        // nothing special – the object is already updated
    }

    public void deleteReservation(int id) {
        reservations.removeIf(r -> r.getId() == id);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}

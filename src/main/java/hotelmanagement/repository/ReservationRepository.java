package hotelmanagement.repository;

import hotelmanagement.model.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository за работа с резервации.
 */
public class ReservationRepository {

    private static ReservationRepository instance;

    private List<Reservation> reservations = new ArrayList<>();

    public static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}

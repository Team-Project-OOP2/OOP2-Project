package hotelmanagement.service;

import hotelmanagement.model.Reservation;
import hotelmanagement.repository.ReservationRepository;

import java.util.List;

/**
 * Сервизен клас за работа с резервации.
 */
public class ReservationService {

    private static ReservationService instance;

    private final ReservationRepository reservationRepository = ReservationRepository.getInstance();

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.addReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }
}
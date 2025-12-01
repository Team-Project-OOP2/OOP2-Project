package hotelmanagement.service;

import hotelmanagement.model.Reservation;
import hotelmanagement.repository.ReservationRepository;

import java.util.List;

public class ReservationService {

    private static ReservationService instance;

    private final ReservationRepository reservationRepository =
            ReservationRepository.getInstance();

    private ReservationService() {}

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

    public void deleteReservation(int id) {
        reservationRepository.deleteReservation(id);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.updateReservation(reservation);
    }

    public void removeReservation(int id) {
        reservationRepository.deleteReservation(id);
    }

}

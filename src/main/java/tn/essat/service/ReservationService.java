package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.essat.dao.IReservationRepository;
import tn.essat.model.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);  // Sauvegarde ou mise à jour de la réservation
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();  // Récupère toutes les réservations
    }

    @Override
    public Reservation getReservationById(Integer id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);  // Recherche par ID
        return reservation.orElse(null);  // Retourne la réservation ou null si elle n'existe pas
    }

    @Override
    public List<Reservation> getReservationsByAdherantId(Integer adherantId) {
        return reservationRepository.findByAdherantId(adherantId);  // Recherche par ID d'adhérent
    }

    @Override
    public List<Reservation> getReservationsByTerrainId(Integer terrainId) {
        return reservationRepository.findByTerrainId(terrainId);  // Recherche par ID de terrain
    }

    @Override
    public List<Reservation> getReservationsByDateRes(String dateRes) {
        return reservationRepository.findByDateRes(dateRes);  // Recherche par date de réservation
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);  // Suppression de la réservation par ID
    }
}

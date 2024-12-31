package tn.essat.service;

import tn.essat.model.Reservation;
import java.util.List;

public interface IReservationService {

    // Méthodes pour la gestion des réservations
    Reservation saveReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Integer id);
    List<Reservation> getReservationsByAdherantId(Integer adherantId);
    List<Reservation> getReservationsByTerrainId(Integer terrainId);
    List<Reservation> getReservationsByDateRes(String dateRes);
    void deleteReservation(Integer id);
}

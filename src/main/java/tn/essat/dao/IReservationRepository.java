package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.model.Reservation;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer> {

    // Trouver toutes les réservations d'un adhérent
    List<Reservation> findByAdherantId(Integer adherantId);

    // Trouver toutes les réservations pour un terrain
    List<Reservation> findByTerrainId(Integer terrainId);

    // Trouver les réservations par date
    List<Reservation> findByDateRes(String dateRes);
}

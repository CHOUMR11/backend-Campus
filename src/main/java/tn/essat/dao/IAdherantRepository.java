package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.model.Adherant;

@Repository
public interface IAdherantRepository extends JpaRepository<Adherant, Integer> {

    // Requête personnalisée : Trouver un adhérent par son email
    Adherant findByEmail(String email);
}

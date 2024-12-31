package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.model.Administrateur;

@Repository
public interface IAdminRepository extends JpaRepository<Administrateur, Integer> {

    // Requête personnalisée : Trouver un administrateur par son username
    Administrateur findByUsername(String username);
}

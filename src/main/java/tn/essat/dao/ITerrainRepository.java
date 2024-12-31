package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.model.Terrain;

@Repository
public interface ITerrainRepository extends JpaRepository<Terrain, Integer> {
    // Requête personnalisée : Trouver un terrain par son titre
    Terrain findByTitre(String titre);
}

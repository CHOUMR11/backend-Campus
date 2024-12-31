package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.essat.dao.ITerrainRepository;
import tn.essat.model.Terrain;

@Service
public class TerrainService implements ITerrainService {

    @Autowired
    private ITerrainRepository terrainRepository;

    // Implémentation de la méthode pour récupérer un terrain par son titre
    @Override
    public Terrain getTerrainByTitre(String titre) {
        return terrainRepository.findByTitre(titre);  // Recherche par titre
    }

    // Implémentation de la méthode pour créer un nouveau terrain
    @Override
    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);  // Enregistrer un terrain dans la base de données
    }

    // Implémentation de la méthode pour mettre à jour un terrain existant
    @Override
    public Terrain updateTerrain(Terrain terrain) {
        if (terrainRepository.existsById(terrain.getId())) {
            return terrainRepository.save(terrain);  // Met à jour le terrain si l'id existe
        }
        return null;  // Retourne null si le terrain n'existe pas
    }

    // Implémentation de la méthode pour supprimer un terrain
    @Override
    public void deleteTerrain(Integer id) {
        if (terrainRepository.existsById(id)) {
            terrainRepository.deleteById(id);  // Supprimer le terrain en fonction de son id
        }
    }
}

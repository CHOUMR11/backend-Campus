package tn.essat.service;

import tn.essat.model.Terrain;

public interface ITerrainService {
    // Méthode pour récupérer un terrain par son titre
    Terrain getTerrainByTitre(String titre);
    
    // Ajouter d'autres méthodes nécessaires selon les besoins
    // Par exemple, pour créer, modifier, ou supprimer des terrains
    Terrain createTerrain(Terrain terrain);
    Terrain updateTerrain(Terrain terrain);
    void deleteTerrain(Integer id);
}

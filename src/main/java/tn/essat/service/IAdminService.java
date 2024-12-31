package tn.essat.service;

import tn.essat.model.Administrateur;

public interface IAdminService {

    // Trouver un administrateur par son identifiant
    Administrateur findById(Integer id);

    // Trouver un administrateur par son username
    Administrateur findByUsername(String username);

    // Sauvegarder un administrateur
    Administrateur save(Administrateur administrateur);

    // Supprimer un administrateur par son identifiant
    void deleteById(Integer id);
}

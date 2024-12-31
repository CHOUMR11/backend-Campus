package tn.essat.service;

import tn.essat.model.Adherant;
import java.util.List;

public interface IAdherantService {
    // Ajouter un nouvel adhérent
    Adherant ajouterAdherant(Adherant adherant);

    // Modifier un adhérent existant
    Adherant modifierAdherant(Adherant adherant);

    // Supprimer un adhérent
    void supprimerAdherant(Integer id);

    // Trouver un adhérent par son ID
    Adherant trouverParId(Integer id);

    // Trouver un adhérent par son email
    Adherant trouverParEmail(String email);

    // Lister tous les adhérents
    List<Adherant> listerAdherants();

    // Charger un utilisateur par son email (utilisé dans Spring Security)
    Adherant loadUserByUsername(String username);

    // Vérifier si le token est valide
    boolean isTokenValid(String token, Adherant adherant);

    // Récupérer les rôles d'un adhérent
    List<String> getAuthorities(Adherant adherant);
}

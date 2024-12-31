package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.essat.dao.IAdherantRepository;
import tn.essat.model.Adherant;

import java.util.List;
import java.util.Optional;

@Service
public class AdherantService implements IAdherantService {

    @Autowired
    private IAdherantRepository adherantRepository;

    // Ajouter un nouvel adhérent
    @Override
    public Adherant ajouterAdherant(Adherant adherant) {
        return adherantRepository.save(adherant);
    }

    // Modifier un adhérent existant
    @Override
    public Adherant modifierAdherant(Adherant adherant) {
        return adherantRepository.save(adherant);
    }

    // Supprimer un adhérent
    @Override
    public void supprimerAdherant(Integer id) {
        adherantRepository.deleteById(id);
    }

    // Trouver un adhérent par son ID
    @Override
    public Adherant trouverParId(Integer id) {
        Optional<Adherant> adherant = adherantRepository.findById(id);
        return adherant.orElse(null);  // Retourne null si l'adhérent n'est pas trouvé
    }

    // Trouver un adhérent par son email
    @Override
    public Adherant trouverParEmail(String email) {
        return adherantRepository.findByEmail(email);
    }

    // Lister tous les adhérents
    @Override
    public List<Adherant> listerAdherants() {
        return adherantRepository.findAll();
    }

	@Override
	public Adherant loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValid(String token, Adherant adherant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getAuthorities(Adherant adherant) {
		// TODO Auto-generated method stub
		return null;
	}
}

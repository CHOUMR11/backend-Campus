package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.essat.model.Administrateur;
import tn.essat.dao.IAdminRepository;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    // Implémentation de la méthode pour trouver un administrateur par son id
    @Override
    public Administrateur findById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Implémentation de la méthode pour trouver un administrateur par son username
    @Override
    public Administrateur findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Implémentation de la méthode pour sauvegarder un administrateur
    @Override
    public Administrateur save(Administrateur administrateur) {
        return adminRepository.save(administrateur);
    }

    // Implémentation de la méthode pour supprimer un administrateur par son id
    @Override
    public void deleteById(Integer id) {
        adminRepository.deleteById(id);
    }
}

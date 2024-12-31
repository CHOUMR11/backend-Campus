package tn.essat.model;

import javax.persistence.*;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String surface;

    // Constructeur par défaut
    public Terrain() {}

    // Constructeur paramétré
    public Terrain(Integer id, String titre, String surface) {
        this.id = id;
        this.titre = titre;
        this.surface = surface;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}

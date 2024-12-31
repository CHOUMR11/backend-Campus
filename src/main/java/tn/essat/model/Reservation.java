package tn.essat.model;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dateRes;
    private int heureDebut;
    private int heureFin;

    @ManyToOne
    private Adherant adherant;

    @ManyToOne
    private Terrain terrain;

    // Constructeur par défaut
    public Reservation() {}

    // Constructeur paramétré
    public Reservation(Integer id, String dateRes, int heureDebut, int heureFin, Adherant adherant, Terrain terrain) {
        this.id = id;
        this.dateRes = dateRes;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.adherant = adherant;
        this.terrain = terrain;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public Adherant getAdherant() {
        return adherant;
    }

    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}

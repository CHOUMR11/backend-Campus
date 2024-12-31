package tn.essat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import tn.essat.dao.IAdherantRepository;
import tn.essat.dao.IReservationRepository;
import tn.essat.dao.ITerrainRepository;
import tn.essat.model.Reservation;
import tn.essat.model.Terrain;
import tn.essat.model.Adherant;

@CrossOrigin("*")
@RestController
@RequestMapping("/back")
public class AppCRT {

    @Autowired
    IReservationRepository dao_reservation;

    @Autowired
    ITerrainRepository dao_terrain;

    @Autowired
    IAdherantRepository dao_adherent;

    // CRUD endpoints for Reservation

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return dao_reservation.findAll();
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Optional<Reservation> reservation = dao_reservation.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Void> addReservation(@RequestBody @Validated Reservation reservation) {
        dao_reservation.save(reservation);
        return ResponseEntity.status(201).build();  // Returning 201 Created
    }

    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        if (dao_reservation.existsById(id)) {
            reservation.setId(id); // Ensure the ID is preserved
            dao_reservation.save(reservation);
            return ResponseEntity.ok(reservation);  // Returning updated reservation
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        if (dao_reservation.existsById(id)) {
            dao_reservation.deleteById(id);
            return ResponseEntity.noContent().build();  // Returning 204 No Content
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    // f5S for Reservation
    @GetMapping("/reservationDetail/{id}")
    public ResponseEntity<Reservation> f5SReservation(@PathVariable int id) {
        Optional<Reservation> reservation = dao_reservation.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CRUD endpoints for Terrain

    @GetMapping("/terrains")
    public List<Terrain> getTerrains() {
        return dao_terrain.findAll();
    }

    @GetMapping("/terrain/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable int id) {
        Optional<Terrain> terrain = dao_terrain.findById(id);
        return terrain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addTerrain")
    public ResponseEntity<Void> addTerrain(@RequestBody @Validated Terrain terrain) {
        dao_terrain.save(terrain);
        return ResponseEntity.status(201).build();  // Returning 201 Created
    }

    @PutMapping("/updateTerrain/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable int id, @RequestBody Terrain terrain) {
        if (dao_terrain.existsById(id)) {
            terrain.setId(id); // Ensure the ID is preserved
            dao_terrain.save(terrain);
            return ResponseEntity.ok(terrain);  // Returning updated terrain
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    @DeleteMapping("/deleteTerrain/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable int id) {
        if (dao_terrain.existsById(id)) {
            dao_terrain.deleteById(id);
            return ResponseEntity.noContent().build();  // Returning 204 No Content
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    // f5S for Terrain
    @GetMapping("/terrainDetail/{id}")
    public ResponseEntity<Terrain> f5STerrain(@PathVariable int id) {
        Optional<Terrain> terrain = dao_terrain.findById(id);
        return terrain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CRUD endpoints for Adherant

    @GetMapping("/adherents")
    public List<Adherant> getAdherents() {
        return dao_adherent.findAll();
    }

    @GetMapping("/adherent/{id}")
    public ResponseEntity<Adherant> getAdherentById(@PathVariable int id) {
        Optional<Adherant> adherent = dao_adherent.findById(id);
        return adherent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addAdherent")
    public ResponseEntity<Void> addAdherent(@RequestBody @Validated Adherant adherent) {
        dao_adherent.save(adherent);
        return ResponseEntity.status(201).build();  // Returning 201 Created
    }

    @PutMapping("/updateAdherent/{id}")
    public ResponseEntity<Adherant> updateAdherent(@PathVariable int id, @RequestBody Adherant adherent) {
        if (dao_adherent.existsById(id)) {
            adherent.setId(id); // Ensure the ID is preserved
            dao_adherent.save(adherent);
            return ResponseEntity.ok(adherent);  // Returning updated adherent
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    @DeleteMapping("/deleteAdherent/{id}")
    public ResponseEntity<Void> deleteAdherent(@PathVariable int id) {
        if (dao_adherent.existsById(id)) {
            dao_adherent.deleteById(id);
            return ResponseEntity.noContent().build();  // Returning 204 No Content
        }
        return ResponseEntity.notFound().build();  // Returning 404 Not Found
    }

    // f5S for Adherent
    @GetMapping("/adherentDetail/{id}")
    public ResponseEntity<Adherant> f5SAdherent(@PathVariable int id) {
        Optional<Adherant> adherent = dao_adherent.findById(id);
        return adherent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

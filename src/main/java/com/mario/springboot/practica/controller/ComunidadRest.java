package com.mario.springboot.practica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.springboot.practica.entity.Comunidad;
import com.mario.springboot.practica.service.ComunidadService;

@CrossOrigin
@RestController
@RequestMapping("/comunidad")
public class ComunidadRest {
	
	@Autowired
	private ComunidadService comunidadService;
	
	// Get all comunidades
	@GetMapping
	public ResponseEntity<List<Comunidad>> getAllComunidad() {
		List<Comunidad> comunidades = comunidadService.findAll();
		return ResponseEntity.ok(comunidades);
	}
	
	// Find comunidades by nam_m
	/*@GetMapping("/buscar")
	public ResponseEntity<List<Comunidad>> findComunidadByNamM(@RequestParam String nam_m) {
        List<Comunidad> comunidades = comunidadService.findComunidadByNamM(nam_m);
        return ResponseEntity.ok(comunidades);
    }*/
	
	// Obtener comunidad por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Comunidad> findComunidadById(@PathVariable Long id) {
        Optional<Comunidad> comunidadOptional = comunidadService.findById(id);
        return comunidadOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	// Crear una nueva comunidad
    @PostMapping
    public ResponseEntity<Comunidad> createComunidad(@RequestBody Comunidad comunidad) {
        Comunidad newComunidad = comunidadService.createComunidad(comunidad);
        return ResponseEntity.ok(newComunidad);
    }

    // Actualizar una comunidad por ID
    @PutMapping("/{id}")
    public ResponseEntity<Comunidad> updateComunidad(@PathVariable Long id, @RequestBody Comunidad comunidadDetails) {
        Comunidad updatedComunidad = comunidadService.updateComunidad(id, comunidadDetails);
        if (updatedComunidad != null) {
            return ResponseEntity.ok(updatedComunidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una comunidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComunidad(@PathVariable Long id) {
        comunidadService.deleteComunidad(id);
        return ResponseEntity.noContent().build();
    }
}

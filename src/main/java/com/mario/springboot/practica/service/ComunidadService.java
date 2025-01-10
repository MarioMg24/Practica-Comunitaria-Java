package com.mario.springboot.practica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mario.springboot.practica.dao.ComunidadRepository;
import com.mario.springboot.practica.entity.Comunidad;

@Service
public class ComunidadService {
	
	@Autowired
	private ComunidadRepository comunidadRepository;

	// Mostrar all comunidades
	public List<Comunidad> findAll() {
		return comunidadRepository.findAll();
	}
	
	// Find comunidades by nam_m
	public List<Comunidad> findComunidadByNamM(String nam_m) {
		return comunidadRepository.findComunidadByNamM(nam_m);
	}

	// Find comunidad by ID
	public Optional<Comunidad> findById(Long id) {
		return comunidadRepository.findById(id);
	}

	// Crear a new comunidad
	public Comunidad createComunidad(Comunidad comunidad) {
		return comunidadRepository.save(comunidad);
	}
	
	 // Actualizar una comunidad existente
    public Comunidad updateComunidad(Long id, Comunidad comunidadDetails) {
        Optional<Comunidad> comunidadOptional = comunidadRepository.findById(id);

        if (comunidadOptional.isPresent()) {
            Comunidad comunidad = comunidadOptional.get();
            comunidad.setNam_m(comunidadDetails.getNam_m());
            comunidad.setGeom(comunidadDetails.getGeom());
            return comunidadRepository.save(comunidad);
        }
        return null; // O lanzar excepción personalizada
    }

	// Delete comunidad by ID
	public void deleteComunidad(Long id) {
		comunidadRepository.deleteById(id);
	}
}

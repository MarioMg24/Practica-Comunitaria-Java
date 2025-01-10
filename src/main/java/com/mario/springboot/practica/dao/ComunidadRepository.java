package com.mario.springboot.practica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mario.springboot.practica.entity.Comunidad;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long>{
	 // Definir métodos de consulta personalizados si se necesita, por ejemplo:
	@Query("SELECT c FROM Comunidad c WHERE c.nam_m = :nam_m")
	List<Comunidad> findComunidadByNamM(@Param("nam_m") String nam_m);
	
	
}

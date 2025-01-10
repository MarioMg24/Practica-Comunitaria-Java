package com.mario.springboot.practica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.MultiPoint;

@Entity
@Table(name = "comunidad_reconocida",schema="asentamiento")
public class Comunidad {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nam_m")
    private String nam_m;
    
 // Mapear el campo geométrico como tipo espacial con SRID específico
   @Column(columnDefinition = "geometry(MultiPoint, 32718)", nullable = true)
    private MultiPoint geom;
    
    public Comunidad(String nam_m, MultiPoint geom) {
        this.nam_m = nam_m;
        setGeom(geom);
    }
    
 // Constructor por defecto requerido por JPA/Hibernate
    public Comunidad() {
    }
    
 // Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNam_m() {
		return nam_m;
	}

	public void setNam_m(String nam_m) {
		this.nam_m = nam_m;
	}
	
	public MultiPoint getGeom() {
        return geom;
    }

    public void setGeom(MultiPoint geom) {
    	if (geom != null && geom.getSRID() != 32718) {
    		geom.setSRID(32718);
    	}
    	this.geom= geom;
    }
    
    @Override
    public String toString() {
        return "Comunidad{" +
                "id=" + id +
                ", nam_m='" + nam_m + '\'' +
                ", geom=" + geom +
                '}';
    }
}
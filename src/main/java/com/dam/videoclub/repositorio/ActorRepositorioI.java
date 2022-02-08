package com.dam.videoclub.repositorio;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dam.videoclub.entidades.Actor;

@Repository
public interface ActorRepositorioI extends JpaRepository<Actor, Long>{
	
	List<Actor> findByNombre(String nombre);
	
	List<Actor> findByApellidos(String apellidos);
	
	List<Actor> findByNombreOrApellidos(final String nombre, final String apellidos);
	
	List<Actor> findByNombreAndApellidos(final String nombre, final String apellidos);
	
	List<Actor> findByFechNacimiento(Date fechNacimiento);
	
	List<Actor> findByNacionalidad(String nacionalidad);
	
}

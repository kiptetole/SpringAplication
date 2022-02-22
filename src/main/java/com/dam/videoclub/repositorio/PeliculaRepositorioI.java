package com.dam.videoclub.repositorio;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.entidades.Pelicula;

@Repository
public interface PeliculaRepositorioI extends JpaRepository<Pelicula, Long>{
	
	Pelicula findByid(long id);
	
	List<Pelicula> findBytitulo(String titulo);
	
	List<Pelicula> findByAnnoEstreno(Date annoEstreno);
	
	List<Pelicula> findByMinDuracion(int minDuracion);
	
	List<Actor> findByActores(long id);

}

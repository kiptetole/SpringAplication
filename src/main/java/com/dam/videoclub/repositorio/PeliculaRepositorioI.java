package com.dam.videoclub.repositorio;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.videoclub.entidades.Pelicula;

@Repository
public interface PeliculaRepositorioI extends JpaRepository<Pelicula, Long>{
	
	List<Pelicula> findBytitulo(String titulo);
	
	List<Pelicula> findByAnnoEstreno(Date annoEstreno);
	
	List<Pelicula> findByMinDuracion(int minDuracion);

}

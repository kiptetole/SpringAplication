package com.dam.videoclub.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.videoclub.entidades.ActorPelicula;

@Repository
public interface ActorPeliculaRepositorio extends JpaRepository<ActorPelicula,Long>{

	@Query(value = "SELECT * FROM pelicula_actor WHERE actor_id = ?", nativeQuery = true)
	List <ActorPelicula> findActorPeliculaByActorId(Long Id);
	
	@Query(value = "SELECT * FROM pelicula_actor WHERE pelicula_id = ?", nativeQuery = true)
	List <ActorPelicula> findActorPeliculaByPeliculaId(Long Id);

	@Query(value = "SELECT id, actor_id, pelicula_actor FROM actor_pelicula", nativeQuery = true)
	List <ActorPelicula> findActorPelicula();

}

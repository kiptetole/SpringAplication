package com.dam.videoclub.servicios;

import java.sql.Date;
import java.util.List;
import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.entidades.Pelicula;

public interface ActorServiceI {
	
	public List<Actor> obtenerTodosActores();
	
	public Actor obtenerActorPorId(Long id);
	
	public List<Actor> obtenerActoresPorNombre(String nombre);
	
	public List<Actor> obtenerActoresPorApellidos(String apellidos);
	
	public List<Actor> obtenerActoresPorNombreOApellidos(String nombre, String apellidos);
	
	public List<Actor> obtenerActoresPorNombreYApellidos(String nombre, String apellidos);
	
	public List<Actor> obtenerActoresPorFechaNacimiento(Date fechNacimiento);
	
	public List<Actor> obtenerActoresPorNacionalidad(String nacionalidad);
	
	public List<Pelicula> obtenerPeliculasDelActor(long idActor);
	
	public void removeActorPorId(final long idActor);

	public void addActor(final Actor actor);

	public void updateActor(final Actor actor);
}

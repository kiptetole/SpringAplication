package com.dam.videoclub.servicios;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.entidades.Pelicula;
import com.dam.videoclub.repositorio.ActorRepositorioI;

@SpringBootApplication
public class ActorServiceImpl implements ActorServiceI {

	@Autowired
	private ActorRepositorioI actorRepositorio;
	
	@Override
	public List<Actor> obtenerTodosActores() {
		return actorRepositorio.findAll();
	}

	@Override
	public Actor obtenerActorPorId(Long id) {
		return actorRepositorio.findByid(id);
	}

	@Override
	public List<Actor> obtenerActoresPorNombre(String nombre) {
		return actorRepositorio.findByNombre(nombre);
	}

	@Override
	public List<Actor> obtenerActoresPorApellidos(String apellidos) {
		return actorRepositorio.findByApellidos(apellidos);
	}

	@Override
	public List<Actor> obtenerActoresPorNombreOApellidos(String nombre, String apellidos) {
		return actorRepositorio.findByNombreOrApellidos(nombre, apellidos);
	}

	@Override
	public List<Actor> obtenerActoresPorNombreYApellidos(String nombre, String apellidos) {
		return actorRepositorio.findByNombreAndApellidos(nombre, apellidos);
	}

	@Override
	public List<Actor> obtenerActoresPorFechaNacimiento(Date fechNacimiento) {
		return actorRepositorio.findByFechNacimiento(fechNacimiento);
	}

	@Override
	public List<Actor> obtenerActoresPorNacionalidad(String nacionalidad) {
		return actorRepositorio.findByNacionalidad(nacionalidad);
	}

	@Override
	public List<Pelicula> obtenerPeliculasDelActor(long idActor) {
		return actorRepositorio.findByPeliculas(idActor);
	}

	@Override
	public void removeActorPorId(long idActor) {
		actorRepositorio.deleteById(idActor);
	}

	@Override
	public void addActor(Actor actor) {
		actorRepositorio.save(actor);
	}

	@Override
	public void updateActor(Actor actor) {
		actorRepositorio.save(actor);
	}

	

}

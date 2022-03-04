package com.dam.videoclub.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.videoclub.entidades.ActorPelicula;
import com.dam.videoclub.repositorio.ActorPeliculaRepositorio;

@Service
public class ActorPeliculaServiceImple implements ActorPeliculaServiceI{

	@Autowired
	private ActorPeliculaRepositorio actorPeliculaRepositorio;
	
	@Override
	public List<ActorPelicula> obtenerActorPeliculaPorIdActor(long idActor) {
		return actorPeliculaRepositorio.findActorPeliculaByActorId(idActor);
	}
	
	@Override
	public List<ActorPelicula> obtenerActorPeliculaPorIdPelicula(long idPelicula) {
		return actorPeliculaRepositorio.findActorPeliculaByPeliculaId(idPelicula);
	}

	@Override
	public void eliminarActorPeliculaPorId(long id) {
		actorPeliculaRepositorio.deleteById(id);
		
	}

	@Override
	public void anadirActorPelicula(ActorPelicula actorPelicula) {
		actorPeliculaRepositorio.save(actorPelicula);
	}

	@Override
	public void actualizarActorPelicula(ActorPelicula actorPelicula) {
		actorPeliculaRepositorio.save(actorPelicula);
		
	}

	@Override
	public List<ActorPelicula> obtenerActorPeliculaTodos() {
		return actorPeliculaRepositorio.findAll();
	}

	@Override
	public List<ActorPelicula> obtenerTodos() {
		return actorPeliculaRepositorio.findActorPelicula();
	}
}

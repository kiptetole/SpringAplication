package com.dam.videoclub.servicios;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.entidades.Pelicula;
import com.dam.videoclub.repositorio.PeliculaRepositorioI;

@Service
public class PeliculaServiceImpl implements PeliculaServiceI {

	@Autowired
	private PeliculaRepositorioI peliculaRepositorio;
	
	@Override
	public List<Pelicula> obtenerTodasPeliculas() {
		return peliculaRepositorio.findAll();
	}
	
	@Override
	public Pelicula obtenerPeliculaPorId(long id) {
		return peliculaRepositorio.findByid(id);
	}

	@Override
	public List<Pelicula> obtenerPeliculaPorTitulo(String Titulo) {
		return peliculaRepositorio.findBytitulo(Titulo);
	}

	@Override
	public List<Pelicula> obtenerPeliculaPorAnnoEstreno(Date annoEstreno) {		// TODO Auto-generated method stub
		return peliculaRepositorio.findByAnnoEstreno(annoEstreno);
	}

	@Override
	public List<Pelicula> obtenerPeliculaPorDuracion(int minDuracion) {
		return peliculaRepositorio.findByMinDuracion(minDuracion);
	}

	@Override
	public List<Actor> obtenerActoresDePelicula(long id) {
		return peliculaRepositorio.findByActores(id);
	}

	@Override
	public void removePeliculaPorId(long idPelicula) {
		peliculaRepositorio.deleteById(idPelicula);
	}

	@Override
	public void addPelicula(Pelicula pelicula) {
		peliculaRepositorio.save(pelicula);
	}

	@Override
	public void updatePelicula(Pelicula pelicula) {
		peliculaRepositorio.save(pelicula);
	}
}

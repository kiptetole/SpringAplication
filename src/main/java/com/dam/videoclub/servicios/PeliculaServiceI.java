package com.dam.videoclub.servicios;

import java.sql.Date;
import java.util.List;
import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.entidades.Pelicula;

public interface PeliculaServiceI {

	public List<Pelicula> obtenerTodasPeliculas();
	
	public Pelicula obtenerPeliculaPorId(long id);
	
	public List<Pelicula> obtenerPeliculaPorTitulo(final String Titulo);
	
	public List<Pelicula> obtenerPeliculaPorAnnoEstreno(final Date annoEstreno);
	
	public List<Pelicula> obtenerPeliculaPorDuracion(final int minDuracion);
	
	public List<Actor> obtenerActoresDePelicula(long id);
	
	public void removePeliculaPorId(final long idPelicula);

	public void addPelicula(final Pelicula pelicula);

	public void updatePelicula(final Pelicula pelicula);
}

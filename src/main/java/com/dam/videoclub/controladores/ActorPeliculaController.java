package com.dam.videoclub.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dam.videoclub.entidades.*;
import com.dam.videoclub.servicios.ActorPeliculaServiceI;
import com.dam.videoclub.servicios.ActorServiceI;
import com.dam.videoclub.servicios.PeliculaServiceI;

@Controller
public class ActorPeliculaController {

	@Autowired
	private ActorPeliculaServiceI actorPeliculaServiceI;
	
	@Autowired
	private ActorServiceI actorServiceI;
	
	@Autowired
	private PeliculaServiceI peliculaServiceI;
	
	
	//Formulario de que pelicula y actor relacionar.
	@GetMapping("/FormularioActorPelicula")
	public String FormularioActorPelicula(Model model) {
		
		final List<Actor> listaActores = actorServiceI.obtenerTodosActores();
		final List<Pelicula> listaPeliculas = peliculaServiceI.obtenerTodasPeliculas();
		
		model.addAttribute("listaActores", listaActores);
		model.addAttribute("listaPeliculas", listaPeliculas);
		
		return "ActorPelicula";
	}
	
	//Relacion Pelicula y Actor seleccionados
	@PostMapping("/UnionActorPelicula")
	public String UnionActorPelicula(@Valid @ModelAttribute ActorPelicula ActorPelicula, BindingResult result) {
		
		if(ActorPelicula != null) {
			actorPeliculaServiceI.anadirActorPelicula(ActorPelicula);
		}else
			System.err.println("No se ha unido nada");
		
		return "redirect:index";
	}
	
	//Antes de la busqueda de Peliculas por Actores
	@GetMapping("/BusquedaPeliculasPorActor")
	public String BusquedaPeliculasPorActor(Model model) {
		
		final List<Actor> listaActores = actorServiceI.obtenerTodosActores();
		
		model.addAttribute("listaActores", listaActores);
		
		return "PeliculasPorActor";
	}
	
	//Lista de Peliculas del Actor.
	@PostMapping("/peliculasPorActor")
	public String PeliculasPorActor(@ModelAttribute Actor actorBusqueda, Model model) throws Exception{
		
		List<ActorPelicula> listaActorPelicula = new ArrayList<>();
		List<Pelicula> listaPelicula = new ArrayList<>();
		
		final long idActor = actorBusqueda.getId();
		
		if (StringUtils.hasText(String.valueOf(idActor))) {
			listaActorPelicula = actorPeliculaServiceI.obtenerActorPeliculaPorIdActor(idActor);

			for	(ActorPelicula d : listaActorPelicula) {
				listaPelicula.add(d.getPelicula());
			}
		}
		
		model.addAttribute("peliculaListView", listaPelicula);
		
		return "listaPelicula";
	}
	
	//Antes de la busqueda de Actores por Peliculas
	@GetMapping("/BusquedaActoresPorPeliculas")
	public String BusquedaActoresPorPelicula(Model model) {
		
		final List<Pelicula> listaPeliculas = peliculaServiceI.obtenerTodasPeliculas();
		
		model.addAttribute("listaPeliculas", listaPeliculas);
			
		return "ActoresPorPelicula";
	}
	
	//Lista de Peliculas del Actor.
	@PostMapping("/actoresPorPelicula")
	public String PeliculasPorActor(@ModelAttribute Pelicula peliculaBusqueda, Model model) throws Exception{
			
		List<ActorPelicula> listaActorPelicula = new ArrayList<>();
		List<Actor> listaActor = new ArrayList<>();
			
		final long idPelicula = peliculaBusqueda.getId();
			
		if (StringUtils.hasText(String.valueOf(idPelicula))) {
			listaActorPelicula = actorPeliculaServiceI.obtenerActorPeliculaPorIdPelicula(idPelicula);

			for	(ActorPelicula d : listaActorPelicula) {
				listaActor.add(d.getActor());
			}
		}
			
		model.addAttribute("actorListView", listaActor);
		
		return "listaActores";
	}
}

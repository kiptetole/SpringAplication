package com.dam.videoclub.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {
		
	//Capta cualquier solicitud y la manda a la pagina principal
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	/**
	 * Redirecciones al controlador de Actores
	 */
	/*Redirecciones al controlador de Actores*/
	@GetMapping("/ListaActores")
	public String redirectToActorDealershipController() {
		return "redirect:listaActores";
	}
	
	//Redirecciona a la plantilla de insercción de Actores
	@GetMapping("/AddActor")
	public String redirectToNewActorTemplate() {
		return "addActor";
	}
	
	/**
	 * Redirecciones al controlador de Peliculas
	 */
	/*Redirecciones al controlador de Peliculas*/
	@GetMapping("/ListaPelicula")
	public String redirectToPeliculaDealershipController() {
		return "redirect:listaPelicula";
	}
	
	//Redirecciona a la plantilla de insercción de Actores
	@GetMapping("/AddPelicula")
	public String redirectToNewPeliculaTemplate() {
		return "addPelicula";
	}
	
	/**
	 * Redirecciones al controlador de ActorPelicula
	 */
	
	//Vista que crea una relacion entre un actor y una pelicula
	@GetMapping("/formularioActorPelicula")
	public String redirectToNewActorPelicula() {
		return "redirect:FormularioActorPelicula";
	}
			
	//Muestra la lista de peliculas por actor
	@GetMapping("/listaPeliculaPorActor")
	public String redirectToSearchByActor() {
		return "redirect:BusquedaPeliculasPorActor";
	}
			
	//Muestra la lista de actores por Pelicula
	@GetMapping("/listaActoresPorPelicula")
	public String redirectToSearchByPelicula() {
		return "redirect:BusquedaActoresPorPeliculas";
	}
}

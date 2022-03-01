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
}

package com.dam.videoclub.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {
		
	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/ListaActores")
	public String redirectToActorDealershipController() {
		return "redirect:listaActores";
	}
	
	@GetMapping("/ListaPelicula")
	public String redirectToPeliculaDealershipController() {
		return "redirect:listaPelicula";
	}

}

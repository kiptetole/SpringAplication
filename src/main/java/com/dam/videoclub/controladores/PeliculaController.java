package com.dam.videoclub.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dam.videoclub.entidades.Pelicula;
import com.dam.videoclub.servicios.PeliculaServiceI;

@Controller
public class PeliculaController {

	@Autowired
	private PeliculaServiceI peliculaServiceI;

	@GetMapping("/listaPelicula")
	public String listaActores(Model model) {
		// Lista de Peliculas
		final List<Pelicula> listaPeliculas = peliculaServiceI.obtenerTodasPeliculas();
		
		//Carga de los datos en el modelo
		model.addAttribute("peliculaListView", listaPeliculas);
		model.addAttribute("btnDropPeliculaEnabled", Boolean.FALSE);
		
		return "listaPelicula";
	}
	
	@PostMapping("/removePelicula")
	public String eliminarCoche(@RequestParam String peliculaId, Model model) {

		// Eliminación de pelicula por Id
		peliculaServiceI.removePeliculaPorId(Long.valueOf(peliculaId)); 

		return "redirect:listaPelicula";

	}
}

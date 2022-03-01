package com.dam.videoclub.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dam.videoclub.entidades.Actor;
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
	
	@PostMapping("/addPelicula")
	private String addPelicula(@Valid @ModelAttribute Pelicula newPelicula, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parametros de la pelicula erroneos.");
		} else {

			// Se añade el nuevo coche
			peliculaServiceI.addPelicula(newPelicula);
		}

		return "redirect:listaPelicula";
	}
	
	@PostMapping("/antesUpdatePelicula")
	public String updateCoche(@RequestParam long peliculaId, Model model) {
		
		Pelicula pelicula = peliculaServiceI.obtenerPeliculaPorId(peliculaId);
		
		model.addAttribute("pelicula", pelicula);
		
		return "updatePelicula";
	}
	
	@PostMapping("/updatePelicula")
	private String updateActor(@Valid @ModelAttribute Pelicula updatePelicula, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parametros del actor erroneos.");
		} else {

			// Se añade el nuevo coche
			peliculaServiceI.updatePelicula(updatePelicula);
		}

		return "redirect:listaPelicula";
	}
	
	@PostMapping("/removePelicula")
	public String eliminarCoche(@RequestParam String peliculaId, Model model) {

		// Eliminación de pelicula por Id
		peliculaServiceI.removePeliculaPorId(Long.valueOf(peliculaId)); 

		return "redirect:listaPelicula";

	}
}

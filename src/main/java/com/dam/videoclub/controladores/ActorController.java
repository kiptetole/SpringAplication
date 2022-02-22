package com.dam.videoclub.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.servicios.ActorServiceI;

import java.util.List;


@Controller
public class ActorController {
	
	@Autowired
	private ActorServiceI actorServiceI;

	@GetMapping("/listaActores")
	public String listaActores(Model model) {
		// Lista de actores
		final List<Actor> listaActores = actorServiceI.obtenerTodosActores();
		
		//Carga de los datos en el modelo
		model.addAttribute("actorListView", listaActores);
		model.addAttribute("btnDropActorEnabled", Boolean.FALSE);
		
		return "listaActores";
	}
	
	@PostMapping("/removeActor")
	public String eliminarCoche(@RequestParam String ActorId, Model model) {

		// Eliminación de vehículo
		actorServiceI.removeActorPorId(Long.valueOf(ActorId)); 

		return "redirect:listaActores";

	}
}

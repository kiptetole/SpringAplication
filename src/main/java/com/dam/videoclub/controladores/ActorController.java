package com.dam.videoclub.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dam.videoclub.entidades.Actor;
import com.dam.videoclub.servicios.ActorServiceI;

import java.util.List;

import javax.validation.Valid;

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
	
	@PostMapping("/addActor")
	private String addActor(@Valid @ModelAttribute Actor newActor, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parametros del actor erroneos.");
		} else {

			// Se añade el nuevo coche
			actorServiceI.addActor(newActor);
		}

		return "redirect:listaActores";
	}
	
	@PostMapping("/antesUpdateActor")
	public String updateCoche(@RequestParam long ActorId, Model model) {
		
		Actor actor = actorServiceI.obtenerActorPorId(ActorId);
		
		model.addAttribute("actor", actor);
		
		return "updateActor";
	}
	
	@PostMapping("/updateActor")
	private String updateActor(@Valid @ModelAttribute Actor updateActor, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parametros del actor erroneos.");
		} else {

			// Se añade el nuevo coche
			actorServiceI.updateActor(updateActor);
		}

		return "redirect:listaActores";
	}
	
	@PostMapping("/removeActor")
	public String removeCoche(@RequestParam String ActorId, Model model) {

		actorServiceI.removeActorPorId(Long.valueOf(ActorId)); 

		return "redirect:listaActores";

	}
}

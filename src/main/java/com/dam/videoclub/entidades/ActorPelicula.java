package com.dam.videoclub.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pelicula_actor")
@Data @AllArgsConstructor @NoArgsConstructor
public class ActorPelicula implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "actor_id")
    Actor actor;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    Pelicula pelicula;

}

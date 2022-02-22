package com.dam.videoclub.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "pelicula")
@Data @AllArgsConstructor @NoArgsConstructor
public class Pelicula implements Serializable {
	
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador de Pelicula (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** Titulo de la pelicula */
	@NotEmpty(message="El tiulo de la pelicula no puede estar vacio")
	@Size(min=1, max=200, message="No se ha introducido el Titulo correctamente" )
	@Column(name = "Titulo", nullable = false)
	private String titulo;
	
	/** Año de la pelicula */
	@NotEmpty(message="El año de estreno de la pelicula no puede estar vacio")
	@NotNull(message="Tiene que introducir la fecha de estreno")
	@Column(name = "Fecha_Estreno", nullable = false)
	private Date annoEstreno;
	
	/** Duracion de la pelicula */
	@NotEmpty(message="La duracion de la pelicula no puede estar vacio")
	@Size(min=1, max=4, message="No se ha introducido la duracion de la pelicula" )
	@Column(name = "Min_Duracion", nullable = false)
	private int minDuracion;
	
	/** Resumen de la pelicula */
	@Size(min=1, max=20, message="No se ha introducido la nacionalidad correctamente" )
	@Column(name = "Resumen", nullable = true)
	private String resumen;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "pelicula_actor",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    public List<Actor> actores;
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", Titulo: " + titulo + ", Año de estreno: " + annoEstreno + ", Duracion de la pelicula=" + minDuracion + ", Resumen:\n" + resumen + "]";
	}
}

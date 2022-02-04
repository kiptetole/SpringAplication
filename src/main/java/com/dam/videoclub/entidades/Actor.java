package com.dam.videoclub.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {
	
	/** Identificador del actor/actriz (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** Nombre del actor/actriz */
	@Size(min=1, max=20, message="No se ha introducido el nombre correctamente" )
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	/** Apellidos del actor/actriz */
	@Size(min=1, max=100, message="No se ha introducido los apellidos correctamente" )
	@Column(name = "Apellidos", nullable = false)
	private String apellidos;
	
	/** Fecha de nacimiento del actor/actriz */
	@NotNull(message="Tiene que introducir la fecha de nacimiento")
	@Column(name = "Fecha_nacimiento", nullable = false)
	private Date fech_nacimiento;
	
	/** Nacionalidad del actor/actriz */
	@Size(min=1, max=20, message="No se ha introducido la nacionalidad correctamente" )
	@Column(name = "Nacionalidad", nullable = false)
	private String nacionalidad;
	
	@ManyToMany(mappedBy = "actor")
	private List<Pelicula> peliculas;
	
}

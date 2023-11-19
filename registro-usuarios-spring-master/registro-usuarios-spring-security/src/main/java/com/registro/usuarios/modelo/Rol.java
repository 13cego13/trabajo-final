package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un rol de usuario en el sistema.
 */
@Entity
@Table(name = "rol")
public class Rol {

	/**
	 * Identificador único del rol.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del rol.
	 */
	private String nombre;

	/**
	 * Obtiene el identificador único del rol.
	 *
	 * @return El identificador único del rol.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el identificador único del rol.
	 *
	 * @param id El nuevo identificador único del rol.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del rol.
	 *
	 * @return El nombre del rol.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del rol.
	 *
	 * @param nombre El nuevo nombre del rol.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor que crea un nuevo objeto Rol con los parámetros proporcionados.
	 *
	 * @param id     El identificador único del rol.
	 * @param nombre El nombre del rol.
	 */
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Constructor por defecto sin parámetros.
	 */
	public Rol() {

	}

	/**
	 * Constructor que crea un nuevo objeto Rol con el nombre proporcionado.
	 *
	 * @param nombre El nombre del rol.
	 */
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
}
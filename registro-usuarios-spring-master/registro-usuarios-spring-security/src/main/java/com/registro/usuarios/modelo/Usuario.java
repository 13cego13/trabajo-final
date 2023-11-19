package com.registro.usuarios.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	/**
	 * Identificador único del usuario.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del usuario.
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Apellido del usuario.
	 */
	@Column(name = "apellido")
	private String apellido;

	/**
	 * Dirección de correo electrónico del usuario.
	 */
	private String email;

	/**
	 * Contraseña del usuario.
	 */
	private String password;

	/**
	 * Roles asociados al usuario.
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
	)
	private Collection<Rol> roles;

	/**
	 * Obtiene el identificador único del usuario.
	 *
	 * @return El identificador único del usuario.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el identificador único del usuario.
	 *
	 * @param id El nuevo identificador único del usuario.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param nombre El nuevo nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del usuario.
	 *
	 * @return El apellido del usuario.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido del usuario.
	 *
	 * @param apellido El nuevo apellido del usuario.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene la dirección de correo electrónico del usuario.
	 *
	 * @return La dirección de correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece la dirección de correo electrónico del usuario.
	 *
	 * @param email La nueva dirección de correo electrónico del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 *
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 *
	 * @param password La nueva contraseña del usuario.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene los roles asociados al usuario.
	 *
	 * @return La colección de roles del usuario.
	 */
	public Collection<Rol> getRoles() {
		return roles;
	}

	/**
	 * Establece los roles asociados al usuario.
	 *
	 * @param roles La nueva colección de roles del usuario.
	 */
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * Constructor que crea un nuevo objeto Usuario con los parámetros proporcionados.
	 *
	 * @param id      El identificador único del usuario.
	 * @param nombre  El nombre del usuario.
	 * @param apellido El apellido del usuario.
	 * @param email   La dirección de correo electrónico del usuario.
	 * @param password La contraseña del usuario.
	 * @param roles   La colección de roles del usuario.
	 */
	public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * Constructor que crea un nuevo objeto Usuario con los parámetros proporcionados.
	 *
	 * @param nombre  El nombre del usuario.
	 * @param apellido El apellido del usuario.
	 * @param email   La dirección de correo electrónico del usuario.
	 * @param password La contraseña del usuario.
	 * @param roles   La colección de roles del usuario.
	 */
	public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * Constructor por defecto sin parámetros.
	 */
	public Usuario() {

	}
}
package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;

/**
 * Interfaz que define los métodos del servicio relacionados con la gestión de usuarios.
 */
public interface UsuarioServicio extends UserDetailsService {

	/**
	 * Guarda un nuevo usuario a partir de la información proporcionada en el DTO de registro.
	 *
	 * @param registroDTO El DTO que contiene la información del nuevo usuario.
	 * @return El usuario guardado.
	 */
	public Usuario guardar(UsuarioRegistroDTO registroDTO);

	/**
	 * Obtiene una lista de todos los usuarios registrados en el sistema.
	 *
	 * @return Lista de usuarios.
	 */
	public List<Usuario> listarUsuarios();

}

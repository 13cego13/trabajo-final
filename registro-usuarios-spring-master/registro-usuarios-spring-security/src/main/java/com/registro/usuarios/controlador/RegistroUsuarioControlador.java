package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * Controlador para gestionar las solicitudes relacionadas con el registro de usuarios.
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private UsuarioServicio usuarioServicio;

	/**
	 * Constructor que inyecta el servicio de usuario al controlador.
	 *
	 * @param usuarioServicio El servicio de usuario a ser inyectado.
	 */
	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}

	/**
	 * Método que retorna un nuevo objeto UsuarioRegistroDTO y lo agrega al modelo.
	 *
	 * @return Un nuevo objeto UsuarioRegistroDTO.
	 */
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	/**
	 * Muestra el formulario de registro.
	 *
	 * @return El nombre de la vista "registro".
	 */
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}

	/**
	 * Procesa la solicitud de registro de un nuevo usuario.
	 *
	 * @param registroDTO El objeto UsuarioRegistroDTO que contiene la información del nuevo usuario.
	 * @return Redirecciona a la página de registro con un mensaje de éxito.
	 */
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioServicio.guardar(registroDTO);
		return "redirect:/registro?exito";
	}
}

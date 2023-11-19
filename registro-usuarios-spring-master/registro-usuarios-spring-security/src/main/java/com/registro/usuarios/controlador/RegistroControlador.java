package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * Controlador para gestionar las solicitudes relacionadas con el registro de usuarios.
 */
@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;

	/**
	 * Muestra la página de inicio de sesión.
	 *
	 * @return El nombre de la vista "login".
	 */
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	/**
	 * Muestra la página de inicio y lista de usuarios.
	 *
	 * @param modelo El modelo que se utilizará en la vista.
	 * @return El nombre de la vista "Inicio".
	 */
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "Inicio";
	}

	/**
	 * Muestra la página que describe qué es el sistema.
	 *
	 * @return El nombre de la vista "Que somos".
	 */
	@GetMapping("/Que somos")
	public String mostrarQueSomos() {
		return "Que somos";
	}
}

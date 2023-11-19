package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot para el registro de usuarios con Spring Security.
 */
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 *
	 * @param args Los argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
	}
}
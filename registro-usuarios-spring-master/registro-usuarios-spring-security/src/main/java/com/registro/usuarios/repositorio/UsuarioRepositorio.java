package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Usuario;

/**
 * Repositorio que gestiona las operaciones de base de datos para la entidad Usuario.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	/**
	 * Busca un usuario por su dirección de correo electrónico.
	 *
	 * @param email La dirección de correo electrónico del usuario a buscar.
	 * @return El usuario encontrado, o null si no se encuentra ninguno.
	 */
	public Usuario findByEmail(String email);

}

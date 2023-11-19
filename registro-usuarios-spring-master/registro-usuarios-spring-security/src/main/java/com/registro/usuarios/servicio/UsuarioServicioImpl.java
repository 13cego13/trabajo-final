package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

/**
 * Implementación del servicio de usuario.
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Constructor que inyecta el repositorio de usuario.
	 *
	 * @param usuarioRepositorio El repositorio de usuario a ser inyectado.
	 */
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	/**
	 * Guarda un nuevo usuario a partir de la información proporcionada en el DTO de registro.
	 *
	 * @param registroDTO El DTO que contiene la información del nuevo usuario.
	 * @return El usuario guardado.
	 */
	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(),
				registroDTO.getApellido(), registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

	/**
	 * Carga un usuario por su nombre de usuario (email).
	 *
	 * @param username El nombre de usuario (email) del usuario a cargar.
	 * @return Detalles del usuario cargado.
	 * @throws UsernameNotFoundException Si el usuario no se encuentra.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	/**
	 * Mapea los roles del usuario a autoridades de Spring Security.
	 *
	 * @param roles La colección de roles del usuario.
	 * @return Lista de autoridades.
	 */
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	/**
	 * Obtiene una lista de todos los usuarios registrados en el sistema.
	 *
	 * @return Lista de usuarios.
	 */
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
}

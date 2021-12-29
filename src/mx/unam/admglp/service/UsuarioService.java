package mx.unam.admglp.service;

import java.util.List;

import mx.unam.admglp.service.dto.Usuario;

public interface UsuarioService {
	public Usuario obtenerUsuario(Integer id);
	public List<Usuario> obtenerUsuarios();
	public Usuario insertarUsuario(Usuario usuario);
	public Boolean actualizarUsuario(Usuario usuario);
	public Boolean borrarUsuario(Usuario usuario);
}

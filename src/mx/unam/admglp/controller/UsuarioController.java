package mx.unam.admglp.controller;

import mx.unam.admglp.service.dto.Usuario;

public interface UsuarioController {
	public void obtenerUsuario(Integer id);
	public void obtenerUsuarios();
	public void insertarUsuario(Usuario usuarioRequest);
	public void actualizarUsuario(Usuario usuarioRequest);
	public void borrarUsuario(Usuario usuarioRequest);
}

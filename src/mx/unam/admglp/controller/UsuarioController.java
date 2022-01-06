package mx.unam.admglp.controller;

import mx.unam.admglp.service.dto.Usuario;

public interface UsuarioController {
	public void obtenerUsuario(Integer id);
	public void obtenerUsuarios();
	public void insertarUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	public void actualizarUsuarioEstatus(Usuario usuario, Integer nuevoEstatus);
}

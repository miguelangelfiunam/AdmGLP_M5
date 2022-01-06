package mx.unam.admglp.repository;

import java.util.List;

import mx.unam.admglp.repository.dto.UsuarioDTO;

public interface UsuarioRepository {
	public UsuarioDTO obtenerUsuario(Integer id);
	public List<UsuarioDTO> obtenerUsuarios();
	public Integer insertarUsuario(UsuarioDTO usuarioDTO);
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);
	public UsuarioDTO actualizarUsuarioEstatus(UsuarioDTO usuarioDTO, Integer nuevoEstatus);
}

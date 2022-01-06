package mx.unam.admglp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import mx.unam.admglp.service.UsuarioService;
import mx.unam.admglp.service.dto.Usuario;

@Controller
public class UsuarioControllerImpl implements UsuarioController {

	private static Log log = LogFactory.getLog(UsuarioControllerImpl.class);

	private UsuarioService usuarioService;

	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void obtenerUsuario(Integer id) {
		// TODO Auto-generated method stub
		Usuario u = usuarioService.obtenerUsuario(id);
		System.out.println(u);
	}

	@Override
	public void obtenerUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario u = usuarioService.insertarUsuario(usuario);
		System.out.println(u);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario u = usuarioService.actualizarUsuario(usuario);
		if (u != null) {
			System.out.println("Se actualiza usuario");
			System.out.println(u);
		} else {
			System.out.println("Sin actualizar usuario");
		}
	}

	@Override
	public void actualizarUsuarioEstatus(Usuario usuario, Integer nuevoEstatus) {
		// TODO Auto-generated method stub
		Usuario u = usuarioService.actualizarUsuarioEstatus(usuario, nuevoEstatus);
		if (u != null) {
			System.out.println("Se actualiza estatus usuario (" + nuevoEstatus + ")");
			System.out.println(u);
		} else {
			System.out.println("Sin actualizar estatus usuario");
		}

	}

	@PostConstruct
	public void inicializar() {
		log.info("Inicializando UsuarioControllerImpl");
	}

	@PreDestroy
	public void destruir() {
		log.info("Destruyendo UsuarioControllerImpl");
	}

}

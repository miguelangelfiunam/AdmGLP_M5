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
		List<Usuario> usuarios =  usuarioService.obtenerUsuarios();
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
	public void actualizarUsuario(Usuario usuarioRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarUsuario(Usuario usuarioRequest) {
		// TODO Auto-generated method stub
		
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

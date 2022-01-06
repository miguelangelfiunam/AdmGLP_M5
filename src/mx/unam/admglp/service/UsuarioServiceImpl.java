package mx.unam.admglp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import mx.unam.admglp.repository.ContraRepository;
import mx.unam.admglp.repository.UsuarioRepository;
import mx.unam.admglp.repository.dto.ContraDTO;
import mx.unam.admglp.repository.dto.UsuarioDTO;
import mx.unam.admglp.service.dto.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static Log log = LogFactory.getLog(UsuarioService.class);

	private UsuarioRepository usuarioRepository;

	private ContraRepository contraRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ContraRepository contraRepository) {
		this.usuarioRepository = usuarioRepository;
		this.contraRepository = contraRepository;
	}

	@Override
	public Usuario obtenerUsuario(Integer id) {
		// TODO Auto-generated method stub
		UsuarioDTO u = usuarioRepository.obtenerUsuario(id);
		return new Usuario(u.getIdUsuario(), u.getApodo(), u.getCorreo1(), u.getCorreo2(), u.getNombre(),
				u.getApellido1(), u.getApellido2(), u.getEdad(), u.getFechaNacimiento(), u.getTelefono1(),
				u.getTelefono2(), u.getFecRegistro(), u.getFecActualizacion(), u.getEstatus());
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.obtenerUsuarios().stream()
				.map(u -> new Usuario(u.getIdUsuario(), u.getApodo(), u.getCorreo1(), u.getCorreo2(), u.getNombre(),
						u.getApellido1(), u.getApellido2(), u.getEdad(), u.getFechaNacimiento(), u.getTelefono1(),
						u.getTelefono2(), u.getFecRegistro(), u.getFecActualizacion(), u.getEstatus()))
				.collect(Collectors.toList());
	}

	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		ContraDTO contraDTO = new ContraDTO(usuario.getContra().getContraCifrado(), usuario.getContra().getEstatus());
		Integer idContra = contraRepository.insertarContra(contraDTO);
		UsuarioDTO usuarioDTO = new UsuarioDTO(idContra, usuario.getApodo(), usuario.getCorreo1(), usuario.getCorreo2(),
				usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getEdad(),
				usuario.getFechaNacimiento(), usuario.getTelefono1(), usuario.getTelefono2(), usuario.getFecRegistro(),
				usuario.getFecActualizacion(), usuario.getEstatus());
		Integer id = usuarioRepository.insertarUsuario(usuarioDTO);
		return new Usuario(id, usuarioDTO.getApodo(), usuarioDTO.getCorreo1(), usuarioDTO.getCorreo2(),
				usuarioDTO.getNombre(), usuarioDTO.getApellido1(), usuarioDTO.getApellido2(), usuarioDTO.getEdad(),
				usuarioDTO.getFechaNacimiento(), usuarioDTO.getTelefono1(), usuarioDTO.getTelefono2(),
				usuarioDTO.getFecRegistro(), usuarioDTO.getFecActualizacion(), usuarioDTO.getEstatus());
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		UsuarioDTO dto = usuarioRepository.actualizarUsuario(
				new UsuarioDTO(usuario.getIdUsuario(), usuario.getApodo(), usuario.getCorreo1(), usuario.getCorreo2(),
						usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getEdad(),
						usuario.getFechaNacimiento(), usuario.getTelefono1(), usuario.getTelefono2()));
		return dto == null ? null : usuario;
	}

	@Override
	public Usuario actualizarUsuarioEstatus(Usuario usuario, Integer nuevoEstatus) {
		// TODO Auto-generated method stub
		UsuarioDTO dto = usuarioRepository.actualizarUsuarioEstatus(new UsuarioDTO(usuario.getIdUsuario()), nuevoEstatus);
		return dto == null ? null : usuario;
	}

	@PostConstruct
	public void inicializar() {
		log.info("Inicializando UsuarioServiceImpl");
	}

	@PreDestroy
	public void destruir() {
		log.info("Destruyendo UsuarioServiceImpl");
	}

}

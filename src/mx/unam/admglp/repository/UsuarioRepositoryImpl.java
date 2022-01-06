package mx.unam.admglp.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.unam.admglp.repository.dto.UsuarioDTO;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	protected static String SELECT_USUARIO = "SELECT * FROM t_usuario WHERE id_usuario = ?";
	protected static String SELECT_USUARIOS = "SELECT * FROM t_usuario";
	protected static String INSERT_USUARIO = "INSERT INTO t_usuario(id_contra, usuario_vc_apodo, usuario_vc_correo1, "
			+ "usuario_vc_correo2, usuario_vc_nombre, usuario_vc_apellido1, usuario_vc_apellido2, "
			+ "usuario_ti_edad, usuario_d_fec_nacimiento, usuario_vc_telefono1, "
			+ "usuario_vc_telefono2, usuario_dt_fecha_registro, usuario_dt_fecha_actualizacion, "
			+ "usuario_si_estatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NULL, ?)";
	private static String UPDATE_USUARIO = "UPDATE t_usuario SET usuario_vc_apodo = ?, "
			+ "usuario_vc_correo1 = ?, usuario_vc_correo2 = ?, usuario_vc_nombre = ?, "
			+ "usuario_vc_apellido1 = ?, usuario_vc_apellido2 = ?, usuario_ti_edad = ?, "
			+ "usuario_d_fec_nacimiento = ?, usuario_vc_telefono1 = ?, usuario_vc_telefono2 = ?, "
			+ "usuario_dt_fecha_actualizacion = NOW() WHERE id_usuario = ?";

	private static String UPDATE_USUARIO_STATUS = "UPDATE t_usuario SET usuario_si_estatus = ?, "
			+ "usuario_dt_fecha_actualizacion = NOW() WHERE id_usuario = ?";

	private JdbcTemplate jdbcTemplate;

	public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UsuarioDTO obtenerUsuario(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SELECT_USUARIO, (rs, rowNum) -> new UsuarioDTO(rs.getInt("id_usuario"),
				rs.getInt("id_contra"), rs.getString("usuario_vc_apodo"), rs.getString("usuario_vc_correo1"),
				rs.getString("usuario_vc_correo2"), rs.getString("usuario_vc_nombre"),
				rs.getString("usuario_vc_apellido1"), rs.getString("usuario_vc_apellido2"),
				rs.getInt("usuario_ti_edad"),
				rs.getDate("usuario_d_fec_nacimiento") != null ? rs.getDate("usuario_d_fec_nacimiento").toLocalDate()
						: null,
				rs.getString("usuario_vc_telefono1"), rs.getString("usuario_vc_telefono2"),
				rs.getTimestamp("usuario_dt_fecha_registro") != null
						? rs.getTimestamp("usuario_dt_fecha_registro").toLocalDateTime()
						: null,
				rs.getTimestamp("usuario_dt_fecha_actualizacion") != null
						? rs.getTimestamp("usuario_dt_fecha_actualizacion").toLocalDateTime()
						: null,
				rs.getInt("usuario_si_estatus")), id);
	}

	@Override
	public List<UsuarioDTO> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_USUARIOS, (rs, rowNum) -> new UsuarioDTO(rs.getInt("id_usuario"),
				rs.getInt("id_contra"), rs.getString("usuario_vc_apodo"), rs.getString("usuario_vc_correo1"),
				rs.getString("usuario_vc_correo2"), rs.getString("usuario_vc_nombre"),
				rs.getString("usuario_vc_apellido1"), rs.getString("usuario_vc_apellido2"),
				rs.getInt("usuario_ti_edad"),
				rs.getDate("usuario_d_fec_nacimiento") != null ? rs.getDate("usuario_d_fec_nacimiento").toLocalDate()
						: null,
				rs.getString("usuario_vc_telefono1"), rs.getString("usuario_vc_telefono2"),
				rs.getTimestamp("usuario_dt_fecha_registro") != null
						? rs.getTimestamp("usuario_dt_fecha_registro").toLocalDateTime()
						: null,
				rs.getTimestamp("usuario_dt_fecha_actualizacion") != null
						? rs.getTimestamp("usuario_dt_fecha_actualizacion").toLocalDateTime()
						: null,
				rs.getInt("usuario_si_estatus")));
	}

	@Override
	public Integer insertarUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_USUARIO, new String[] { "id" });
			Integer i = 1;
			ps.setInt(i++, usuarioDTO.getIdContra());
			ps.setString(i++, usuarioDTO.getApodo());
			ps.setString(i++, usuarioDTO.getCorreo1());
			ps.setString(i++, usuarioDTO.getCorreo2());
			ps.setString(i++, usuarioDTO.getNombre());
			ps.setString(i++, usuarioDTO.getApellido1());
			ps.setString(i++, usuarioDTO.getApellido2());
			ps.setInt(i++, usuarioDTO.getEdad());
			ps.setDate(i++, java.sql.Date.valueOf(usuarioDTO.getFechaNacimiento()));
			ps.setString(i++, usuarioDTO.getTelefono1());
			ps.setString(i++, usuarioDTO.getTelefono2());
			ps.setInt(i++, usuarioDTO.getEstatus());
			return ps;
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		int res = jdbcTemplate.update(UPDATE_USUARIO, usuarioDTO.getApodo(), usuarioDTO.getCorreo1(),
				usuarioDTO.getCorreo2(), usuarioDTO.getNombre(), usuarioDTO.getApellido1(), usuarioDTO.getApellido2(),
				usuarioDTO.getEdad(), java.sql.Date.valueOf(usuarioDTO.getFechaNacimiento()), usuarioDTO.getTelefono1(),
				usuarioDTO.getTelefono2(), usuarioDTO.getIdUsuario());
		return res == 1 ? usuarioDTO : null;
	}

	@Override
	public UsuarioDTO actualizarUsuarioEstatus(UsuarioDTO usuarioDTO, Integer nuevoEstatus) {
		// TODO Auto-generated method stub
		int res = jdbcTemplate.update(UPDATE_USUARIO_STATUS, nuevoEstatus, usuarioDTO.getIdUsuario());
		return res == 1 ? usuarioDTO : null;
	}

}

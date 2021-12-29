package mx.unam.admglp.repository;

import java.sql.PreparedStatement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.unam.admglp.repository.dto.ContraDTO;

@Repository
public class ContraRepositoryImpl implements ContraRepository {

	private static Log log = LogFactory.getLog(ContraRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;

	public ContraRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected static String SELECT_CONTRA = "SELECT * FROM t_contra WHERE id_contra = ?";
	protected static String SELECT_CONTRA_USU = "SELECT tc.id_contra, tc.contra_vc_contra_cifrado, "
			+ "tc.contra_dt_fecha_registro, " + "tc.contra_dt_fecha_actualizacion, " + "tc.contra_si_estatus "
			+ "FROM t_usuario tu, t_contra tc WHERE tu.id_usuario = ? " + "AND tu.id_contra = tc.id_contra ";
	protected static String INSERT_CONTRA = "INSERT INTO " + "t_contra(contra_vc_contra_cifrado, "
			+ "contra_dt_fecha_registro, contra_dt_fecha_actualizacion, contra_si_estatus) VALUES(?, NOW(), NULL, ?)";

	@Override
	public ContraDTO obtenerContra(Integer id) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject(SELECT_CONTRA,
					(rs, rowNum) -> new ContraDTO(rs.getInt("id_contra"), rs.getString("contra_vc_contra_cifrado"),
							rs.getTimestamp("contra_dt_fecha_registro"),
							rs.getTimestamp("contra_dt_fecha_actualizacion"), rs.getInt("contra_si_estatus")),
					id);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
			return null;
		}

	}

	@Override
	public ContraDTO obtenerContraPorUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject(SELECT_CONTRA_USU,
					(rs, rowNum) -> new ContraDTO(rs.getInt("id_contra"), rs.getString("contra_vc_contra_cifrado"),
							rs.getTimestamp("contra_dt_fecha_registro"),
							rs.getTimestamp("contra_dt_fecha_actualizacion"), rs.getInt("contra_si_estatus")),
					idUsuario);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
			return null;
		}
	}

	@Override
	public Integer insertarContra(ContraDTO contraDTO) {
		// TODO Auto-generated method stub
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_CONTRA, new String[] { "id" });
			Integer i = 1;
			ps.setString(i++, contraDTO.getContraCifrado());
			ps.setInt(i++, contraDTO.getEstatus());
			return ps;
		}, keyHolder);
		return Integer.valueOf(keyHolder.getKey().intValue());
	}

	@Override
	public ContraDTO actualizarContra(ContraDTO contraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContraDTO borrarContra(ContraDTO contraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}

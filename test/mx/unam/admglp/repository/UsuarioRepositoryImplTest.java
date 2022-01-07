package mx.unam.admglp.repository;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.unam.admglp.TestConfigRepository;
import mx.unam.admglp.repository.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigRepository.class)
public class UsuarioRepositoryImplTest {

	@Autowired
	private UsuarioRepositoryImpl usuarioRepositoryImpl;

	@Autowired
	private JdbcTemplate mockJdbcTemplate;

	@After
	public void tearDown() throws Exception {
		Mockito.clearInvocations(mockJdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerUsuario() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = "1995-10-05";
		LocalDate localDate = LocalDate.parse(date, formatter);
		UsuarioDTO mockUsuarioDTO = new UsuarioDTO(1, "dani_glp2", "daniii@adm.com.mx", "otrocorreo@dgp.unam.mx", "Daniel", "Arteaga", "Rodriguez", 26,
				localDate, "5613915719", "5512345678");

		Mockito.when(mockJdbcTemplate.queryForObject(Mockito.eq(UsuarioRepositoryImpl.SELECT_USUARIO),
				Mockito.any(RowMapper.class), Mockito.eq(1))).thenReturn(mockUsuarioDTO);
		
		UsuarioDTO usuarioDTO = usuarioRepositoryImpl.obtenerUsuario(1);
		Assert.assertEquals(Integer.valueOf(1), usuarioDTO.getIdUsuario());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerUsuarios() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = "1995-10-05";
		LocalDate localDate = LocalDate.parse(date, formatter);
		UsuarioDTO mockUsuarioDTO_1 = new UsuarioDTO(1, "dani_glp2", "daniii@adm.com.mx", "otrocorreo@dgp.unam.mx", "Daniel", "Arteaga", "Rodriguez", 26,
				localDate, "5613915719", "5512345678");
		UsuarioDTO mockUsuarioDTO_2 = new UsuarioDTO(2, "dani_glp2", "daniii@adm.com.mx", "otrocorreo@dgp.unam.mx", "Daniel", "Arteaga", "Rodriguez", 26,
				localDate, "5613915719", "5512345678");
		List <UsuarioDTO> mocklistaDTO = new ArrayList<UsuarioDTO>();
		mocklistaDTO.add(mockUsuarioDTO_1);
		mocklistaDTO.add(mockUsuarioDTO_2);
		
		Mockito.when(mockJdbcTemplate.query(Mockito.eq(UsuarioRepositoryImpl.SELECT_USUARIOS),
				Mockito.any(RowMapper.class))).thenReturn(mocklistaDTO);
		
		List <UsuarioDTO> listaDTO = usuarioRepositoryImpl.obtenerUsuarios();
		Assert.assertEquals(mocklistaDTO.size(), listaDTO.size());
		
		
	}

//	@Test
	public void testInsertarUsuario() {
		fail("Not yet implemented");
	}

//	@Test
	public void testActualizarUsuario() {
		fail("Not yet implemented");
	}

//	@Test
	public void testActualizarUsuarioEstatus() {
		fail("Not yet implemented");
	}

}

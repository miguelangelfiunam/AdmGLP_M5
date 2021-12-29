package mx.unam.admglp.repository;

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
import mx.unam.admglp.repository.dto.ContraDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigRepository.class)
public class ContraRepositoryImplTest {

	@Autowired
	private ContraRepositoryImpl contraRepositoryImpl;

	@Autowired
	private JdbcTemplate mockJdbcTemplate;

	@After
	public void tearDown() throws Exception {
		Mockito.clearInvocations(mockJdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerContra() {
		ContraDTO mockContraDTO = new ContraDTO(1, "passCifrado", null, null, 10);

		Mockito.when(mockJdbcTemplate.queryForObject(Mockito.eq(ContraRepositoryImpl.SELECT_CONTRA),
				Mockito.any(RowMapper.class), Mockito.eq(1))).thenReturn(mockContraDTO);
		
		ContraDTO contraDTO = contraRepositoryImpl.obtenerContra(1);
		Assert.assertEquals(Integer.valueOf(1), contraDTO.getId());
		Assert.assertEquals(Integer.valueOf(10), contraDTO.getEstatus());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerContraNull() {
		Mockito.when(mockJdbcTemplate.queryForObject(
				Mockito.eq(ContraRepositoryImpl.SELECT_CONTRA), 
				Mockito.any(RowMapper.class), 
				Mockito.eq(1)))
		.thenThrow(new RuntimeException());
		
		ContraDTO contraDTO = contraRepositoryImpl.obtenerContra(1);
		Assert.assertNull(contraDTO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerContraPorUsuario() {
		ContraDTO mockContraDTO = new ContraDTO(1, "passCifrado", null, null, 10);

		Mockito.when(mockJdbcTemplate.queryForObject(Mockito.eq(ContraRepositoryImpl.SELECT_CONTRA_USU),
				Mockito.any(RowMapper.class), Mockito.eq(1))).thenReturn(mockContraDTO);
		
		ContraDTO contraDTO = contraRepositoryImpl.obtenerContraPorUsuario(1);
		Assert.assertEquals(Integer.valueOf(1), contraDTO.getId());
		Assert.assertEquals(Integer.valueOf(10), contraDTO.getEstatus());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testObtenerContraPorUsuarioNull() {
		Mockito.when(mockJdbcTemplate.queryForObject(
				Mockito.eq(ContraRepositoryImpl.SELECT_CONTRA_USU), 
				Mockito.any(RowMapper.class), 
				Mockito.eq(1)))
		.thenThrow(new RuntimeException());
		
		ContraDTO contraDTO = contraRepositoryImpl.obtenerContraPorUsuario(1);
		Assert.assertNull(contraDTO);
	}

//	@Test
//	public void testObtenerContraPorUsuario() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertarContra() {
//		fail("Not yet implemented");
//	}

}

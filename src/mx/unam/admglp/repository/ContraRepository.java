package mx.unam.admglp.repository;

import mx.unam.admglp.repository.dto.ContraDTO;

public interface ContraRepository {
	public ContraDTO obtenerContra(Integer id);
	public ContraDTO obtenerContraPorUsuario(Integer idUsuario);
	public Integer insertarContra(ContraDTO contraDTO);
	public ContraDTO actualizarContra(ContraDTO contraDTO);
	public ContraDTO borrarContra(ContraDTO contraDTO);
}

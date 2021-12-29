package mx.unam.admglp.service;

import mx.unam.admglp.service.dto.Contra;

public interface ContraService {
	public Contra obtenerContra(Integer id);
	public Contra obtenerContraPorUsuario(Integer idUsuario);
	public Integer insertarContra(Contra contra);
	public Contra actualizarContra(Contra contra);
	public Contra borrarContra(Contra contra);
}

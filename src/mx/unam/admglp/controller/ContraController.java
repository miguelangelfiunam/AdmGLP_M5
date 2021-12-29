package mx.unam.admglp.controller;

import mx.unam.admglp.service.dto.Contra;

public interface ContraController {
	public void obtenerContra(Integer id);
	public void obtenerContraPorUsuario(Integer idUsuario);
	public void insertarContra(Contra contra);
	public void actualizarContra(Contra contra);
	public void borrarContra(Contra contra);
}

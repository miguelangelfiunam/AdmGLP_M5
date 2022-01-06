package mx.unam.admglp.repository.dto;

import java.time.LocalDateTime;

public class ContraDTO {
	private Integer id;
	private String contraCifrado;
	private LocalDateTime fecRegistro; // Fecha de registro
	private LocalDateTime fecActualizacion; // Fecha de actualizacion
	private Integer estatus; // Estatus del registro en la base

	public ContraDTO(Integer id, String contraCifrado, LocalDateTime fecRegistro, LocalDateTime fecActualizacion, Integer estatus) {
		this.id = id;
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public ContraDTO(String contraCifrado, LocalDateTime fecRegistro, LocalDateTime fecActualizacion, Integer estatus) {
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public ContraDTO(String contraCifrado, Integer estatus) {
		this.contraCifrado = contraCifrado;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContraCifrado() {
		return contraCifrado;
	}

	public void setContraCifrado(String contraCifrado) {
		this.contraCifrado = contraCifrado;
	}

	public LocalDateTime getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(LocalDateTime fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public LocalDateTime getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(LocalDateTime fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
}

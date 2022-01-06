package mx.unam.admglp.service.dto;

import java.time.LocalDateTime;

public class Contra {
	private Integer id;
	private String contraCifrado;
	private LocalDateTime fecRegistro; // Fecha de registro
	private LocalDateTime fecActualizacion; // Fecha de actualizacion
	private Integer estatus; // Estatus del registro en la base

	public Contra(Integer id, String contraCifrado, LocalDateTime fecRegistro, LocalDateTime fecActualizacion, Integer estatus) {
		this.id = id;
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Contra(String contraCifrado, LocalDateTime fecRegistro, LocalDateTime fecActualizacion, Integer estatus) {
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Contra(String contraCifrado, Integer estatus) {
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

	@Override
	public String toString() {
		return "Contra [id=" + id + ", contraCifrado=" + contraCifrado + ", fecRegistro=" + fecRegistro
				+ ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus + "]";
	}
}

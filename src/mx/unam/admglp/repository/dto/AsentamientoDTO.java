package mx.unam.admglp.repository.dto;

import java.time.LocalDateTime;

public class AsentamientoDTO {
	private Integer id;
	private String clave;
	private String codigoPostal;
	private String tipo;
	private String nombre;
	private LocalDateTime fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	private LocalDateTime fecActualizacion; // Fecha de fin de acceso a la aplicacion
	private Integer estatus;

	public AsentamientoDTO(Integer id, String clave, String codigoPostal, String tipo, String nombre, LocalDateTime fecRegistro,
			LocalDateTime fecActualizacion, Integer estatus) {
		this.id = id;
		this.clave = clave;
		this.codigoPostal = codigoPostal;
		this.tipo = tipo;
		this.nombre = nombre;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

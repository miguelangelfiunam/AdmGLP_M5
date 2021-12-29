package mx.unam.admglp.repository.dto;

import java.util.Date;

public class RolDTO {
	private Integer idRol; // Identificador del rol
	private String nombre; // Nombre del rol
	private String tipo; // Tipo del rol
	private Date fecRegistro; // Fecha de registro
	private Date fecActualizacion; // Fecha de actualizacion
	private Integer estatus; // Estatus del registro en la base

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
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
		return "RolDTO [idRol=" + idRol + ", nombre=" + nombre + ", tipo=" + tipo + ", fecRegistro=" + fecRegistro
				+ ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus + "]";
	}
}

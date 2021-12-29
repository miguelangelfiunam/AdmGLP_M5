package mx.unam.admglp.service.dto;

import java.util.Date;

public class Usuario {
	private Integer idUsuario; // Identificador de usuario

	private String apodo; // Seudonimo del usuario en la aplicacion
	private String correo1; // Correo electronico
	private String correo2; // Correo electronico
	private String nombre; // Nombre de la persona 100
	private String apellido1; // Primer apellido 100
	private String apellido2; // Segundo apellido 100
	private Integer edad;// Edad de la persona
	private Date fechaNacimiento; // Fecha de nacimiento
	private String telefono1; // Telefono del usuario
	private String telefono2; // Segundo telefono de contacto
	private Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	private Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	private Integer estatus; // Estado del usuario
//	private Set<UsuarioRol> usuariosRoles;

	private Contra contra;

	public Usuario(Integer idUsuario, String apodo, String correo1, String correo2, String nombre, String apellido1,
			String apellido2, Integer edad, Date fechaNacimiento, String telefono1, String telefono2, Date fecRegistro,
			Date fecActualizacion, Integer estatus) {
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Usuario(Contra contra, String apodo, String correo1, String correo2, String nombre, String apellido1,
			String apellido2, Integer edad, Date fechaNacimiento, String telefono1, String telefono2,
			Integer estatus) {
		this.contra = contra;
		this.apodo = apodo;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.estatus = estatus;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getCorreo1() {
		return correo1;
	}

	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}

	public String getCorreo2() {
		return correo2;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
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

	public Contra getContra() {
		return contra;
	}

	public void setContra(Contra contra) {
		this.contra = contra;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apodo=" + apodo + ", correo1=" + correo1 + ", correo2=" + correo2
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento + ", telefono1=" + telefono1 + ", telefono2=" + telefono2
				+ ", fecRegistro=" + fecRegistro + ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus
				+ ", contra=" + contra + "]";
	}

}

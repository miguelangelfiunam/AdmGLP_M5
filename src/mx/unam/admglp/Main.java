package mx.unam.admglp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mx.unam.admglp.controller.ContraControllerImpl;
import mx.unam.admglp.controller.UsuarioControllerImpl;
import mx.unam.admglp.service.dto.Usuario;

public class Main { 
	
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationConfig.class);
		context.refresh();

		ContraControllerImpl contraController = (ContraControllerImpl) context.getBean("contraControllerImpl");	
		contraController.obtenerContra(1);
		
		UsuarioControllerImpl usuarioControllerImpl =  (UsuarioControllerImpl) context.getBean("usuarioControllerImpl");
		usuarioControllerImpl.obtenerUsuarios();
		
		Usuario u = new Usuario(1, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Integer nuevoEstatus = 10;
		usuarioControllerImpl.actualizarUsuarioEstatus(u, nuevoEstatus);
		
		usuarioControllerImpl.obtenerUsuario(1);
		
		/**
		 * idUsuario=1, 
		 * apodo=dani_glp, 
		 * correo1=dani@adm.com.mx, 
		 * correo2=null, 
		 * nombre=Daniel, 
		 * apellido1=Arteaga, 
		 * apellido2=Rodriguez, 
		 * edad=26, 
		 * fechaNacimiento=1995-10-05, 
		 * telefono1=5613915719, 
		 * telefono2=null, 
		 * fecRegistro=2021-12-06T23:23:16, 
		 * fecActualizacion=2022-01-06T02:24:23, 
		 * estatus=20, 
		 * contra=null
		 */
		
		context.close();
	}

}

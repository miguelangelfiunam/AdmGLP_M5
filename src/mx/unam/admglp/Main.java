package mx.unam.admglp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mx.unam.admglp.controller.ContraControllerImpl;
import mx.unam.admglp.controller.UsuarioControllerImpl;

public class Main { 
	
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationConfig.class);
		context.refresh();

		ContraControllerImpl contraController = (ContraControllerImpl) context.getBean("contraControllerImpl");	
		contraController.obtenerContra(1);
		
		UsuarioControllerImpl usuarioControllerImpl =  (UsuarioControllerImpl) context.getBean("usuarioControllerImpl");
		usuarioControllerImpl.obtenerUsuarios();
		
		usuarioControllerImpl.obtenerUsuario(1);
		context.close();
	}

}

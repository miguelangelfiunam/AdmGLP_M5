package mx.unam.admglp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

		UsuarioControllerImpl usuarioControllerImpl = (UsuarioControllerImpl) context.getBean("usuarioControllerImpl");
		usuarioControllerImpl.obtenerUsuarios();

		Usuario u = new Usuario(1, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Integer nuevoEstatus = 10;
		usuarioControllerImpl.actualizarUsuarioEstatus(u, nuevoEstatus);

		usuarioControllerImpl.obtenerUsuario(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = "1995-10-05";

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);

		Usuario u2 = new Usuario(1, "dani_glp2", "daniii@adm.com.mx", "otrocorreo@dgp.unam.mx", "Daniel", "Arteaga", "Rodriguez", 26,
				localDate, "5613915719", "5512345678");
		usuarioControllerImpl.actualizarUsuario(u2);
		usuarioControllerImpl.obtenerUsuario(1);
		
		context.close();
	}

}

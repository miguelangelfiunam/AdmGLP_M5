package mx.unam.admglp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import mx.unam.admglp.service.ContraServiceImpl;
import mx.unam.admglp.service.dto.Contra;

@Controller
public class ContraControllerImpl implements ContraController {

	private static Log log = LogFactory.getLog(ContraControllerImpl.class);

	@Autowired
	private ContraServiceImpl contraServiceImpl;

	@Value("${error.descripcion}")
	private String errorDescripcion;

	@Value("${error.busqueda}")
	private String errorBusqueda;

	@Override
	public void obtenerContra(Integer id) {
		// TODO Auto-generated method stub
		Contra c = contraServiceImpl.obtenerContra(id);
		System.out.println(c);
	}

	@Override
	public void obtenerContraPorUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		try {
			Contra c = contraServiceImpl.obtenerContraPorUsuario(idUsuario);
			System.out.println(c);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("No se obtuvo contra por usuario: " + idUsuario);
		}

	}

	@Override
	public void insertarContra(Contra contra) {
		// TODO Auto-generated method stub
		Contra c = new Contra(contra.getContraCifrado(), contra.getEstatus());
		contraServiceImpl.insertarContra(c);
	}

	@Override
	public void actualizarContra(Contra contra) {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrarContra(Contra contra) {
		// TODO Auto-generated method stub
	}

}

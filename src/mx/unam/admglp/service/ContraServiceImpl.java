package mx.unam.admglp.service;

import org.springframework.stereotype.Service;

import mx.unam.admglp.repository.ContraRepository;
import mx.unam.admglp.repository.dto.ContraDTO;
import mx.unam.admglp.service.dto.Contra;

@Service
public class ContraServiceImpl implements ContraService {

	private ContraRepository contraRepository;

	public ContraServiceImpl(ContraRepository contraRepository) {
		this.contraRepository = contraRepository;
	}

	@Override
	public Contra obtenerContra(Integer id) {
		// TODO Auto-generated method stub
		ContraDTO contraDTO = contraRepository.obtenerContra(id);
		return new Contra(contraDTO.getId(), contraDTO.getContraCifrado(), contraDTO.getFecRegistro(),
				contraDTO.getFecActualizacion(), contraDTO.getEstatus());
	}

	@Override
	public Contra obtenerContraPorUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		ContraDTO contraDTO = contraRepository.obtenerContraPorUsuario(idUsuario);
		return new Contra(contraDTO.getId(), contraDTO.getContraCifrado(), contraDTO.getFecRegistro(),
				contraDTO.getFecActualizacion(), contraDTO.getEstatus());
	}

	@Override
	public Integer insertarContra(Contra contra) {
		// TODO Auto-generated method stub
		ContraDTO c = new ContraDTO(contra.getContraCifrado(),
				contra.getEstatus());
		return contraRepository.insertarContra(c);
	}

	@Override
	public Contra actualizarContra(Contra contra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contra borrarContra(Contra contra) {
		// TODO Auto-generated method stub
		return null;
	}

}

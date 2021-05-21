package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.DTO.CargoModelDTO;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;

/**
 * 
 * Controller que interage com o API, expondo os atributos necessários do CargoModel
 * 
 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6 
 *
 */
public class CargoControllerAPI {

	CargoDAO cargoDAO = CargoDAO.getInstancia();
	
	/**
	 * Método que gera um CargoModelDTO a partir de um CargoModel buscado pelo seu respectivo ID
	 * 
	 * @param idCargo
	 * @return CargoModelDTO
	 */
	public CargoModelDTO buscarPorID(int idCargo) {
		return new CargoModelDTO(cargoDAO.buscar(CargoModel.class, idCargo));
	}
		
	/**
	 * Método que gera uma lista de CargoModelDTO com bas em todos os CargoModel
	 * 
	 * @return cargosDTO List<CargoModelDTO>
	 */
	public List<CargoModelDTO> buscarTodos(){
		List<CargoModelDTO> cargosDTO = new ArrayList<CargoModelDTO>();
		for (CargoModel cargoModel : cargoDAO.listarPorTabela(CargoModel.class)) {
			cargosDTO.add(new CargoModelDTO(cargoModel));		
		}
		return cargosDTO;		
	}	
}

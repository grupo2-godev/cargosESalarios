package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CargoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.CargoModelDTO;

/**
 * <h1>Classe responsavel pela interação com a API</h1>
 * 
 * <p>Controller que interage com a API,
 * expondo os atributos necessários do
 * {@link CargoModel}</p>
 * 
 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6 
 *
 * @see CargoModel
 */

@RestController
public class CargoControllerAPI {

	CargoDAO cargoDAO = CargoDAO.getInstancia();	
	
	/**
	 * <h1>Método que gera um CargoModelDTO.</h1> 
	 * 
	 * <p> Recebe um id de um {@link CargoModel}
	 * e busca o registro do mesmo no banco de dados.</p>
	 * 
	 * @param idCargo int - Referente ao id do {@link CargoModel}
	 * 
	 * @return {@link CargoModelDTO} - Referente ao {@link CargoModel} encontrado
	 * 
	 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
	 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6 
	 * 
	 * @see CargoModel
	 * @see CargoModelDTO
	 */
	@GetMapping("/cargos/{idCargo}")
	public CargoModelDTO buscarPorID(@PathVariable int idCargo) {
		return new CargoModelDTO(cargoDAO.buscar(CargoModel.class, idCargo));
	}
		
	/**
	 * <h1>Busca todos os {@link CargoModelDTO}</h1>
	 * 
	 * <p>Busca todos os {@link CargoModelDTO}, e
	 * coloca-los em uma lista. Retorna essa lista
	 * ao final da operação.</p>
	 * 
	 * @return List<CargoModelDTO> - Referente aos {@link CargoModelDTO}
	 * encontrados
	 * 
	 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
	 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6 
	 * 
	 * @see CargoModelDTO
	 */
	
	@GetMapping("/cargos")
	public List<CargoModelDTO> buscarTodos(){
		List<CargoModelDTO> cargosDTO = new ArrayList<CargoModelDTO>();
		for (CargoModel cargoModel : cargoDAO.listarPorTabela(CargoModel.class)) {
			cargosDTO.add(new CargoModelDTO(cargoModel));		
		}
		return cargosDTO;		
	}	
}
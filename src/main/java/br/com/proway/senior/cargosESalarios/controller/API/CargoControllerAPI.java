package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.CargoController;
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

	CargoController cargoController = new CargoController();
	
	/**
	 * <h1>Inserir um {@link CargoModel}.</h1>
	 * 
	 * <p>Recebe um {@link CargoModel} e 
	 * usa o {@link CargoController} para inserir
	 * no banco.</p>
	 * 
	 * @param cargoModel {@link CargoModel} - Referente ao
	 * {@link CargoModel} informado
	 * 
	 * @return Integer - Referente ao Id do {@link CargoModel}
	 * casdastrado
	 * 
	 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
	 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong>
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 * 
	 * @see CargoModel
	 * @see CargoController
	 */
	@PostMapping("/cargos")
	public Integer postCargo(@RequestBody CargoModel cargoModel) {
		return cargoController.cadastrarCargo(cargoModel);
	}
	
	/**
	 * <h1>Deletar {@link CargoModel}.</h1>
	 * 
	 * <p>Recebe um id delete um {@link CargoModel}
	 * usando o {@link CargoController}.</p>
	 * 
	 * @param idCargo Integer - Referente ao id informado
	 * 
	 * @return boolean - true caso de certo, false caso
	 * contrário
	 * 
	 * @throws Exception - Caso de errado
	 * 
	 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
	 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong>
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 * 
	 * @see CargoModel
	 * @see CargoController
	 */
	@DeleteMapping("/cargos/{idCargo}")
	public boolean deletarCargo(@PathVariable Integer idCargo) throws Exception {
		return cargoController.deletarCargoPorID(idCargo);
	}
	
	/**
	 * <h1>Atualiza um {@link CargoModel}.</h1>
	 * 
	 * <p>Rece um id e um {@link CargoModel}
	 * e usa o {@link CargoController} para
	 * atualizar.</p>
	 * 
	 * @param idCargo Integer - Referente ao id informado
	 * @param cargoModel {@link CargoModel} - Referente ao {@link CargoModel}
	 * informado
	 *  
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @throws Exception - Caso alguma coisa de errado
	 * 
	 * @see CargoModel
	 * @see CargoController
	 */
	@PutMapping("/cargos/{idCargo}")
	public boolean atualizarCargo(@PathVariable Integer idCargo, @RequestBody CargoModel cargoModel) throws Exception {
		return cargoController.atualizarCargo(idCargo, cargoModel);
	}
	
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
	 * @throws Exception 
	 * 
	 * @see CargoModel
	 * @see CargoModelDTO
	 */
	@GetMapping("/cargos/{idCargo}")
	public CargoModelDTO buscarPorID(@PathVariable Integer idCargo) throws Exception {
		return new CargoModelDTO(cargoController.buscarCargoPorID(idCargo));
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
		for (CargoModel cargoModel : cargoController.buscarTodosCargos()) {
			cargosDTO.add(new CargoModelDTO(cargoModel));		
		}
		return cargosDTO;		
	}	
}
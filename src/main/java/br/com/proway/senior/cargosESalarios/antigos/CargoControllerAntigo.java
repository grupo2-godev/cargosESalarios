package br.com.proway.senior.cargosESalarios.antigos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CargoModel;

/**
 * Classe CargoController
 * 
 * Implementa os m�todos do DAO para as devidas trataivas necess�rias
 * 
 * @author David Hildebrandt; david.hildebrandt@senior.com.br
 * @author Sarah Brito; sarah.brito@senior.com.br 
 */
public class CargoControllerAntigo {

	CargoDaoAl cargoDao = new CargoDaoAl();
	
	/**
	 * Cadastro Cargo
	 * 
	 * Recebe os par�metros necessarios para a criacao de um cargo
	 * as valida e envia para o dao 
	 * 
	 * @param idCargo
	 * @param nomeCargo
	 * @param dataCadastro
	 * @param dataUltimaRevisao
	 * @param cbo2002
	 * @param cbo94
	 * @param horaMes
	 * @param grauDeInstrucao
	 * @param experienciaMinima
	 * @param atribuicoes
	 * @param status
	 * @param idPermissao
	 * @return boolean
	 */
	public Integer cadastrarCargo(String nomeCargo, LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao,
			Integer cbo2002, Integer cbo94, Integer horaMes, Integer grauInstrucao,
			String experienciaMinima, String atribuicoes, Boolean status, Integer idPermissao) {
		
	
		if (cargoDao.retrieve(nomeCargo) != null) {
			return null;
		}
		else {
			CargoModel newCargo = new CargoModel(nomeCargo, dataCadastro, dataUltimaRevisao,
					cbo2002, cbo94, horaMes, grauInstrucao, experienciaMinima, atribuicoes, status,
					idPermissao);
			int idNovoCargo = cargoDao.create(newCargo);
			return idNovoCargo;
		}
	} 
	
	/**
	 * Deletar Cargo
	 * 
	 * Realiza a exclus�o do cargo conforme id de par�metro.
	 * 
	 * @param idCargo
	 * @return boolean
	 */
	public boolean deletarCargo(Integer idCargo) {
		return cargoDao.delete(idCargo);
	}
	
	/**
	 * Atualizar Cargo
	 * 
	 * M�todo realiza a atualiza��o do cargo conforme par�metros 
	 * poss�veis de altera��o. Para os demais dados, o indicado � criar
	 * um novo cargo para manter hist�rico.
	 * 
	 * @param idCargo
	 * @param novoNome
	 * @param dataUltimaRevisao
	 * @param novoStatus
	 * @param idPermissao
	 * @return boolean
	 */
	public boolean atualizarCargo(Integer idCargo, String novoNome, LocalDateTime dataUltimaRevisao, 
			boolean novoStatus, Integer idPermissao) {
		CargoModel cargo = cargoDao.retrieve(idCargo);
		cargo.setNomeCargo(novoNome);
		cargo.setDataUltimaRevisao(dataUltimaRevisao);
		cargo.setStatus(novoStatus);
		cargo.setIdPermissao(idPermissao);
		return cargoDao.update(cargo);
	}
	
	/**
	 * Buscar cargo por ID
	 * 
	 * Realiza a busca do cargo conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param idCargo
	 * @return CargoModel
	 */
	public CargoModel buscarCargoId(Integer idCargo) {
		return cargoDao.retrieve(idCargo);
	}
	
	/**
	 * Buscar cargo por nome
	 * 
	 * Realiza a busca do cargo conforme nome informado
	 * e retorna o objeto do mesmo.
	 * 
	 * @param nomeCargo
	 * @return CargoModel
	 */
	public CargoModel buscarCargoNome(String nomeCargo) {
		return cargoDao.retrieve(nomeCargo);
	}
	
	/**
	 * Busca todos os cargos
	 *  
	 * @return ArrayList
	 */
	public ArrayList<CargoModel> buscarTodosCargos() {
		return cargoDao.getAll();
		
	}
	
}

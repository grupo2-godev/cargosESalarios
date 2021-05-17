package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.PostoDeTrabalhoDAO;
import utils.Validators;

/**
 * Classe PostoDeTrabalhoController
 * 
 * Implementa os metodos do DAO para as devidas trataivas necess�rias
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class PostoDeTrabalhoController {
	
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstance(
		ConnectionHibernate.getSession()
	);
	
	/**
	 * Cadastro Posto de Trabalho
	 * 
	 * Recebe os parametros necessarios para a criacao de um posto de
	 * trabalho, as valida e envia para o DAO.
	 * @param nomePosto
	 * @param idCargo
	 * @param idSetor
	 * @param idNivel
	 * @param salario
	 * @return null ou idNovoPosto
	 * @throws Exception 
	 */
	public Integer cadastrarPostoDeTrabalho(String nomePosto, Integer idCargo, Integer idSetor, Integer idNivel, Double salario) throws Exception {		
		if (!Validators.onlyValidChars(nomePosto)) {
			throw new Exception("Nome invalido para Posto de Trabalho!!!");
		}

		else {
			PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
			int idRegistrado = this.postoDAO.create(novoPosto);
			return idRegistrado;
		}
	}
	
	/**
	 * Deletar Posto de Trabalho
	 * 
	 * Realiza a exclusao do posto de trabalho conforme id de par�metro.
	 * 
	 * @param idPosto
	 * @return boolean
	 */
	public boolean deletarPostoDeTrabalho(Integer idPosto) {
		return this.postoDAO.delete(idPosto);
	}
	
	/**
	 * Atualizar Posto de Trabalho
	 * 
	 * M�todo realiza a atualiza��o do posto de trabalho conforme par�metros.
	 * 
	 * @param idPosto
	 * @param novoNome
	 * @param novaIdCargo
	 * @param novaIdSetor
	 * @param novoIdNivel
	 * @param novoSalario
	 * @return boolean
	 */
	public boolean atualizarPostoDeTrabalho(Integer idPosto, String novoNome, Integer novaIdCargo, Integer novaIdSetor,
			Integer novoIdNivel, Double novoSalario) {
		PostoDeTrabalhoModel posto = this.postoDAO.retrieve(idPosto);
		if (Validators.onlyValidChars(novoNome)) {
			posto.setNomePosto(novoNome);
		}
		posto.setIdCargo(novaIdCargo);
		posto.setIdSetor(novaIdSetor);
		posto.setIdNivel(novoIdNivel);
		posto.setSalario(novoSalario);
		return this.postoDAO.update(idPosto, posto);
	}
	
	/**
	 * Buscar posto de trabalho por ID
	 * 
	 * Realiza a busca do posto de trabalho conforme Id informada
	 * e retorna o objeto da mesma.
	 * 
	 * @param idPosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel buscarPostoDeTrabalhoId(Integer idPosto) {
		return this.postoDAO.retrieve(idPosto);
	}
	
	/**
	 * Buscar posto de trabalho por nome
	 * 
	 * Realiza a busca do posto de trabalho conforme nome informado
	 * e retorna o objeto do mesmo.
	 * 
	 * @param nomePosto
	 * @return PostoDeTrabalhoModel
	 */
	public ArrayList<PostoDeTrabalhoModel> buscarPostoDeTrabalhoNome(String nomePosto) {
		return this.postoDAO.retrieveByName(nomePosto);
	}
	
	/**
	 * Buscar todos os postos de trabalho cadastrados.
	 *  
	 * @return ArrayList
	 */
	public ArrayList<PostoDeTrabalhoModel> buscarTodosPostosDeTrabalho() {
		return this.postoDAO.getAll();
		
	}

}

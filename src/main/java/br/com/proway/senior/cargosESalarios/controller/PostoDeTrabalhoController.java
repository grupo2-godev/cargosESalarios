package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoDaoAl;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;

/**
 * Classe PostoDeTrabalhoController
 * 
 * Implementa os m�todos do DAO para as devidas trataivas necess�rias
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br 
 */
public class PostoDeTrabalhoController {
	
	PostoDeTrabalhoDaoAl daoPosto = new PostoDeTrabalhoDaoAl();
	
	/**
	 * Cadastro Posto de Trabalho
	 * 
	 * Recebe os par�metros necessarios para a criacao de um posto de
	 * trabalho, as valida e envia para o DAO.
	 * @param nomePosto
	 * @param idCargo
	 * @param idSetor
	 * @param idNivel
	 * @param salario
	 * @return null ou idNovoPosto
	 */
	public Integer cadastrarPostoDeTrabalho(String nomePosto, Integer idCargo, Integer idSetor, Integer idNivel, Double salario) {		
		if (daoPosto.retrieve(nomePosto) != null) {
			return null;
		}
		else {
			PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
			int idNovoPosto = daoPosto.create(novoPosto);
			return idNovoPosto;
		}
	}
	
	/**
	 * Deletar Posto de Trabalho
	 * 
	 * Realiza a exclus�o do posto de trabalho conforme id de par�metro.
	 * 
	 * @param idPosto
	 * @return boolean
	 */
	public boolean deletarPostoDeTrabalho(Integer idPosto) {
		return daoPosto.delete(idPosto);
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
		PostoDeTrabalhoModel posto = daoPosto.retrieve(idPosto);
		posto.setNomePosto(novoNome);
		posto.setIdCargo(novaIdCargo);
		posto.setIdSetor(novaIdSetor);
		posto.setIdNivel(novoIdNivel);
		posto.setSalario(novoSalario);
		return daoPosto.update(posto);
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
		return daoPosto.retrieve(idPosto);
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
	public PostoDeTrabalhoModel buscarPostoDeTrabalhoNome(String nomePosto) {
		return daoPosto.retrieve(nomePosto);
	}
	
	/**
	 * Buscar todos os postos de trabalho cadastrados.
	 *  
	 * @return ArrayList
	 */
	public ArrayList<PostoDeTrabalhoModel> buscarTodosPostosDeTrabalho() {
		return daoPosto.getAll();
		
	}

}
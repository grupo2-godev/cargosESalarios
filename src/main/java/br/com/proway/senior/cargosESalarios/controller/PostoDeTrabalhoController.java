package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.PostoDeTrabalhoDAO;
import utils.Validators;

/**
 * Classe PostoDeTrabalhoController
 * 
 * Implementa os metodos do DAO para as devidas trataivas necessarias
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class PostoDeTrabalhoController {
	
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstance(
		ConexaoHibernate.getSessao()
	);
	
	/**
	 * Cadastro Posto de Trabalho
	 * 
	 * Recebe os parametros necessarios para a criacao de um posto de
	 * trabalho, as valida e envia para o DAO.
	 * @param nomePosto
	 * @param cargo
	 * @param setor
	 * @param nivel
	 * @param salario
	 * @return null ou idNovoPosto
	 * @throws Exception 
	 */
	public Integer cadastrarPostoDeTrabalho(String nomePosto, CargoModel cargo, SetorModel setor, NivelModel nivel, Double salario) throws Exception {		
		if (!Validators.onlyValidChars(nomePosto)) {
			throw new Exception("Nome invalido para Posto de Trabalho!!!");
		}

		else {
			PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(nomePosto, cargo, setor, nivel, salario);
			return this.postoDAO.criar(novoPosto);
		}
	}
	
	/**
	 * Deletar Posto de Trabalho
	 * 
	 * Realiza a exclusao do posto de trabalho conforme id de parametro.
	 * 
	 * @param idPosto
	 * @return boolean
	 */
	public boolean deletarPostoDeTrabalho(Integer idPosto) {
		return this.postoDAO.deletar(idPosto);
	}
	
	/**
	 * Atualizar Posto de Trabalho
	 * 
	 * Metodo realiza a atualizacao do posto de trabalho conforme parametros.
	 * 
	 * @param idPosto
	 * @param novoNome
	 * @param novoCargo
	 * @param novoSetor
	 * @param novoNivel
	 * @param novoSalario
	 * @return boolean
	 */
	public boolean atualizarPostoDeTrabalho(Integer idPosto, String novoNome, CargoModel novoCargo, SetorModel novoSetor,
			NivelModel novoNivel, Double novoSalario) {
		PostoDeTrabalhoModel posto = this.postoDAO.buscar(idPosto);
		if (Validators.onlyValidChars(novoNome)) {
			posto.setNomePosto(novoNome);
		}
		posto.setCargo(novoCargo);
		posto.setSetor(novoSetor);
		posto.setNivel(novoNivel);
		posto.setSalario(novoSalario);
		return this.postoDAO.atualizar(idPosto, posto);
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
		return this.postoDAO.buscar(idPosto);
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
		return this.postoDAO.buscarTodos();
		
	}
	
	/**
	 * Deleta todos os registros
	 */
	public boolean deletarTodosPostosDeTrabalho() {
		return this.postoDAO.deletarTodos();
	}
}

package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

/**
 * Classe SetorController
 * 
 * Faz contato com a classe DAO, faz as devidas tratativas com entrada e saida
 * de dados.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */

public class SetorController {

	SetorDAO setorDAO = new SetorDAO();

	/**
	 * Cadastra na tabela setor um objeto do tipo {@link CargoModel}.
	 * 
	 * Verifica se ja existe um setor com o mesmo nome, se nao existir, registra o
	 * objeto. Se ja existir um setor com o mesmo nome, retorna nulo.
	 * 
	 * @param nomeSetor String Nome do setor.
	 * @param idPermissao int Id da permissao.
	 * @return Integer/null id do setor se foi possivel ser criado
	 */
	public Integer cadastrarSetor(String nomeSetor, Integer idPermissao) {
		if (setorDAO.retrieve(nomeSetor).toString().isEmpty()) {
			return null;
		} else {
			SetorModel newSetor = new SetorModel(nomeSetor, idPermissao);
			int quantidadeRegistros = setorDAO.create(newSetor);
			return quantidadeRegistros;
		}
	}

	/**
	 * Deleta um setor
	 * 
	 * Envia o id do setor para o dao deletar
	 * 
	 * @param idSetor
	 * @return boolean
	 */
	public boolean deletarSetor(Integer idSetor) {
		return setorDAO.delete(idSetor);
	}

	/**
	 * Atualizar Setor
	 * 
	 * M�todo realiza a atualiza��o do setor
	 * 
	 * @param idSetor
	 * @param novoNome
	 * @return boolean
	 */
	public boolean atualizarSetor(Integer idSetor, String novoNome, Integer IdPermissao) {
		SetorModel setor = setorDAO.retrieve(idSetor);
		setor.setNomeSetor(novoNome);
		setor.setIdPermissao(IdPermissao);
		return setorDAO.update(idSetor, setor);
	}

	/**
	 * M�todo buscarTodosSetores
	 * 
	 * M�todo realiza a busca de todos os setores cadastrados e retorna em um
	 * ArrayList.
	 * 
	 * @return ArrayList<SetorModel>
	 */
	public ArrayList<SetorModel> buscarTodosSetores() {
		return setorDAO.getAll();
	}

	/**
	 * Buscar setor por ID
	 * 
	 * Realiza a busca do setor conforme Id informada e retorna o objeto do mesmo.
	 * 
	 * @param idSetor
	 * @return SetorModel
	 */
	public SetorModel buscarSetor(Integer idSetor) {
		return setorDAO.retrieve(idSetor);
	}

	/**
	 * Buscar setor por ID
	 * 
	 * Realiza a busca do setor conforme Id informada e retorna o objeto do mesmo.
	 * 
	 * @param idSetor
	 * @return SetorModel
	 */
	public SetorModel buscarSetor(String nomeSetor) {
		return setorDAO.retrieve(nomeSetor);
	}

}

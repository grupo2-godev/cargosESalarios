package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

/**
 * Classe SetorController
 * 
 * Implementa os m�todos do DAO para as devidas trataivas necess�rias
 *  
 * @author Sprint 4
 *
 */

public class SetorController {

	SetorDAO setorSQL = new SetorDAO();
	
	/**
	 * Cadastra um novo setor
	 * 
	 * Verifica se j� existe um setor com o mesmo nome
	 * e se n�o exister cria o setor e envia para o SetorDaoAl
	 * 
	 * @param nomeSetor
	 * @return Integer/null id do setor se foi possivel ser criado
	 */
	public Integer cadastrarSetor(String nomeSetor, Integer idPermissao) {
		if (setorSQL.retrieve(nomeSetor).toString().isEmpty()) {
			return null;
		}
		else {
		SetorModel newSetor = new SetorModel(nomeSetor, idPermissao);
		int quantidadeRegistros = setorSQL.create(newSetor);
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
		return setorSQL.delete(idSetor);
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
		SetorModel setor = setorSQL.retrieve(idSetor);
		setor.setNomeSetor(novoNome);
		setor.setIdPermissao(IdPermissao);
		return setorSQL.update(idSetor, setor);
	}
	
	
	/**
	 * M�todo buscarTodosSetores
	 * 
	 * M�todo realiza a busca de todos os setores cadastrados
	 * e retorna em um ArrayList.
	 * 
	 * @return ArrayList<SetorModel>
	 */
	public ArrayList<SetorModel> buscarTodosSetores(){
		return setorSQL.getAll();
	}
	
	/**
	 * Buscar setor por ID
	 * 
	 * Realiza a busca do setor conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param idSetor
	 * @return SetorModel
	 */
	public SetorModel buscarSetor(Integer idSetor) {
		return setorSQL.retrieve(idSetor);
	}
	
	/**
	 * Buscar setor por ID
	 * 
	 * Realiza a busca do setor conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param idSetor
	 * @return SetorModel
	 */
	public SetorModel buscarSetor(String nomeSetor) {
		return setorSQL.retrieve(nomeSetor);
	}
	
}

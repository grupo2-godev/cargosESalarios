package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

public class SetorController {

	SetorDaoAl dao = new SetorDaoAl();
	
	/**
	 * Cadastra um novo setor
	 * 
	 * Verifica se já existe um setor com o mesmo nome
	 * e se não exister cria o setor e envia para o SetorDaoAl
	 * 
	 * @param nome
	 * @return Integer/null id do setor se foi possivel ser criado
	 */
	public Integer cadastrarSetor(String nome, Integer permissao) {
		for (SetorModel setor : dao.getAll()) {
			if(setor.getNomeSetor() == nome) {
				return null;
			}
		}
		SetorModel newSetor = new SetorModel(nome, permissao);
		return dao.create(newSetor);
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
		return dao.delete(idSetor);
	}
	
	/**
	 * Atualizar Setor
	 * 
	 * Método realiza a atualização do setor
	 *  
	 * @param idSetor
	 * @param novoNome
	 * @return boolean
	 */
	public boolean atualizarSetor(Integer idSetor, String novoNome, Integer permissao) {
		SetorModel setor = dao.retrieve(idSetor);
		setor.setNomeSetor(novoNome);
		setor.setIdPermissao(permissao);
		return dao.update(setor);
	}
	
	public ArrayList<SetorModel> buscarTodosSetores(){
		return dao.getAll();
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
		return dao.retrieve(idSetor);
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
		return dao.retrieve(nomeSetor);
	}
	
}

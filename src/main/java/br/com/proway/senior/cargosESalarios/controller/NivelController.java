package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.NivelDao;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelController {

	NivelDao dao = new NivelDao();
	
	/**
	 * Cadastra um novo nível
	 * 
	 * Verifica se já existe um nível com o mesmo nome
	 * e se não exister cria o nivel e envia para o NivelDao
	 * 
	 * @param nome
	 * @return Integer/null id do usuário se foi possivel ser criado
	 */
	public Integer cadastrarNivel(String nome) {
		for (NivelModel nivel : dao.getAll()) {
			if(nivel.getNomeNivel() == nome) {
				return null;
			}
		}
		NivelModel newNivel = new NivelModel(nome);
		return dao.create(newNivel);
	}
	
	/**
	 * Deleta um nivel
	 * 
	 * Envia o id do nivel para o dao deletar 
	 * 
	 * @param idCargo
	 * @return boolean
	 */
	public boolean deletarNivel(Integer idNivel) {
		return dao.delete(idNivel);
	}
	
	/**
	 * Atualizar Nivel
	 * 
	 * Método realiza a atualização do nivel
	 *  
	 * @param idNivel
	 * @param novoNome
	 * @return boolean
	 */
	public boolean atualizarNivel(Integer idNivel, String novoNome) {
		NivelModel nivel = dao.retrieve(idNivel);
		nivel.setNomeNivel(novoNome);
		return dao.update(nivel);
	}
	
	public ArrayList<NivelModel> buscarTodosNiveis(){
		return dao.getAll();
	}
	
	/**
	 * Buscar nivel por ID
	 * 
	 * Realiza a busca do nivel conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param idNivel
	 * @return NivelModel
	 */
	public NivelModel buscarNivelId(Integer idNivel) {
		return dao.retrieve(idNivel);
	}
	
}

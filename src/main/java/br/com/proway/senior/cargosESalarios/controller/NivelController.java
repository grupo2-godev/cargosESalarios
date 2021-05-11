package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.NivelDaoSQL;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelController {

	NivelDaoSQL dao = new NivelDaoSQL();
	
	/**
	 * Cadastra um novo n�vel
	 * 
	 * Verifica se j� existe um n�vel com o mesmo nome
	 * e se n�o exister cria o nivel e envia para o NivelDaoSQL
	 * 
	 * @param nome
	 * @return Integer/null id do usu�rio se foi possivel ser criado
	 */
	public Integer cadastrarNivel(String nome) {
		for (NivelModel nivel : dao.getAll()) {
			if(nivel.getNome() == nome) {
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
	 * M�todo realiza a atualiza��o do nivel
	 *  
	 * @param idNivel
	 * @param novoNome
	 * @return boolean
	 */
	public boolean atualizarNivel(Integer idNivel, String novoNome) {
		NivelModel nivel = dao.retrieve(idNivel);
		nivel.setNome(novoNome);
		return dao.update((int) idNivel , nivel);
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

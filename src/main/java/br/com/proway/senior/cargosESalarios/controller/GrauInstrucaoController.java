package br.com.proway.senior.cargosESalarios.controller;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoDao;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class GrauInstrucaoController {

	GrauInstrucaoDao dao = new GrauInstrucaoDao();
	
	/**
	 * Cadastra um novo grau de instrucao
	 * 
	 * Verifica se já existe um nível com o mesmo nome
	 * e se não exister cria o grau de instrucao e envia para o GrauInstucaoDao
	 * 
	 * @param nome
	 * @return Integer/null id do GrauInstrucao se foi possivel ser criado
	 */
	public Integer cadastrarGrauInstrucao(String nome) {
		for (GrauInstrucaoModel gi : dao.getAll()) {
			if(gi.getInstrucao() == nome) {
				return null;
			}
		}
		GrauInstrucaoModel newGI = new GrauInstrucaoModel(nome);
		return dao.create(newGI);
	}
	
	/**
	 * Deleta um grauInstrucao
	 * 
	 * Envia o id do grauInstrucao para o dao deletar 
	 * 
	 * @param idGrauInstrucao
	 * @return boolean
	 */
	public boolean deletarGrauInstrucao(Integer idGrauInstrucao) {
		return dao.delete(idGrauInstrucao);
	}
	
	/**
	 * Atualizar GrauInstrucao
	 * 
	 * Método realiza a atualização do GrauInstrucao
	 *  
	 * @param idGrauInstrucao
	 * @param novoNome
	 * @return boolean
	 */
	public boolean atualizarGrauInstrucao(Integer idInstrucao, String novoNome) {
		GrauInstrucaoModel gi = dao.retrieve(idInstrucao);
		gi.setInstrucao(novoNome);
		return dao.update(gi);
	}
	
	/**
	 * Buscar grauInstrucao por ID
	 * 
	 * Realiza a busca do grauInstrucao conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param idGrauInstrucao
	 * @return GrauInstrucaoModel
	 */
	public GrauInstrucaoModel buscarGrauInstrucao(Integer idInstrucao) {
		return dao.retrieve(idInstrucao);
	}
	
	/**
	 * Buscar grauInstrucao por nome
	 * 
	 * Realiza a busca do grauInstrucao conforme nome informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param nomeGI
	 * @return GrauInstrucaoModel
	 */
	public GrauInstrucaoModel buscarGrauInstrucao(String nomeGI) {
		return dao.retrieve(nomeGI);
	}
	
}
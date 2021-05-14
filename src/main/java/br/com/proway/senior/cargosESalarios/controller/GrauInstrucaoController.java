package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.GrauInstrucaoDAO;
import utils.Validators;

/**
 * Controller que interage com o GrauIntrucaoDAO.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoController {

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstance(ConnectionHibernate.getSession());

	/**
	 * Cadastra um objeto do tipo {@link GrauInstrucaoModel} no banco de dados.
	 * 
	 * Valida o grauInstrucao e insere o registro no banco de dados.
	 * 
	 * @param grauInstrucao String Descricao do grau de instrucao.
	 * @return Integer/Exception Retorna o id do objeto caso ele seja cadastrado com
	 *         sucesso. Caso a validacao retorne false, retorna Exception.
	 * @throws Exception 
	 */
	public Integer cadastrar(String grauInstrucao) throws Exception {
		if(!Validators.onlyValidChars(grauInstrucao)) {
			throw(new Exception("O grau de instrução possui caracteres inválidos."));
		}
		GrauInstrucaoModel grauInstrucaoModel = new GrauInstrucaoModel();
		grauInstrucaoModel.setNome(grauInstrucao);
		return grauInstrucaoDAO.create(grauInstrucaoModel);
	}
	
	/**
	 * Retorna um ArrayList com todos os registros da tabela.
	 * @return ArrayList<GrauInstrucaoModel> Lista de objetos do tipo {@link GrauInstrucaoModel}
	 */
	public ArrayList<GrauInstrucaoModel> buscarTodos() {
		return grauInstrucaoDAO.getAll();
	}
	
	/**
	 * Deleta todos os registros da tabela.
	 * @return boolean Retorna false caso a validacao apos o comando de deletarTodos retorne algum registro da tabela. Caso contrario, retorna true.
	 */
	public boolean deletarTodos() {
		grauInstrucaoDAO.deleteAll();
		if(this.buscarTodos().size() > 0) {
			return false;
		}
		return true;
	}

}
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
		if (!Validators.onlyValidChars(grauInstrucao)) {
			throw (new Exception("O grau de instrução possui caracteres inválidos."));
		}
		GrauInstrucaoModel grauInstrucaoModel = new GrauInstrucaoModel();
		grauInstrucaoModel.setNome(grauInstrucao);
		return grauInstrucaoDAO.create(grauInstrucaoModel);
	}

	/**
	 * Retorna objeto do tipo {@link GrauInstrucaoModel} que contenha o id igual ao
	 * id recebido no parametro.
	 * 
	 * Verifica se o id eh valido, nao pode ser nulo ou igual a zero.
	 * 
	 * @param id Integer Id do objeto a ser consultado.
	 * @return GrauInstrucaoModel Objeto encontrado no banco de dados.
	 * @throws Exception
	 */
	public GrauInstrucaoModel buscarPorId(Integer id) throws Exception {
		if (id == null || id == 0) {
			throw (new Exception("O Id não pode ser nulo ou zero."));
		}
		return grauInstrucaoDAO.retrieve(id);
	}

	/**
	 * Retorna ArrayList de objetos do tipo {@link GrauInstrucaoModel} que possuam a
	 * palavra recebida no parametro na coluna instrucao.
	 * 
	 * Verifica se a palavra nao contem caracteres especias antes de consultar no
	 * banco de dados.
	 * 
	 * @param nome String Palavra a ser consultada.
	 * @return ArrayList<GrauInstrucaoModel> Lista de objetos encontrados.
	 * @throws Exception
	 */
	public ArrayList<GrauInstrucaoModel> buscarPorNomeQueContenha(String nome) throws Exception {
		if (!Validators.onlyValidChars(nome)) {
			throw (new Exception("A palavra de consulta não pode ter caracteres especiais."));
		}
		return grauInstrucaoDAO.retrieveNameCountains(nome);
	}

	/**
	 * Retorna um ArrayList com todos os registros da tabela.
	 * 
	 * @return ArrayList<GrauInstrucaoModel> Lista de objetos do tipo
	 *         {@link GrauInstrucaoModel}
	 */
	public ArrayList<GrauInstrucaoModel> buscarTodos() {
		return grauInstrucaoDAO.getAll();
	}

	/**
	 * Deleta todos os registros da tabela.
	 */
	public void deletarTodos() {
		grauInstrucaoDAO.deleteAll();
	}

}
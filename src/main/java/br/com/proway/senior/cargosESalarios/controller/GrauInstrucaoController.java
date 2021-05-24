package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DAO.GrauInstrucaoDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Controller que interage com o GrauIntrucaoDAO.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoController {

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstancia();

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
		if (!Validadores.apenasCaracteresValidos(grauInstrucao)) {
			throw (new Exception("O grau de instrução possui caracteres inválidos."));
		}
		GrauInstrucaoModel grauInstrucaoModel = new GrauInstrucaoModel();
		grauInstrucaoModel.setNome(grauInstrucao);
		return grauInstrucaoDAO.criar(grauInstrucaoModel);
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
		if (Validadores.ehZeroOuNulo(id)) {
			throw (new Exception("O Id não pode ser nulo ou zero."));
		}
		return grauInstrucaoDAO.buscar(GrauInstrucaoModel.class, id);
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
		if (!Validadores.apenasCaracteresValidos(nome)) {
			throw (new Exception("A palavra de consulta não pode ter caracteres especiais."));
		}
		return (ArrayList<GrauInstrucaoModel>) grauInstrucaoDAO.listarPorValorDeColunaComStringIncompleta(GrauInstrucaoModel.class, "instrucao", nome);
	}

	/**
	 * Altera o objeto no banco de dados que possui o id recebido no parametro.
	 * 
	 * Verifica se existe no banco de dados um objeto com o id informado e verifica
	 * tambem se o objeto recebido no parametro nao eh nulo. Localizando o objeto no
	 * banco, efetua a alteracao para o objeto recebido no parametro.
	 * 
	 * @param idObjetoASerAlterado Integer Id do objeto a ser alterado.
	 * @param novoObjeto           GrauInstrucaoModel Objeto que possui as
	 *                             alteracoes que substituirao o objeto do banco de
	 *                             dados.
	 * @return boolean Retorna true caso nao encontre nenhum erro durante a
	 *         verificacao, inclusive a busca pelo objeto no banco de dados pelo id.
	 * @throws Exception
	 */
	public boolean atualizar(Integer idObjetoASerAlterado, String novaInstrucao) throws Exception {
		if (!Validadores.apenasCaracteresValidos(novaInstrucao)) {
			throw (new Exception("Instrucao invalida para atualizacao do Grau de Instrucao"));
		}
		
		GrauInstrucaoModel objetoParaAtualizar = grauInstrucaoDAO.buscar(GrauInstrucaoModel.class, idObjetoASerAlterado);
		
		if (Validadores.ehObjetoNulo(objetoParaAtualizar)) {
			throw (new Exception("O objeto não existe no banco de dados."));
		}
		
		if(objetoParaAtualizar.getNome() == novaInstrucao) {
			return false;
		}

		objetoParaAtualizar.setId(idObjetoASerAlterado);
		objetoParaAtualizar.setNome(novaInstrucao);
		
		grauInstrucaoDAO.atualizar(objetoParaAtualizar);
		return true;
	}
	

	/**
	 * Deleta um registro do banco de dados que corresponde ao id recebido no
	 * parametro.
	 * 
	 * Verifica se o id eh valido (diferente de zero, diferente de nulo). Verifica
	 * se existe um objeto no banco de dados com o id recebido no parametro.
	 * 
	 * @param id Integer Id do objeto a ser deletado.
	 * @return boolean Retorna true caso o objeto seja localizado no banco de dados.
	 *         Retorna false caso o id seja invalido conforme validacao.
	 * @throws Exception
	 */
	public boolean deletarPorId(Integer id) throws Exception {
		if (Validadores.ehZeroOuNulo(id)) {
			throw (new Exception("O id não pode ser nulo ou igual a zero."));
		}
		if (Validadores.ehObjetoNulo(this.buscarPorId(id))) {
			throw (new Exception("O objeto não existe no banco de dados."));
		}
		grauInstrucaoDAO.deletar(GrauInstrucaoModel.class, id);
		return true;
	}

	/**
	 * Retorna um ArrayList com todos os registros da tabela.
	 * 
	 * @return ArrayList<GrauInstrucaoModel> Lista de objetos do tipo
	 *         {@link GrauInstrucaoModel}
	 */
	public ArrayList<GrauInstrucaoModel> buscarTodos() {
		return (ArrayList<GrauInstrucaoModel>) grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class);
	}

	/**
	 * Deleta todos os registros da tabela {@link GrauInstrucaoModel}.
	 */
	public void deletarTodos() {
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
	}

}
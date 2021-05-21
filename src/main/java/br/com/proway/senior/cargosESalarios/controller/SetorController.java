package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.SetorDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

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

	SetorDAO setorDAO = SetorDAO.getInstancia();

	/**
	 * Cadastra na tabela setor um objeto do tipo {@link SetorModel}.
	 * 
	 * Verifica se ja existe um setor com o mesmo nome, se nao existir, registra o
	 * objeto. Se ja existir um setor com o mesmo nome, retorna nulo.
	 * 
	 * @param nomeSetor   String nome do setor.
	 * @param idPermissao int Id da permissao.
	 * @return Integer|null id do setor se foi possivel ser criado.
	 */
	public Integer cadastrarSetor(String nomeSetor, Integer idPermissao) {
		ArrayList<SetorModel> setoresConsultados = (ArrayList<SetorModel>) setorDAO.listarPorValorDeColunaComStringIncompleta(SetorModel.class, "nomeSetor", nomeSetor);
		for (SetorModel setorModel : setoresConsultados) {
			if (setorModel.getNomeSetor().equals(nomeSetor)) {
				System.out.println("Setor informado já cadastrado.");
				return null;
			}
		}

		SetorModel novoSetor = new SetorModel(nomeSetor, idPermissao);
		int idCadastrado = setorDAO.criar(novoSetor);
		return idCadastrado;
	}

	/**
	 * Buscar setor por ID.
	 * 
	 * Realiza a busca do setor conforme Id informada e retorna o objeto do mesmo.
	 * 
	 * @param Integer idSetor Identificacao do setor procurado.
	 * @return SetorModel objeto localizado ou null caso nao conste no banco.
	 */
	public SetorModel buscarSetorPorId(Integer idSetor) {
		return setorDAO.buscar(SetorModel.class, idSetor);
	}

	/**
	 * Buscar setor por nome.
	 * 
	 * Realiza a busca do setor conforme nome informado e retorna a lista de
	 * objetos. O texto pode ser informado parcial, pois ira buscar no banco todos
	 * os registros que possuem os caracteres informados.
	 * 
	 * @param idSetor a ser procurado.
	 * @return rrayList SetorModel lista de registros localizados.
	 */
	public ArrayList<SetorModel> buscarSetorPorNome(String nomeSetor) {
		return (ArrayList<SetorModel>) setorDAO.listarPorValorDeColunaComStringIncompleta(SetorModel.class, "nomeSetor",nomeSetor);
	}

	/**
	 * Atualizar setor.
	 * 
	 * Metodo realiza a atualizacao do setor conforme modificacoes informadas via
	 * parametros.
	 * 
	 * @param idSetor  a ser alterado
	 * @param novoNome
	 * @paramar novaIdPermissão
	 * @return boolean
	 * @throws Exception
	 */
	public boolean atualizarSetor(Integer idSetor, String novoNome, Integer novaIdPermissao) throws Exception {
		SetorModel setorRecuperado = setorDAO.buscar(SetorModel.class, idSetor);
		if (Validadores.ehObjetoNulo(setorRecuperado)) {
			throw new Exception("O setor informado não consta na base de dados, informe um valor válido.");
		}
		setorRecuperado.setNomeSetor(novoNome);
		setorRecuperado.setIdPermissao(novaIdPermissao);
		return setorDAO.atualizar(idSetor, setorRecuperado);
	}

	/**
	 * Deleta um setor.
	 * 
	 * Envia o id do setor para o dao deletar
	 * 
	 * @param Integer idSetor Identificacao do setor que sera deletado.
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deletarSetor(Integer idSetor) throws Exception {
		if (Validadores.ehObjetoNulo(setorDAO.buscar(SetorModel.class, idSetor))) {
			throw new Exception("O setor informado não consta na base de dados, informe um valor válido.");
		}
		return setorDAO.deletar(SetorModel.class, idSetor);
	}

	/**
	 * Buscar todos os setores.
	 * 
	 * Realiza a busca de todos os setores cadastrados e retorna em um ArrayList.
	 * 
	 * @return ArrayList SetorModel lista de todos os setores cadastrados.
	 */
	public ArrayList<SetorModel> buscarTodosSetores() {
		return (ArrayList<SetorModel>) setorDAO.listarPorTabela(SetorModel.class);
	}

	/**
	 * Deletar todos os setores.
	 * 
	 * Realiza a exclusao no banco de dados de todos os registros de setores
	 * cadastrados.
	 */
	public void deletarTodosSetores() {
		setorDAO.deletarTodos("setor");
	}

}

package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.DAO.CBO2002DAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Classe CBO2002Controller
 * 
 * Faz contato com a classe DAO {@link CBO2002DAO} e realiza as devidas
 * tratativas com entrada e saida de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class CBO2002Controller {

	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstancia();
	
	private static CBO2002Controller cbo2002Controller;
	
	private CBO2002Controller() {
		
	}
	
	public static CBO2002Controller getInstancia() {
		if(cbo2002Controller == null) {
			cbo2002Controller = new CBO2002Controller();
		}
		return cbo2002Controller;
	}

	/**
	 * Cadastrar na banco de dados um CBO 2002.
	 * 
	 * Verifica se ja existe um CBO 2002 com o mesmo codigo, se nao existir,
	 * registra o objeto. Se ja existir um CBO 2002 com o mesmo codigo, retorna
	 * nulo. Valida tambem a quantidade de caracteres do codigoCBO, visto que o
	 * padrao e 6.
	 * 
	 * @param Integer        codigoCBO codigo do CBO 2002 que sera cadastrado.
	 * @param String         descricao descricao | nome do CBO 2002 que sera
	 *                       cadastrado.
	 * @param Insalubridade  percentualInsalubridade.
	 * @param Periculosidade percentualPericulosidade.
	 * @return Integer codigoCBO codigo do CBO 2002 cadastrado.
	 * @throws Exception.
	 */
	public Integer cadastrarCBO2002(Integer codigoCBO, String descricao, Insalubridade percentualInsalubridade,
			Periculosidade percentualPericulosidade) throws Exception {
		if (Validadores.ehValidoCBO2002(codigoCBO) == false) {
			throw new Exception("Código de CBO 2002 informado inválido.");
		}
		if (!Validadores.ehObjetoNulo(cbo2002DAO.buscar(CBO2002Model.class, codigoCBO))) {
			throw new Exception("Código de CBO 2002 informado já cadastrado.");
		}
		if (!Validadores.apenasCaracteresValidos(descricao)) {
			throw new Exception("A descrição deve conter apenas caracteres válidos.");
		}
		CBO2002Model novoCBO2002 = new CBO2002Model(codigoCBO, descricao, percentualInsalubridade.getValor(),
				percentualPericulosidade.getValor());
		cbo2002DAO.criar(novoCBO2002);
		return codigoCBO;
	}

	/**
	 * Buscar CBO 2002 por codigo.
	 * 
	 * Realiza a busca do CBO 2002 conforme codigo informado e retorna o objeto do
	 * mesmo.
	 * 
	 * @param Integer codigoCBO Identificacao do CBO 2002 procurado.
	 * @return CBO2002Model objeto localizado ou null caso nao conste no banco.
	 */

	public CBO2002Model buscarCBO2002PorCodigo(Integer codigoCBO) {
		return cbo2002DAO.buscar(CBO2002Model.class, codigoCBO);
	}

	/**
	 * Buscar CBO 2002 por descricao.
	 * 
	 * Realiza a busca do CBO 2002 conforme nome informado e retorna a lista de
	 * objetos CBO2002Model localizados. O texto pode ser parcial, pois ira buscar
	 * no banco todos os registros que contenham o texto informado.
	 * 
	 * @param descricaoCBO2002 descricao | nome parcial do CBO 2002 que esta sendo
	 *                         procurado.
	 * @return ArrayList CBO2002Model lista de CBO 2002 localizados.
	 */
	public ArrayList<CBO2002Model> buscarCBO2002PorDescricaoParcial(String descricaoCBO2002) {
		return (ArrayList<CBO2002Model>) cbo2002DAO.listarPorValorDeColunaComStringIncompleta(CBO2002Model.class,
				"descricao", descricaoCBO2002);
	}

	/**
	 * Atualizar CBO 2002.
	 * 
	 * Realiza a alteracao das informacoes do CBO 2002 conforme codigo informado. E
	 * possivel alterar: descricao, percentual insalubridade e percentual
	 * periculosidade. Nao e possivel alterar o codigo do CBO 2002, pois se trata de
	 * identificacao unica. Caso o codigo CBO seja diferente, e recomendado
	 * cadastrar novo registro.
	 * 
	 * @param codigoCBO           codigo de CBO que sera alterado.
	 * @param novaDescricao.
	 * @param novaInsalubridade.
	 * @param novaPericulosidade.
	 * @return boolean true, se o registro foi atualizado.
	 * @throws Exception
	 */
	public boolean atualizarCBO2002(Integer codigoCBO, String novaDescricao, Insalubridade novaInsalubridade,
			Periculosidade novaPericulosidade) throws Exception {
		CBO2002Model cboRecuperado = this.cbo2002DAO.buscar(CBO2002Model.class, codigoCBO);
		if (Validadores.ehObjetoNulo(cboRecuperado)) {
			throw new Exception("O código informado não consta na base de dados, informe um valor válido.");
		}
		cboRecuperado.setCodigoCBO2002(codigoCBO);
		cboRecuperado.setDescricao(novaDescricao);
		cboRecuperado.setPercentualInsalubridade(novaInsalubridade.getValor());
		cboRecuperado.setPercentualPericulosidade(novaPericulosidade.getValor());
		return this.cbo2002DAO.atualizar(cboRecuperado);
	}

	/**
	 * Deletar um CBO 2002.
	 * 
	 * Metodo exclui o registro do CBO 2002, conforme codigo informado. Antes de
	 * realizar o procedimento, verifica se o registro realmente existe no banco de
	 * dados.
	 * 
	 * @param codigoCBO codigo do CBO 2002 que sera excluido.
	 * @return boolean true, caso haja a exclusao.
	 * @throws Exception
	 */
	public boolean deletarCBO2002(Integer codigoCBO) throws Exception {
		if (Validadores.ehObjetoNulo(cbo2002DAO.buscar(CBO2002Model.class, codigoCBO))) {
			throw new Exception("O código informado não consta na base de dados, informe um valor válido.");
		}
		this.cbo2002DAO.deletar(CBO2002Model.class, codigoCBO);
		return true;
	}

	/**
	 * Buscar todos os CBOs 2002.
	 * 
	 * Realiza a busca de todos os registros de CBO 2002 constantes no banco de
	 * dados e retorna um ArrayList de CBO2002Model.
	 * 
	 * @return ArrayList CBO2002Model lista de registros localizados.
	 */
	public ArrayList<CBO2002Model> buscarTodosCBO2002() {
		return (ArrayList<CBO2002Model>) this.cbo2002DAO.listarPorTabela(CBO2002Model.class);
	}

	/**
	 * Deletar todos os CBOs 2002.
	 * 
	 * Realiza a exclusao de todos os registros de CBO 2002 cadastrados no banco de
	 * dados.
	 */
	public void deletarTodosCBO2002() {
		cbo2002DAO.deletarTodos("cbo2002");
	}

}

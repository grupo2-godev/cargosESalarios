package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO2002DAO;
import utils.Insalubridade;
import utils.Periculosidade;
import utils.Validators;

/**
 * Classe CBO2002Controller
 * 
 * Faz contato com a classe DAO, faz as devidas tratativas com entrada e saida
 * de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class CBO2002Controller {

	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstance(ConnectionHibernate.getSession());

	/**
	 * /** Cadastrar na banco de dados um CBO 2002.
	 * 
	 * Verifica se ja existe um CBO 2002 com o mesmo codigo, se nao existir,
	 * registra o objeto. Se ja existir um CBO 2002 com o mesmo codigo, retorna
	 * nulo. Valida tambem a quantidade de caracteres do codigoCBO, visto que o
	 * padrao eh 6.
	 * 
	 * @param Integer codigoCBO codigo do CBO 2002 que sera cadastrado.
	 * @param String descricao descricao | nome do CBO 2002 que sera cadastrado.
	 * @param Insalubridade percentualInsalubridade.
	 * @param Periculosidade percentualPericulosidade.
	 * @return Integer codigoCBO codigo do CBO 2002 cadastrado.
	 * @throws Exception.
	 */
	public Integer cadastrarCBO2002(Integer codigoCBO, String descricao, Insalubridade percentualInsalubridade,
			Periculosidade percentualPericulosidade) throws Exception {
		if (Validators.isCBO2002Valid(codigoCBO) == false) {
			throw new Exception("Código de CBO 2002 informado inválido.");
		} 
		if (!(cbo2002DAO.retrieve(codigoCBO) == null)) {
			throw new Exception("Código de CBO 2002 informado já cadastrado.");
		} 
			CBO2002Model novoCBO2002 = new CBO2002Model(codigoCBO, descricao, percentualInsalubridade.getValor(),
					percentualPericulosidade.getValor());
			cbo2002DAO.create(novoCBO2002);
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
	public CBO2002Model buscarSetorPorId(Integer codigoCBO) {
		return cbo2002DAO.retrieve(codigoCBO);
	}
	
	
	/**
	 * Buscar CBO 2002 por descricao.
	 * 
	 * Realiza a busca do CBO 2002 conforme nome informado e retorna a lista de objetos
	 * CBO2002Model localizados. O texto pode ser parcial, pois ira buscar no banco todos
	 * os registros que contenham o texto informado.
	 * 
	 * @param descricaoCBO2002 descricao | nome parcial do CBO 2002 que esta sendo procurado.
	 * @return ArrayList CBO2002Model lista de CBO 2002 localizados.
	 */
	public ArrayList<CBO2002Model> buscarCBO2002PorNome(String descricaoCBO2002) {
		return cbo2002DAO.retrieveByName(descricaoCBO2002);
	}

}

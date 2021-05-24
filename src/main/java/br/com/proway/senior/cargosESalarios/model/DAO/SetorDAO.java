package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe SetorDAO
 * 
 * Classe DAO que extende a classe HybernateMethods para interacao com o
 * banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAO extends HibernateMethods<SetorModel> {

	private static SetorDAO instancia;
	
	/**
	 * Singleton da classe SetorDAO.
	 * 
	 * @param Session session
	 * @return SetorDAO instance
	 */
	public static SetorDAO getInstancia() {
		if (instancia == null)
			instancia = new SetorDAO();
		return instancia;
	}
	
	/**
	 * Construtor da classe SetorDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private SetorDAO() {
	}
}

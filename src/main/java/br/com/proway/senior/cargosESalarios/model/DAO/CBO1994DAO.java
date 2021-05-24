package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe DAO que extende a classe HybernateMethods para interacao com o
 * banco de dados.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DAO extends HibernateMethods<CBO1994Model>{

	private static CBO1994DAO instancia;

	/**
	 * Singleton da classe CBO1994DAO
	 * 
	 * @param Session session
	 * @return CBO1994DAO instance
	 */
	public static CBO1994DAO getInstancia() {
		if (instancia == null)
			instancia = new CBO1994DAO();
		return instancia;
	}

	/**
	 * Construtor da classe CBO1994DAO, utilizado no Singleton
	 * 
	 * @param Session session
	 */
	private CBO1994DAO() {
	}
}

package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe CBO2002DAO
 * 
 * Classe DAO que extende a classe genérica {@link HibernateMethods} para
 * interacao com o banco de dados.
 * 
 * @author Samuel Alves <samuel.levi@senior.com.br> - Sprint 4
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class CBO2002DAO extends HibernateMethods<CBO2002Model> {

	private static CBO2002DAO instancia;

	/**
	 * Singleton da classe CBO2002DAO.
	 * 
	 * @return CBO2002DAO instance
	 */
	public static CBO2002DAO getInstancia() {
		if (instancia == null)
			instancia = new CBO2002DAO();
		return instancia;
	}

	/**
	 * Construtor da classe CBO2002DAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private CBO2002DAO() {
	}
}

package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe PostoDeTrabalhoDAO
 * 
 * Classe DAO que extende o HibernateMethodos para interacao com o banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 4 e 5
 * @author Lorran Santos, lorran.santos@senior.com.br - Sprint 4
 * @author Samuel Levi, samuel.levi@senior.com.br - Sprint 4
 */

public class PostoDeTrabalhoDAO extends HibernateMethods<PostoDeTrabalhoModel> {

	private static PostoDeTrabalhoDAO instancia;

	/**
	 * Singleton da classe PostoDeTrabalhoDAO.
	 * 
	 * @param sessao
	 * @return PostoDeTrabalhoDAO
	 */
	public static PostoDeTrabalhoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PostoDeTrabalhoDAO();
		}
		return instancia;
	}

	/**
	 * Contrutor da classe PostoDeTrabalhoDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private PostoDeTrabalhoDAO() {
	}
}

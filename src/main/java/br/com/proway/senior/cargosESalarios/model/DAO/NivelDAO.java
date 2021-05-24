package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe DAO para a tabela de NivelModel
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 *
 */
public class NivelDAO extends HibernateMethods<NivelModel> {

	private static NivelDAO instancia;

	/**
	 * Obtem a instancia do Singleton DAO.
	 * 
	 * @param sessao : HibernateSession a ser utilizada
	 * @return
	 */
	public static NivelDAO getInstancia() {
		if (instancia == null) {
			instancia = new NivelDAO();
		}
		return instancia;
	}

	/**
	 * Construtor para uso exclusivo do singleton
	 * 
	 * @param sessao
	 */
	private NivelDAO() {
	}
}

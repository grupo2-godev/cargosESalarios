package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe grau de instrucao que implementa a {@link InterfaceDAOCRUD} para
 * interação com o banco de dados.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i> - Sprint 4
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i> - Sprint 4
 */

public class GrauInstrucaoDAO extends HibernateMethods<GrauInstrucaoModel>{
	
	private static GrauInstrucaoDAO instancia;

	/**
	 * Singleton da classe GrauInstrucaoDAO.
	 * 
	 * @return instance GrauInstrucaoDAO
	 */
	public static GrauInstrucaoDAO getInstancia() {
		if (instancia == null)
			instancia = new GrauInstrucaoDAO();
		return instancia;
	}
}

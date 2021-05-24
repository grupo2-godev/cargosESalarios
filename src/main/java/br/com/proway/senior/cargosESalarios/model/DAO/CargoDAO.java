package br.com.proway.senior.cargosESalarios.model.DAO;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/***
 * <h1>Classe responsável pela atualizacao do {@link CargoModel}.</h1>
 * 
 * <p>Implementa a InterfaceDaoCrud e passa {@link CargoModel}
 * como parâmetro. É responsável por atualizar {@link CargoModel}.</p>
 * 
 * @author Samuel Levi <b>samuel.levi@senior.com.br</b> - Sprint 4
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * 
 * @see CargoModel
 */
public class CargoDAO extends HibernateMethods<CargoModel> {

	private static CargoDAO instancia;
	
	/**
	 * <h1>Singleton da classe {@link CargoDAO}.</h1>
	 * 
	 * <p>Singleton da classe {@link CargoDAO}.
	 * Responsável pela gerencia das instancias
	 * do {@link CargoDAO}.</p>
	 * 
	 * @return {@link CargoDAO} - Referente ao {@link CargoDAO} 
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoDAO
	 */
	public static CargoDAO getInstancia() {
		if (instancia == null)
			instancia = new CargoDAO();
		return instancia;
	}

	/**
	 * <h1>Construtor vazio do {@link CargoDAO}.</h1>
	 * 
	 * <p>Construtor vazio da classe {@link CargoDAO},
	 * utilizado no Singleton.</p>
	 * 
	 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
	 * 
	 * @see CargoDAO
	 */
	private CargoDAO() {
	}
}

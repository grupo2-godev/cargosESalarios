package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
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
	private Session sessao = ConexaoHibernate.getSessao();
	
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

	/***
	 * <h1>Atualizar um {@link CargoModel}.</h1>
	 * 
	 * <p>Recebe um objeto do tipo {@link CargoModel} que
	 * sera a atualizacao do objeto no banco de dados
	 * que possui o id recebido no parametro.</p>
	 * 
	 * @param cargoNovo {@link CargoModel} - Referente ao novo 
	 * objeto que sera atualizado no banco de dados
	 * @param idCargo int - Referente ao Id do objeto a ser atualizado
	 * 
	 * @return boolean - Retorna true caso o objeto seja localizado
	 * no banco e atualizado com sucesso. Retorna false caso ocorra
	 * algum tipo de erro durante a atualizacao.
	 * 
	 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public boolean atualizar(int idCargo, CargoModel cargoNovo) {
		CargoModel cargo = buscar(CargoModel.class, idCargo);
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		cargoNovo.setIdCargo(idCargo);
		sessao.clear();
		sessao.update(cargoNovo);
		sessao.getTransaction().commit();
		return true;
	}
}
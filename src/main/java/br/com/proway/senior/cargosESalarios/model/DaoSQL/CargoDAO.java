package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/***
 * CargoDaoSQL Classe DAO que implementa a InterfaceDaoCrud, com os metodos
 * necessarios para a interacao com o banco de dados.
 * 
 * @author Samuel Levi <b>samuel.levi@senior.com.br</b> - Sprint 4
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAO extends HibernateMethods<CargoModel> {

	private static CargoDAO instancia;

	/**
	 * Singleton da classe CargoDAO.
	 * 
	 * @param sessao Session
	 * @return instance GrauInstrucaoDAO
	 */
	public static CargoDAO getInstancia() {
		if (instancia == null)
			instancia = new CargoDAO();
		return instancia;
	}

	/**
	 * Construtor da classe CargoDAO, utilizado no Singleton.
	 * 
	 * @param sessao Session
	 */
	private CargoDAO() {
		
	}

	/***
	 * Atualizar um objeto do tipo {@link CargoModel}.
	 * 
	 * Recebe um objeto do tipo {@link CargoModel} que sera a atualizacao do objeto
	 * no banco de dados que possui o id recebido no parametro.
	 * 
	 * @param cargoNovo CargoModel Novo objeto que sera inserido no banco de dados.
	 * @param idCargo   int Id do objeto a ser atualizado.
	 * @return boolean Retorna true caso o objeto seja localizado no banco e
	 *         atualizado com sucesso. Retorna false caso ocorra algum tipo de erro
	 *         durante a atualizacao.
	 */
	public boolean atualizar(int idCargo, CargoModel cargoNovo) {
		CargoModel cargo = buscar(CargoModel.class, idCargo);
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		cargoNovo.setIdCargo(idCargo);
		sessao.update(cargoNovo);
		sessao.getTransaction().commit();
		return true;
	}
}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/***
 * CargoDaoSQL Classe DAO que implementa a InterfaceDaoCrud, com os metodos
 * necessarios para a intercao com o banco de dados.
 * 
 * @author Samuel Levi <b>samuel.levi@senior.com.br</b> - Sprint 4
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAO implements InterfaceDAOCRUD<CargoModel> {

	private static CargoDAO instance;
	private Session session;

	/**
	 * Singleton da classe CargoDAO.
	 * 
	 * @param session Session
	 * @return instance GrauInstrucaoDAO
	 */
	public static CargoDAO getInstance(Session session) {
		if (instance == null)
			instance = new CargoDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe CargoDAO, utilizado no Singleton.
	 * 
	 * @param session Session
	 */
	private CargoDAO(Session session) {
		this.session = session;
	}

	/***
	 * Insere no banco de dados o registro de um objeto do tipo {@link CargoModel}.
	 *
	 * @param obj CargoModel Objeto a ser inserido.
	 * @return int Id do objeto inserido.
	 */
	public int create(CargoModel cargo) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();

		Integer idCadastrado = (Integer) session.save(cargo);
		session.getTransaction().commit();
		return idCadastrado;
	}

	/***
	 * Retorna um objeto do tipo {@link CargoModel} pelo idCargo. Realiza uma busca
	 * no banco de dados pelo ID informado e retorna a tupla com os dados
	 * correspondentes.
	 * 
	 * @param idCargo int Id do cargo a ser consultado.
	 * @return cargo CargoModel Objeto encontrado no banco de dados.
	 */
	public CargoModel retrieve(int idCargo) {
		CargoModel cargo = session.get(CargoModel.class, idCargo);
		return cargo;
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
	public boolean update(int idCargo, CargoModel cargoNovo) {
		CargoModel cargo = retrieve(idCargo);
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		cargo.setNomeCargo(cargoNovo.getNomeCargo());
		cargo.setDataCadastro(cargoNovo.getDataCadastro());
		cargo.setDataUltimaRevisao(cargoNovo.getDataUltimaRevisao());
		cargo.setCbo2002(cargoNovo.getCbo2002());
		cargo.setCbo94(cargoNovo.getCbo94());
		cargo.setHoraMes(cargoNovo.getHoraMes());
		cargo.setGrauInstrucao(cargoNovo.getGrauInstrucao());
		cargo.setExperienciaMinima(cargoNovo.getExperienciaMinima());
		cargo.setAtribuicoes(cargoNovo.getAtribuicoes());
		cargo.setStatus(cargoNovo.getStatus());
		cargo.setIdPermissao(cargoNovo.getIdPermissao());
		session.update(cargo);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Deleta do banco de dados um objeto do tipo {@link CargoModel}.
	 * 
	 * Consulta no banco de dados um objeto do tipo {@link CargoModel} cujo
	 * id eh igual ao id recebido no parametro.
	 * 
	 * @param idCargo int Id do objeto a ser deletado.
	 * @return boolean Retorna true caso o banco de dados encontre um objeto com o
	 *         id recebido. Retorna false caso ocorra algum erro durante o método.
	 */
	public boolean delete(int idCargo) {
		CargoModel cargo = retrieve(idCargo);

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.delete(cargo);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Listar todos os registros da tabela. Busca todos os registros do banco, salva
	 * em um ArrayLis e retorna o ArrayList contendo objetos do tipo
	 * {@link CargoModel}.
	 * 
	 * @return cargos ArrayList<CargoModel> Todos os registros da tabela
	 *         {@link CargoModel}.
	 */
	public ArrayList<CargoModel> getAll() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CargoModel> criteria = criteriaBuilder.createQuery(CargoModel.class);
		Root<CargoModel> root = criteria.from(CargoModel.class);
		Query query = session.createQuery(criteria);
		List<CargoModel> cargos = query.getResultList();
		return new ArrayList<CargoModel>(cargos);
	}

	/**
	 * Deleta todos os registros da tabela {@link CargoModel}.
	 * 
	 * @return boolean Retorna true caso algum registro seja deletado, se der algum
	 *         erro ou se nao houverem registros, retorna false.
	 */
	public boolean deleteAll() {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		int registrosModificados = session.createSQLQuery("DELETE FROM cargo").executeUpdate();
		session.getTransaction().commit();
		return registrosModificados > 0 ? true : false;
	}
}

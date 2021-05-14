package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
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
		if (!ConnectionHibernate.getSession().getTransaction().isActive())
			ConnectionHibernate.getSession().beginTransaction();

		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(cargo);
		ConnectionHibernate.getSession().getTransaction().commit();
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
		CargoModel cargo = ConnectionHibernate.getSession().get(CargoModel.class, idCargo);
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
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
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
		ConnectionHibernate.getSession().update(cargo);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/***
	 * Deleta um registro da tabela. Busca no banco o registro cujo ID seja igual ao
	 * informado no parâmetro e exclui a tupla.
	 * 
	 * @param idCargo int Id do registro a ser deletado.
	 * @return boolean True se o registro for apagado e False em caso de falha.
	 */
	public boolean delete(int idCargo) {
		String deleteDB = "DELETE FROM grupo2.cargo WHERE id_cargo = " + idCargo;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			stmt.execute(deleteDB);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
		Session session = ConnectionHibernate.getSession();
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
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int registrosModificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM cargo").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		return registrosModificados > 0 ? true : false;
	}
}

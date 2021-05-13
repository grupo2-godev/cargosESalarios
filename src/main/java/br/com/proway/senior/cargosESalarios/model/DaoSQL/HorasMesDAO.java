package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe HorasMesDao
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 * @author Lorran Santos, lorran.santos@senior.com.br - Sprint 4
 */
public class HorasMesDAO implements InterfaceDAOCRUD<HorasMesModel> {

	private static HorasMesDAO instance;
	private Session session;

	/**
	 * Singleton da classe HorasMesDAO.
	 * 
	 * @param session
	 * @return
	 */
	public static HorasMesDAO getInstance(Session session) {
		if (instance == null)
			instance = new HorasMesDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe HorasMesDAO, utilizado no Singleton.
	 * 
	 * @param session
	 */
	private HorasMesDAO(Session session) {
		this.session = session;
	}

	/**
	 * Inserir horas trabalhadas por mes.
	 * 
	 * Recebe um objeto HorasMesModel para inserir no banco de dados.
	 * 
	 * @param HorasMesModel horasMes Objeto a ser inserido.
	 * @return int id Id do registro.
	 */
	public int create(HorasMesModel horasMes) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}

		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(horasMes);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Quantidade de horas registradas
	 * 
	 * � feita uma consulta SQL para contar a quantidade de linhas que h� na tabela
	 * horas_mes, a qual retornar� a quantidade de horas que foram trabalhadas por
	 * m�s
	 * 
	 * @return qtdBD int
	 * @throws SQLException
	 */
	public int getAmountOfLines() throws SQLException {
		String qtd = "SELECT COUNT(id_horas_mes) as quantidade FROM grupo2.horas_mes";
		ResultSet colunas = ConnectionPostgres.executeQuery(qtd);
		colunas.next();
		int qtdBD = colunas.getInt("quantidade");
		return qtdBD;
	}

	/**
	 * Apaga tudo
	 * 
	 * � feito um comando para apagar todos os registros no banco de dados
	 */
	public void deleteAll() {
		String query = "DELETE FROM grupo2.horas_mes";
		try {
			ConnectionPostgres.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HorasMesModel retrieve(int id) {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<HorasMesModel> criteria = criteriaBuilder.createQuery(HorasMesModel.class);
		
		Root<HorasMesModel> root = criteria.from(HorasMesModel.class);
		Expression idSelector = (Expression) root.get("idhorasmes");
		criteria.select(root).where(criteriaBuilder.equal(idSelector, id));

		Query<HorasMesModel> query = session.createQuery(criteria);
		HorasMesModel results = query.getSingleResult();
		return (results);
	}

	public boolean update(int id, HorasMesModel objetoAlterado) {
		HorasMesModel original = retrieve(id);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setQuantidade(objetoAlterado.getQuantidade());
		ConnectionHibernate.getSession().update(original);
		return true;
	}

	public boolean delete(int id) {
		HorasMesModel entry = retrieve(id);
		
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	public ArrayList<HorasMesModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<HorasMesModel> criteria = criteriaBuilder.createQuery(HorasMesModel.class);

		Query<HorasMesModel> query = session.createQuery(criteria);
		List<HorasMesModel> results = query.getResultList();
		return new ArrayList<HorasMesModel>(results);
	}

}

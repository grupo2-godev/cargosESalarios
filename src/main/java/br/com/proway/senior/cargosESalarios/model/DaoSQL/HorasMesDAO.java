package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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
	 * @param Session session
	 * @return HorasMesDAO instance
	 */
	public static HorasMesDAO getInstance(Session session) {
		if (instance == null)
			instance = new HorasMesDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe HorasMesDAO, utilizado no Singleton.
	 * 
	 * @param Session session
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
	 * Buscar horas mes por ID.
	 * 
	 * Método busca o objeto horas mes no banco de dados conforme parametro
	 * informado.
	 * 
	 * @param int id
	 * @return results retorna um objeto HorasMesModel
	 */
	public HorasMesModel retrieve(int id) {
		return ConnectionHibernate.getSession().get(HorasMesModel.class, id);
	}

	/**
	 * Atualizar um registro de horas mes.
	 * 
	 * Realiza a atualizacao de um registro HorasMesModel, conforme a Id informada
	 * como parametro.
	 * 
	 * @param int           id Identificacao do registro que será alterado
	 * @param HorasMesModel objetoAlterado novo objeto com os dados alterados.
	 * @return boolean
	 */
	public boolean update(int id, HorasMesModel objetoAlterado) {
		HorasMesModel original = retrieve(id);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setQuantidade(objetoAlterado.getQuantidade());
		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Deletar um registro de horas mes.
	 * 
	 * Método deleta um registro de horas mes no banco de dados, conforme Id
	 * informada.
	 * 
	 * @param int id Identificao do registro a ser deletado
	 * @return boolean
	 */
	public boolean delete(int id) {
		HorasMesModel entry = retrieve(id);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Buscar todos os registros de horas mes.
	 * 
	 * Método busca todos os registros de horas mes que constam no banco de dados e
	 * retorna em um ArrayList.
	 * 
	 * @return ArrayList HorasMesModel
	 */
	public ArrayList<HorasMesModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<HorasMesModel> criteria = criteriaBuilder.createQuery(HorasMesModel.class);
		Root<HorasMesModel> root = criteria.from(HorasMesModel.class);
		Query query = session.createQuery(criteria);
		List<HorasMesModel> results = query.getResultList();
		return new ArrayList<HorasMesModel>(results);
	}

	/**
	 * Deletar todos os registros do banco de dados.
	 * 
	 * Comando limpa a tabela de horas mes no banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deleteAll() {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int modificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM horas_mes").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		return modificados > 0 ? true : false;
	}
}

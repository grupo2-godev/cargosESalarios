package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe CBO2002DAO
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Samuel Alves <samuel.levi@senior.com.br> - Sprint 4
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class CBO2002DAO implements InterfaceDAOCRUD<CBO2002Model> {

	private static CBO2002DAO instance;
	private Session session;

	/**
	 * Singleton da classe CBO2002DAO.
	 * 
	 * @param Session session
	 * @return CBO2002DAO instance
	 */
	public static CBO2002DAO getInstance(Session session) {
		if (instance == null)
			instance = new CBO2002DAO(session);
		return instance;
	}

	/**
	 * Construtor da classe CBO2002DAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private CBO2002DAO(Session session) {
		this.session = session;
	}

	/**
	 * Inserir CBO 2002.
	 * 
	 * Recebe um objeto CBO2002Model e insere como registro no banco de dados.
	 * 
	 * @param CBO2002Model Cbo2002 Objeto a ser inserido.
	 * @return int id Id do registro.
	 */
	public int create(CBO2002Model cbo2002) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer codigoCadastrado = (Integer) ConnectionHibernate.getSession().save(cbo2002);
		ConnectionHibernate.getSession().getTransaction().commit();
		return codigoCadastrado;
	}

	/**
	 * Buscar CBO 2002 por ID.
	 * 
	 * Metodo busca um objeto CBO 2002 no banco de dados, conforme codigo informado
	 * no parametro.
	 * 
	 * @param int codigoCBO
	 * @return CBO2002Model
	 */
	public CBO2002Model retrieve(int codigoCBO2002) {
		CBO2002Model results = ConnectionHibernate.getSession().get(CBO2002Model.class, codigoCBO2002);
		System.out.println(results.toString());
		return results;
	}

	/**
	 * Atualizar um registro de CBO 2002.
	 * 
	 * Realiza a atualizacao de um registro CBO 2002, conforme o codigo informado
	 * como parametro.
	 * 
	 * @param int          codigoCBO2002 Identificacao do registro que sera alterado
	 * @param CBO2002Model cbo2002Alterado novo objeto com os dados alterados.
	 * @return boolean
	 */
	public boolean update(int codigoCBO2002, CBO2002Model cbo2002Alterado) {
		CBO2002Model original = retrieve(codigoCBO2002);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setDescricao(cbo2002Alterado.getDescricao());
		original.setPercentualInsalubridade(cbo2002Alterado.getPercentualInsalubridade());
		original.setPercentualPericulosidade(cbo2002Alterado.getPercentualPericulosidade());
		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Deletar um registro de CBO 2002.
	 * 
	 * Metodo deleta um registro de CBO 2002 no banco de dados, conforme codigo
	 * informado.
	 * 
	 * @param int codigoCBO2002 Identificacao do registro a ser deletado
	 * @return boolean
	 */
	public boolean delete(int codigoCBO2002) {
		CBO2002Model entry = retrieve(codigoCBO2002);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Buscar todos os registros de CBO 2002.
	 * 
	 * Metodo busca todos os registros de CBO 2002 que constam no banco de dados e
	 * retorna em um ArrayList.
	 * 
	 * @return ArrayList CBO2002Model
	 */
	public ArrayList<CBO2002Model> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CBO2002Model> criteria = criteriaBuilder.createQuery(CBO2002Model.class);
		Root<CBO2002Model> root = criteria.from(CBO2002Model.class);
		Query query = session.createQuery(criteria);
		List<CBO2002Model> results = query.getResultList();
		return new ArrayList<CBO2002Model>(results);
	}

	/**
	 * Deletar todos os registros de CBOs 2002 do banco de dados.
	 * 
	 * Metodo limpa a tabela cbo2002 no banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deleteAll() {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int modificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM cbo2002").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		return modificados > 0 ? true : false;
	}

}

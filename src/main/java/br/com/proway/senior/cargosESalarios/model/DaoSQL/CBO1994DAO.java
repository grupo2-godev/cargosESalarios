package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Implementar os metodos CRUD para o DB
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DAO implements InterfaceDAOCRUD<CBO1994Model> {

	private static CBO1994DAO instance;

	/**
	 * Singleton da classe CBO1994DAO
	 * 
	 * @param Session session
	 * @return CBO1994DAO instance
	 */
	public static CBO1994DAO getInstance(Session session) {
		if (instance == null)
			instance = new CBO1994DAO(session);
		return instance;
	}

	/**
	 * Construtor da classe CBO1994DAO, utilizado no Singleton
	 * 
	 * @param Session session
	 */
	private CBO1994DAO(Session session) {
	}

	/**
	 * Inserir CBO1994.
	 * 
	 * Recebe um objeto CBO1994Model para inserir no banco de dados.
	 * 
	 * @param CBO1994Model CBO1994
	 * @return int codigoCBO
	 */
	public int create(CBO1994Model CBO1994) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer codigoCBO = (Integer) ConnectionHibernate.getSession().save(CBO1994);
		ConnectionHibernate.getSession().getTransaction().commit();
		return codigoCBO;
	}

	/**
	 * Busca CBO1994 pelo seu codigo
	 * 
	 * Metodo busca o objeto CBO1994 no banco de dados conforme codigo informado
	 * 
	 * @param int codigo_CBO1994
	 * @return results retorna objeto CBO1994Model
	 */
	public CBO1994Model retrieve(int codigo_CBO1994) {
		CBO1994Model results = ConnectionHibernate.getSession().get(CBO1994Model.class, codigo_CBO1994);
		System.out.println(results.toString());
		return results;
	}

	/**
	 * Atualiza um CBO1994
	 * 
	 * Realiza a atualizacao de um CBO1994Model, conforme codigo informado como
	 * parametro
	 * 
	 * @param int          codigo_CBO1994
	 * @param CBO1994Model objetoAlterado
	 */
	public boolean update(int codigo_CBO1994, CBO1994Model objetoAlterado) {
		CBO1994Model original = retrieve(codigo_CBO1994);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setCodigo_cbo(objetoAlterado.getCodigo_cbo());
		original.setDescricao(objetoAlterado.getDescricao());
		original.setPercentualInsalubridade(objetoAlterado.getPercentualInsalubridade());
		original.setPercentualPericulosidade(objetoAlterado.getPercentualPericulosidade());

		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Deletar um CBO1994
	 * 
	 * Metodo deleta um CBO1994, conforme codigo CBO1994 informado
	 * 
	 * @param int codigo_CBO1994
	 * @return boolean
	 */
	public boolean delete(int codigo_CBO1994) {
		CBO1994Model objeto_deletar = retrieve(codigo_CBO1994);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}

		ConnectionHibernate.getSession().delete(objeto_deletar);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Busca todos os CBO1994 cadastrados
	 * 
	 * Metodo busca todos os CBO1994 cadastrados que constam no banco de dados e retorna no formate de ArrayList
	 * 
	 * @return ArrayList<Cbo1994Model>
	 */
	public ArrayList<CBO1994Model> getAll() {		
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CBO1994Model> criteria = criteriaBuilder.createQuery(CBO1994Model.class);
		
		Root<CBO1994Model> root = criteria.from(CBO1994Model.class);
		
		Query query = session.createQuery(criteria);
		
		List<CBO1994Model> results = query.getResultList();
		
		return new ArrayList<CBO1994Model>(results);
	}

	/**
	 * Deleta todos os CBO1994 no banco de dados
	 * 
	 * Metodo remove todos os CBO1994 presentes na tabela no banco de dados
	 * 
	 * @return boolean
	 */
	public boolean deleteAll() {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int modificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM cbo1994").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		ConnectionHibernate.getSession().clear();
		return modificados > 0 ? true : false;
	}

}

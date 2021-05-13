package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
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
	public int create(CBO2002Model Cbo2002) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(CBO2002);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	public CBO2002Model retrieve(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(int id, CBO2002Model obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CBO2002Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}


}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;

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
public class CBO1994DAO implements InterfaceDAOCRUD<CBO1994Model>{

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
	 * Realiza a atualizacao de um CBO1994Model, conforme codigo informado como parametro
	 * 
	 * @param int codigo_CBO1994
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

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Lista todos os registro da tabela, salvando em uma ArrayList
	 * 
	 * @return ArrayList<Cbo1994Model>
	 */
	public ArrayList<CBO1994Model> getAll() {

		ArrayList<CBO1994Model> list = new ArrayList<CBO1994Model>();
		String sqlSelectAll = "SELECT * FROM grupo2.cbo1994";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			CBO1994Model cbo1994Model = new CBO1994Model();
			while (rs.next()) {

				cbo1994Model.setCodigo_cbo(rs.getInt(1));
				cbo1994Model.setDescricao(rs.getString(2));
				cbo1994Model.setPercentualInsalubridade(rs.getDouble(3));
				cbo1994Model.setPercentualPericulosidade(rs.getDouble(4));
				System.out.println(cbo1994Model.toString());
				list.add(cbo1994Model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Metodo realiza a limpeza da tabela do DB, detalando os registros.
	 * Foi feito para ser utilizado nos testes unitarios.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.cbo1994";	
		conexao.criarConexao().createStatement().executeUpdate(limpar);	
		System.out.println("Limpeza realizada.");
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

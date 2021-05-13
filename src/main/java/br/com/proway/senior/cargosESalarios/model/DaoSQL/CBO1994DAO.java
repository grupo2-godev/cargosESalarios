package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Implementar os metodos CRUD para o DB 
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DAO implements InterfaceDAOCRUD<Cbo1994Model>{

	private static CBO1994DAO instance;
	FactoryConexao conexao = new FactoryPostgres();
	
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
	
	private CBO1994DAO(Session session) {
	}
	
	
	/**
	 * Insere no DB o registro de um Cbo1994Model
	 * 
	 * @param obj Cbo1994Model
	 * @return int 
	 */
	public int create(Cbo1994Model obj) {
		String sqlInsert = "INSERT INTO grupo2.cbo1994 (codigo_cbo, descricao, percentual_insalubridade, percentual_periculosidade) VALUES (?,?,?,?)";
		int quantidadeRegistros = 0;
		try {
			PreparedStatement pstmt = conexao.criarConexao().prepareStatement(sqlInsert);
			pstmt.setInt(1, obj.getCodigo_cbo());
			pstmt.setString(2, obj.getDescricao());
			pstmt.setDouble(3, obj.getPercentualInsalubridade());
			pstmt.setDouble(4, obj.getPercentualPericulosidade());
			pstmt.execute();
			pstmt.close();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.cbo1994";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			quantidadeRegistros = rs.getInt(1);
			System.out.println("CBO 1994 cadastrado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar o CBO 1994");
			e.printStackTrace();
			return -1;
		}
		return quantidadeRegistros;
	}

	public Cbo1994Model retrieve(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(int id, Cbo1994Model obj) {
		// TODO Auto-generated method stub
		return false;
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
	public ArrayList<Cbo1994Model> getAll() {

		ArrayList<Cbo1994Model> list = new ArrayList<Cbo1994Model>();
		String sqlSelectAll = "SELECT * FROM grupo2.cbo1994";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			Cbo1994Model cbo1994Model = new Cbo1994Model();
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

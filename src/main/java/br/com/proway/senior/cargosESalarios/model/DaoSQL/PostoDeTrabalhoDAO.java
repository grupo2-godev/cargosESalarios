package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.connection.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe PostoDeTrabalhoDaoSql
 * 
 * Classe DAO que implementa a interface CRUDInterface para
 * interacao com o banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 * @author Lorran Santos, lorran.santos@senior.com.br
 * @author Samuel Levi, samuel.levi@senior.com.br
 */

public class PostoDeTrabalhoDAO implements InterfaceDAOCRUD<PostoDeTrabalhoModel> {
	
	FactoryConexao conexao = new FactoryPostgres();
	
	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return quantidade
	 */
	public int create(PostoDeTrabalhoModel postoModel) {
		String sqlInsert = "INSERT INTO grupo2.posto_de_trabalho (nome_posto, id_cargo, id_setor, id_nivel, salario) "
				+ "VALUES (?, ?, ?, ?, ?)";
		int quantidadeRegistros = 0;
		try {
			PreparedStatement pstmt = conexao.criarConexao().prepareStatement(sqlInsert);
			pstmt.setString(1, postoModel.getNomePosto());
			pstmt.setInt(2, postoModel.getIdCargo());
			pstmt.setInt(3, postoModel.getIdSetor());
			pstmt.setInt(4, postoModel.getIdNivel());
			pstmt.setDouble(5, postoModel.getSalario());
			pstmt.execute();
			pstmt.close();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.posto_de_trabalho";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			quantidadeRegistros = rs.getInt(1);
			System.out.println("Posto de Trabalho cadastrado com sucesso.");
			return quantidadeRegistros;
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar Posto de Trabalho");
			e.printStackTrace();
		}
		return quantidadeRegistros;
	}
	
	/**
	 * Metodo countValores
	 * 
	 * Metodo realiza um select no banco para verificar a quantidade
	 * de registros e retorna esse valor.
	 * 
	 * @return int quantidade
	 */
	public int countValores() {
		int quantidade = 0;
		try {
			String sqlCount = "SELECT COUNT(*) FROM grupo2.posto_de_trabalho";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			quantidade = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantidade;
	}
	
	/**
	 * Metodo retrieve por idPosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados,
	 * conforme idPosto informada.
	 * 
	 * @param int idPosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(int idPosto) {
		String sqlRetrieveId = "SELECT * FROM grupo2.posto_de_trabalho WHERE id_posto = " + idPosto;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlRetrieveId);
			PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
			while (rs.next()) {
				posto.setIdCargo(rs.getInt(1));
				posto.setIdNivel(rs.getInt(2));
				posto.setIdSetor(rs.getInt(3));
				posto.setNomePosto(rs.getString(4));
				posto.setSalario(rs.getDouble(5));
				posto.setIdPosto(rs.getInt(6));
				System.out.println(posto.toString());
			}
			return posto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo retrieve por nomePosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados,
	 * conforme nomePosto informado.
	 * 
	 * @param String nomePosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(String nomePosto) {
		String sqlRetrieveNome = "SELECT * FROM grupo2.posto_de_trabalho WHERE nome_posto = " 
				+ "'" + nomePosto + "'";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlRetrieveNome);
			PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
			while (rs.next()) {
				posto.setIdCargo(rs.getInt(1));
				posto.setIdNivel(rs.getInt(2));
				posto.setIdSetor(rs.getInt(3));
				posto.setNomePosto(rs.getString(4));
				posto.setSalario(rs.getDouble(5));
				posto.setIdPosto(rs.getInt(6));
				System.out.println(posto.toString());
			}
			return posto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo upadate
	 * 
	 * Metodo realiza a atualizacao dos dados no banco de dados
	 * para o posto informado, conforme idPosto.
	 * 
	 * @param int idPosto
	 * @param PostoDeTrabalhoModel postoModel
	 * @return boolean
	 */
	public boolean update(int idPosto, PostoDeTrabalhoModel postoModel) {
		String sqlUpdate = "UPDATE grupo2.posto_de_trabalho SET nome_posto = ?, id_cargo = ?, "
				+ "id_setor = ?, id_nivel = ?, salario = ? WHERE id_posto = " + idPosto;
		PreparedStatement pstmt;
		try {
			pstmt = conexao.criarConexao().prepareStatement(sqlUpdate);
			pstmt.setString(1, postoModel.getNomePosto());
			pstmt.setInt(2, postoModel.getIdCargo());
			pstmt.setInt(3, postoModel.getIdSetor());
			pstmt.setInt(4, postoModel.getIdNivel());
			pstmt.setDouble(5, postoModel.getSalario());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo delete
	 * 
	 * Realiza a exclus�o do posto de trabalho informado
	 * em idPosto.
	 * 
	 * @param int idPosto
	 * @return boolean
	 */
	public boolean delete(int idPosto) {
		String sqlDelete = "DELETE FROM grupo2.posto_de_trabalho WHERE id_posto = " + idPosto;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			stmt.execute(sqlDelete);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Metodo getAll
	 * 
	 * Metodo realiza a busca de todos os postos de trabalho
	 * cadastrados no banco e armazena em um ArrayList.
	 * 
	 * @return ArrayList<PostoDeTrabalhoModel>
	 */
	public ArrayList<PostoDeTrabalhoModel> getAll() {
        ArrayList<PostoDeTrabalhoModel> results = new ArrayList<PostoDeTrabalhoModel>();
        String sqlSelectAll = "SELECT * FROM grupo2.posto_de_trabalho";
        try {
        	Statement stmt = conexao.criarConexao().createStatement();
     		ResultSet rs = stmt.executeQuery(sqlSelectAll);
			PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
			while (rs.next()) {
				posto.setIdCargo(rs.getInt(1));
				posto.setIdNivel(rs.getInt(2));
				posto.setIdSetor(rs.getInt(3));
				posto.setNomePosto(rs.getString(4));
				posto.setSalario(rs.getDouble(5));
				posto.setIdPosto(rs.getInt(6)); 
				System.out.println(posto.toString());
               	results.add(posto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
	}
	
	/**
	 * Metodo limparTabela
	 * 
	 * Metodo realiza a limpeza da tabela no banco de dados, deletando os registros
	 * e resetando a PrimaryKey. O foco eh ser utilizado nos testes. É necessário criar
	 * as sequences no banco, pois eh partir delas que a Primary Key é resetada.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.posto_de_trabalho";
		String removerIncremento = "ALTER SEQUENCE grupo2.posto_de_trabalho_increment RESTART";	
		conexao.criarConexao().createStatement().executeUpdate(limpar);	
		conexao.criarConexao().createStatement().executeUpdate(removerIncremento);
		System.out.println("Limpeza realizada.");
	}

}

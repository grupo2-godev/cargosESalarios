package br.com.proway.senior.cargosESalarios.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classe PostoDeTrabalhoDaoSql
 * 
 * Classe DAO que implementa a interface CRUDInterface para
 * interação com o banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class PostoDeTrabalhoDaoSql implements InterfaceDaoCrud<PostoDeTrabalhoModel> {
	
	ConnectionPostgres conexao = new ConnectionPostgres();
	
	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return novoPostoId
	 */
	public int create(PostoDeTrabalhoModel postoModel) {
		String sqlInsert = "INSERT INTO grupo2.posto_de_trabalho (nome_posto, id_cargo, id_setor, id_nivel, salario) VALUES (?, ?, ?, ?, ?)";
		int quantidade = 0;
		try {
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sqlInsert);
			pstmt.setString(1, postoModel.getNomePosto());
			pstmt.setInt(2, postoModel.getIdCargo());
			pstmt.setInt(3, postoModel.getIdSetor());
			pstmt.setInt(4, postoModel.getIdNivel());
			pstmt.setDouble(5, postoModel.getSalario());
			pstmt.execute();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.posto_de_trabalho";
			ResultSet rs = conexao.executeQuery(sqlCount);
			rs.next();
			quantidade = rs.getInt(1);
			System.out.println("Posto de Trabalho cadastrado com sucesso.");
			return quantidade;
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar Posto de Trabalho");
			e.printStackTrace();
		}
		return quantidade;
	}
	
	/**
	 * Método countValores
	 * 
	 * Método realiza um select no banco para verificar a quantidade
	 * de registros e retorna esse valor.
	 * 
	 * @return int quantidade
	 */
	public int countValores() {
		int quantidade = 0;
		try {
			String sqlCount = "SELECT COUNT(*) FROM grupo2.posto_de_trabalho";
			ResultSet rs = conexao.executeQuery(sqlCount);
			rs.next();
			quantidade = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantidade;
	}
	
	/**
	 * Método retrieve por idPosto
	 * 
	 * Método realiza a busca dos dados do posto no banco de dados,
	 * conforme idPosto informada.
	 * 
	 * @param int idPosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(int idPosto) {
		String sqlRetrieveId = "SELECT * FROM grupo2.posto_de_trabalho WHERE id_posto = " + idPosto;
		try {
			Statement stmt = conexao.conectar().createStatement();
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
	 * Método retrieve por nomePosto
	 * 
	 * Método realiza a busca dos dados do posto no banco de dados,
	 * conforme nomePosto informado.
	 * 
	 * @param String nomePosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(String nomePosto) {
		String sqlRetrieveId = "SELECT * FROM grupo2.posto_de_trabalho WHERE nome_posto = " 
				+ "'" + nomePosto + "'";
		try {
			Statement stmt = conexao.conectar().createStatement();
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
	 * Método upadate
	 * 
	 * Método realiza a atualização dos dados no banco de dados
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
			pstmt = conexao.conectar().prepareStatement(sqlUpdate);
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
	 * Método delete
	 * 
	 * Realiza a exclusão do posto de trabalho informado
	 * em idPosto.
	 * 
	 * @param int idPosto
	 * @return boolean
	 */
	public boolean delete(int idPosto) {
		String sqlDelete = "DELETE FROM grupo2.posto_de_trabalho WHERE id_posto = " + idPosto;
		try {
			Statement stmt = conexao.conectar().createStatement();
			stmt.execute(sqlDelete);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Método getAll
	 * 
	 * Método realiza a busca de todos os postos de trabalho
	 * cadastrados no banco e armazena em um ArrayList.
	 * 
	 * @return ArrayList<PostoDeTrabalhoModel>
	 */
	public ArrayList<PostoDeTrabalhoModel> getAll() {
        ArrayList<PostoDeTrabalhoModel> results = new ArrayList<PostoDeTrabalhoModel>();
        String sqlSelectAll = "SELECT * FROM grupo2.posto_de_trabalho";
        try {
        	Statement stmt = conexao.conectar().createStatement();
     		ResultSet rs = stmt.executeQuery(sqlSelectAll);
			PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
			while (rs.next()) {
				posto.setIdCargo(rs.getInt(1));
				posto.setIdNivel(rs.getInt(2));
				posto.setIdPosto(rs.getInt(3));
				posto.setIdSetor(rs.getInt(4));
				posto.setNomePosto(rs.getString(5));
				posto.setSalario(rs.getDouble(6));  
				System.out.println(posto.toString());
               	results.add(posto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
	}
	
	/**
	 * Método limparTabela
	 * 
	 * Método realiza a limpeza da tabela no banco de dados, deletando os registros
	 * e resetando a PrimaryKey. O foco é ser utilizado nos testes.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.posto_de_trabalho";
		String removerIncremento = "ALTER SEQUENCE grupo2.posto_de_trabalho_increment RESTART";	
		ConnectionPostgres.executeUpdate(limpar);
		ConnectionPostgres.executeUpdate(removerIncremento);
		System.out.println("Limpou tudo");
	}

}

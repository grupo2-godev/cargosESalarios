package br.com.proway.senior.cargosESalarios.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classe SetoroDaoSql
 * 
 * Classe DAO que implementa a interface CRUDInterface para interação com o
 * banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class SetorDaoSql implements InterfaceDaoCrud<SetorModel> {

	ConnectionPostgres conexao = new ConnectionPostgres();

	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto setor para inserir no banco de dados.
	 * 
	 * @param SetorModel setorModel
	 * @return quantidadeRegistros
	 */
	public int create(SetorModel setorModel) {
		String sqlInsert = "INSERT INTO grupo2.setor (nome_setor, id_permissao) VALUES (?, ?)";
		int quantidadeRegistros = 0;
		try {
			PreparedStatement pstmt = conexao.conectar().prepareStatement(sqlInsert);
			pstmt.setString(1, setorModel.getNomeSetor());
			pstmt.setInt(2, setorModel.getIdPermissao());
			pstmt.execute();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.setor";
			ResultSet rs = conexao.executeQuery(sqlCount);
			rs.next();
			quantidadeRegistros = rs.getInt(1);
			System.out.println("Setor cadastrado com sucesso.");
			return quantidadeRegistros;
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar Setor");
			e.printStackTrace();
		}
		return quantidadeRegistros;
	}

	/**
	 * Método countValores
	 * 
	 * Método realiza um select no banco para verificar a quantidade de registros e
	 * retorna esse valor.
	 * 
	 * @return int quantidade
	 */
	public int countValores() {
		int quantidade = 0;
		try {
			String sqlCount = "SELECT COUNT(*) FROM grupo2.setor";
			ResultSet rs = conexao.executeQuery(sqlCount);
			rs.next();
			quantidade = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantidade;
	}

	/**
	 * Método retrieve por idSetor
	 * 
	 * Método realiza a busca dos dados do setor no banco de dados, conforme idSetor
	 * informada.
	 * 
	 * @param int idSetor
	 * @return SetorModel
	 */
	public SetorModel retrieve(int idSetor) {
		String sqlRetrieveId = "SELECT * FROM grupo2.setor WHERE id_setor = " + idSetor;
		try {
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sqlRetrieveId);
			SetorModel setorModel = new SetorModel();
			while (rs.next()) {
				setorModel.setNomeSetor(rs.getString(1));
				setorModel.setId(rs.getInt(2));
				setorModel.setIdPermissao(rs.getInt(3));
				System.out.println(setorModel.toString());
			}
			return setorModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método retrieve por nomeSetor
	 * 
	 * Método realiza a busca dos dados do posto no banco de dados, conforme
	 * nomeSetor informado.
	 * 
	 * @param String nomeSetor
	 * @return SetorModel
	 */
	public SetorModel retrieve(String nomeSetor) {
		String sqlRetrieveNome = "SELECT * FROM grupo2.setor WHERE nome_setor = " + "'" + nomeSetor + "'";
		try {
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sqlRetrieveNome);
			SetorModel setorModel = new SetorModel();
			while (rs.next()) {
				setorModel.setNomeSetor(rs.getString(1));
				setorModel.setId(rs.getInt(2));
				setorModel.setIdPermissao(rs.getInt(3));
				System.out.println(setorModel.toString());
			}
			return setorModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método upadate
	 * 
	 * Método realiza a atualização dos dados no banco de dados para o setor
	 * informado, conforme idSetor.
	 * 
	 * @param int        idSetor
	 * @param SetorModel setorModel
	 * @return boolean
	 */
	public boolean update(int idSetor, SetorModel setorModel) {
		String sqlUpdate = "UPDATE grupo2.setor SET nome_setor= ?, id_permissao = ? WHERE id_setor = " + idSetor;
		PreparedStatement pstmt;
		try {
			pstmt = conexao.conectar().prepareStatement(sqlUpdate);
			pstmt.setString(1, setorModel.getNomeSetor());
			pstmt.setInt(2, setorModel.getIdPermissao());
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
	 * Realiza a exclusão do setor informado em idSetor.
	 * 
	 * @param int idSetor
	 * @return boolean
	 */
	public boolean delete(int idSetor) {
		String sqlDelete = "DELETE FROM grupo2.setor WHERE id_setor = " + idSetor;
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
	 * Método realiza a busca de todos os setores cadastrados no banco e armazena em
	 * um ArrayList.
	 * 
	 * @return ArrayList<SetorModel>
	 */
	public ArrayList<SetorModel> getAll() {
		ArrayList<SetorModel> results = new ArrayList<SetorModel>();
		String sqlSelectAll = "SELECT * FROM grupo2.setor";
		try {
			Statement stmt = conexao.conectar().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			SetorModel setorModel = new SetorModel();
			while (rs.next()) {
				setorModel.setNomeSetor(rs.getString(1));
				setorModel.setId(rs.getInt(2));
				setorModel.setIdPermissao(rs.getInt(3));
				System.out.println(setorModel.toString());
				results.add(setorModel);
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
	 * e resetando a PrimaryKey. O foco é ser utilizado nos testes. É necessário
	 * implementar no banco as sequences, pois é lá que ocorre essa "limpeza" do
	 * increment.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.setor";
		String removerIncremento = "ALTER SEQUENCE grupo2.setor_increment RESTART";
		ConnectionPostgres.executeUpdate(limpar);
		ConnectionPostgres.executeUpdate(removerIncremento);
		System.out.println("Limpeza realizada.");
	}

}

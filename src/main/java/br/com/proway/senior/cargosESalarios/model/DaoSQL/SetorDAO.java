package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe SetoroDaoSql
 * 
 * Classe DAO que implementa a interface CRUDInterface para intera��o com o
 * banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class SetorDAO implements InterfaceDAOCRUD<SetorModel> {

	FactoryConexao conexao = new FactoryPostgres();

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
			PreparedStatement pstmt = conexao.criarConexao().prepareStatement(sqlInsert);
			pstmt.setString(1, setorModel.getNomeSetor());
			pstmt.setInt(2, setorModel.getIdPermissao());
			pstmt.execute();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.setor";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
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
	 * M�todo countValores
	 * 
	 * M�todo realiza um select no banco para verificar a quantidade de registros e
	 * retorna esse valor.
	 * 
	 * @return int quantidade
	 */
	public int countValores() {
		int quantidade = 0;
		try {
			String sqlCount = "SELECT COUNT(*) FROM grupo2.setor";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			quantidade = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantidade;
	}

	/**
	 * M�todo retrieve por idSetor
	 * 
	 * M�todo realiza a busca dos dados do setor no banco de dados, conforme idSetor
	 * informada.
	 * 
	 * @param int idSetor
	 * @return SetorModel
	 */
	public SetorModel retrieve(int idSetor) {
		String sqlRetrieveId = "SELECT * FROM grupo2.setor WHERE id_setor = " + idSetor;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
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
	 * M�todo retrieve por nomeSetor
	 * 
	 * M�todo realiza a busca dos dados do posto no banco de dados, conforme
	 * nomeSetor informado.
	 * 
	 * @param String nomeSetor
	 * @return SetorModel
	 */
	public SetorModel retrieve(String nomeSetor) {
		String sqlRetrieveNome = "SELECT * FROM grupo2.setor WHERE nome_setor = " + "'" + nomeSetor + "'";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
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
	 * M�todo upadate
	 * 
	 * M�todo realiza a atualiza��o dos dados no banco de dados para o setor
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
			pstmt = conexao.criarConexao().prepareStatement(sqlUpdate);
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
	 * M�todo delete
	 * 
	 * Realiza a exclus�o do setor informado em idSetor.
	 * 
	 * @param int idSetor
	 * @return boolean
	 */
	public boolean delete(int idSetor) {
		String sqlDelete = "DELETE FROM grupo2.setor WHERE id_setor = " + idSetor;
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
	 * M�todo getAll
	 * 
	 * M�todo realiza a busca de todos os setores cadastrados no banco e armazena em
	 * um ArrayList.
	 * 
	 * @return ArrayList<SetorModel>
	 */
	public ArrayList<SetorModel> getAll() {
		ArrayList<SetorModel> results = new ArrayList<SetorModel>();
		String sqlSelectAll = "SELECT * FROM grupo2.setor";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
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
	 * M�todo limparTabela
	 * 
	 * M�todo realiza a limpeza da tabela no banco de dados, deletando os registros
	 * e resetando a PrimaryKey. O foco � ser utilizado nos testes. � necess�rio
	 * implementar no banco as sequences, pois � l� que ocorre essa "limpeza" do
	 * increment.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.setor";
		String removerIncremento = "ALTER SEQUENCE grupo2.setor_increment RESTART";
		conexao.criarConexao().createStatement().executeUpdate(limpar);	
		conexao.criarConexao().createStatement().executeUpdate(removerIncremento);
		System.out.println("Limpeza realizada.");
	}

}

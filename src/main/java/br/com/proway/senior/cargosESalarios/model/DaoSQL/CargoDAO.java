package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/***
 * CargoDaoSQL Classe DAO que implementa a InterfaceDaoCrud, com os métodos
 * necessários para a interação com o banco de dados.
 * 
 * @author Samuel Levi <b>samuel.levi@senior.com.br</b> - Sprint 4
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAO implements InterfaceDAOCRUD<CargoModel> {

	FactoryConexao conexao = new FactoryPostgres();

	/***
	 * Insere no banco de dados o registro de um CargoModel.
	 *
	 * @param obj CargoModel Objeto a ser inserido.
	 * @return int Quantidade de registros inseridos.
	 */
	public int create(CargoModel obj) {
		String insertDB = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int qtd = 0;
		try {
			PreparedStatement prepStmt = conexao.criarConexao().prepareStatement(insertDB);
			prepStmt.setString(1, obj.getNomeCargo());
			prepStmt.setDate(2, Date.valueOf(obj.getDataCadastro().toLocalDate()));
			prepStmt.setDate(3, Date.valueOf(obj.getDataUltimaRevisao().toLocalDate()));
			prepStmt.setInt(4, obj.getCbo2002());
			prepStmt.setInt(5, obj.getCbo94());
			prepStmt.setInt(6, obj.getHoraMes());
			prepStmt.setInt(7, obj.getGrauInstrucao());
			prepStmt.setString(8, obj.getExperienciaMinima());
			prepStmt.setString(9, obj.getAtribuicoes());
			prepStmt.setBoolean(10, obj.getStatus());
			prepStmt.setInt(11, obj.getIdPermissao());
			prepStmt.execute();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.cargo";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			qtd = rs.getInt(1);
			System.out.println("Cargo cadastrado com sucesso.");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar Cargo");
			e.printStackTrace();
			return -1;
		}
		return qtd;
	}

	/***
	 * Retorna um cargo pelo ID do cargo. Realiza uma busca no banco de dados pelo
	 * ID informado e retorna a tupla com os dados correspondentes.
	 * 
	 * @param idCargo int Id do cargo a ser consultado.
	 * @return cargo CargoModel Objeto encontrado no banco de dados.
	 */
	public CargoModel retrieve(int idCargo) {
		String retrieveById = "SELECT * FROM grupo2.cargo WHERE id_cargo = " + idCargo;
		CargoModel cargo = null;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(retrieveById);
			while (rs.next()) {
				cargo = new CargoModel();
				cargo.setIdCargo(rs.getInt(1));
				cargo.setNomeCargo(rs.getString(2));
				cargo.setDataCadastro(new Timestamp(rs.getDate(3).getTime()).toLocalDateTime());
				cargo.setDataUltimaRevisao(new Timestamp(rs.getDate(4).getTime()).toLocalDateTime());
				cargo.setCbo2002(rs.getInt(5));
				cargo.setCbo94(rs.getInt(6));
				cargo.setHoraMes(rs.getInt(7));
				cargo.setGrauInstrucao(rs.getInt(8));
				cargo.setExperienciaMinima(rs.getString(9));
				cargo.setAtribuicoes(rs.getString(10));
				cargo.setStatus(rs.getBoolean(11));
				cargo.setIdPermissao(rs.getInt(12));
				System.out.println(cargo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cargo;
	}

	/**
	 * Atualizar um registro no banco de dados. Realiza a atualização dos dados no
	 * registro cujo o id_cargo seja idêntico ao IdCargo informado no parâmetro.
	 * 
	 * @param idCargo int Id do objeto a ser atualizado.
	 * @param obj     CargoModel Objeto que possui as informações que serão setadas no objeto que possui o id informado.
	 * @return boolean True se a atualização for efetuada e False caso contrário.
	 */
	public boolean update(int idCargo, CargoModel obj) {
		String updateDB = "UPDATE grupo2.cargo SET nome_cargo = ?, data_cadastro = ?,"
				+ "data_ultima_revisao = ?, cbo2002 = ?, cbo1994 = ?, horas_mes = ?,"
				+ "grau_de_instrucao = ?, experiencia_minima = ?, atribuicoes = ?, status = ?, id_permissao = ? WHERE id_cargo = "
				+ idCargo;
		PreparedStatement prepStmt;
		try {
			prepStmt = conexao.criarConexao().prepareStatement(updateDB);
			prepStmt.setString(1, obj.getNomeCargo());
			prepStmt.setDate(2, Date.valueOf(obj.getDataCadastro().toLocalDate()));
			prepStmt.setDate(3, Date.valueOf(obj.getDataUltimaRevisao().toLocalDate()));
			prepStmt.setInt(4, obj.getCbo2002());
			prepStmt.setInt(5, obj.getCbo94());
			prepStmt.setInt(6, obj.getHoraMes());
			prepStmt.setInt(7, obj.getGrauInstrucao());
			prepStmt.setString(8, obj.getExperienciaMinima());
			prepStmt.setString(9, obj.getAtribuicoes());
			prepStmt.setBoolean(10, obj.getStatus());
			prepStmt.setInt(11, obj.getIdPermissao());
			prepStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/***
	 * Deleta um registro da tabela. Busca no banco o registro cujo ID seja igual
	 * ao informado no parâmetro e exclui a tupla.
	 * 
	 * @param idCargo int Id do registro a ser deletado.
	 * @return boolean True se o registro for apagado e False em caso de falha.
	 */
	public boolean delete(int idCargo) {
		String deleteDB = "DELETE FROM grupo2.cargo WHERE id_cargo = " + idCargo;
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			stmt.execute(deleteDB);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Listar todos os registros da tabela. Busca todos os registros do banco, salva
	 * em um ArrayLis e retorna o ArrayList contendo objetos do tipo CargoModel.
	 * 
	 * @return list ArrayList<CargoModel>
	 */
	public ArrayList<CargoModel> getAll() {
		ArrayList<CargoModel> list = new ArrayList<CargoModel>();
		String sqlSelectAll = "SELECT * FROM grupo2.cargo";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			CargoModel cargo = new CargoModel();
			while (rs.next()) {
				cargo.setIdCargo(rs.getInt(1));
				cargo.setNomeCargo(rs.getString(2));
				cargo.setDataCadastro(new Timestamp(rs.getDate(3).getTime()).toLocalDateTime());
				cargo.setDataUltimaRevisao(new Timestamp(rs.getDate(4).getTime()).toLocalDateTime());
				cargo.setCbo2002(rs.getInt(5));
				cargo.setCbo94(rs.getInt(6));
				cargo.setHoraMes(rs.getInt(7));
				cargo.setGrauInstrucao(rs.getInt(8));
				cargo.setExperienciaMinima(rs.getString(9));
				cargo.setAtribuicoes(rs.getString(10));
				cargo.setStatus(rs.getBoolean(11));
				cargo.setIdPermissao(rs.getInt(12));
				System.out.println(cargo.toString());
				list.add(cargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Método limparTabela
	 * 
	 * Método realiza a limpeza da tabela no banco de dados, deletando os registros
	 * e resetando a PrimaryKey. O foco é ser utilizado nos testes. É necessário
	 * implementar no banco as sequences.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.cargo";
		String removerIncremento = "ALTER SEQUENCE grupo2.cargo_increment RESTART";
		conexao.criarConexao().createStatement().executeUpdate(limpar);
		conexao.criarConexao().createStatement().executeUpdate(removerIncremento);
		System.out.println("Limpeza realizada.");
	}
}
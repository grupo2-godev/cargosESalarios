package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDaoCrud;

/**
 * Implementar os metodos CRUD para o DB 
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DaoSQL implements InterfaceDaoCrud<Cbo1994Model>{

	FactoryConexao conexao = new FactoryPostgres();

	public int create(Cbo1994Model obj) {
		String sqlInsert = "INSERT INTO grupo2.cbo1994 (codigo_cbo, descricao, percentual_insalubridade, percentual_periculosidade) VALUES (?,?,?,?)";
		int quantidadeRegistros = 0;
		try {
			PreparedStatement pstmt = conexao.criarConexao().prepareStatement(sqlInsert);
//			pstmt.setInt(pstmt.getResultSet().getInt("codigo_cbo"), obj.getCodigo_cbo());
//			pstmt.setString(pstmt.getResultSet().getInt("descricao"), obj.getDescricao());
//			pstmt.setDouble(pstmt.getResultSet().getInt("percentual_insalubridade"), obj.getPercentualInsalubridade());
//			pstmt.setDouble(pstmt.getResultSet().getInt("percentual_periculosidade"), obj.getPercentualPericulosidade());
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
	
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.cbo1994";	
		conexao.criarConexao().createStatement().executeUpdate(limpar);	
		System.out.println("Limpeza realizada.");
	}
	
}

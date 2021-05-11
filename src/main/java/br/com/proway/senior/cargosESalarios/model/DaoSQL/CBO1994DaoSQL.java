package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.FactoryPostgres;
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
		String sqlInsert = "INSERT INTO grupo2.cbo1994 (descricao, percentual_insalubridade, percentual_periculosidade) VALUES (?,?,?)";
		int quantidadeRegistros = 0;
		try {
			PreparedStatement pstmt = conexao.criarConexao().prepareStatement(sqlInsert);
			pstmt.setString(1, obj.getDescricao());
			pstmt.setDouble(2, obj.getPercentualInsalubridade());
			pstmt.setDouble(3, obj.getPercentualPericulosidade());
			pstmt.execute();
			pstmt.close();
			String sqlCount = "SELECT COUNT(*) FROM grupo2.cbo1994";
			ResultSet rs = conexao.criarConexao().createStatement().executeQuery(sqlCount);
			rs.next();
			quantidadeRegistros = rs.getInt(1);
			System.out.println("CBO 1994 cadastrado com sucesso.");
			return quantidadeRegistros;
		} catch (SQLException e) {
			System.out.println("Falha ao cadastrar o CBO 1994");
			e.printStackTrace();
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
		// TODO Auto-generated method stub
		return null;
	}
	
}

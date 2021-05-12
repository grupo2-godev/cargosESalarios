package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.GrauInstrucaoDAO;

public class GrauInstrucaoDAOTest2 {

	ConnectionPostgres conexao = new ConnectionPostgres();
	GrauInstrucaoDAO giSql = new GrauInstrucaoDAO(conexao.conectar());
	
	@Test
	public void testCreate() {
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Medio");
		giSql.create(gi);
		String sql = "SELECT descricao FROM grau_de_instrucao";
		ResultSet rs;
		try {
			rs = ConnectionPostgres.executeQuery(sql);
			rs.next();
			assertEquals("Ensino Medio", rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

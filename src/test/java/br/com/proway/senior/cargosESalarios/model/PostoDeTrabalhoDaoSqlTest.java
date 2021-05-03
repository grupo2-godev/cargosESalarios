package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

public class PostoDeTrabalhoDaoSqlTest {

	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	PostoDeTrabalhoDaoSql postoSql = new PostoDeTrabalhoDaoSql();
	ConnectionPostgres conexao = new ConnectionPostgres();
	
	
	@Test
	public void testCreateSql() throws SQLException {
		postoSql.create(posto);
		String sql = "SELECT COUNT(*) FROM grupo2.posto_de_trabalho";
		ResultSet rs = conexao.executeQuery(sql);
		rs.next();
		rs.getInt(1);
		assertEquals(1, rs.getInt(1));
	}
	
//	@Before
//	public void limparTabela() throws SQLException {
//		postoSql.limparTabela();
//	}

}

package br.com.proway.senior.cargosESalarios.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.SetorDaoSql;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Testes da classe ConnectionPostgres.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class ConnectionPostgresTest {

	SetorDaoSql setorSQL = new SetorDaoSql();
	
	@Test
	public void testConectar() {
		ConnectionPostgres conexao = new ConnectionPostgres();
		assertNotNull(conexao.conectar());
	}
	
	@Test
	public void testConectarErro() {
		ConnectionPostgres conexao = new ConnectionPostgres();
		conexao.setSenha("ABCDE");
		assertNull(conexao.conectar());
	}
	
	@Test
	public void dbVersionTest() throws SQLException {
		ConnectionPostgres conexao = new ConnectionPostgres();
		assertEquals("Conectado com sucesso.", conexao.dbVersion());
	}
	
	@Test
	public void getInstanceTest() {
		ConnectionPostgres conexao = new ConnectionPostgres();
		assertNotNull(conexao.getInstance());
	}

	@Test (expected = Exception.class)
	public void executeQueryErroTest() throws SQLException {
		setorSQL.limparTabela();
		String sql = "";
		ConnectionPostgres conexao = new ConnectionPostgres();
		conexao.executeQuery(sql);
	}
	
	@Test
	public void executeQueryOkTest() throws SQLException {
		setorSQL.limparTabela();
		String nomeSetor1 = "ERP I";
		Integer idPermissao1 = 3;
		SetorModel setor1 = new SetorModel(nomeSetor1, idPermissao1);
		SetorDaoSql setorSQL = new SetorDaoSql();
		setorSQL.create(setor1);
		String sql = "SELECT * FROM grupo2.setor";
		ConnectionPostgres conexao = new ConnectionPostgres();
		assertEquals(true, conexao.executeQuery(sql).next());	
	}
	
	@Test (expected = Exception.class)
	public void executeUpdateErroTest() throws SQLException {
		String sql = "";
		ConnectionPostgres conexao = new ConnectionPostgres();
		conexao.executeUpdate(sql);
	}
}

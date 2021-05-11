package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;

public class CBO1994DaoSQLTest {

	Integer codigo_cbo = 345678;
	String descricao = "descricao";
	Double percentual_insalubridade = 0.3;
	Double percentual_periculosidade = 0.2;
	CBO1994DaoSQL cbo1994Sql = new CBO1994DaoSQL();	
	FactoryConexao conexao = new FactoryPostgres();
	
	@After
	public void limparTabela() throws SQLException {
			cbo1994Sql.limparTabela();
			assertEquals(0, cbo1994Sql.getAll().size());
	}
	
	@Test
	public void testCreate() {
		Cbo1994Model cbo1994 = new Cbo1994Model(codigo_cbo, descricao, percentual_insalubridade, percentual_periculosidade);
		cbo1994Sql.create(cbo1994);	
		assertEquals(1, cbo1994Sql.getAll().size());		
	}

	@Test
	public void testRetrieve() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}

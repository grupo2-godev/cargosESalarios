package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;

public class CBO1994DAOTest {

	Integer codigo_cbo = 345678;
	String descricao = "descricao";
	Double percentual_insalubridade = 0.3;
	Double percentual_periculosidade = 0.2;
	CBO1994DAO cbo1994Sql = CBO1994DAO.getInstance(ConnectionHibernate.getSession());	
	FactoryConexao conexao = new FactoryPostgres();

	@Test
	public void testGetInstance() {
		CBO1994DAO test_getInstance1 = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
		CBO1994DAO test_getInstance2 = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
		assertEquals(test_getInstance1, test_getInstance2);		
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

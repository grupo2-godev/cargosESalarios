package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

public class CBO1994DAOTest {

	Integer codigo_cbo = 345678;
	String descricao = "descricao";
	Double percentual_insalubridade = 0.3;
	Double percentual_periculosidade = 0.2;
	CBO1994DAO CBO1994Dao = CBO1994DAO.getInstance(ConnectionHibernate.getSession());	
	FactoryConexao conexao = new FactoryPostgres();

	@Test
	public void testGetInstance() {
		CBO1994DAO test_getInstance1 = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
		CBO1994DAO test_getInstance2 = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
		assertEquals(test_getInstance1, test_getInstance2);		
	}			
	
	@Test
	public void testCriaUmCBO1994() {
		try {
			CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", 0.3, 0.4);
			Integer codigo_CBO1994 = CBO1994Dao.create(CBO1994);
			Object CBO1994Consultado = ConnectionHibernate.getSession().get(CBO1994Model.class, codigo_CBO1994);
			assertEquals(codigo_CBO1994, ((CBO1994Model) CBO1994Consultado).getCodigo_cbo());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testBuscaCBO1994InformadoNumaListaContendoDoisObjetos() {
		CBO1994Dao.create(new CBO1994Model(45343, "analista", 0.2, 0.1));
		
		CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", 0.3, 0.4);
		CBO1994Model novo_CBO1994 = CBO1994Dao.retrieve(CBO1994Dao.create(CBO1994));
		assertEquals(CBO1994.getCodigo_cbo(), novo_CBO1994.getCodigo_cbo());
		assertEquals(CBO1994.getDescricao(), novo_CBO1994.getDescricao());
		assertEquals(CBO1994.getPercentualInsalubridade(), novo_CBO1994.getPercentualInsalubridade());
		assertEquals(CBO1994.getPercentualPericulosidade(), novo_CBO1994.getPercentualPericulosidade());		
	}

	@Test
	public void testUpdateCBO1994() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCBO1994() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCBO1994() {
		fail("Not yet implemented");
	}

}

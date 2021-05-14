package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import utils.Insalubridade;
import utils.Periculosidade;

public class CBO1994DAOTest {

	Integer codigo_cbo = 345678;
	String descricao = "descricao";
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
			CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Quarenta.getValor(), Periculosidade.Trinta.getValor());
			Integer codigo_CBO1994 = CBO1994Dao.create(CBO1994);
			Object CBO1994Consultado = ConnectionHibernate.getSession().get(CBO1994Model.class, codigo_CBO1994);
			assertEquals(codigo_CBO1994, ((CBO1994Model) CBO1994Consultado).getCodigo_cbo());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testBuscaCBO1994InformadoNumaListaContendoDoisObjetos() {
		CBO1994Dao.create(new CBO1994Model(45343, "analista", Insalubridade.Vinte.getValor(), Periculosidade.Zero.getValor()));
		
		CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Quarenta.getValor(), Periculosidade.Trinta.getValor());
		CBO1994Model novo_CBO1994 = CBO1994Dao.retrieve(CBO1994Dao.create(CBO1994));
		assertEquals(CBO1994.getCodigo_cbo(), novo_CBO1994.getCodigo_cbo());
		assertEquals(CBO1994.getDescricao(), novo_CBO1994.getDescricao());
		assertEquals(CBO1994.getPercentualInsalubridade(), novo_CBO1994.getPercentualInsalubridade());
		assertEquals(CBO1994.getPercentualPericulosidade(), novo_CBO1994.getPercentualPericulosidade());		
	}

	@Test
	public void testUpdateCBO1994() {
		CBO1994Model CBO1994_cadastrado = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		CBO1994Model CBO1994_alterado = new CBO1994Model(44576, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		
		int codigo_CBO1994 = CBO1994Dao.create(CBO1994_cadastrado);
		
		CBO1994Dao.update(codigo_CBO1994, CBO1994_alterado);
		
		CBO1994Model novo_CBO1994 = CBO1994Dao.retrieve(codigo_CBO1994);
		assertEquals(CBO1994_alterado.getCodigo_cbo(), novo_CBO1994.getCodigo_cbo());
		assertEquals(CBO1994_alterado.getDescricao(), novo_CBO1994.getDescricao());
		assertEquals(CBO1994_alterado.getPercentualInsalubridade(), novo_CBO1994.getPercentualInsalubridade());
		assertEquals(CBO1994_alterado.getPercentualPericulosidade(), novo_CBO1994.getPercentualPericulosidade());
	}

	@Test
	public void testDeleteCBO1994() {
		int size_inicial = CBO1994Dao.getAll().size();
		CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		int codigo_CBO1994 = CBO1994Dao.create(CBO1994);
		CBO1994Dao.delete(codigo_CBO1994);
		assertEquals(size_inicial, CBO1994Dao.getAll().size());
	}

	@Test
	public void testGetAllCBO1994() {
		CBO1994Dao.create(new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.create(new CBO1994Model(44577, "desenvolvedor pleno", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.create(new CBO1994Model(44578, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		
		assertFalse(CBO1994Dao.getAll().isEmpty());
		assertEquals(3, CBO1994Dao.getAll().size());
	}
	
	@Test
	public void testDeleteAllCBO1994() {
		CBO1994Dao.create(new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.create(new CBO1994Model(44577, "desenvolvedor pleno", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.create(new CBO1994Model(44578, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));

		CBO1994Dao.deleteAll();
		
		assertTrue(CBO1994Dao.getAll().isEmpty());
	}
	
	@Before
	public void limparBancoDeDados() {
		CBO1994Dao.deleteAll();
	}
}

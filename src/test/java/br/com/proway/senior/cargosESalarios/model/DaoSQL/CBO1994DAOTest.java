package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.utils.Insalubridade;
import br.com.proway.senior.cargosESalarios.utils.Periculosidade;

public class CBO1994DAOTest {

	Integer codigo_cbo = 345678;
	String descricao = "descricao";
	CBO1994DAO CBO1994Dao = CBO1994DAO.getInstancia(ConexaoHibernate.getSessao());	

	@Test
	public void testCriarObjetoVazio() {
		CBO1994Model CBO1994 = new CBO1994Model();
		assertNull(CBO1994.getCodigo_cbo());
		assertNull(CBO1994.getDescricao());
		assertNull(CBO1994.getPercentualInsalubridade());
		assertNull(CBO1994.getPercentualPericulosidade());
		assertEquals("CBO1994Model [codigo_cbo=null, descricao=null, percentualInsalubridade=null, percentualPericulosidade=null]", CBO1994.toString());
	}   
	
	@Test
	public void testGetInstance() {
		CBO1994DAO test_getInstance1 = CBO1994DAO.getInstancia(ConexaoHibernate.getSessao());
		CBO1994DAO test_getInstance2 = CBO1994DAO.getInstancia(ConexaoHibernate.getSessao());
		assertEquals(test_getInstance1, test_getInstance2);		
	}			
	
	@Test
	public void testCriaUmCBO1994() {
			CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Quarenta.getValor(), Periculosidade.Trinta.getValor());
			Integer codigo_CBO1994 = CBO1994Dao.criar(CBO1994);
			Object CBO1994Consultado = ConexaoHibernate.getSessao().get(CBO1994Model.class, codigo_CBO1994);
			assertEquals(codigo_CBO1994, ((CBO1994Model) CBO1994Consultado).getCodigo_cbo());
	}

	@Test
	public void testBuscaCBO1994InformadoNumaListaContendoDoisObjetos() {
		CBO1994Dao.criar(new CBO1994Model(45343, "analista", Insalubridade.Vinte.getValor(), Periculosidade.Zero.getValor()));
		
		CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Quarenta.getValor(), Periculosidade.Trinta.getValor());
		CBO1994Model novo_CBO1994 = CBO1994Dao.buscar(CBO1994Dao.criar(CBO1994));
		assertEquals(CBO1994.getCodigo_cbo(), novo_CBO1994.getCodigo_cbo());
		assertEquals(CBO1994.getDescricao(), novo_CBO1994.getDescricao());
		assertEquals(CBO1994.getPercentualInsalubridade(), novo_CBO1994.getPercentualInsalubridade());
		assertEquals(CBO1994.getPercentualPericulosidade(), novo_CBO1994.getPercentualPericulosidade());		
	}

	@Test
	public void testUpdateCBO1994() {
		CBO1994Model CBO1994_cadastrado = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		CBO1994Model CBO1994_alterado = new CBO1994Model(44576, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		
		int codigo_CBO1994 = CBO1994Dao.criar(CBO1994_cadastrado);
		
		CBO1994Dao.atualizar(codigo_CBO1994, CBO1994_alterado);
		
		CBO1994Model novo_CBO1994 = CBO1994Dao.buscar(codigo_CBO1994);
		assertEquals(CBO1994_alterado.getCodigo_cbo(), novo_CBO1994.getCodigo_cbo());
		assertEquals(CBO1994_alterado.getDescricao(), novo_CBO1994.getDescricao());
		assertEquals(CBO1994_alterado.getPercentualInsalubridade(), novo_CBO1994.getPercentualInsalubridade());
		assertEquals(CBO1994_alterado.getPercentualPericulosidade(), novo_CBO1994.getPercentualPericulosidade());
	}

	@Test
	public void testDeleteCBO1994() {
		int size_inicial = CBO1994Dao.buscarTodos().size();
		CBO1994Model CBO1994 = new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor());
		int codigo_CBO1994 = CBO1994Dao.criar(CBO1994);
		CBO1994Dao.deletar(codigo_CBO1994);
		assertEquals(size_inicial, CBO1994Dao.buscarTodos().size());
	}

	@Test
	public void testGetAllCBO1994() {
		CBO1994Dao.criar(new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.criar(new CBO1994Model(44577, "desenvolvedor pleno", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.criar(new CBO1994Model(44578, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		
		assertFalse(CBO1994Dao.buscarTodos().isEmpty());
		assertEquals(3, CBO1994Dao.buscarTodos().size());
	}
	
	@Test
	public void testDeleteAllCBO1994() {
		CBO1994Dao.criar(new CBO1994Model(44576, "desenvolvedor", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.criar(new CBO1994Model(44577, "desenvolvedor pleno", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));
		CBO1994Dao.criar(new CBO1994Model(44578, "desenvolvedor senior", Insalubridade.Vinte.getValor(), Periculosidade.Trinta.getValor()));

		CBO1994Dao.deletarTodos();
		
		assertTrue(CBO1994Dao.buscarTodos().isEmpty());
	}
	
	@Before
	public void limparBancoDeDados() {
		CBO1994Dao.deletarTodos();
	}
}

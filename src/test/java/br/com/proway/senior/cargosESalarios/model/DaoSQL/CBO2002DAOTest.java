package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Classe CBO2002DAOTest.
 * 
 * Classe que testa os métodos da classe CBO2002DAO.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class CBO2002DAOTest {
        
	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstancia();
	
	@Test
	public void testCriarObjetoVazio() {
		CBO2002Model CBO2002 = new CBO2002Model();
		assertNull(CBO2002.getCodigoCBO2002());
		assertNull(CBO2002.getDescricao());
		assertNull(CBO2002.getPercentualInsalubridade());
		assertNull(CBO2002.getPercentualPericulosidade());
		assertEquals("CBO2002Model [codigoCBO2002=null, descricao=null, percentualInsalubridade=null, percentualPericulosidade=null]", CBO2002.toString());
	}       
	
    @Test
    public void testInserirCBO2002() {
        CBO2002Model novoCBO = new CBO2002Model(784205, "Abastecedor de máquinas de "
        		+ "linha de produção", Insalubridade.Zero.getValor(), Periculosidade.Trinta.getValor());
        Integer codigoCboCadastrado = cbo2002DAO.criar(novoCBO);
        Object CBOConsultado = ConexaoHibernate.getSessao().get(CBO2002Model.class, codigoCboCadastrado);
        assertEquals(codigoCboCadastrado, ((CBO2002Model) CBOConsultado).getCodigoCBO2002());   
    }

    @Test
    public void testBuscarCBO2002PorID() {
    	CBO2002Model novoCBO = new CBO2002Model(765010, "Padronista de chapéus", Insalubridade.Zero.getValor(), 
    				Periculosidade.Zero.getValor());
    	CBO2002Model cboRetornado = cbo2002DAO.buscar(CBO2002Model.class, cbo2002DAO.criar(novoCBO));
    	assertEquals(novoCBO.getDescricao(), cboRetornado.getDescricao());
    	assertEquals(novoCBO.getPercentualInsalubridade(), cboRetornado.getPercentualInsalubridade());
    	assertEquals(novoCBO.getPercentualPericulosidade(), cboRetornado.getPercentualPericulosidade());
    }
    
    @Test
    public void testBuscarCBO2002PorDescricao() {
    	CBO2002Model novoCBO = new CBO2002Model(261305, "Administrador de Arquivos", Insalubridade.Zero.getValor(), 
    				Periculosidade.Zero.getValor());
    	cbo2002DAO.criar(novoCBO);
    	ArrayList<CBO2002Model> cboRetornado = (ArrayList<CBO2002Model>) cbo2002DAO.listarPorValorDeColunaComStringIncompleta(CBO2002Model.class, "cbo2002", "Arqu");
    	assertEquals(novoCBO.getDescricao(), cboRetornado.get(0).getDescricao());
    	assertEquals(novoCBO.getPercentualInsalubridade(), cboRetornado.get(0).getPercentualInsalubridade());
    	assertEquals(novoCBO.getPercentualPericulosidade(), cboRetornado.get(0).getPercentualPericulosidade());
    }

    @Test
    public void testAtualizarCBO2002() {
    	CBO2002Model novoCBO = new CBO2002Model(223405, "Farmacêutico", Insalubridade.Vinte.getValor(), 
    				Periculosidade.Zero.getValor());
    	CBO2002Model cboAlterado = new CBO2002Model(223405, "Farmacêutico(a)", Insalubridade.Vinte.getValor(), 
    				Periculosidade.Zero.getValor());
    	int codigo = cbo2002DAO.criar(novoCBO);
    	cbo2002DAO.atualizar(codigo, cboAlterado);
    	CBO2002Model alterado = cbo2002DAO.buscar(CBO2002Model.class, codigo);
    	assertEquals(alterado.getDescricao(), cboAlterado.getDescricao());
    	assertEquals(alterado.getPercentualInsalubridade(), cboAlterado.getPercentualInsalubridade());
    	assertEquals(alterado.getPercentualPericulosidade(), cboAlterado.getPercentualPericulosidade());
    }
    
    @Test
    public void testDeletarCBO() {
    	int size = cbo2002DAO.listarPorTabela(CBO2002Model.class).size();
    	CBO2002Model novoCBO = new CBO2002Model(351415, "Tabelião substituto", Insalubridade.Zero.getValor(),
    				Periculosidade.Zero.getValor());
    	int codigoCbo = cbo2002DAO.criar(novoCBO);
    	cbo2002DAO.deletar(CBO2002Model.class, codigoCbo);
    	assertEquals(size, cbo2002DAO.listarPorTabela(CBO2002Model.class).size());
    }
    
    @Test
    public void testListarTodosCBOs2002() {
    	CBO2002Model novoCBO = new CBO2002Model(262810, "Dançarino", Insalubridade.Zero.getValor(), 
    				Periculosidade.Zero.getValor());
    	cbo2002DAO.criar(novoCBO);
    	assertFalse(cbo2002DAO.listarPorTabela(CBO2002Model.class).isEmpty());
    }  

    @Test
    public void deleteAll() {
    	CBO2002Model cbo1 = new CBO2002Model(241005, "Advogado", Insalubridade.Zero.getValor(), 
    				Periculosidade.Zero.getValor());
    	cbo2002DAO.criar(cbo1);
    	CBO2002Model cbo2 = new CBO2002Model(234604, "Professor de língua alema", Insalubridade.Zero.getValor(), 
    				Periculosidade.Zero.getValor());
    	cbo2002DAO.criar(cbo2);
    	cbo2002DAO.deletarTodos("cbo2002");
    	assertTrue(cbo2002DAO.listarPorTabela(CBO2002Model.class).isEmpty());
    }
    
    @Before
    public void limparTabela() {
    	cbo2002DAO.deletarTodos("cbo2002");
    }
}
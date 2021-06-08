package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.DAO.CBO1994DAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class CBO1994ControllerTest {
	
	CBO1994Controller controller = CBO1994Controller.getInstancia();
	CBO1994DAO dao = CBO1994DAO.getInstancia();
	
	@Before
	public void resetarSequencia(){
		controller.deletarTodosCBO1994();
	}	
	
	@Test
	public void testCadastrarUmCBO1994() throws Exception {
		int sizeOriginal = controller.buscarTodosCBO1994().size();
		
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.4, 0.0);
		
		assertEquals(sizeOriginal+1, controller.buscarTodosCBO1994().size());
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarCBO1994JaExistente() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.0, 0.0);
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.0, 0.0);
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarCBO1994ComCodigoInvalido() throws Exception {
		controller.cadastrarCBO1994(1234567, "desenvolvedor", 0.0, 0.0);
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarCBO1994ComDescricaoInvalida() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor@", 0.0, 0.0);
	}

	@Test
	public void testBuscarCBO1994() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.0, 0.0);
		
		int codigo_CBO1994 = controller.cadastrarCBO1994(44578, "desenvolvedor senior", 0.0, 0.3);
		
		assertEquals(controller.buscarCBO1994(codigo_CBO1994).getCodigo_cbo(), (Integer) 44578);		
		assertEquals(controller.buscarCBO1994(codigo_CBO1994).getDescricao(), "desenvolvedor senior");
		assertTrue(controller.buscarTodosCBO1994().size() > 1);
	}
	
	@Test (expected = Exception.class)
	public void testBuscarCBO1994Inexistente() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.0, 0.0);
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", 0.0, 0.3);

		controller.buscarCBO1994(54000);
	}
	
	@Test (expected = Exception.class)
	public void testBuscarCBO1994Invalido() throws Exception {
		controller.buscarCBO1994(540000);
	}	
	
	@Test
	public void testAtualizarCBO1994() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor", 0.0d,  0.0);
				
		assertTrue(controller.atualizarCBO1994(codigo_CBO1994, "desenvolvedor senior", 0.0, 0.0));
	}
	
	@Test
	public void testAtualizarCBO1994ObjetosIguais() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", 0.0, 0.0);
		
		assertFalse(controller.atualizarCBO1994(codigo_CBO1994, "desenvolvedor senior", 0.0, 0.0));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarCBO1994Inexistente() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", 0.0, 0.0);

		controller.atualizarCBO1994(codigo_CBO1994+1, "desenvolvedor senior", 0.0, 0.0);
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarCBO1994ComDescricaoInvalida() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", 0.0, 0.0);
		
		controller.atualizarCBO1994(codigo_CBO1994, "desenvolvedor senior@", 0.0, 0.0);
	}	

	@Test
	public void testDeletarCBO1994() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosCBO1994().size();
		
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", 0.0, 0.0);
		controller.deletarCBO1994(codigo_CBO1994);
		assertEquals(sizeAntesDoTest, controller.buscarTodosCBO1994().size());
	}
	
	@Test(expected = Exception.class)
	public void testDeletarCBO1994Inexistente() throws Exception {
		//controller.cadastrarCBO1994(44576, "desenvolvedor senior", 0.0, 0.0);
		controller.deletarCBO1994(10000);
	}

	@Test
	public void testBuscarTodosCBO1994() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosCBO1994().size();
		
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.2, 0.3);
		controller.cadastrarCBO1994(44577, "desenvolvedor pleno", 0.2, 0.3);
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", 0.2, 0.3);
		
		
		ArrayList<CBO1994Model> listaRetornada = controller.buscarTodosCBO1994();
		int sizeDepoisDoTest = listaRetornada.size();
	
		assertFalse(listaRetornada.isEmpty());
		assertNotEquals(sizeAntesDoTest, sizeDepoisDoTest);
	}
	
	@Test
	public void testBuscarTodosCBO1994SemCBO1994Registrados() throws Exception {
		controller.deletarTodosCBO1994();
		ArrayList<CBO1994Model> listaRetornada = controller.buscarTodosCBO1994();
		assertTrue(listaRetornada.isEmpty());
	}
	
	@Test
	public void testBuscarTodosCBO1994PorDescricaoParcial() throws Exception {
		controller.deletarTodosCBO1994();
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.2, 0.3);
		ArrayList<CBO1994Model> listaRetornada = controller.buscarPorDescricaoParcial("desenvolvedor");
		assertEquals(1, listaRetornada.size());
	}

	@Test
	public void testDeletarTodosCBO1994() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.2, 0.3);
		controller.cadastrarCBO1994(44577, "desenvolvedor pleno", 0.2, 0.3);
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", 0.2, 0.3);
		
		controller.deletarTodosCBO1994();
		ArrayList<CBO1994Model> listaRetornada = controller.buscarTodosCBO1994();
		assertTrue(listaRetornada.isEmpty());
	}

}

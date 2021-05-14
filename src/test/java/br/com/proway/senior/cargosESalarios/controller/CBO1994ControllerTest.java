package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import utils.Insalubridade;
import utils.Periculosidade;

public class CBO1994ControllerTest {
	
	CBO1994Controller controller = CBO1994Controller.getInstance();
	
	@Before
	public void resetarSequencia(){
		controller.deletarTodosCBO1994();
	}
	
	
	@Test
	public void testCadastrarUmCBO1994() throws Exception {
		int sizeOriginal = controller.buscarTodosCBO1994().size();
		
		controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Quarenta, Periculosidade.Zero);
		
		assertEquals(sizeOriginal+1, controller.buscarTodosCBO1994().size());
	}
	
//	@Test (expected = Exception.class)
//	public void testCadastrarNivelInvalido() throws Exception {
//		controller.cadastrarNivel("suprem0sk8!");
//	}

	@Test
	public void testBuscarCBO1994() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Zero, Periculosidade.Zero);
		
		int codigo_CBO1994 = controller.cadastrarCBO1994(44578, "desenvolvedor senior", Insalubridade.Dez, Periculosidade.Trinta);
		
		assertEquals(controller.buscarCBO1994(codigo_CBO1994).getCodigo_cbo(), (Integer) 44578);		
		assertEquals(controller.buscarCBO1994(codigo_CBO1994).getDescricao(), "desenvolvedor senior");
		assertTrue(controller.buscarTodosCBO1994().size() > 1);
	}
	
	@Test (expected = Exception.class)
	public void testBuscarCBO1994Invalido() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Zero, Periculosidade.Zero);		
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", Insalubridade.Dez, Periculosidade.Trinta);

		controller.buscarCBO1994(54000);
	}

	@Test
	public void testAtualizarCBO1994() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Zero, Periculosidade.Zero);
		
		CBO1994Model objetoAtualizado = new CBO1994Model(44576, "desenvolvedor senior", Insalubridade.Zero.getValor(), Periculosidade.Zero.getValor());
		
		assertTrue(controller.atualizarCBO1994(codigo_CBO1994, objetoAtualizado));
	}
	
	@Test
	public void testAtualizarCBO1994ObjetosIguais() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", Insalubridade.Zero, Periculosidade.Zero);
		CBO1994Model objetoAtualizado = new CBO1994Model(44576, "desenvolvedor senior", Insalubridade.Zero.getValor(), Periculosidade.Zero.getValor());
		
		assertFalse(controller.atualizarCBO1994(codigo_CBO1994, objetoAtualizado));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarCBO1994Inexistente() throws Exception {
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", Insalubridade.Zero, Periculosidade.Zero);

		controller.atualizarCBO1994(10000, controller.buscarCBO1994(codigo_CBO1994));
	}

	@Test
	public void testDeletarCBO1994() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosCBO1994().size();
		
		int codigo_CBO1994 = controller.cadastrarCBO1994(44576, "desenvolvedor senior", Insalubridade.Zero, Periculosidade.Zero);
		controller.deletarCBO1994(codigo_CBO1994);
		assertEquals(sizeAntesDoTest, controller.buscarTodosCBO1994().size());
	}
	
	@Test(expected = Exception.class)
	public void testDeletarCBO1994Inexistente() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor senior", Insalubridade.Zero, Periculosidade.Zero);
		controller.deletarCBO1994(10000);
	}

	@Test
	public void testBuscarTodosCBO1994() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosCBO1994().size();
		
		controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Vinte, Periculosidade.Trinta);
		controller.cadastrarCBO1994(44577, "desenvolvedor pleno", Insalubridade.Vinte, Periculosidade.Trinta);
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", Insalubridade.Vinte, Periculosidade.Trinta);
		
		
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
	public void testDeletarTodosCBO1994() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", Insalubridade.Vinte, Periculosidade.Trinta);
		controller.cadastrarCBO1994(44577, "desenvolvedor pleno", Insalubridade.Vinte, Periculosidade.Trinta);
		controller.cadastrarCBO1994(44578, "desenvolvedor senior", Insalubridade.Vinte, Periculosidade.Trinta);
		
		controller.deletarTodosCBO1994();
		ArrayList<CBO1994Model> listaRetornada = controller.buscarTodosCBO1994();
		assertTrue(listaRetornada.isEmpty());
	}

}

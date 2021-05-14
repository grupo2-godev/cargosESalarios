package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class CBO1994ControllerTest {
	
	CBO1994Controller controller = CBO1994Controller.getInstance();
	
	@Before
	public void resetarSequencia(){
		controller.deletarTodosCBO1994();
	}
	
	
	@Test
	public void testCadastrarUmCBO1994() throws Exception {
		int sizeOriginal = controller.buscarTodosCBO1994().size();
		
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.3, 0.4);
		
		assertEquals(sizeOriginal+1, controller.buscarTodosCBO1994().size());
	}
	
//	@Test (expected = Exception.class)
//	public void testCadastrarNivelInvalido() throws Exception {
//		controller.cadastrarNivel("suprem0sk8!");
//	}

	@Test
	public void testBuscarCBO1994() throws Exception {
		controller.cadastrarCBO1994(44576, "desenvolvedor", 0.3, 0.4);
		
		int codigo_CBO1994 = controller.cadastrarCBO1994(44578, "desenvolvedor senior", 0.3, 0.4);
		
		assertNotNull(controller.buscarCBO1994(codigo_CBO1994));
		assertTrue(controller.buscarTodosCBO1994().size() > 1);
	}
	
	@Test (expected = Exception.class)
	public void testBuscarNivelInvalido() throws Exception {
		controller.cadastrarNivel("Invalidando");
		controller.cadastrarNivel("Invalidandooo");
		int ultimoId = controller.cadastrarNivel("Invalidandoooooooo");
		
		controller.buscarNivel(ultimoId+ 1);
	}

	@Test
	public void testAtualizarNivel() throws Exception {
		int idASerAtualizado = controller.cadastrarNivel("Carro");
		NivelModel ObjetoAtualizado = new NivelModel("Moto");
		
		assertTrue(controller.atualizarNivel(idASerAtualizado, ObjetoAtualizado));
	}
	
	@Test
	public void testAtualizarNivelObjetosIguais() throws Exception {
		int idASerAtualizado = controller.cadastrarNivel("Moto");
		NivelModel ObjetoAtualizado = new NivelModel("Moto");
		
		assertFalse(controller.atualizarNivel(idASerAtualizado, ObjetoAtualizado));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarNivelInexistente() throws Exception {
		int idInexistente = controller.buscarTodosNiveis().size() + 1;
		NivelModel ObjetoAtualizado = new NivelModel("Moto");
		
		controller.atualizarNivel(idInexistente, ObjetoAtualizado);
	}

	@Test
	public void testDeletarNivel() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosNiveis().size();
		
		int idTest = controller.cadastrarNivel("OutroNivel");
		controller.deletarNivel(idTest);
		assertEquals(sizeAntesDoTest, controller.buscarTodosNiveis().size());
	}
	
	@Test(expected = Exception.class)
	public void testDeletarNivelInexistente() throws Exception {
		int idInvalido = controller.buscarTodosNiveis().size();
		controller.deletarNivel(idInvalido);
	}

	@Test
	public void testBuscarTodosNiveis() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosNiveis().size();
		
		controller.cadastrarNivel("Um");
		controller.cadastrarNivel("Dois");
		controller.cadastrarNivel("Tres");
		
		ArrayList<NivelModel> listaRetornada = controller.buscarTodosNiveis();
		int sizeDepoisDoTest = listaRetornada.size();
	
		assertFalse(listaRetornada.isEmpty());
		assertNotEquals(sizeAntesDoTest, sizeDepoisDoTest);
	}
	
	@Test
	public void testBuscarTodosNiveisSemNiveis() throws Exception {
		controller.deletarTodosNiveis();
		ArrayList<NivelModel> listaRetornada = controller.buscarTodosNiveis();
		assertTrue(listaRetornada.isEmpty());
	}

	@Test
	public void testDeletarTodosNiveis() throws Exception {
		controller.cadastrarNivel("Um");
		controller.cadastrarNivel("Dois");
		controller.cadastrarNivel("Tres");
		controller.deletarTodosNiveis();
		ArrayList<NivelModel> listaRetornada = controller.buscarTodosNiveis();
		assertTrue(listaRetornada.isEmpty());
	}

}

package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelControllerTest {
	NivelController controller = new NivelController();
	
	@Before
	public void resetarSequencia(){
		controller.deletarTodosNiveis();
		ConexaoHibernate.getSessao();
	}	
	
	@Test
	public void testCadastrarNivel() throws Exception {
		int idGerado = controller.cadastrarNivel("supremo");
		assertTrue(idGerado > 0);
		assertTrue(controller.buscarTodosNiveis().size() > 0);
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarNivelInvalido() throws Exception {
		controller.cadastrarNivel("suprem0sk8!");
	}

	@Test
	public void testBuscarNivel() throws Exception {
		controller.cadastrarNivel("nivel");
		int idTest = controller.cadastrarNivel("OutroNivel");
		NivelModel retornado = controller.buscarNivel(idTest);
		assertNotNull(retornado);
		assertTrue(controller.buscarTodosNiveis().size() > 1);
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
		
		assertTrue(controller.atualizar(idASerAtualizado, "Moto"));
	}
	
	@Test
	public void testAtualizarNivelObjetosIguais() throws Exception {
		int idASerAtualizado = controller.cadastrarNivel("Moto");
		
		assertFalse(controller.atualizar(idASerAtualizado, "Moto"));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarNivelInexistente() throws Exception {
		int idInexistente = controller.buscarTodosNiveis().size() + 1;
		
		controller.atualizar(idInexistente, "Moto");
		
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
	
	@Test
	public void testSetId() throws Exception {
		NivelModel nivel = new NivelModel("teste");	
		nivel.setId(1);
		assertNotNull(nivel.getId());
	}

}

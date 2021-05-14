package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.GrauInstrucaoDAO;

/**
 * Classe dependente da finaliza��o do GrauInstrucaoController. Pode ser
 * exluida. att
 */

public class GrauInstrucaoControllerTest {

	GrauInstrucaoController controller = new GrauInstrucaoController();

	@Test
	public void testCadastrar() throws Exception {
		controller.cadastrar("Ensino Medio Completo");
		assertEquals(1, controller.buscarTodos().size());
	}

	@Test(expected = Exception.class)
	public void testCadastrarGrauInstrucaoInvalido() throws Exception {
		controller.cadastrar("Ensino medio!@.");
	}

	@Test
	public void testBuscarPorId() throws Exception {
		int idCadastrado = controller.cadastrar("Ensino Medio Completo");
		GrauInstrucaoModel grauInstrucao = controller.buscarPorId(idCadastrado);
		assertNotNull(grauInstrucao);
		assertEquals("Ensino Medio Completo", grauInstrucao.getNome());
	}
	
	@Test (expected = Exception.class)
	public void testBuscarPorIdInvalido() throws Exception {
		controller.buscarPorId(0);
	}

	@Test
	public void testBuscarPorNomeQueContenha() throws Exception {
		controller.cadastrar("Ensino Medio Completo");
		controller.cadastrar("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarPorNomeQueContenha("Ensino Medio").size());
		assertEquals(0, controller.buscarPorNomeQueContenha("Palavra aleatória").size());
	}
	
	@Test(expected = Exception.class)
	public void testBuscarPorNomeQueContenhaInvalido() throws Exception {
		controller.buscarPorNomeQueContenha("Ensino@!#");
	}
	
	@Test
	public void testAlterar() throws Exception {
		Integer idCadastrado = controller.cadastrar("Ensino Medio Completo");
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel();
		grauInstrucao.setNome("Ensino Alterado");
		controller.alterar(idCadastrado, grauInstrucao);
		assertEquals("Ensino Alterado", controller.buscarPorId(idCadastrado).getNome());
	}
	
	@Test
	public void testDeletarPorId() throws Exception {
		Integer idCadastrado = controller.cadastrar("Ensino Medio Completo");
		assertEquals(1, controller.buscarTodos().size());
		controller.deletarPorId(idCadastrado);
		assertNull(controller.buscarTodos());
	}
	
	@Test(expected = Exception.class)
	public void testDeletarPorIdInexistente() {
		assertNull(controller.buscarTodos());
		controller.deletarPorId(2);
	}
	
	@Test(expected = Exception.class)
	public void testDeletarPorIdIgualAZero() {
		assertNull(controller.buscarTodos());
		controller.deletarPorId(0);
	}

	@Test
	public void testBuscarTodos() throws Exception {
		assertEquals(0, controller.buscarTodos().size());
		controller.cadastrar("Ensino Medio Completo");
		controller.cadastrar("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarTodos().size());
	}

	@Test
	public void testDeletarTodos() throws Exception {
		controller.cadastrar("Ensino Medio Completo");
		controller.cadastrar("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarTodos().size());
		controller.deletarTodos();
		ArrayList<GrauInstrucaoModel> lista = controller.buscarTodos();
		assertTrue(lista.isEmpty());
	}

	@Before
	public void beforeAll() {
		controller.deletarTodos();
	}

}

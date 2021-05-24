package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;

/**
 * Classe que testa os metodos da classe {@link GrauInstrucaoController}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoControllerTest {

	GrauInstrucaoController controller = new GrauInstrucaoController();

	@Test
	public void testCadastrarGrauDeInstrucao() throws Exception {
		controller.cadastrarInstrucao("Ensino Medio Completo");
		assertEquals(1, controller.buscarTodasInstrucoes().size());
	}

	@Test(expected = Exception.class)
	public void testCadastrarGrauInstrucaoInvalido() throws Exception {
		controller.cadastrarInstrucao("Ensino medio!@.");
	}

	@Test
	public void testBuscarGrauDeInstrucaoPorId() throws Exception {
		int idCadastrado = controller.cadastrarInstrucao("Ensino Medio Completo");
		GrauInstrucaoModel grauInstrucao = controller.buscarInstrucaoPorID(idCadastrado);
		assertNotNull(grauInstrucao);
		assertEquals("Ensino Medio Completo", grauInstrucao.getNome());
	}

	@Test(expected = Exception.class)
	public void testBuscarGrauDeInstrucaoPorIdInvalido() throws Exception {
		controller.buscarInstrucaoPorID(0);
	}

	@Test
	public void testBuscarGrauDeInstrucaoPorNomeQueContenha() throws Exception {
		controller.cadastrarInstrucao("Ensino Medio Completo");
		controller.cadastrarInstrucao("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarInstrucaoPorNomeQueContenha("Ensino Medio").size());
		assertEquals(0, controller.buscarInstrucaoPorNomeQueContenha("Palavra aleatória").size());
	}

	@Test(expected = Exception.class)
	public void testBuscarGrauDeInstrucaoPorNomeQueContenhaInvalido() throws Exception {
		controller.buscarInstrucaoPorNomeQueContenha("Ensino@!#");
		
	}

	@Test
	public void testAtualizarGrauDeInstrucao() throws Exception {
		Integer idCadastrado = controller.cadastrarInstrucao("Ensino Medio Completo");
		controller.atualizarInstrucao(idCadastrado, "Ensino Alterado");
		assertEquals("Ensino Alterado", controller.buscarInstrucaoPorID(idCadastrado).getNome());
	}

	@Test(expected = Exception.class)
	public void testAtualizarGrauDeInstrucaoComCaracteresInvalidos() throws Exception {
		Integer idCadastrado = controller.cadastrarInstrucao("Ensino Medio Completo");
		controller.atualizarInstrucao(idCadastrado, "Ensino Alter-+ado");
		assertEquals("Ensino Alterado", controller.buscarInstrucaoPorID(idCadastrado).getNome());
	}

	@Test
	public void testAtualizarGrauDeInstrucaoSemMudancaReal() throws Exception {
		Integer idCadastrado = controller.cadastrarInstrucao("Ensino Medio Completo");
		assertFalse(controller.atualizarInstrucao(idCadastrado, "Ensino Medio Completo"));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarGrauDeInstrucaoObjetoIdInexistente() throws Exception {
		controller.atualizarInstrucao(2, "Ensino básico completo");
	}

	@Test
	public void testDeletarGrauDeInstrucaoPorId() throws Exception {
		Integer idCadastrado = controller.cadastrarInstrucao("Ensino Medio Completo");
		assertEquals(1, controller.buscarTodasInstrucoes().size());
		controller.deletarInstrucaoPorID(idCadastrado);
		assertEquals(0, controller.buscarTodasInstrucoes().size());
	}

	@Test(expected = Exception.class)
	public void testDeletarGrauDeInstrucaoPorIdInexistente() throws Exception {
		assertEquals(0, controller.buscarTodasInstrucoes().size());
		controller.deletarInstrucaoPorID(2);
	}

	@Test(expected = Exception.class)
	public void testDeletarGrauDeInstrucaoPorIdIgualAZero() throws Exception {
		assertNull(controller.deletarInstrucaoPorID(0));
	}

	@Test(expected = Exception.class) 
	public void testDeletarGrauDeInstrucaoPorIdNulo() throws Exception {
		Integer idNulo = null;
		assertNull(controller.deletarInstrucaoPorID(idNulo));
	}
	
	@Test
	public void testBuscarTodosGrausDeInstrucoes() throws Exception {
		assertEquals(0, controller.buscarTodasInstrucoes().size());
		controller.cadastrarInstrucao("Ensino Medio Completo");
		controller.cadastrarInstrucao("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarTodasInstrucoes().size());
	}

	@Test
	public void testDeletarTodosGrausDeInstrucoes() throws Exception {
		controller.cadastrarInstrucao("Ensino Medio Completo");
		controller.cadastrarInstrucao("Ensino Medio Incompleto");
		assertEquals(2, controller.buscarTodasInstrucoes().size());
		controller.deletarTodasInstrucoes();
		ArrayList<GrauInstrucaoModel> lista = controller.buscarTodasInstrucoes();
		assertTrue(lista.isEmpty());
	}

	@Before
	public void beforeAll() {
		controller.deletarTodasInstrucoes();
	}

}

package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.GrauInstrucaoDAO;

/**
 * Classe dependente da finaliza��o do GrauInstrucaoController.
 * Pode ser exluida. att
 */

public class GrauInstrucaoControllerTest {

	GrauInstrucaoController controller = new GrauInstrucaoController();

	@Test
	public void testCadastrar() throws Exception {
		controller.cadastrar("Ensino Medio Completo");
		assertEquals(1, controller.buscarTodos().size());
	}

//	@Test
//	void testCadastrarGrauInstrucaoNull() {
//		controller.cadastrarGrauInstrucao("Ensino medio");
//		assertNull(controller.cadastrarGrauInstrucao("Ensino medio"));
//	}
//	
//	@Test
//	void testDeletarGraunstrucao() {
//		controller.cadastrarGrauInstrucao("Ensino Medio");
//		assertTrue(controller.deletarGrauInstrucao(0));
//		assertEquals(0, dao.getAll().size());
//	}
//	
//	@Test
//	void testDeletarGraunstrucaoFalse() {
//		controller.cadastrarGrauInstrucao("Ensino Medio");
//		assertFalse(controller.deletarGrauInstrucao(1));
//		assertEquals(1, dao.getAll().size());
//	}
//	
//	@Test
//	void testAtualizarGrauInstrucao( ) {
//		controller.cadastrarGrauInstrucao("Ensino Medio");
//		assertTrue(controller.atualizarGrauInstrucao(0, "Ensino Superior"));
//		assertEquals(dao.retrieve(0).getInstrucao(), "Ensino Superior");
//	}
	
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
		boolean sucesso = controller.deletarTodos();
		assertTrue(sucesso);
		ArrayList<GrauInstrucaoModel> lista = controller.buscarTodos();
		assertTrue(lista.isEmpty());	
	}
	
	@Before
	public void beforeAll() {
		controller.deletarTodos();
	}
	
}

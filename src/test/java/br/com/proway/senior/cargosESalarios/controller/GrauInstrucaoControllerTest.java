package br.com.proway.senior.cargosESalarios.controller;

<<<<<<< HEAD
=======


>>>>>>> 3102e4371203e0601f7ae9834a58bb282fc190f6
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoDao;

class GrauInstrucaoControllerTest {

	GrauInstrucaoController controller = new GrauInstrucaoController();
	GrauInstrucaoDao dao = new GrauInstrucaoDao();
	
	@Ignore
	void testCadastrarGrauInstrucao() {
<<<<<<< HEAD
		Integer id = 0;
		assertEquals(id, controller.cadastrarGrauInstrucao("Ensino medio"));		
=======
		assertEquals((Integer)0, controller.cadastrarGrauInstrucao("Ensino medio"));		
>>>>>>> 3102e4371203e0601f7ae9834a58bb282fc190f6
	}

	@Ignore
	void testCadastrarGrauInstrucaoNull() {
		controller.cadastrarGrauInstrucao("Ensino medio");
		assertNull(controller.cadastrarGrauInstrucao("Ensino medio"));
	}
	
	@Ignore
	void testDeletarGraunstrucao() {
		controller.cadastrarGrauInstrucao("Ensino Medio");
		assertTrue(controller.deletarGrauInstrucao(0));
		assertEquals(0, dao.getAll().size());
	}
	
	@Ignore
	void testDeletarGraunstrucaoFalse() {
		controller.cadastrarGrauInstrucao("Ensino Medio");
		assertFalse(controller.deletarGrauInstrucao(1));
		assertEquals(1, dao.getAll().size());
	}
	
	@Test
	void testAtualizarGrauInstrucao( ) {
		controller.cadastrarGrauInstrucao("Ensino Medio");
		assertTrue(controller.atualizarGrauInstrucao(0, "Ensino Superior"));
		assertEquals(dao.retrieve(0).getInstrucao(), "Ensino Superior");
	}
	
}

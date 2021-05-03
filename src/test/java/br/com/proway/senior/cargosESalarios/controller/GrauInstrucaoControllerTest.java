package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoDao;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;

class GrauInstrucaoControllerTest {

	GrauInstrucaoController controller = new GrauInstrucaoController();
	GrauInstrucaoDao dao = new GrauInstrucaoDao();
	
	@Ignore
	void testCadastrarGrauInstrucao() {
		assertEquals(0, controller.cadastrarGrauInstrucao("Ensino medio"));		
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

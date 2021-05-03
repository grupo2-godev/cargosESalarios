package br.com.proway.senior.setoresESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

class SetorControllerTest {

	SetorDaoAl dao = new SetorDaoAl();
	SetorController controller = new SetorController();
	
	@Before
	public void limparArray() {
		dao.limparArray();
		
	}
	
	@Test
	public void testCadastroSetorTrue() {	
		SetorModel cm = new SetorModel("RH", 5);
		cm.setId(0);
		controller.cadastrarSetor("RH", 5);
		assertEquals(cm, dao.retrieve(0));
	}
	
	@Test
	public void testDeletarSetor() {
		controller.cadastrarSetor("RH", 5);
		assertTrue(controller.deletarSetor(0));
		
	}
	
	@Test
	public void testAtualizarSetor() {
		SetorModel setor = new SetorModel("RH", 5);
		dao.create(setor);
		controller.atualizarSetor(0, "Financeiro", 5);
		assertEquals("Financeiro", dao.retrieve(0).getNomeSetor());
		
	}
	
	@Test
	public void testBuscarSetorPorID() {
		SetorModel novoSetor = new SetorModel("RH", 5);
		controller.cadastrarSetor("RH", 5);
		assertEquals(novoSetor, controller.buscarSetor(0));
	}
	
	@Test
	public void testBuscarSetorPorNome() {
		SetorModel novoSetor = new SetorModel("RH", 5);
		controller.cadastrarSetor("RH", 5);
		assertEquals(novoSetor, controller.buscarSetor("RH"));
	}
	
	@Test
	public void testBuscarTodosSetores() {
		SetorModel novoSetor1 = new SetorModel("RH", 5);
		dao.create(novoSetor1);
		SetorModel novoSetor2 = new SetorModel("Financeiro", 6);
		dao.create(novoSetor2);
		
		assertEquals(2, controller.buscarTodosSetores().size());
	}

}

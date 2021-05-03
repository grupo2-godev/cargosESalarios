package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Cbo2002Model;
import br.com.proway.senior.cargosESalarios.model.GrauDeInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelDao;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

class NivelControllerTest {

	NivelController controller = new NivelController();
	NivelDao dao = new NivelDao();
	GrauDeInstrucaoModel gi = new GrauDeInstrucaoModel();
	Cbo2002Model cbo2002 = new Cbo2002Model();
	Cbo1994Model cbo1994 = new Cbo1994Model();
	HorasMesModel hm = new HorasMesModel();
	
	@Before
	public void limparArray() {
		dao.limparArray();
		
	}
	
	@Test
	public void testCadastroNivelTrue() {	
		NivelModel cm = new NivelModel("nivel1");
		cm.setIdNivel(0);
		controller.cadastrarNivel("nivel1");
		assertEquals(cm, dao.retrieve(0));
	}
	
	@Test
	public void testDeletarNivel() {
		controller.cadastrarNivel("nivel1");
		assertTrue(controller.deletarNivel(0));
		
	}
	
	@Test
	public void testAtualizarNivel() {
		controller.cadastrarNivel("nivel1");	
		NivelModel cargoAtualizado = dao.retrieve(0);
		controller.atualizarNivel(0, "nivel2");
		assertEquals("nivel2", cargoAtualizado.getNomeNivel());
		}
	
	@Test
	public void testBuscarNivelPorID() {
		NivelModel novoNivel = new NivelModel("nivel1");
		dao.create(novoNivel);
		controller.cadastrarNivel("nivel1");
		assertEquals(novoNivel, controller.buscarNivelId(0));
	}
	
	@Test
	public void testBuscarTodosNiveis() {
		NivelModel novoNivel1 = new NivelModel("nivel1");
		dao.create(novoNivel1);
		NivelModel novoNivel2 = new NivelModel("nivel2");
		dao.create(novoNivel2);
		
		assertEquals(2, controller.buscarTodosNiveis().size());
	}

}

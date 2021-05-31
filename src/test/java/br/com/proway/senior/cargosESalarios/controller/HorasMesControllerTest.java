package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

public class HorasMesControllerTest {
	
	static HorasMesController controller = HorasMesController.getInstancia();	
	
	@BeforeClass
	public static void limparBanco() {
		ConexaoHibernate.getSessao().clear();
		new CargoController().deletarTodosCargos();
	}
		
	@Test
	public void testCadastrarHorasMes() throws Exception {
		int idGerado = controller.cadastrarHorasMes(1000.0);
		assertTrue(idGerado > 0);
		assertTrue(controller.buscarTodosHorasMes().size() > 0);
	}	
	
	@Test
	public void testCadastrarHorasMesPorString() throws Exception {
		int idGerado = controller.cadastrarHorasMes("13.257");
		assertTrue(idGerado > 0);
	}	
	
	@Test
	public void testCadastrarHorasMesPorString2() throws Exception {
		int idGerado = controller.cadastrarHorasMes("13,257");
		assertTrue(idGerado > 0);
	}	
	
	@Test (expected = Exception.class)
	public void testCadastrarHorasMesInvalido1() throws Exception {
		controller.cadastrarHorasMes("2007.88abh");
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarHorasMesInvalido2() throws Exception {
		controller.cadastrarHorasMes("2007.88!(*");
	}	

	@Test
	public void testBuscarHorasMes() throws Exception {
		controller.cadastrarHorasMes(1000.0);
		int idTest = controller.cadastrarHorasMes(2000.0);
		HorasMesModel retornado = controller.buscarHorasMes(idTest);
		assertNotNull(retornado);
		assertTrue(controller.buscarTodosHorasMes().size() > 1);
	}
	
	@Test (expected = Exception.class)
	public void testBuscarHorasMesInvalido() throws Exception {
		controller.cadastrarHorasMes(1000.0);
		controller.cadastrarHorasMes(2000.0);
		int ultimoId = controller.cadastrarHorasMes(3000.0);
		
		controller.buscarHorasMes(ultimoId+ 1);
	}

	@Test
	public void testAtualizarHorasMes() throws Exception {
		int idASerAtualizado = controller.cadastrarHorasMes(1000.0);
		
		assertTrue(controller.atualizarHorasMes(idASerAtualizado, 2000.0));
	}
	
	@Test
	public void testAtualizarHorasMesObjetosIguais() throws Exception {
		int idASerAtualizado = controller.cadastrarHorasMes(1000.0);
		
		assertFalse(controller.atualizarHorasMes(idASerAtualizado, 1000.0));
	}
	
	@Test(expected = Exception.class)
	public void testAtualizarHorasMesInexistente() throws Exception {
		int idInexistente = controller.buscarTodosHorasMes().size() + 1;
		
		controller.atualizarHorasMes(idInexistente, 2000.0);
	}

	@Test
	public void testDeletarHorasMes() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosHorasMes().size();
		
		int idTest = controller.cadastrarHorasMes(1000.0);
		controller.deletarHorasMes(idTest);
		assertEquals(sizeAntesDoTest, controller.buscarTodosHorasMes().size());
	}
	
	@Test(expected = Exception.class)
	public void testDeletarHorasMesInexistente() throws Exception {
		int idInvalido = controller.buscarTodosHorasMes().size();
		controller.deletarHorasMes(idInvalido);
	}

	@Test
	public void testBuscarTodosHorasMes() throws Exception {
		int sizeAntesDoTest = controller.buscarTodosHorasMes().size();
		
		controller.cadastrarHorasMes(1000.0);
		controller.cadastrarHorasMes(2000.0);
		controller.cadastrarHorasMes(3000.0);
		
		ArrayList<HorasMesModel> listaRetornada = controller.buscarTodosHorasMes();
		int sizeDepoisDoTest = listaRetornada.size();
	
		assertFalse(listaRetornada.isEmpty());
		assertNotEquals(sizeAntesDoTest, sizeDepoisDoTest);
	}
	
	@Test
	public void testBuscarTodosHorasMesSemHorasMes() throws Exception {
		controller.deletarTodosHorasMes();
		ArrayList<HorasMesModel> listaRetornada = controller.buscarTodosHorasMes();
		assertTrue(listaRetornada.isEmpty());
	}

	@Test
	public void testDeletarTodosHorasMes() throws Exception {
		controller.cadastrarHorasMes(1000.0);
		controller.cadastrarHorasMes(2000.0);
		controller.cadastrarHorasMes(3000.0);
		controller.deletarTodosHorasMes();
		ArrayList<HorasMesModel> listaRetornada = controller.buscarTodosHorasMes();
		assertTrue(listaRetornada.isEmpty());
	}
	
}

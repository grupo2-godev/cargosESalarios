package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;

/**
 * Classes de testes para o PostoDeTrabalhoController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;

public class PostoDeTrabalhoControllerTest {
	
	//static Integer idPosto = 1;
	static String nomePosto = "Desenvolvedor(a)";
	static Integer idCargo = 3;
	static Integer idSetor = 4;
	static Integer idNivel = 1;
	static Double salario = 1800.00;
	
	static PostoDeTrabalhoModel postoModel = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	
	static PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoRecuperado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a)", postoRecuperado.getNomePosto());
		assertEquals(idCargo, postoRecuperado.getIdCargo());
		assertEquals(idSetor, postoRecuperado.getIdSetor());
		assertEquals(idNivel, postoRecuperado.getIdNivel());
		assertEquals(salario, postoRecuperado.getSalario());
	}
	
	@Test(expected = Exception.class)
	public void cadastrarPostoDeTrabalhoTestNomeInvalido() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho("Inval1d0!", idCargo, idSetor, idNivel, salario);
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(id));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.atualizarPostoDeTrabalho(id, "Desenvolvedor(a) Junior", idCargo, 7, idNivel, salario);
		PostoDeTrabalhoModel postoAtualizado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals((Integer) 7, postoAtualizado.getIdSetor());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals((Object)id, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals(idCargo, postoProcurado.getIdCargo());
		assertEquals(idSetor, postoProcurado.getIdSetor());
		assertEquals(idNivel, postoProcurado.getIdNivel());
		assertEquals(salario, postoProcurado.getSalario());
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() throws Exception {
		int id = controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = controller.buscarPostoDeTrabalhoId(id);
		assertEquals(postoProcurado.getNomePosto(),
				controller.buscarPostoDeTrabalhoNome(nomePosto).get(0).getNomePosto());
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() throws Exception {
		int before = controller.buscarTodosPostosDeTrabalho().size();
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", 8, 2, 2, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", 7, 3, 3, 7000.00);
		assertEquals(before+3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
	@After
	public void limparTabela() throws SQLException {
		controller.postoDAO.deleteAll();
		//assertEquals(0, controller.buscarTodosPostosDeTrabalho().size());
	}
	
}

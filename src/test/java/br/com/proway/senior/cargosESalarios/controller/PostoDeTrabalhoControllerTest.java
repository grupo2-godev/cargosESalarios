package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;

/**
 * Classes de testes para o PostoDeTrabalhoController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoDaoAl;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;

public class PostoDeTrabalhoControllerTest {
	
	Integer idPosto = 1;
	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoDaoAl dao = new PostoDeTrabalhoDaoAl();
	PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
	PostoDeTrabalhoModel postoModel = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	
	
	@Before
	public void limparArray() {
		dao.limparArray();
		
	}
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoRecuperado = dao.retrieve(nomePosto);
		assertEquals("Desenvolvedor(a)", postoRecuperado.getNomePosto());
		assertEquals(3, postoRecuperado.getIdCargo());
		assertEquals(4, postoRecuperado.getIdSetor());
		assertEquals(1, postoRecuperado.getIdNivel());
		assertEquals(1800.00, postoRecuperado.getSalario());
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(0));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoAtualizado = dao.retrieve(0);
		controller.atualizarPostoDeTrabalho(0, "Desenvolvedor(a) Junior", idCargo, 7, idNivel, salario);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals(7, postoAtualizado.getIdSetor());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() {
		dao.limparArray();
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = dao.retrieve(0);
		assertEquals(0, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals(idCargo, postoProcurado.getIdCargo());
		assertEquals(idSetor, postoProcurado.getIdSetor());
		assertEquals(idNivel, postoProcurado.getIdNivel());
		assertEquals(salario, postoProcurado.getSalario());	
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() {
		dao.limparArray();
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = dao.retrieve(nomePosto);
		assertEquals(postoProcurado, controller.buscarPostoDeTrabalhoNome(nomePosto));	
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", 8, 2, 2, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", 7, 3, 3, 7000.00);
		assertEquals(3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
}

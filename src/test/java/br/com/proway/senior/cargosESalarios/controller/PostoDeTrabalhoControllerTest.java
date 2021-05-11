package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;

/**
 * Classes de testes para o PostoDeTrabalhoController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoDaoSQL;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;

public class PostoDeTrabalhoControllerTest {
	
	Integer idPosto = 1;
	String nomePosto = "Desenvolvedor(a)";
	Integer idCargo = 3;
	Integer idSetor = 4;
	Integer idNivel = 1;
	Double salario = 1800.00;
	PostoDeTrabalhoController controller = new PostoDeTrabalhoController();
	PostoDeTrabalhoModel postoModel = new PostoDeTrabalhoModel(nomePosto, idCargo, idSetor, idNivel, salario);
	PostoDeTrabalhoDaoSQL postoDaoSql = new PostoDeTrabalhoDaoSQL();
	
//	@Before
//	public void limparArray() {
//		dao.limparArray();
//		
//	}
	
	@Test
	public void cadastrarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoRecuperado = postoDaoSql.retrieve(idPosto);
		assertEquals("Desenvolvedor(a)", postoRecuperado.getNomePosto());
		assertEquals(idCargo, postoRecuperado.getIdCargo());
		assertEquals(idSetor, postoRecuperado.getIdSetor());
		assertEquals(idNivel, postoRecuperado.getIdNivel());
		assertEquals(salario, postoRecuperado.getSalario());
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		assertTrue(controller.deletarPostoDeTrabalho(1));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.atualizarPostoDeTrabalho(1, "Desenvolvedor(a) Junior", idCargo, 7, idNivel, salario);
		PostoDeTrabalhoModel postoAtualizado = postoDaoSql.retrieve(1);
		assertEquals("Desenvolvedor(a) Junior", postoAtualizado.getNomePosto());
		assertEquals((Integer) 7, postoAtualizado.getIdSetor());
		assertEquals(salario, postoAtualizado.getSalario());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = postoDaoSql.retrieve(1);
		assertEquals((Integer) 1, postoProcurado.getIdPosto());
		assertEquals(nomePosto, postoProcurado.getNomePosto());
		assertEquals(idCargo, postoProcurado.getIdCargo());
		assertEquals(idSetor, postoProcurado.getIdSetor());
		assertEquals(idNivel, postoProcurado.getIdNivel());
		assertEquals(salario, postoProcurado.getSalario());	
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		PostoDeTrabalhoModel postoProcurado = postoDaoSql.retrieve(nomePosto);
		assertEquals(postoProcurado.getNomePosto(), controller.buscarPostoDeTrabalhoNome(nomePosto).getNomePosto());	
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() {
		controller.cadastrarPostoDeTrabalho(nomePosto, idCargo, idSetor, idNivel, salario);
		controller.cadastrarPostoDeTrabalho("Analista de Sistemas", 8, 2, 2, 3000.00);
		controller.cadastrarPostoDeTrabalho("Coordenador de RH", 7, 3, 3, 7000.00);
		assertEquals(3, controller.buscarTodosPostosDeTrabalho().size());
	}
	
	@After
	public void limparTabela() throws SQLException {
		postoDaoSql.limparTabela();
	}
	
}

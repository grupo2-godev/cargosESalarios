package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classes de testes para o SetorController.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorControllerTest {
	
	Integer idSetor = 1;
	String nomeSetor1 = "ERP I";
	Integer idPermissao1 = 3;
	SetorModel setor1 = new SetorModel(nomeSetor1, idPermissao1);
	String nomeSetor2 = "Gestao de Pessoas";
	Integer idPermissao2 = 4;
	SetorModel setor2 = new SetorModel(nomeSetor2, idPermissao2);
	SetorController setorController = new SetorController();

	@Test
	public void testCadastrarSetorCorreto() {
		Integer idCadastrada = setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorRcuperado = setorController.buscarSetorPorId(idCadastrada);
		assertEquals(nomeSetor1, setorRcuperado.getNomeSetor());
		assertEquals(idPermissao1, setorRcuperado.getIdPermissao());
	}
	
	@Test
	public void testCadastrarSetorNull() {
		setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		assertNull(setorController.cadastrarSetor(nomeSetor1, idPermissao1));
	}
	
	@Test
	public void testDeletarSetorExistente() throws Exception {
		Integer idCadastrada = setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		assertTrue(setorController.deletarSetor(idCadastrada));
	}
	
	@Test (expected = Exception.class)
	public void testDeletarSetorInexistente() throws Exception {
		setorController.deletarSetor(456);
	}
	
	@Test
	public void testAtualizarSetorExistente() throws Exception {
		Integer idCadastrada = setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		setorController.atualizarSetor(idCadastrada, nomeSetor2, idPermissao2);
		SetorModel setorAtualizado = setorController.buscarSetorPorId(idCadastrada);
		assertEquals(nomeSetor2, setorAtualizado.getNomeSetor());
		assertEquals(idPermissao2, setorAtualizado.getIdPermissao());
	}
	
	@Test (expected = Exception.class)
	public void testAtualizarSetorInexistente() throws Exception {
		setorController.atualizarSetor(123, nomeSetor2, idPermissao2);

	}

	@Test
	public void testBuscarSetorId() {
		Integer idCadastrada = setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorProcurado = setorController.buscarSetorPorId(idCadastrada);
		assertEquals(idCadastrada, setorProcurado.getId());
		assertEquals(nomeSetor1, setorProcurado.getNomeSetor());
		assertEquals(idPermissao1, setorProcurado.getIdPermissao());
	}
	
	@Test
	public void testBuscarSetorNome() {
		SetorModel novoSetor = new SetorModel("Financeiro", 2);
		setorController.cadastrarSetor(novoSetor.getNomeSetor(), novoSetor.getIdPermissao());
		ArrayList<SetorModel> setorProcurado = setorController.buscarSetorPorNome("Finan");
		assertEquals(1, setorProcurado.size());	
	}
	
	@Test
	public void testBuscarTodosPostosDeTrabalho() {
		setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		setorController.cadastrarSetor(nomeSetor2, idPermissao2);
		setorController.cadastrarSetor("Financeiro", 3);
		assertFalse(setorController.buscarTodosSetores().isEmpty());
	}

	@Test
	public void testDeletarTodosOsSetoresTrue() {
		setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		setorController.cadastrarSetor(nomeSetor2, idPermissao2);
		setorController.deletarTodosSetores();
		assertTrue(setorController.buscarTodosSetores().isEmpty());
	}
		
	@Test
	public void testDeletarTodosOsSetoresFalse() {
		setorController.cadastrarSetor(nomeSetor1, idPermissao1);
		setorController.deletarTodosSetores();
		setorController.cadastrarSetor(nomeSetor2, idPermissao2);
		assertFalse(setorController.buscarTodosSetores().isEmpty());
	}
	
	@Before
	public void limparTabela() {
		setorController.deletarTodosSetores();
	}
}

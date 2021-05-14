package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.SetorDAO;

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
	SetorController controller = new SetorController();
	SetorDAO setorSQL = new SetorDAO();

	@Test
	public void cadastrarPostoDeTrabalhoTest() {
		Integer idCadastrada = controller.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorRcuperado = setorSQL.retrieve(idCadastrada);
		assertEquals(nomeSetor1, setorRcuperado.getNomeSetor());
		assertEquals(idPermissao1, setorRcuperado.getIdPermissao());
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() {
		Integer idCadastrada = controller.cadastrarSetor(nomeSetor1, idPermissao1);
		assertTrue(controller.deletarSetor(idCadastrada));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() {
		Integer idCadastrada = controller.cadastrarSetor(nomeSetor1, idPermissao1);
		controller.atualizarSetor(idCadastrada, nomeSetor2, idPermissao2);
		SetorModel setorAtualizado = setorSQL.retrieve(idCadastrada);
		assertEquals(nomeSetor2, setorAtualizado.getNomeSetor());
		assertEquals(idPermissao2, setorAtualizado.getIdPermissao());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() {
		Integer idCadastrada = controller.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorProcurado = setorSQL.retrieve(idCadastrada);
		assertEquals(idCadastrada, setorProcurado.getId());
		assertEquals(nomeSetor1, setorProcurado.getNomeSetor());
		assertEquals(idPermissao1, setorProcurado.getIdPermissao());
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() {
		Integer idCadastrada = controller.cadastrarSetor(setor2.getNomeSetor(), setor2.getIdPermissao());
		ArrayList<SetorModel> setorProcurado = setorSQL.retrieveByName(nomeSetor2);
		assertEquals(setor2.getNomeSetor(), setorProcurado.get(0).getNomeSetor());	
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		controller.cadastrarSetor(nomeSetor2, idPermissao2);
		controller.cadastrarSetor("Financeiro", 3);
		assertFalse(controller.buscarTodosSetores().isEmpty());
	}
	
	@Before
	public void limparTabela() {
		setorSQL.deleteAll();
	}
}

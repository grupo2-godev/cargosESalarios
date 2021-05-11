package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.SetorDaoSQL;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classes de testes para o SetorController.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 */

public class SetorControllerTest {
	
	Integer idSetor = 1;
	String nomeSetor1 = "ERP I";
	Integer idPermissao1 = 3;
	SetorModel setor1 = new SetorModel(nomeSetor1, idPermissao1);
	String nomeSetor2 = "Gest�o de Pessoas";
	Integer idPermissao2 = 4;
	SetorModel setor2 = new SetorModel(nomeSetor2, idPermissao2);
	SetorController controller = new SetorController();
	SetorDaoSQL setorSQL = new SetorDaoSQL();
	ConnectionPostgres conexao = new ConnectionPostgres();

	@Test
	public void cadastrarPostoDeTrabalhoTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorRcuperado = setorSQL.retrieve(idSetor);
		assertEquals(nomeSetor1, setorRcuperado.getNomeSetor());
		assertEquals(idPermissao1, setorRcuperado.getIdPermissao());
	}
	
	@Test
	public void deletarPostoDeTrabalhoTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		assertTrue(controller.deletarSetor(1));
	}
	
	@Test
	public void atualizarPostoDeTrabalhoTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		controller.atualizarSetor(idSetor, nomeSetor2, idPermissao2);
		SetorModel setorAtualizado = setorSQL.retrieve(1);
		assertEquals(nomeSetor2, setorAtualizado.getNomeSetor());
		assertEquals(idPermissao2, setorAtualizado.getIdPermissao());
	}

	@Test
	public void buscarPostoDeTrabalhoIdTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorProcurado = setorSQL.retrieve(1);
		assertEquals((Integer) 1, setorProcurado.getId());
		assertEquals(nomeSetor1, setorProcurado.getNomeSetor());
		assertEquals(idPermissao1, setorProcurado.getIdPermissao());
	}
	
	@Test
	public void buscarPostoDeTrabalhoNomeTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		SetorModel setorProcurado = setorSQL.retrieve(nomeSetor1);
		assertEquals(setorProcurado.getNomeSetor(), controller.buscarSetor(nomeSetor1).getNomeSetor());	
	}
	
	@Test
	public void buscarTodosPostosDeTrabalhoTest() {
		controller.cadastrarSetor(nomeSetor1, idPermissao1);
		controller.cadastrarSetor(nomeSetor2, idPermissao2);
		controller.cadastrarSetor("Financeiro", 3);
		assertEquals(3, controller.buscarTodosSetores().size());
	}
	
	@After
	public void limparTabela() throws SQLException {
		setorSQL.limparTabela();
	}
}

package br.com.proway.senior.cargosESalarios.controller.API;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.SetorDAO;

public class SetorControllerAPITest {

	static String nomeSetor = "RH";
	static Integer idPermissao = 12;

	SetorControllerAPI setorAPI = new SetorControllerAPI();
	static SetorController setorController = SetorController.getInstancia();
	static SetorDAO setorDAO = SetorDAO.getInstancia();

	@Before
	public void beforeAll() {
		setorController.deletarTodosSetores();
	}

	@Test
	public void testInserirSetor() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		setorAPI.inserirSetor(setorModel);
		assertEquals(setorController.buscarTodosSetores().size(), 1);	
	}

	@Test
	public void testBuscarPorID() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		assertEquals(setorModel.getNomeSetor(), ((SetorModel) (setorAPI.buscarPorID(idSetor).getBody())).getNomeSetor());
	}
	
	@Test
	public void testBuscarPorIDInvalido() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		assertEquals("ID invalido", ((String) (setorAPI.buscarPorID(1).getBody())));
	}

	@Test
	public void testBuscarTodos() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor2 = (Integer) setorDAO.criar(setorModel2);
		assertEquals(2, ((ArrayList<SetorModel>) (setorAPI.buscarTodos().getBody())).size());
	}

	@Test
	public void testAtualizarSetor() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, 1);
		setorAPI.atualizarSetor(idSetor, setorModel2);
		assertEquals(1, ((SetorModel) (setorAPI.buscarPorID(idSetor).getBody())).getIdPermissao());
	}
	
	@Test
	public void testAtualizarSetorComIDInvalido() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, 1);
		String texto = (String) setorAPI.atualizarSetor(1, setorModel2).getBody();
		assertEquals("ID invalido", texto);
	}

	@Test
	public void testDeletarSetorComApenasUmSetor() {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		setorAPI.deletarSetor(idSetor);
		assertEquals("Não há nenhum setor cadastrado", ((String) (setorAPI.buscarTodos().getBody())));
	}
	
	@Test
	public void testDeletarSetor() {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor2 = (Integer) setorDAO.criar(setorModel2);
		setorAPI.deletarSetor(idSetor);
		assertEquals(1, ((ArrayList<SetorModel>) (setorAPI.buscarTodos().getBody())).size());
	}
	
	@Test
	public void testDeletarSetorComIDInvalido() {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor2 = (Integer) setorDAO.criar(setorModel2);
		String texto = (String) setorAPI.deletarSetor(1).getBody();
		assertEquals(texto, "ID invalido");
		assertEquals(2, ((ArrayList<SetorModel>) (setorAPI.buscarTodos().getBody())).size());
	}

	@Test
	public void testBuscarSetoresPeloNome() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor2 = (Integer) setorDAO.criar(setorModel2);
		SetorModel setorModel3 = new SetorModel("Gerência", idPermissao);
		Integer idSetor3 = (Integer) setorDAO.criar(setorModel3);
		assertEquals(2, ((ArrayList<SetorModel>) (setorAPI.buscarSetoresPeloNome("RH").getBody())).size());
	}
	
	@Test
	public void testBuscarSetoresPeloNomeComNomeNulo() throws Exception {
		SetorModel setorModel = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor = (Integer) setorDAO.criar(setorModel);
		SetorModel setorModel2 = new SetorModel(nomeSetor, idPermissao);
		Integer idSetor2 = (Integer) setorDAO.criar(setorModel2);
		SetorModel setorModel3 = new SetorModel("Gerência", idPermissao);
		Integer idSetor3 = (Integer) setorDAO.criar(setorModel3);
		assertEquals(3, ((ArrayList<SetorModel>) (setorAPI.buscarSetoresPeloNome(null).getBody())).size());
	}
	
	@Test
	public void testBuscarSetoresPeloNomeSemSetoresCadastrados() throws Exception {
		assertEquals("Não há setores cadastrados", (String) (setorAPI.buscarSetoresPeloNome("RH").getBody()));
	}
}

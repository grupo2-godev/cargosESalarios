package br.com.proway.senior.cargosESalarios.controller.API;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CBO1994DAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class CBO1994ControllerAPITest {

	static String descricao = "Desenvolvedor de slidinho";
	static Integer codigoCBO = 12345;
	static Insalubridade insalubridade = Insalubridade.Dez;
	static Periculosidade periculosidade = Periculosidade.Trinta;
	static Integer idPermissao = 12;

	CBO1994ControllerAPI cboAPI = new CBO1994ControllerAPI();
	static CBO1994Controller cboController = CBO1994Controller.getInstancia();
	static CBO1994DAO cboDAO = CBO1994DAO.getInstancia();

	@Before
	public void beforeAll() {
		cboController.deletarTodosCBO1994();
	}

	@Test
	public void testInserirSetor() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		assertEquals(cboController.buscarTodosCBO1994().size(), 1);	
	}

	@Test
	public void testBuscarPorID() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		assertEquals(cboModel.getDescricao(), ((CBO1994Model) (cboAPI.buscarPorCodigo(idCBO).getBody())).getDescricao());
	}
	
	@Test
	public void testBuscarPorIDInvalido() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		assertEquals("Código do CBO1994 invalido", ((String) (cboAPI.buscarPorCodigo(1).getBody())));
	}

	@Test
	public void testBuscarTodos() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO2 = (Integer) cboAPI.inserirCBO1994(cboModel2).getBody();
		assertEquals(2, ((ArrayList<SetorModel>) (cboAPI.buscarTodos().getBody())).size());
	}

	@Test
	public void testAtualizarSetor() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, "Nova descrição", 
				insalubridade.getValor(), periculosidade.getValor());
		cboAPI.atualizarCBO1994(idCBO, cboModel2);
		assertEquals("Nova descrição", ((CBO1994Model) (cboAPI.buscarPorCodigo(idCBO).getBody())).getDescricao());
	}
	
	@Test
	public void testAtualizarSetorComIDInvalido() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, "Nova descrição", 
				insalubridade.getValor(), periculosidade.getValor());
		String texto = (String) cboAPI.atualizarCBO1994(1, cboModel2).getBody();
		assertEquals("Codigo do CBO1994 invalido", texto);
	}

	@Test
	public void testDeletarSetorComApenasUmSetor() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		cboAPI.deletarCBO1994(idCBO);
		assertEquals("Não há nenhum CBO1994 cadastrado", ((String) (cboAPI.buscarTodos().getBody())));
	}
	
	@Test
	public void testDeletarSetor() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO2 = (Integer) cboAPI.inserirCBO1994(cboModel2).getBody();
		cboAPI.deletarCBO1994(idCBO);
		assertEquals(1, ((ArrayList<SetorModel>) (cboAPI.buscarTodos().getBody())).size());
	}
	
	@Test
	public void testDeletarSetorComIDInvalido() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO2 = (Integer) cboAPI.inserirCBO1994(cboModel2).getBody();
		String texto = (String) cboAPI.deletarCBO1994(1).getBody();
		assertEquals(texto, "ID invalido");
		assertEquals(2, ((ArrayList<SetorModel>) (cboAPI.buscarTodos().getBody())).size());
	}

	@Test
	public void testBuscarSetoresPeloNome() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO2 = (Integer) cboAPI.inserirCBO1994(cboModel2).getBody();
		CBO1994Model cboModel3 = new CBO1994Model(codigoCBO + 2, "gerencia coisas", 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO3 = (Integer) cboAPI.inserirCBO1994(cboModel3).getBody();
		assertEquals(2, ((ArrayList<SetorModel>) (cboAPI.buscarCBO1994PelaDescricao("volvedor").getBody())).size());
	}
	
	@Test
	public void testBuscarSetoresPeloNomeComNomeNulo() throws Exception {
		CBO1994Model cboModel = new CBO1994Model(codigoCBO, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO = (Integer) cboAPI.inserirCBO1994(cboModel).getBody();
		CBO1994Model cboModel2 = new CBO1994Model(codigoCBO + 1, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO2 = (Integer) cboAPI.inserirCBO1994(cboModel2).getBody();
		CBO1994Model cboModel3 = new CBO1994Model(codigoCBO + 2, descricao, 
				insalubridade.getValor(), periculosidade.getValor());
		Integer idCBO3 = (Integer) cboAPI.inserirCBO1994(cboModel3).getBody();
		assertEquals(3, ((ArrayList<SetorModel>) (cboAPI.buscarCBO1994PelaDescricao(null).getBody())).size());
	}
	
	@Test
	public void testBuscarSetoresPeloNomeSemSetoresCadastrados() throws Exception {
		assertEquals("Não há nenhum CBO1994 cadastrado", (String) (cboAPI.buscarCBO1994PelaDescricao("RH").getBody()));
	}

}

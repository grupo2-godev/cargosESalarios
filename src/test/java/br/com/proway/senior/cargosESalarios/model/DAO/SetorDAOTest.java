package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classes de testes para o SetorDAO.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAOTest {

	SetorDAO setorDAO = SetorDAO.getInstancia();

	@Test
	public void testIserirSetor() throws SQLException {
		SetorModel novoSetor = new SetorModel("Financeiro", 15);
		Integer idSetorCadastrado = setorDAO.criar(novoSetor);
		Object setorConsultado = ConexaoHibernate.getSessao().get(SetorModel.class, idSetorCadastrado);
		assertEquals(idSetorCadastrado, ((SetorModel) setorConsultado).getId());
	}

	@Test
	public void testBuscarSetorPorID() {
		SetorModel novoSetor = new SetorModel("Gestão de Pessoas", 3);
		SetorModel setorRetornado = setorDAO.buscar(SetorModel.class, setorDAO.criar(novoSetor));
		assertEquals(novoSetor.getNomeSetor(), setorRetornado.getNomeSetor());
		assertEquals(novoSetor.getIdPermissao(), setorRetornado.getIdPermissao());
	}
	
	@Test
	public void testBuscarSetorPorNome() {
		SetorModel novoSetor = new SetorModel("Gestão de Pessoas", 3);
		setorDAO.criar(novoSetor);
		ArrayList<SetorModel> setorRetornado = (ArrayList<SetorModel>) setorDAO.listarPorValorDeColunaComStringIncompleta(SetorModel.class, "nomeSetor","tão");
		assertEquals(novoSetor.getNomeSetor(), setorRetornado.get(0).getNomeSetor());
		assertEquals(novoSetor.getIdPermissao(), setorRetornado.get(0).getIdPermissao());
	}

	@Test
	public void testAlterarSetor() {
		SetorModel novoSetor = new SetorModel("Desenvolvimento I", 3);
		SetorModel setorAlterado = new SetorModel("Desenvolvimento II", 3);
		Integer idcriado = setorDAO.criar(novoSetor);
		setorAlterado.setId(idcriado);		
		
		setorDAO.atualizar(setorAlterado);
		SetorModel atualizado = setorDAO.buscar(SetorModel.class, idcriado);
		assertEquals(setorAlterado.getNomeSetor(), atualizado.getNomeSetor());
		assertEquals(setorAlterado.getIdPermissao(), atualizado.getIdPermissao());
	}

	@Test
	public void testDeletarSetorPorID() {
		int size = setorDAO.listarPorTabela(SetorModel.class).size();
		SetorModel novoSetor = new SetorModel("Desenvolvimento I", 3);
		int idCriada = setorDAO.criar(novoSetor);
		setorDAO.deletar(SetorModel.class, idCriada);
		assertEquals(size, setorDAO.listarPorTabela(SetorModel.class).size());
	}
	
	@Test
	public void testDeletarTodosSetores() {
		setorDAO.deletarTodos("setor");
		assertTrue(setorDAO.listarPorTabela(SetorModel.class).isEmpty());
	}

	@Test
	public void testBuscarTodosSetores() {
		SetorModel setor1 = new SetorModel("Cobrança", 3);
		setorDAO.criar(setor1);
		SetorModel setor2 = new SetorModel("Atendimento", 3);
		setorDAO.criar(setor2);
		
		assertFalse(setorDAO.listarPorTabela(SetorModel.class).isEmpty());
	}

	@Before
	public void limparTabela() {
		setorDAO.deletarTodos("setor");
	}
	
}

package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelDAOTest {

	NivelDAO nivelDAO = NivelDAO.getInstancia();
	
	@Test
	public void testInserirNivel() {
		try {
			NivelModel nivel = new NivelModel("Willian");
			Integer idObjetoCadastrado = nivelDAO.criar(nivel);
			Object nivelConsultado = ConexaoHibernate.getSessao().get(NivelModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((NivelModel) nivelConsultado).getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBuscarNivelPorId() {
		NivelModel novoModel = new NivelModel("Willian");
		NivelModel nivelRetornado = nivelDAO.buscar(NivelModel.class, nivelDAO.criar(novoModel));
		assertTrue(novoModel.getNome().equals(nivelRetornado.getNome()));
	}

	@Test
	public void testAtualizarNivel() {
		NivelModel modelAntigo = new NivelModel("...");
		NivelModel modelAlterado = new NivelModel("Willian");
		int id = nivelDAO.criar(modelAntigo);
		modelAlterado.setId(id);
		
		nivelDAO.atualizar(modelAlterado);
		NivelModel atualizado = nivelDAO.buscar(NivelModel.class, id);
		assertTrue(atualizado.getNome().equals(modelAlterado.getNome()));
	}
	
	@Test
	public void testDeletarNivel() {
		int size = nivelDAO.listarPorTabela(NivelModel.class).size();
		NivelModel nivelModel = new NivelModel("Willian");
		int id = nivelDAO.criar(nivelModel);
		nivelDAO.deletar(NivelModel.class, id);
		assertEquals(size, nivelDAO.listarPorTabela(NivelModel.class).size());
	}
	
	@Test
	public void testBuscarTodosNiveis() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.criar(nivelModel);
		
		assertFalse(nivelDAO.listarPorTabela(NivelModel.class).isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistros() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.criar(nivelModel);
		
		nivelDAO.deletarTodos("nivelmodel");
		
		assertTrue(nivelDAO.listarPorTabela(NivelModel.class).isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistrosSemRegistrosADeletar() {
		nivelDAO.deletarTodos("nivelmodel");
		Boolean itensDeletados = nivelDAO.deletarTodos("nivelmodel");
		assertFalse(itensDeletados);
		assertTrue(nivelDAO.listarPorTabela(NivelModel.class).isEmpty());
	}
	
	@Test
	public void testSetNome() {
		NivelModel nivelModel = new NivelModel();
		nivelModel.setNome("Junior");
		assertTrue(nivelModel.getNome().equals("Junior"));
	}

	
}
	


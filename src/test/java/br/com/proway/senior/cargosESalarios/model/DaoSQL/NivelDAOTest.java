package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelDAOTest {

	NivelDAO nivelDAO = NivelDAO.getInstancia(ConexaoHibernate.getSessao());
	
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
		NivelModel nivelRetornado = nivelDAO.buscar(nivelDAO.criar(novoModel));
		assertEquals(novoModel.getNome(), nivelRetornado.getNome());
	}

	@Test
	public void testAtualizarNivel() {
		NivelModel modelAntigo = new NivelModel("...");
		NivelModel modelAlterado = new NivelModel("Willian");
		int id = nivelDAO.criar(modelAntigo);
		nivelDAO.atualizar(id, modelAlterado);
		NivelModel atualizado = nivelDAO.buscar(id);
		assertEquals(atualizado.getNome(), modelAlterado.getNome());
	}
	
	@Test
	public void testDeletarNivel() {
		int size = nivelDAO.buscarTodos().size();
		NivelModel nivelModel = new NivelModel("Willian");
		int id = nivelDAO.criar(nivelModel);
		nivelDAO.deletar(id);
		assertEquals(size, nivelDAO.buscarTodos().size());
	}
	
	@Test
	public void testBuscarTodosNiveis() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.criar(nivelModel);
		
		assertFalse(nivelDAO.buscarTodos().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistros() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.criar(nivelModel);
		
		Boolean ret = nivelDAO.deletarTodos();
		
		assertTrue(nivelDAO.buscarTodos().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistrosSemRegistrosADeletar() {
		nivelDAO.deletarTodos();
		Boolean itensDeletados = nivelDAO.deletarTodos();
		assertFalse(itensDeletados);
		assertTrue(nivelDAO.buscarTodos().isEmpty());
	}
	
}
	


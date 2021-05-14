package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

public class NivelDAOTest {

	NivelDAO nivelDAO = NivelDAO.getInstance(ConnectionHibernate.getSession());
	
	@Test
	public void testInserirNivel() {
		try {
			NivelModel nivel = new NivelModel("Willian");
			Integer idObjetoCadastrado = nivelDAO.create(nivel);
			Object nivelConsultado = ConnectionHibernate.getSession().get(NivelModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((NivelModel) nivelConsultado).getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBuscarNivelPorId() {
		NivelModel novoModel = new NivelModel("Willian");
		NivelModel nivelRetornado = nivelDAO.retrieve(nivelDAO.create(novoModel));
		assertEquals(novoModel.getNome(), nivelRetornado.getNome());
	}

	@Test
	public void testAtualizarNivel() {
		NivelModel modelAntigo = new NivelModel("...");
		NivelModel modelAlterado = new NivelModel("Willian");
		int id = nivelDAO.create(modelAntigo);
		nivelDAO.update(id, modelAlterado);
		NivelModel atualizado = nivelDAO.retrieve(id);
		assertEquals(atualizado.getNome(), modelAlterado.getNome());
	}
	
	@Test
	public void testDeletarNivel() {
		int size = nivelDAO.getAll().size();
		NivelModel nivelModel = new NivelModel("Willian");
		int id = nivelDAO.create(nivelModel);
		nivelDAO.delete(id);
		assertEquals(size, nivelDAO.getAll().size());
	}
	
	@Test
	public void testBuscarTodosNiveis() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.create(nivelModel);
		
		assertFalse(nivelDAO.getAll().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistros() {
		NivelModel nivelModel = new NivelModel("Willian");
		nivelDAO.create(nivelModel);
		
		Boolean ret = nivelDAO.deleteAll();
		
		assertTrue(nivelDAO.getAll().isEmpty());
	}
	
	@Test
	public void testDeletarTodosRegistrosSemRegistrosADeletar() {
		nivelDAO.deleteAll();
		Boolean itensDeletados = nivelDAO.deleteAll();
		assertFalse(itensDeletados);
		assertTrue(nivelDAO.getAll().isEmpty());
	}
	
}
	


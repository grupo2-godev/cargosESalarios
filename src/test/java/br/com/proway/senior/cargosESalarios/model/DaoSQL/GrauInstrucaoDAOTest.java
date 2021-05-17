package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;

/**
 * Testes referentes aos métodos da classe {@link GrauInstrucaoDAO}.
 * 
 * * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoDAOTest {

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstance(ConexaoHibernate.getSessao());

	@Test
	public void testCreate() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Ensino Medio");
		Integer idObjetoCadastrado = grauInstrucaoDAO.create(grauInstrucao);
		Object grauInstrucaoConsultado = ConexaoHibernate.getSessao().get(GrauInstrucaoModel.class,
				idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((GrauInstrucaoModel) grauInstrucaoConsultado).getId());
	}

	@Test
	public void testRetriveId() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		GrauInstrucaoModel grauInstrucaoConsultado = grauInstrucaoDAO.retrieve(grauInstrucaoDAO.create(grauInstrucao));
		assertEquals(grauInstrucao.getNome(), grauInstrucaoConsultado.getNome());
	}
	
	@Test
	public void testRetrieveNameCountains() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.create(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.getAll().size());
		ArrayList<GrauInstrucaoModel> lista = grauInstrucaoDAO.retrieveNameCountains("Comple");
		assertEquals(1, lista.size());
	}

	@Test
	public void testUpdate() {
		GrauInstrucaoModel grauInstrucaoAntigo = new GrauInstrucaoModel("Tecnologia Antigo");
		GrauInstrucaoModel grauInstrucaoNovo = new GrauInstrucaoModel("Tecnologia Novo");
		Integer idObjetoCadastrado = grauInstrucaoDAO.create(grauInstrucaoAntigo);
		grauInstrucaoDAO.update(idObjetoCadastrado, grauInstrucaoNovo);
		GrauInstrucaoModel grauInstrucaoAtualizado = grauInstrucaoDAO.retrieve(idObjetoCadastrado);
		assertEquals(grauInstrucaoNovo.getNome(), grauInstrucaoAtualizado.getNome());
	}
	
	@Test
	public void testDelete() {
		int totalRegistros = grauInstrucaoDAO.getAll().size();
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Fundamental Completo");
		int idObjetoCriado = grauInstrucaoDAO.create(grauInstrucao);
		assertEquals(totalRegistros + 1, grauInstrucaoDAO.getAll().size());
		grauInstrucaoDAO.delete(idObjetoCriado);
		assertEquals(totalRegistros, grauInstrucaoDAO.getAll().size());
	}


	@Test
	public void testGetAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Incompleto");
		GrauInstrucaoModel grauInstrucao2 = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.create(grauInstrucao);
		grauInstrucaoDAO.create(grauInstrucao2);
		ArrayList<GrauInstrucaoModel> lista = grauInstrucaoDAO.getAll();
		assertEquals(2, lista.size());
	}

	@Test
	public void testDeleteAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Mestrado completo");
		grauInstrucaoDAO.create(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.getAll().size());
		grauInstrucaoDAO.deleteAll();
		assertEquals(0, grauInstrucaoDAO.getAll().size());
	}
	
	@Before
	public void beforeAll() {
		grauInstrucaoDAO.deleteAll();
	}
	
	@After
	public void afterAll() {
		grauInstrucaoDAO.deleteAll();
	}
	
	

}

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

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstancia(ConexaoHibernate.getSessao());

	@Test
	public void testCreate() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Ensino Medio");
		Integer idObjetoCadastrado = grauInstrucaoDAO.criar(grauInstrucao);
		Object grauInstrucaoConsultado = ConexaoHibernate.getSessao().get(GrauInstrucaoModel.class,
				idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((GrauInstrucaoModel) grauInstrucaoConsultado).getId());
	}

	@Test
	public void testRetriveId() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		GrauInstrucaoModel grauInstrucaoConsultado = grauInstrucaoDAO.buscar(grauInstrucaoDAO.criar(grauInstrucao));
		assertEquals(grauInstrucao.getNome(), grauInstrucaoConsultado.getNome());
	}
	
	@Test
	public void testRetrieveNameCountains() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.buscarTodos().size());
		ArrayList<GrauInstrucaoModel> lista = grauInstrucaoDAO.buscarPorNome("Comple");
		assertEquals(1, lista.size());
	}

	@Test
	public void testUpdate() {
		GrauInstrucaoModel grauInstrucaoAntigo = new GrauInstrucaoModel("Tecnologia Antigo");
		GrauInstrucaoModel grauInstrucaoNovo = new GrauInstrucaoModel("Tecnologia Novo");
		Integer idObjetoCadastrado = grauInstrucaoDAO.criar(grauInstrucaoAntigo);
		grauInstrucaoDAO.atualizar(idObjetoCadastrado, grauInstrucaoNovo);
		GrauInstrucaoModel grauInstrucaoAtualizado = grauInstrucaoDAO.buscar(idObjetoCadastrado);
		assertEquals(grauInstrucaoNovo.getNome(), grauInstrucaoAtualizado.getNome());
	}
	
	@Test
	public void testDelete() {
		int totalRegistros = grauInstrucaoDAO.buscarTodos().size();
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Fundamental Completo");
		int idObjetoCriado = grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(totalRegistros + 1, grauInstrucaoDAO.buscarTodos().size());
		grauInstrucaoDAO.deletar(idObjetoCriado);
		assertEquals(totalRegistros, grauInstrucaoDAO.buscarTodos().size());
	}


	@Test
	public void testGetAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Incompleto");
		GrauInstrucaoModel grauInstrucao2 = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		grauInstrucaoDAO.criar(grauInstrucao2);
		ArrayList<GrauInstrucaoModel> lista = grauInstrucaoDAO.buscarTodos();
		assertEquals(2, lista.size());
	}

	@Test
	public void testDeleteAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Mestrado completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.buscarTodos().size());
		grauInstrucaoDAO.deletarTodos();
		assertEquals(0, grauInstrucaoDAO.buscarTodos().size());
	}
	
	@Before
	public void beforeAll() {
		grauInstrucaoDAO.deletarTodos();
	}
	
	@After
	public void afterAll() {
		grauInstrucaoDAO.deletarTodos();
	}
	
	

}

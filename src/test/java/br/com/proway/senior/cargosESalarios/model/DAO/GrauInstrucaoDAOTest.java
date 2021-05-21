package br.com.proway.senior.cargosESalarios.model.DAO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DAO.GrauInstrucaoDAO;

/**
 * Testes referentes aos métodos da classe {@link GrauInstrucaoDAO}.
 * 
 * * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoDAOTest {

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstancia();

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
		GrauInstrucaoModel grauInstrucaoConsultado = grauInstrucaoDAO.buscar(GrauInstrucaoModel.class, grauInstrucaoDAO.criar(grauInstrucao));
		assertEquals(grauInstrucao.getNome(), grauInstrucaoConsultado.getNome());
	}
	
	@Test
	public void testRetrieveNameCountains() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size());
		ArrayList<GrauInstrucaoModel> lista = (ArrayList<GrauInstrucaoModel>) grauInstrucaoDAO.listarPorValorDeColunaComStringIncompleta(GrauInstrucaoModel.class, "instrucao", "Comple");
		assertEquals(1, lista.size());
	}

	@Test
	public void testUpdate() {
		GrauInstrucaoModel grauInstrucaoAntigo = new GrauInstrucaoModel("Tecnologia Antigo");
		GrauInstrucaoModel grauInstrucaoNovo = new GrauInstrucaoModel("Tecnologia Novo");
		Integer idObjetoCadastrado = grauInstrucaoDAO.criar(grauInstrucaoAntigo);
		grauInstrucaoDAO.atualizar(idObjetoCadastrado, grauInstrucaoNovo);
		GrauInstrucaoModel grauInstrucaoAtualizado = grauInstrucaoDAO.buscar(GrauInstrucaoModel.class, idObjetoCadastrado);
		assertEquals(grauInstrucaoNovo.getNome(), grauInstrucaoAtualizado.getNome());
	}
	
	@Test
	public void testDelete() {
		int totalRegistros = grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size();
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Fundamental Completo");
		int idObjetoCriado = grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(totalRegistros + 1, grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size());
		grauInstrucaoDAO.deletar(GrauInstrucaoModel.class, idObjetoCriado);
		assertEquals(totalRegistros, grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size());
	}


	@Test
	public void testGetAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Incompleto");
		GrauInstrucaoModel grauInstrucao2 = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		grauInstrucaoDAO.criar(grauInstrucao2);
		ArrayList<GrauInstrucaoModel> lista = (ArrayList<GrauInstrucaoModel>) grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class);
		assertEquals(2, lista.size());
	}

	@Test
	public void testDeleteAll() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Mestrado completo");
		grauInstrucaoDAO.criar(grauInstrucao);
		assertEquals(1, grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size());
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
		assertEquals(0, grauInstrucaoDAO.listarPorTabela(GrauInstrucaoModel.class).size());
	}
	
	@Before
	public void beforeAll() {
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
	}
	
	@After
	public void afterAll() {
		grauInstrucaoDAO.deletarTodos("grau_instrucao");
	}
	
	

}

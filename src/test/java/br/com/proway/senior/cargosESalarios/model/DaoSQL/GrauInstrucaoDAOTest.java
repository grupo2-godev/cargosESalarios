package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;

/**
 * Testes referentes aos métodos da classe {@link GrauInstrucaoDAO}.
 * 
 * * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class GrauInstrucaoDAOTest {

	GrauInstrucaoDAO grauInstrucaoDAO = GrauInstrucaoDAO.getInstance(ConnectionHibernate.getSession());

	@Test
	public void testCreate() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Ensino Medio");
		Integer idObjetoCadastrado = grauInstrucaoDAO.create(grauInstrucao);
		Object grauInstrucaoConsultado = ConnectionHibernate.getSession().get(GrauInstrucaoModel.class,
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
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		grauInstrucaoDAO.create(grauInstrucao);
		grauInstrucaoDAO.create(grauInstrucao);
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

}

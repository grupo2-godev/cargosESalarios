package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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

//	@Ignore
//	void testGetAll() {
//		ArrayList<GrauInstrucaoModel> listaGI = new ArrayList<GrauInstrucaoModel>();
//		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi1);
//		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
//		dao.create(gi2);
//		listaGI.add(gi1);
//		listaGI.add(gi2);
//		assertEquals(listaGI.get(0).getInstrucao(), db.get(0).getInstrucao());
//	}

//	@Ignore
//	void testDeleteTrue() {
////		dao.limparArray();
//		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi);
//		assertTrue(dao.delete(0));
//		assertEquals(0, db.size());
//	}
//	
//	@Ignore
//	void testDeleteFalse() {
////		dao.limparArray();
//		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi);
//		assertTrue(dao.delete(1));
//		assertEquals(1, db.size());
//	}

}

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
	void testRetriveId() {
		GrauInstrucaoModel grauInstrucao = new GrauInstrucaoModel("Superior Completo");
		GrauInstrucaoModel grauInstrucaoConsultado = grauInstrucaoDAO.retrieve(grauInstrucaoDAO.create(grauInstrucao));
		assertEquals(grauInstrucao.getNome(), grauInstrucaoConsultado.getNome());
	}
	
//	@Ignore
//	void testRetriveNome() {
//		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi1);
//		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
//		dao.create(gi2);
//		assertEquals(gi1, dao.retrieve("Ensino M�dio Incompleto"));
//		assertEquals(gi2, dao.retrieve("Ensino Superior Incompleto"));	
//	}
//	
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
//	
//	@Ignore
//	void testUpdate() {
////		dao.limparArray();
//		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi);
//		GrauInstrucaoModel giNovo = new GrauInstrucaoModel(0, "Ensino M�dio Completo");
//		dao.update(giNovo);
//		assertTrue(dao.update(giNovo));
//		assertEquals("Ensino M�dio Completo", dao.retrieve(0).getInstrucao());
//	}
//	
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

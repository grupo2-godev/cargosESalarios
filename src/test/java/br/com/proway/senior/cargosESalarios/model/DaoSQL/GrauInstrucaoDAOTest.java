package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;

/**
 * Classe dependente da finaliza��o do GrauInstrucaoDao.
 */


class GrauInstrucaoDAOTest {
	
	ConnectionPostgres conexao = new ConnectionPostgres();
//	GrauInstrucaoDao giSql = new GrauInstrucaoDao(conexao);
//	
//	@Before
//	void beforeAllTest() {
//	}
//	
//	@Test 
//	void testCreate() throws SQLException {
//		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Medio");
//		giSql.create(gi);
//		String sql = "SELECT COUNT(*) FROM grau_de_instrucao";
//		ResultSet rs = conexao.executeQuery(sql);
//		rs.next();
//		rs.getInt(1);
//		assertEquals(1, rs.getInt(1));
//	}
//	
//	@Ignore 
//	void testCreateNull() {
//		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio");
//		dao.create(gi1);
//		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino M�dio");
//		assertNull(dao.create(gi2));
//	}
//	
//	@Ignore
//	void testRetriveId() {
//		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
//		dao.create(gi1);
//		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
//		dao.create(gi2);
//		assertEquals(gi1, dao.retrieve(0));
//		assertEquals(gi2, dao.retrieve(1));	
//	}
//	
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

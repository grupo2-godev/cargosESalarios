package br.com.proway.senior.cargosESalarios.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class GrauInstrucaoDaoTest {

	GrauInstrucaoDao dao = new GrauInstrucaoDao();
	ArrayList<GrauInstrucaoModel> db = Dados.getInstance().getListaGrauInstrucao();
	
	@Before
	void beforeAllTest() {
		dao.limparArray();
	}
	
	@Test 
	void testCreate() {
		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Médio");
		assertEquals(0, dao.create(gi));
	}
	
	@Test 
	void testCreateNull() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino Médio");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Médio");
		assertNull(dao.create(gi2));
	}
	
	@Test 
	void testRetriveId() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
		dao.create(gi2);
		assertEquals(gi1, dao.retrieve(0));
		assertEquals(gi2, dao.retrieve(1));	
	}
	
	@Test 
	void testRetriveNome() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
		dao.create(gi2);
		assertEquals(gi1, dao.retrieve("Ensino Médio Incompleto"));
		assertEquals(gi2, dao.retrieve("Ensino Superior Incompleto"));	
	}
	
	@Test
	void testGetAll() {
		ArrayList<GrauInstrucaoModel> listaGI = new ArrayList<GrauInstrucaoModel>();
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
		dao.create(gi2);
		listaGI.add(gi1);
		listaGI.add(gi2);
		assertEquals(listaGI.get(0).getInstrucao(), db.get(0).getInstrucao());
	}
	
	@Test
	void testUpdate() {
//		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi);
		GrauInstrucaoModel giNovo = new GrauInstrucaoModel(0, "Ensino Médio Completo");
		dao.update(giNovo);
		assertTrue(dao.update(giNovo));
		assertEquals("Ensino Médio Completo", dao.retrieve(0).getInstrucao());
	}
	
	@Test
	void testDeleteTrue() {
//		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi);
		assertTrue(dao.delete(0));
		assertEquals(0, db.size());
	}
	
	@Test
	void testDeleteFalse() {
//		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino Médio Incompleto");
		dao.create(gi);
		assertTrue(dao.delete(1));
		assertEquals(1, db.size());
	}
	
}

package br.com.proway.senior.cargosESalarios.model;

<<<<<<< HEAD
=======


>>>>>>> 3102e4371203e0601f7ae9834a58bb282fc190f6
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

class GrauInstrucaoDaoTest {

	GrauInstrucaoDao dao = new GrauInstrucaoDao();
	ArrayList<GrauInstrucaoModel> db = Dados.getInstance().getListaGrauInstrucao();
	
	@Before
	void beforeAllTest() {
		dao.limparArray();
	}
	
	@Test 
	void testCreate() {
		Integer id = 0;
		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio");
<<<<<<< HEAD
		assertEquals(id, dao.create(gi));
=======
		assertEquals((Integer)0, dao.create(gi));
>>>>>>> 3102e4371203e0601f7ae9834a58bb282fc190f6
	}
	
	@Test 
	void testCreateNull() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino M�dio");
		assertNull(dao.create(gi2));
	}
	
	@Test 
	void testRetriveId() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
		dao.create(gi2);
		assertEquals(gi1, dao.retrieve(0));
		assertEquals(gi2, dao.retrieve(1));	
	}
	
	@Test 
	void testRetriveNome() {
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
		dao.create(gi1);
		GrauInstrucaoModel gi2 = new GrauInstrucaoModel("Ensino Superior Incompleto");
		dao.create(gi2);
		assertEquals(gi1, dao.retrieve("Ensino M�dio Incompleto"));
		assertEquals(gi2, dao.retrieve("Ensino Superior Incompleto"));	
	}
	
	@Test
	void testGetAll() {
		ArrayList<GrauInstrucaoModel> listaGI = new ArrayList<GrauInstrucaoModel>();
		GrauInstrucaoModel gi1 = new GrauInstrucaoModel("Ensino M�dio Incompleto");
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
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
		dao.create(gi);
		GrauInstrucaoModel giNovo = new GrauInstrucaoModel(0, "Ensino M�dio Completo");
		dao.update(giNovo);
		assertTrue(dao.update(giNovo));
		assertEquals("Ensino M�dio Completo", dao.retrieve(0).getInstrucao());
	}
	
	@Test
	void testDeleteTrue() {
//		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
		dao.create(gi);
		assertTrue(dao.delete(0));
		assertEquals(0, db.size());
	}
	
	@Test
	void testDeleteFalse() {
//		dao.limparArray();
		GrauInstrucaoModel gi = new GrauInstrucaoModel("Ensino M�dio Incompleto");
		dao.create(gi);
		assertTrue(dao.delete(1));
		assertEquals(1, db.size());
	}
	
}

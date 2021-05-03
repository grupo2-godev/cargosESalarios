package br.com.proway.senior.cargosESalarios.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class NivelDaoTest {

	NivelDao dao = new NivelDao();
	ArrayList<NivelModel> db = Dados.getInstance().getListaNiveis();
	
	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	void testCreateNivel() {
		db.clear();
		NivelModel nivel = new NivelModel("nivel");
		assertEquals(0, dao.create(nivel));
		assertEquals(nivel, db.get(0));
	}
	
	@Test
	public void testRetrive() {
		NivelModel nivel = new NivelModel("nivel");
		db.add(nivel);
		assertEquals(nivel.getIdNivel(), dao.retrieve(0).getIdNivel());
		assertEquals(null, dao.retrieve(1));
	}
	
	@Test
	public void testUpdateNivel() {
		NivelModel nivel1 = new NivelModel("nivel1");
		db.add(nivel1);
		NivelModel nivel2 = new NivelModel("nivel2");
		assertTrue(dao.update(nivel2));
		NivelModel nivelNovo = db.get(0);
		assertEquals("nivel2", nivelNovo.getNomeNivel());
	}
	
}

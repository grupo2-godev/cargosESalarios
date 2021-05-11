package br.com.proway.senior.cargosESalarios.antigos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.NivelDaoSQL;

public class NivelDaoTest {

	NivelDaoSQL dao = new NivelDaoSQL();
	ArrayList<NivelModel> db = Dados.getInstance().getListaNiveis();
	
	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	public void testCreateNivel() {
		db.clear();
		NivelModel nivel = new NivelModel("nivel");
		assertEquals((Integer) 0, dao.create(nivel));
		assertEquals(nivel, db.get(0));
	}
	
	@Test
	public void testRetrive() {
		NivelModel nivel = new NivelModel("nivel");
		db.add(nivel);
		assertEquals(nivel.getId(), dao.retrieve(0).getId());
		assertEquals(null, dao.retrieve(1));
	}
	
	@Test
	public void testUpdateNivel() {
		NivelModel nivel1 = new NivelModel("nivel1");
		db.add(nivel1);
		NivelModel nivel2 = new NivelModel("nivel2");
		assertTrue(dao.update(nivel2));
		NivelModel nivelNovo = db.get(0);
		assertEquals("nivel2", nivelNovo.getNome());
	}
	
}

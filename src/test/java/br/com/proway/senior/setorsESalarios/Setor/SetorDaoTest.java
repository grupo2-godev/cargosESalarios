package br.com.proway.senior.setorsESalarios.Setor;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.Dados;
import br.com.proway.senior.cargosESalarios.model.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classe de testes do SetorDaoAl e SetorDaoCsv.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
 * @version Sprint3:
 *  - Implementação dos testes.
 */
public class SetorDaoTest {

	Dados db = Dados.getInstance();
	SetorDaoAl dao = new SetorDaoAl();

	
	@Before
	public void limparArray() {
		dao.limparArray();	
	}
	
	@Test
	public void testCreateAndRetrieveSetor() {
		dao.limparArray();	
		SetorModel setor1 = new SetorModel("RH", 5);
		dao.create(setor1);
		assertEquals(setor1, dao.retrieve(0));
	}

	@Test
	public void testUpdateSetor() {
		SetorModel setor1 = new SetorModel("RH", 5);

		new SetorDaoAl().create(setor1);

		SetorModel setor2 = new SetorModel("RH", 5);

		new SetorDaoAl().update(setor2);

		SetorModel setorRetornado = new SetorDaoAl().retrieve(0);

		assertNotEquals(setor2, setorRetornado);
		assertEquals(setor1, setorRetornado);
	}

	@Test
	public void testDeleteSetor() {
		int idSetor1 = 0;
		SetorModel setor1 = new SetorModel("RH", 5);
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();

		dao.create(setor1);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaSetores().size());
		dao.delete(idSetor1);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaSetores().size());
		assertNull(dao.retrieve(idSetor1));
	}
	
	@Test
	public void testRetrieveIsNull() {
		SetorModel setorCriado = new SetorModel("RH", 5);
		dao.create(setorCriado);
		int idSetor = 10;
		SetorModel setor = dao.retrieve(idSetor);
		assertNull(setor);
	}
	
	@Test
	public void testRetrieveId() {
		SetorModel setorCriado = new SetorModel("RH", 5);
		dao.create(setorCriado);
		SetorModel setor = dao.retrieve(0);
		assertNotNull(setor);
	}
	
	@Test
	public void testRetrieveNome() {
		SetorModel setorCriado = new SetorModel("RH", 5);
		dao.create(setorCriado);
		SetorModel setor = dao.retrieve("RH");
		assertNotNull(setor);
	}
	
	@Test
	public void testGetAll() {
		SetorDaoAl setorDao = new SetorDaoAl();
		ArrayList<SetorModel> listGetAll = setorDao.getAll();
		ArrayList<SetorModel> listGetListaSetores = Dados.getInstance().getListaSetores();
		assertEquals(listGetAll, listGetListaSetores);
	}

}

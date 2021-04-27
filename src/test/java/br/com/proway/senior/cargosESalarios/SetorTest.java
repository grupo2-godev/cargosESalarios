package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backup.SetorServico;
import br.com.proway.senior.cargosESalarios.Cargo.Cargo;
import br.com.proway.senior.cargosESalarios.Setor.Setor;
import br.com.proway.senior.cargosESalarios.Setor.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class SetorTest {

	@Test
	public void testeUpdate() {
		int idSetor = 2;
		SetorDaoAl setorDao = new SetorDaoAl();
		Setor setor1 = new Setor(idSetor, "Transporte", 20, 200);
		setorDao.Create(setor1);
		Setor setor2 = new Setor(idSetor, "Destruição", 8000, 5832139);
		setorDao.Update(setor2);
		Setor setorAlterado = setorDao.Retrieve(idSetor);
		assertEquals(setorAlterado, setor2);
		assertNotEquals(setorAlterado, setor1);
	}

	@Test
	public void testeCreateERetrieve() {
		int idSetor = 1;
		SetorDaoAl setorDAO = new SetorDaoAl();
		Setor setor = new Setor(idSetor, "Recursos Humanos", 10, 100);
		Setor setorClone = new Setor(idSetor, "Recursos Humanos", 10, 100);
		setorDAO.Create(setor);
		setorDAO.Create(setorClone);
		Setor setorRetornado = setorDAO.Retrieve(idSetor);
		assertEquals(setorRetornado, setor);
		assertNotSame(setorRetornado, setorClone);
	}

	@Test
	public void testeDelete() {
		int idSetor = 3;
		Setor setor01 = new Setor(idSetor, "Contabilidade", 20, 400);
		SetorDaoAl setorDao = new SetorDaoAl();
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
		setorDao.Create(setor01);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaSetores().size());
		setorDao.Delete(idSetor);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaSetores().size());
	}

	@Test
	public void testSetorNaoExistente() {
		int idSetor = 4;
		SetorDaoAl setorDao = new SetorDaoAl();
		Setor setor = setorDao.Retrieve(idSetor);
		assertNull(setor);
	}

	@Test
	public void testeGetAll() {
		SetorDaoAl setorDao = new SetorDaoAl();
		ArrayList<Setor> getAll = setorDao.getAll();
		ArrayList<Setor> listaDados = Dados.getInstance().getListaSetores();
		assertEquals(getAll, listaDados);
	}
}

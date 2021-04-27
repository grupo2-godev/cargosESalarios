package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.Setor.Setor;
import br.com.proway.senior.cargosESalarios.Setor.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.Setor.SetorDaoCsv;
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
	
	@Test
	public void testCSVReadAll() throws Exception {
		SetorDaoCsv setorDAO = new SetorDaoCsv();
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("../classes/br/com/proway/senior/cargosESalarios/recursos/cargos.csv").toURI()));
		List<String[]> minhaLista = setorDAO.readAll(reader);
		for(String[] line : minhaLista) {
			for(String word : line) {
				System.out.println(word);
			}			
		}		
	}
	
	@Test
	public void testCreateCSV() throws Exception{
		SetorDaoCsv setorDao = new SetorDaoCsv();	
		Setor novoSetor = new Setor(4, "Limpeza", 10, 5);
		setorDao.Create(novoSetor);
	}
	
}

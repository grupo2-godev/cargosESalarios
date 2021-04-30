package br.com.proway.senior.cargosESalarios.Setor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.Dados;
import br.com.proway.senior.cargosESalarios.model.Setor;
import br.com.proway.senior.cargosESalarios.model.SetorDaoAl;
import br.com.proway.senior.cargosESalarios.model.SetorDaoCsv;

/**
 * Classe de testes do SetorDaoAl e SetorDaoCsv.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
 * @version Sprint3:
 *  - Implementação dos testes.
 */
public class SetorTest {

	@Test
	public void testeUpdate() {
		int idSetor = 2;
		SetorDaoAl setorDao = new SetorDaoAl();
		Setor setor1 = new Setor(idSetor, "Transporte", 200);
		setorDao.create(setor1);
		Setor setor2 = new Setor(idSetor, "Nome do Setor Alterado (Teste)", 5832139);
		setorDao.update(setor2);
		Setor setorAlterado = setorDao.retrieve(idSetor);
		assertEquals(setorAlterado, setor2);
		assertNotEquals(setorAlterado, setor1);
	}

	@Test
	public void testeCreateERetrieve() {
		int idSetor = 1;
		SetorDaoAl setorDAO = new SetorDaoAl();
		Setor setor = new Setor(idSetor, "Recursos Humanos", 100);
		Setor setorClone = new Setor(idSetor, "Recursos Humanos", 100);
		setorDAO.create(setor);
		setorDAO.create(setorClone);
		Setor setorRetornado = setorDAO.retrieve(idSetor);
		assertEquals(setorRetornado, setor);
		assertNotSame(setorRetornado, setorClone);
	}

	@Test
	public void testeDelete() {
		int idSetor = 3;
		Setor setor01 = new Setor(idSetor, "Contabilidade", 400);
		SetorDaoAl setorDao = new SetorDaoAl();
		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
		setorDao.create(setor01);
		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaSetores().size());
		setorDao.delete(idSetor);
		assertEquals(tamanhoInicial, Dados.getInstance().getListaSetores().size());
	}

	@Test
	public void testSetorNaoExistente() {
		int idSetor = 4;
		SetorDaoAl setorDao = new SetorDaoAl();
		Setor setor = setorDao.retrieve(idSetor);
		assertNull(setor);
	}
	
	@Ignore
	public void testCreateCSV() throws Exception{
		int idSetor = 4;
		SetorDaoCsv setorDao = new SetorDaoCsv();		
		Setor novoSetor = new Setor(idSetor, "Limpeza", 5);
		setorDao.create(novoSetor);
		Setor setorRetornado = setorDao.retrieve(idSetor);
		assertEquals(setorRetornado, novoSetor);
	}
	
	@Ignore
	public void testRetrieveCSV() {
		Integer idSetorRetornado = 2;
		SetorDaoCsv setorDao = new SetorDaoCsv();
		Setor setorRetornado = setorDao.retrieve(idSetorRetornado);
		assertEquals(setorRetornado.getId(), idSetorRetornado);
	}
	
	@Ignore
	public void testUpdateCSV() {
		int idSetorAlterado = 3;
		SetorDaoCsv setorDao = new SetorDaoCsv();		
		Setor setorAnterior = setorDao.retrieve(idSetorAlterado);
		Setor setorAlterado = new Setor(setorAnterior.getId(), setorAnterior.getNomeSetor(), setorAnterior.getIdPermissao());
		setorDao.update(setorAlterado);
		Setor setorRetornado = setorDao.retrieve(idSetorAlterado);
		assertEquals(setorRetornado, setorAlterado);
		assertNotEquals(setorRetornado, setorAnterior);
		
	}
	
	@Ignore
	public void testDeleteCSV() {
		int idSetorDeletado = 5;
		SetorDaoCsv setorDao = new SetorDaoCsv();		
		Setor novoSetor = new Setor(idSetorDeletado, "SETOR A SER REMOVIDO", 666);
		int tamanhoAnterior = setorDao.getAll().size();
		setorDao.create(novoSetor);		
		setorDao.delete(idSetorDeletado);
		int tamanhoAtual = setorDao.getAll().size();
		assertEquals(tamanhoAnterior, tamanhoAtual);
		
	}
}

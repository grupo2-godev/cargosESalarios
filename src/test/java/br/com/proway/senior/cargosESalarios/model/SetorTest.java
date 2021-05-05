package br.com.proway.senior.cargosESalarios.model;
//package br.com.proway.senior.cargosESalarios.Setor;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertNull;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import br.com.proway.senior.cargosESalarios.model.Dados;
//import br.com.proway.senior.cargosESalarios.model.SetorDaoAl;
//import br.com.proway.senior.cargosESalarios.model.SetorDaoCsv;
//import br.com.proway.senior.cargosESalarios.model.SetorModel;
//
///**
// * Classe de testes do SetorDaoAl e SetorDaoCsv.
// * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi
// * @version Sprint3:
// *  - Implementação dos testes.
// */
//public class SetorTest {
//
//	@Ignore
//	public void testeUpdate() {
//		int idSetor = 2;
//		SetorDaoAl setorDao = new SetorDaoAl();
//		SetorModel setor1 = new SetorModel(idSetor, "Transporte", 200);
//		setorDao.create(setor1);
//		SetorModel setor2 = new SetorModel(idSetor, "Nome do Setor Alterado (Teste)", 5832139);
//		setorDao.update(setor2);
//		SetorModel setorAlterado = setorDao.retrieve(idSetor);
//		assertEquals(setorAlterado, setor2);
//		assertNotEquals(setorAlterado, setor1);
//	}
//
//	@Ignore
//	public void testeCreateERetrieve() {
//		int idSetor = 1;
//		SetorDaoAl setorDAO = new SetorDaoAl();
//		SetorModel setor = new SetorModel(idSetor, "Recursos Humanos", 100);
//		SetorModel setorClone = new SetorModel(idSetor, "Recursos Humanos", 100);
//		setorDAO.create(setor);
//		setorDAO.create(setorClone);
//		SetorModel setorRetornado = setorDAO.retrieve(idSetor);
//		assertEquals(setorRetornado, setor);
//		assertNotSame(setorRetornado, setorClone);
//	}
//
//	@Ignore
//	public void testeDelete() {
//		int idSetor = 3;
//		SetorModel setor01 = new SetorModel(idSetor, "Contabilidade", 400);
//		SetorDaoAl setorDao = new SetorDaoAl();
//		int tamanhoInicial = Dados.getInstance().getListaSetores().size();
//		setorDao.create(setor01);
//		assertEquals(tamanhoInicial + 1, Dados.getInstance().getListaSetores().size());
//		setorDao.delete(idSetor);
//		assertEquals(tamanhoInicial, Dados.getInstance().getListaSetores().size());
//	}
//
//	@Ignore
//	public void testSetorNaoExistente() {
//		int idSetor = 4;
//		SetorDaoAl setorDao = new SetorDaoAl();
//		SetorModel setor = setorDao.retrieve(idSetor);
//		assertNull(setor);
//	}
//	
////	@Ignore
////	public void testCreateCSV() throws Exception{
////		int idSetor = 4;
////		SetorDaoCsv setorDao = new SetorDaoCsv();		
////		SetorModel novoSetor = new SetorModel(idSetor, "Limpeza", 5);
////		setorDao.create(novoSetor);
////		SetorModel setorRetornado = setorDao.retrieve(idSetor);
////		assertEquals(setorRetornado, novoSetor);
////	}
////	
////	@Ignore
////	public void testRetrieveCSV() {
////		Integer idSetorRetornado = 2;
////		SetorDaoCsv setorDao = new SetorDaoCsv();
////		SetorModel setorRetornado = setorDao.retrieve(idSetorRetornado);
////		assertEquals(setorRetornado.getId(), idSetorRetornado);
////	}
////	
////	@Ignore
////	public void testUpdateCSV() {
////		int idSetorAlterado = 3;
////		SetorDaoCsv setorDao = new SetorDaoCsv();		
////		SetorModel setorAnterior = setorDao.retrieve(idSetorAlterado);
////		SetorModel setorAlterado = new SetorModel(setorAnterior.getId(), setorAnterior.getNomeSetor(), setorAnterior.getIdPermissao());
////		setorDao.update(setorAlterado);
////		SetorModel setorRetornado = setorDao.retrieve(idSetorAlterado);
////		assertEquals(setorRetornado, setorAlterado);
////		assertNotEquals(setorRetornado, setorAnterior);
////		
////	}
////	
////	@Ignore
////	public void testDeleteCSV() {
////		int idSetorDeletado = 5;
////		SetorDaoCsv setorDao = new SetorDaoCsv();		
////		SetorModel novoSetor = new SetorModel(idSetorDeletado, "SETOR A SER REMOVIDO", 666);
////		int tamanhoAnterior = setorDao.getAll().size();
////		setorDao.create(novoSetor);		
////		setorDao.delete(idSetorDeletado);
////		int tamanhoAtual = setorDao.getAll().size();
////		assertEquals(tamanhoAnterior, tamanhoAtual);
////		
////	}
//}

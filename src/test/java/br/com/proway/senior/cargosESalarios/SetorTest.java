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

//
//	@Test
//	public void testeDeleteSetor() {
//
//		SetorDaoAl setorDAO = new SetorDaoAl();
//		Setor setor = new Setor(0, "Recursos Humanos", 10, 100);
//		setorDAO.Create(setor);
//		setorDAO.Delete(0);
//		assertFalse(Dados.getInstance().getListaSetores().contains(setor));
//	}
	
//	@Test
//	public void testeUpdateNaPosicaoDoisDaLista() {
//		SetorDaoAl setorDAO = new SetorDaoAl();
//		Setor setor = new Setor(1, "Transporte", 20, 200);
//		setorDAO.Create(setor);
//		System.out.println(setorDAO.Retrieve(2).getNomeSetor());
//		System.out.println("Foi alterado com sucesso!");
//		setor.se
//	}
	
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
	
//	@Test
//	public void testeConsultarSetorNaoExistente() {
//		SetorServico sv = new SetorServico();
//		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
//		Setor setorConsultado = new Setor();
//		
//		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
//		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
//		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
//		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
//		
//		setorConsultado = sv.consultarSetor(listaSetor, 1111);
//		
//		assertNull(setorConsultado);
//	}
//	
}

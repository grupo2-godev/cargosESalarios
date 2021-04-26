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

//	@Test
//	public void testeSalvarUmSetor() {	
//		
//		SetorDaoAl setorDAO = new SetorDaoAl();
//		Setor s = new Setor(10, "RH", 40, 357);
//		setorDAO.Create(s);
//		System.out.println(setorDAO.Retrieve(0).getNomeSetor());
//}

	@Test
	public void testeUpdateSetor() {

		SetorDaoAl setorDAO = new SetorDaoAl();
		Setor setor = new Setor(0, "Recursos Humanos", 10, 100);
		setorDAO.Create(setor);
		System.out.println(setorDAO.Retrieve(0).getNomeSetor());
		System.out.println("Foi alterado para: ");
		setor.setNomeSetor("RH");
		setor.setCapacidade(10);
		setor.setIdPermissao(100);
		setorDAO.Update(setor);
		System.out.println(setorDAO.Retrieve(0).getNomeSetor());
	}

	@Test
	public void testeDeleteSetor() {

		SetorDaoAl setorDAO = new SetorDaoAl();
		Setor setor = new Setor(0, "Recursos Humanos", 10, 100);
		setorDAO.Create(setor);
		setorDAO.Delete(0);
		assertFalse(Dados.getInstance().getListaSetores().contains(setor));
	}
	
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
	public void testeDeRetornoRetrieve() {

		SetorDaoAl setorDAO = new SetorDaoAl();
		Setor setor = new Setor(1, "Recursos Humanos", 10, 100);	
		Setor setorClone = new Setor(1, "Recursos Humanos", 10, 100);
		setorDAO.Create(setor);
		setorDAO.Create(setorClone);		
		Setor setorRetornado = setorDAO.Retrieve(setor.getId());
		assertEquals(setorRetornado, setor);
		assertNotEquals(setorRetornado, setorClone);
	}

	
	
//	
//	@Test
//	public void testeCadastrarSetor() {
//		String nomeSetor = "RH";
//		int id = 123;
//		int idPermissao = 3;
//		int capacidade = 10;
//		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
//		SetorServico sv = new SetorServico();		
//		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade, idPermissao);
//		assertTrue(!listaSetor.isEmpty());
//	}
//
//	@Test
//	public void testeAlteraSetor() {
//		SetorServico sv = new SetorServico();
//		Setor setor = new Setor(123, "RH", 10, 111);
//		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
////		
//		listaSetor.add(setor);
//		
//		sv.alterarSetor(listaSetor, "Recursos Humanos", setor.getId(), setor.getCapacidade(), setor.getIdPermissao());
//		
//		assertEquals("Recursos Humanos", setor.getNomeSetor());
//	}
//	
//	@Test
//	public void testeConsultarSetor() {
//		SetorServico sv = new SetorServico();
//		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
//		Setor setorConsultado = new Setor();
//		
//		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
//		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
//		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
//		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
//		
//		setorConsultado = sv.consultarSetor(listaSetor, 2123);
//		
//		assertEquals(setorConsultado.getNomeSetor(), "Financeiro");
//	}
//	
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
//	@Test
//	public void testeDeletarSetor() {
//		SetorServico sv = new SetorServico();
//		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
//		Setor setorDeletado = new Setor(2123, "Financeiro", 30, 984);
//		
//		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
//		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
//		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
//		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
//		
//		sv.deletarSetor(listaSetor, 2123);
//		
//		assertTrue(!listaSetor.contains(setorDeletado));
//	}
}

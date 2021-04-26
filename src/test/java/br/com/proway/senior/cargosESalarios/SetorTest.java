package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backup.SetorServico;
import br.com.proway.senior.cargosESalarios.Setor.Setor;
import br.com.proway.senior.cargosESalarios.Setor.SetorDaoCsv;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class SetorTest {

	@Test
	public void testeSalvarUmSetor() {
		Dados.getInstance().getListaCargos();
		
		
		SetorDaoCsv setorDAO = new SetorDaoCsv();
		Setor s = new Setor();
		setorDAO.Create(s);
		System.out.println(setorDAO.getAll());
	}
	
	
	@Test
	public void testeCadastrarSetor() {
		String nomeSetor = "RH";
		int id = 123;
		int idPermissao = 3;
		int capacidade = 10;
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
		SetorServico sv = new SetorServico();		
		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade, idPermissao);
		assertTrue(!listaSetor.isEmpty());
	}

	@Test
	public void testeAlteraSetor() {
		SetorServico sv = new SetorServico();
		Setor setor = new Setor(123, "RH", 10, 111);
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
//		
		listaSetor.add(setor);
		
		sv.alterarSetor(listaSetor, "Recursos Humanos", setor.getId(), setor.getCapacidade(), setor.getIdPermissao());
		
		assertEquals("Recursos Humanos", setor.getNomeSetor());
	}
	
	@Test
	public void testeConsultarSetor() {
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		Setor setorConsultado = new Setor();
		
		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
		
		setorConsultado = sv.consultarSetor(listaSetor, 2123);
		
		assertEquals(setorConsultado.getNomeSetor(), "Financeiro");
	}
	
	@Test
	public void testeConsultarSetorNaoExistente() {
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		Setor setorConsultado = new Setor();
		
		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
		
		setorConsultado = sv.consultarSetor(listaSetor, 1111);
		
		assertNull(setorConsultado);
	}
	@Test
	public void testeDeletarSetor() {
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		Setor setorDeletado = new Setor(2123, "Financeiro", 30, 984);
		
		sv.cadastrarSetor(listaSetor, "Recursos Humanos", 2654, 30, 352);
		sv.cadastrarSetor(listaSetor, "Comercial", 2758, 30, 657);
		sv.cadastrarSetor(listaSetor, "Financeiro", 2123, 30, 984);
		sv.cadastrarSetor(listaSetor, "Contabilidade", 2841, 30, 612);
		
		sv.deletarSetor(listaSetor, 2123);
		
		assertTrue(!listaSetor.contains(setorDeletado));
	}
}

package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SetorServicoTest {

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
		Setor setor = new Setor();
		Setor setorInicial = new Setor();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		setor.setCapacidade(10);
		setor.setId(123);
		setor.setIdPermissao(111);
		setor.setNomeSetor("RH");
		listaSetor.add(setor);
		setorInicial.setCapacidade(setor.getId());
		setorInicial.setIdPermissao(setor.getIdPermissao());
		setorInicial.setCapacidade(setor.getCapacidade());
		setorInicial.setNomeSetor(setor.getNomeSetor());		
		
		setor.setNomeSetor("Cont");
		setor.setCapacidade(9);
		setor.setIdPermissao(222);
		
		sv.alterarSetor(listaSetor, setor.getNomeSetor(), setor.getId(), setor.getCapacidade(), setor.getIdPermissao());
		assertFalse(setor.getIdPermissao() == setorInicial.getIdPermissao());
		assertFalse(setor.getCapacidade() == setorInicial.getCapacidade());
		assertFalse(setor.getNomeSetor() == setorInicial.getNomeSetor());
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

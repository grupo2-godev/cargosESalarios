package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SetorServicoTest {

	@Test
	public void testCadastrarSetor() {
		String nomeSetor;
		int id;
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
		SetorServico sv = new SetorServico();

		nomeSetor = "RH";
		id = 123;
		int capacidade = 10;
		
		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade);
		assertTrue(!listaSetor.isEmpty());
	}
	@Test
	public void testeCapacidadeSetor() {
		int capacidade = 10;
		int id = 123;
		String nomeSetor = "O brabooo";
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
		
		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade);	
		assertTrue(!listaSetor.isEmpty());
	}
	@Test
	public void testeAlteraSetor() {
		SetorServico sv = new SetorServico();
		Setor setor = new Setor();
		Setor setorInicial = new Setor();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		setor.capacidade = 10;
		setor.id = 123;
		setor.idPermissao = 111;
		setor.nomeSetor = "RH";
		listaSetor.add(setor);
		setorInicial.id = setor.id;
		setorInicial.idPermissao = setor.idPermissao;
		setorInicial.capacidade = setor.capacidade;
		setorInicial.nomeSetor = setor.nomeSetor;
		
		sv.alterarSetor(listaSetor, "Cont", setor.id, 9, 222);
		assertFalse(setor.idPermissao == setorInicial.idPermissao);
		assertFalse(setor.capacidade == setorInicial.capacidade);
		assertFalse(setor.nomeSetor == setorInicial.nomeSetor);
	}
}

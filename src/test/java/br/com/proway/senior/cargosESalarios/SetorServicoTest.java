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

	public void testeCapacidadeSetor() {
		int capacidade = 10;
		int id = 123;
		String nomeSetor = "O brabooo";
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
		
		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade);	
		assertTrue(!listaSetor.isEmpty());
	}
}

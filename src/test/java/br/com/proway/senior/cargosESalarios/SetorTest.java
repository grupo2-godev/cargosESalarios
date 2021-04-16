package br.com.proway.senior.cargosESalarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SetorTest {

	@Test
	public void testCadastrarSetor() {
		Setor setor = new Setor();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();
		
		setor.capacidade = 10;
		setor.nomeSetor = "Recursos humanos";
		setor.cadastrarSetor(listaSetor);
		
		assertTrue(listaSetor.contains(setor));
	}
}

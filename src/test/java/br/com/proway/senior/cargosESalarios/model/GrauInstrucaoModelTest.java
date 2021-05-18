package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testes da Classe GrauInstrucaoModel {@link GrauInstrucaoModel}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class GrauInstrucaoModelTest {


	@Test
	public void testConstrutorVazio() {
		GrauInstrucaoModel novoGI = new GrauInstrucaoModel();
		novoGI.setId(1);
		novoGI.setNome("Ensino Médio Completo");
		assertEquals((Integer) 1, novoGI.getId());
		assertEquals("Ensino Médio Completo", novoGI.getNome());
	}

}

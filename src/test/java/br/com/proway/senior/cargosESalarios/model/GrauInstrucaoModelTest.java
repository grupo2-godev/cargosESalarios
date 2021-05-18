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

	@Test
	public void testConstrutorComId() {
		GrauInstrucaoModel novoGI = new GrauInstrucaoModel(3, "Ensino Superior Completo");
		assertEquals((Integer) 2, novoGI.getId());
		assertEquals("Ensino Superior Completo", novoGI.getNome());
	}
	
	@Test
	public void testConstrutorSemId() {
		GrauInstrucaoModel novoGI = new GrauInstrucaoModel("Pós Graduação");
		assertEquals("Pós Graduação", novoGI.getNome());
	}
	
}

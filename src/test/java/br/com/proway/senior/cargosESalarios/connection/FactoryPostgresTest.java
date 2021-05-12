package br.com.proway.senior.cargosESalarios.connection;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;

/**
 * Testes da classe FactoryPostgres.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */
public class FactoryPostgresTest {

	FactoryPostgres factory = new FactoryPostgres();
	
	@Test
	public void testCriarConexao() {
		assertNotNull(factory.criarConexao());
	}

}

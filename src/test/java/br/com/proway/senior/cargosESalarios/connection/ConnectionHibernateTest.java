package br.com.proway.senior.cargosESalarios.connection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

public class ConnectionHibernateTest {

	@Before
	public void init() {
		ConexaoHibernate.setSenha("admin");
	}
	
	@Test
	public void testShutdown() throws Exception {
		ConexaoHibernate.getSessao();
		ConexaoHibernate.fecharSessao();
		assertFalse(ConexaoHibernate.getSessao().isConnected());
	}
	
	@Test
	public void testFactory() throws Exception {
		SessionFactory fac = ConexaoHibernate.getSessaoFactory();
		assertTrue(fac.isOpen());
	}
	
	@Test
	public void testConstrutor() {
		ConexaoHibernate con = new ConexaoHibernate();
		assertNotNull(con);
	}
	
	@Test (expected = ExceptionInInitializerError.class)
	public void testFalhaAoCriarConnection() throws Exception {
		ConexaoHibernate.limparFactory(); // Para podermos rodar o FactoryBuilder
		ConexaoHibernate.setSenha("oPiorPassword"); // Password errado vai causar a excessao
		ConexaoHibernate.getSessaoFactory(); // Vamos obter o ExceptionInInitializerError esperado
		
	}

}

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
		ConnectionHibernate.setPassword("admin");
	}
	
	@Test
	public void testShutdown() throws Exception {
		ConnectionHibernate.getSession();
		ConnectionHibernate.shutdown();
		assertFalse(ConnectionHibernate.getSession().isConnected());
	}
	
	@Test
	public void testFactory() throws Exception {
		SessionFactory fac = ConnectionHibernate.getSessionFactory();
		assertTrue(fac.isOpen());
	}
	
	@Test
	public void testConstrutor() {
		ConnectionHibernate con = new ConnectionHibernate();
		assertNotNull(con);
	}
	
	@Test (expected = ExceptionInInitializerError.class)
	public void testFalhaAoCriarConnection() throws Exception {
		ConnectionHibernate.clearFactory(); // Para podermos rodar o FactoryBuilder
		ConnectionHibernate.setPassword("oPiorPassword"); // Password errado vai causar a excessao
		ConnectionHibernate.getSessionFactory(); // Vamos obter o ExceptionInInitializerError esperado
		
	}

}

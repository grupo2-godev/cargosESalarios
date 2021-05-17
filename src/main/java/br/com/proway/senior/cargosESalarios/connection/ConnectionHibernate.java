package br.com.proway.senior.cargosESalarios.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

public class ConnectionHibernate {
	private static SessionFactory sessionFactory;
	
	private static String dbPassword = "admin";
	/**
	 * Define a senha a ser utilizada na conexao com o banco de dados.
	 * Por padrao a senha esta definida como "admin"
	 * @param pass - Novo password
	 */
	public static void setPassword(String pass) {dbPassword = pass;}

	/**
	 * Exclui a instancia da Factory de Session para que possamos instancia-la novamente.
	 */
	public static void clearFactory() {sessionFactory = null;}

	private static Session session;

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/grupo2")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", dbPassword)
					.setProperty("hibernate.jdbc.time_zone", "UTC")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
					.setProperty("hibernate.show_sql", "true")
					.setProperty("hibernate.format_sql", "false")
					.setProperty("hibernate.hbm2ddl.auto", "update")
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(CargoModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(CBO1994Model.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(CBO2002Model.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(GrauInstrucaoModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(HorasMesModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(NivelModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(PostoDeTrabalhoModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(SetorModel.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("A criação da SessionFactory inicial falhou: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

	public static void shutdown() {
		session.close();
		getSessionFactory().close();
	}

	public static Session getSession() {
		getSessionFactory();
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}
}

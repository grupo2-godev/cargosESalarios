package br.com.proway.senior.cargosESalarios.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.proway.senior.cargosESalarios.controller.Cbo1994Controller;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Cbo2002Model;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

public class ConnectionHibernate {
	private static SessionFactory sessionFactory;

	private static Session session;

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/grupo2")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", "admin")
					.setProperty("hibernate.jdbc.time_zone", "UTC")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
					.setProperty("hibernate.show_sql", "true").setProperty("hibernate.format_sql", "false")
					.setProperty("hibernate.hbm2ddl.auto", "update")
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(CargoModel.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(Cbo1994Model.class)
					.setProperty("hibernate.connection.autocommit", "true").addAnnotatedClass(Cbo2002Model.class)
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

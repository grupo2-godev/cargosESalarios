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


/**
 * Classe ConexaoHibernate.
 * 
 * Classe de conexao com o banco com o banco de dados Postgres.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */

public class ConexaoHibernate {
	
	private static SessionFactory sessaoFactory;
	
	private static String senha = "admin";
	/**
	 * Define a senha a ser utilizada na conexao com o banco de dados.
	 * Por padrao a senha esta definida como "admin"
	 * @param pass - Novo password
	 */
	public static void setSenha(String novaSenha) {senha = novaSenha;}

	/**
	 * Exclui a instancia da Factory de Session para que possamos instancia-la novamente.
	 */
	public static void limparFactory() {sessaoFactory = null;}

	private static Session sessao;

	private static SessionFactory construirSessaoFactory() {
		try {
			return new Configuration().setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/grupo2")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", senha)
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

	public static SessionFactory getSessaoFactory() {
		if (sessaoFactory == null)
			sessaoFactory = construirSessaoFactory();
		return sessaoFactory;
	}

	public static void fecharSessao() {
		getSessaoFactory().close();
	}

	public static Session getSessao() {
		getSessaoFactory();
		if (sessao == null)
			sessao = sessaoFactory.openSession();
		return sessao;
	}
}

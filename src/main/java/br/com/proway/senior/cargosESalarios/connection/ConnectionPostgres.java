package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe de conexao com o banco de dados Postgres e implemtacao da 
 * interface de conexao criando a conexao. Implementa o Design Pattern Singleton
 * para que nao haja mais de uma conexao ativa com o banco de dados.
 * 
 * @author David Hildebrandt, david.hildebrandt@senior.com.br
 * @author Sabrina Schmidt, sabrina.schmidt@senior.com.br
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 4 e 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public final class ConnectionPostgres implements IConectar {
	
	private static ConnectionPostgres instance;
	private static String url = "jdbc:postgresql://localhost:5432/grupo2";
	private static String usuario = "postgres";
	private static String senha = "admin";
	private static Connection conexao;
	
	/**
	 * Metodo Conectar
	 * 
	 * Realiza a conexao com o banco de dados, conforme parametros de URL, usuario e senha.
	 * Retorna uma instancia da conexao para implementacao do Design Pattern Singleton.
	 * 
	 * @return instance
	 */
	public  Connection conectar() {
		try {
			 conexao = DriverManager.getConnection(url, usuario, senha);
			 System.out.println("Conectado com sucesso.");
			 return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao conectar.");
		}
		return conexao;
	}

	/**
	 * Metodo getInstance
	 * 
	 * Verifica se já existe uma conexao ativa e, caso exista, retorna a mesma.
	 * Caso nao exista, retorna uma nova instancia ConneticonPostgres.
	 * 
	 * @return instance
	 */
	public static ConnectionPostgres getInstance() {
		if (instance == null) {
			instance = new ConnectionPostgres();
		}
		return instance;
	} 
	
	/**
	 * Metodo dbVersion
	 * 
	 * Metodo realiza uma query no banco para verificar a vers�o do mesmo.
	 * Retorna uma mensagem de conexao valida ou invalida, utilizada no teste
	 * desta classe e do metodo conectar().
	 * 
	 * @return String
	 * @throws SQLException
	 */
	public String dbVersion() throws SQLException {
		try {
			if (conexao == null){
				conectar();
			}
			String query = "SELECT VERSION()";
			Statement stmt = ((java.sql.Connection) conectar()).createStatement();
			stmt.execute(query);
			String mensagem = "Conectado com sucesso.";
			System.out.println(mensagem);
			return mensagem;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Falha ao conectar.");
		}
		return "Falha ao conectar.";
	}
	
	/**
	 * M�todo executeQuery
	 * 
	 * Realiza a execu��o de uma query no banco de dados, conforme String
	 * informada.
	 * 
	 * @param String query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(String query) throws SQLException {
		Statement st = conexao.createStatement();
		ResultSet rs = st.executeQuery(query);
		conexao.close();
		return rs;	
	}

	/**
	 * M�todo executeUpdate
	 * 
	 * Realiza o update no banco conforme query informada como
	 * par�metro.
	 * 
	 * @param String query
	 * @return void
	 * @throws SQLException
	 */
	public static void executeUpdate(String query) throws SQLException {
		Statement st = conexao.createStatement();
		st.executeUpdate(query);
		conexao.close();
	}

	
	
}


package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe de conexÃ£o com o banco de dados e implemtaÃ§Ã£o da interface 
 * de conexÃ£o criando a conexÃ£o.
 * 
 * @author David Hildebrandt, david.hildebrandt@senior.com.br
 * @author Sabrina Schmidt, sabrina.schmidt@senior.com.br
 * @author Sarah Brito, sarah.brito@senior.com.br
 */
public final class ConnectionPostgres implements IConectar {
	private static String url = "jdbc:postgresql://localhost:5432/grupo2";
	private static String usuario = "postgres";
	private static String senha = "admin";
	
	private static ConnectionPostgres instance;
	private static Connection conexao = null;
	
	/**
	 * Ao construir o singleton ocorre a conexão com o banco de dados e
	 * essa conexao fica armazenada na variavel statica 'conexao'
	 */
	public ConnectionPostgres() {
		conexao = this.conectar();
	}
	
	/**
	 * Retorna o objeto de conexao com o banco de dados armazenado na variavel 
	 * static conexao. 
	 * 
	 * @return conexao
	 */
	public Connection getConnection() {
		if (conexao == null) {
			conexao = this.conectar();
			System.out.println("Conexão Singleton estava nula mas foi estabelecida!");
		}
		System.out.println("Retornando Conexão Singleton...");
		return conexao;
	}
	
	/**
	 * Mï¿½todo Conectar
	 * 
	 * Realiza a conexï¿½o com o banco de dados.
	 * 
	 * @return Connection
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
	 * Retorna a instancia do Singleton. 
	 * 
	 * Essa função deve ser a unica forma de obter a referencia do Singleton para
	 * uso.
	 * 
	 * @return
	 */
	public static ConnectionPostgres getInstance() {
		if (instance == null) {
			instance = new ConnectionPostgres();
		}
		return instance;
	} 
	
	/**
	 * Mï¿½todo dbVersion
	 * 
	 * Mï¿½todo realiza uma query no banco para verificar a versï¿½o do mesmo.
	 * Retorna uma mensagem de conexï¿½o vï¿½lida ou invï¿½lida, utilizada no teste
	 * desta classe e do mï¿½todo conectar().
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
	 * Mï¿½todo executeQuery
	 * 
	 * Realiza a execuï¿½ï¿½o de uma query no banco de dados, conforme String
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
	 * Mï¿½todo executeUpdate
	 * 
	 * Realiza o update no banco conforme query informada como
	 * parï¿½metro.
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

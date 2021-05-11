package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.proway.senior.cargosESalarios.model.IConectar;

/**
 * Classe de conex�o com o banco de dados e implemta��o da interface 
 * de conex�o criando a conex�o.
 * 
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i>
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 * @author Sarah Brito, sarah.brito@senior.com.br
 */
public class ConnectionPostgres implements IConectar<Connection> {
	
	static String url = "jdbc:postgresql://localhost:5432/grupo2";
	static String usuario = "postgres";
	static String senha = "admin";
	static Connection conexao;
	
	/**
	 * M�todo Conectar
	 * 
	 * Realiza a conex�o com o banco de dados.
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
	 * M�todo dbVersion
	 * 
	 * M�todo realiza uma query no banco para verificar a vers�o do mesmo.
	 * Retorna uma mensagem de conex�o v�lida ou inv�lida, utilizada no teste
	 * desta classe e do m�todo conectar().
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
	}

	
	
}

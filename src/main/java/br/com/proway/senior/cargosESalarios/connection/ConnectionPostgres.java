package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Classe de conex�o com o banco de dados.
 * 
 * @author Sprint 4
 */
public class ConnectionPostgres {
	
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
	 * @throws SQLException
	 */
	public static Connection conectar() throws SQLException {
		return conexao = DriverManager.getConnection(url, usuario, senha);
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
			return mensagem;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Falha ao conectar.");
		}
		return "Falha ao conectar.";
	}

}

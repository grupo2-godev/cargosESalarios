package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Classe de conexão com o banco de dados.
 * 
 * @author Sprint 4
 */
public class ConnectionPostgres {
	
	static String url = "jdbc:postgresql://localhost:5432/grupo2";
	static String usuario = "postgres";
	static String senha = "admin";
	static Connection conexao;
	
	/**
	 * Método Conectar
	 * 
	 * Realiza a conexão com o banco de dados.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection conectar() throws SQLException {
		return conexao = DriverManager.getConnection(url, usuario, senha);
	}

	/**
	 * Método dbVersion
	 * 
	 * Método realiza uma query no banco para verificar a versão do mesmo.
	 * Retorna uma mensagem de conexão válida ou inválida, utilizada no teste
	 * desta classe e do método conectar().
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

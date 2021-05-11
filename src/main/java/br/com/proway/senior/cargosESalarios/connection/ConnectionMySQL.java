package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionMySQL implements IConectar {

	private static ConnectionMySQL instance;
	private static String url = "jdbc:mysql://localhost:5432/grupo2";
	private static String usuario = "root";
	private static String senha = "admin";
	
	public Connection conectar() {

		Connection retornoConexao = null;

		try {
			retornoConexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");

		} catch (Exception erro) {
			System.out.println("Falha ao conectar:");
			System.out.println(erro.getMessage());

			erro.printStackTrace();
		}

		return retornoConexao;
	}
	
	public static ConnectionMySQL getInstance() {
		if (instance == null) {
			instance = new ConnectionMySQL();
		}
		return instance;
	} 

}

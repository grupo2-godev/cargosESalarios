package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe de conexao com o banco de dados MySQL e implemtacao da interface de
 * conexao criando a conexao. Implementa o Design Pattern Singleton para que nao
 * haja mais de uma conexao ativa com o banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 4 e 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */

public final class ConnectionMySQL implements IConectar {

	private static ConnectionMySQL instance;
	private static String url = "jdbc:mysql://localhost:5432/grupo2";
	private static String usuario = "root";
	private static String senha = "admin";

	/**
	 * Metodo Conectar
	 * 
	 * Realiza a conexao com o banco de dados, conforme parametros de URL, usuario e
	 * senha. Retorna uma instancia da conexao para implementacao do Design Pattern
	 * Singleton.
	 * 
	 * @return conexao
	 */
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

	/**
	 * Metodo getInstance
	 * 
	 * Verifica se já existe uma conexao ativa e, caso exista, retorna a mesma. Caso
	 * nao exista, retorna uma nova instancia ConneticonPostgres.
	 * 
	 * @return instance
	 */
	public static ConnectionMySQL getInstance() {
		if (instance == null) {
			instance = new ConnectionMySQL();
		}
		return instance;
	}

}

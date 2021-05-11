package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;

/**
 * Interface IConectar
 * 
 * Dita o comportamento das classes ConnectionPostgres {@link ConnetionPostgres}
 * e ConnectionMySQL {@link ConnectionMySQL}. Ambas serao etapas da
 * FactoryConexao {@link FactoryConexao}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */

public interface IConectar {

	/**
	 * Metodo conectar().
	 * 
	 * Apos implementacao da Interface, recebe os parametros de URL, user e password
	 * para conectar ao banco de dados escolhido. Retorna uma conexao.
	 * 
	 * @return Connection
	 */
	public Connection conectar();

}

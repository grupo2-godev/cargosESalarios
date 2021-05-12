package br.com.proway.senior.cargosESalarios.connection.antigo;

import java.sql.Connection;

/**
 * Classe FactoryConexao.
 * 
 * Classe abstrata para o Factory Method de conexoes. Será extendida
 * pelas Factories FactoryPostgres {@link FactoryPostgres} e FactoryMySQL
 * {@link FactoryMySQL}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public abstract class FactoryConexao {
	
	/**
	 * Metodo criarConexao.
	 * 
	 * Metodo abstrato a ser implementado pelas demais Factories, cria a conexao com 
	 * banco de dados escolhido.
	 * 
	 * @return Connection
	 */
	public abstract Connection criarConexao();

}
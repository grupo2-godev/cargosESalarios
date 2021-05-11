package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;

/**
 * Classe FactoryPostgres
 * 
 * Classe que utiliza o Factory Method para criar conexoes com o banco de dados
 * Postgres. Extende a FactoryConexao {@link FactoryConexao}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 * 
 */
public final class FactoryPostgres extends FactoryConexao {

	/*
	 * Metodo criarConexao.
	 * 
	 * Metodo realiza a criação de um objeto ConnectionPostgres e retorna a conexao
	 * já estabelicida na padrao Singleton, logo, eh gerada apenas uma vez.
	 * 
	 * @return Connection
	 */
	@Override
	public Connection criarConexao() {
		ConnectionPostgres conexao = ConnectionPostgres.getInstance();
		return conexao.conectar();
	}

}
package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;

public final class FactoryPostgres extends FactoryConexao {

	@Override
	public Connection criarConexao() {
		ConnectionPostgres conexao = ConnectionPostgres.getInstance();
		return conexao.getConnection();
	}

}
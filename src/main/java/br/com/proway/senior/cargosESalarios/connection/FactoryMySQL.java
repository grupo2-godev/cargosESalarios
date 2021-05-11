package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;

public final class FactoryMySQL extends FactoryConexao {

	@Override
	public Connection criarConexao() {
		ConnectionMySQL conexao = ConnectionMySQL.getInstance();
		return conexao.conectar();
				
	}

}
package br.com.proway.senior.cargosESalarios.connection;

import java.sql.Connection;

public abstract class FactoryConexao {
	
	public abstract Connection criarConexao();

}
package br.com.proway.senior.cargosESalarios.model;

import java.sql.PreparedStatement;

public interface IConectar<T> {
	
	
	public T conectar();

}

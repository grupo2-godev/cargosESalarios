package br.com.proway.senior.cargosESalarios.model;

import java.sql.SQLException;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

public class ConnectFactory<T> implements InterfaceConexaoFactory<T> {
	Object ConnectionPostgres;


    //Fazer metodos que iniciem a conexão e abstrair desse mesmo metodo
	public void definirTipo(T obj) {
		
		if(obj.equals(ConnectionPostgres)) {
		try {
			ConnectionPostgres ps = new ConnectionPostgres();
			 ps.conectar();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			
		}
		
	}

}

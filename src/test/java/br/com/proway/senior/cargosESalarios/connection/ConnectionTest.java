package br.com.proway.senior.cargosESalarios.connection;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void ConnectionTest() throws SQLException {
		ConnectionPostgres conexao = new ConnectionPostgres();
		assertEquals("Conectado com sucesso.", conexao.dbVersion());
	}

}

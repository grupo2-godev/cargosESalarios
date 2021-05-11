package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDaoSqlTest {

	Integer grauinstrucao = 0;
	Integer cbo2002 = 0;
	Integer cbo1994 = 0; 
	Integer horasmes = 0;
	CargoDaoSQL cargoSql = new CargoDaoSQL();
	ConnectionPostgres conexao = new ConnectionPostgres();

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoSql.create(cargo);
		assertEquals(1, cargoSql.getAll().size());
	}
	
	@After
	public void limparTabela() throws SQLException {
			cargoSql.limparTabela();
			assertEquals(0, cargoSql.getAll().size());
	}
}
package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.HoraMesDao;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

public class HoraMesTest {

	@Before
	public void testConectarBD() throws SQLException {
		ConnectionPostgres conexaoBanco = new ConnectionPostgres();
		conexaoBanco.conectar();
	}

	@Test
	public void testConexao() {
		ConnectionPostgres conexao = new ConnectionPostgres();
		try {
			assertEquals("Conectado com sucesso.", conexao.dbVersion());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testInserirHoraMes() {
		try {
			HorasMesModel novaHoraMes = new HorasMesModel(5, 440.0);
			HoraMesDao horaMesDao = new HoraMesDao();
			horaMesDao.create(novaHoraMes.getIdGrauDeInstrucao(), novaHoraMes.getQuantidade());
			assertEquals(1, horaMesDao.getAmountOfLines());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBuscarTodosHorarios() {
		
	}
	
	@Test
	public void testBuscarHorarioPorId() {
		
	}

	@Test
	public void testAtualizarHorario() {
		
	}
	
	@Test
	public void testDeletarHorario() {
		
	}
	
	@After
	public void testLimparTabela() {
		HoraMesDao horaMesDao = new HoraMesDao();
		horaMesDao.deleteAll();
	}
	
}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.HorasMesDAO;

public class HoraMesDAOTest {

	HorasMesDAO horaMesDao = HorasMesDAO.getInstance(ConnectionHibernate.getSession());
	
//	@Before
//	public void testConectarBD() throws SQLException {
//		ConnectionPostgres conexaoBanco = new ConnectionPostgres();
//		conexaoBanco.conectar();
//	}

//	@Test
//	public void testConexao() {
//		ConnectionPostgres conexao = new ConnectionPostgres();
//		try {
//			assertEquals("Conectado com sucesso.", conexao.dbVersion());
//		} catch (SQLException e) {
//			fail(e.getMessage());
//		}
//	}

	@Test
	public void testInserirHoraMes() {
		try {
			HorasMesModel novaHoraMes = new HorasMesModel(5, 220.0);
			Integer idObjetoCadastrado = horaMesDao.create(novaHoraMes);
			Object horasMesConsultado = ConnectionHibernate.getSession().get(HorasMesModel.class, idObjetoCadastrado);
			assertEquals(idObjetoCadastrado, ((HorasMesModel) horasMesConsultado).getIdHorasMes());
		} catch (Exception e) {
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
	
//	@After
//	public void testLimparTabela() {
//		horaMesDao.deleteAll();
//	}
	
}

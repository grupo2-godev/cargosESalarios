package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;

/**
 * Testes referentes aos métodos da classe {@link CargoDAO}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
public class CargoDAOTest {
	CargoDAO cargoDAO = CargoDAO.getInstance(ConnectionHibernate.getSession());

	Integer grauinstrucao = 0;
	Integer cbo2002 = 0;
	Integer cbo1994 = 0;
	Integer horasmes = 0;

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		Object cargoConsultado = ConnectionHibernate.getSession().get(CargoModel.class, idObjetoCadastrado);
		assertEquals(idObjetoCadastrado, ((CargoModel) cargoConsultado).getIdCargo());
	}

	@Test
	public void testRetrieveId() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		Integer idObjetoCadastrado = cargoDAO.create(cargo);
		CargoModel cargoConsultado = cargoDAO.retrieve(idObjetoCadastrado);
		assertEquals(cargo.getNomeCargo(), cargoConsultado.getNomeCargo());
	}

//	@Test
//	public void testUpdate() {
//		String queryCriar = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, "
//				+ "cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) "
//				+ "VALUES ('CargoParaTesteUnitario', '" + Date.valueOf(LocalDateTime.now().toLocalDate()) + "', '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "', " + cbo2002 + ", " + cbo1994 + ", " + horasmes
//				+ ", " + grauinstrucao + ", '12', 'Desenvolvedor', true, 1)";
//		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'CargoParaTesteUnitario' AND data_cadastro = '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
//				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
//				+ " AND experiencia_minima = '12'"
//				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
//		CargoModel novoCargo = new CargoModel("NovoCargoParaTesteUnitario", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
//				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
//		boolean registroAlterado = false;
//		try {
//			conexao.conectar();
//			ConnectionPostgres.executeUpdate(queryCriar);
//			conexao.conectar();
//			ResultSet resultSet = ConnectionPostgres.executeQuery(queryConsultaId);
//			int idObjetoASerAlterado = 0;
//			if (resultSet.next()) {
//				idObjetoASerAlterado = resultSet.getInt("id_cargo");
//			}
//			registroAlterado = cargoSql.update(idObjetoASerAlterado, novoCargo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertTrue(registroAlterado);
//	}
//	
//	@Test
//	public void testDelete() {
//		String queryCriar = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, "
//				+ "cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) "
//				+ "VALUES ('CargoParaTesteUnitario', '" + Date.valueOf(LocalDateTime.now().toLocalDate()) + "', '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "', " + cbo2002 + ", " + cbo1994 + ", " + horasmes
//				+ ", " + grauinstrucao + ", '12', 'Desenvolvedor', true, 1)";
//		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'CargoParaTesteUnitario' AND data_cadastro = '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
//				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
//				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
//				+ " AND experiencia_minima = '12'"
//				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
//		boolean registroDeletado = false;
//		try {
//			conexao.conectar();
//			ConnectionPostgres.executeUpdate(queryCriar);
//			conexao.conectar();
//			ResultSet resultSet = ConnectionPostgres.executeQuery(queryConsultaId);
//			int idObjetoASerAlterado = 0;
//			if (resultSet.next()) {
//				idObjetoASerAlterado = resultSet.getInt("id_cargo");
//			}
//			registroDeletado = cargoSql.delete(idObjetoASerAlterado);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertTrue(registroDeletado);
//	}
//	
	@Test
	public void testGetAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		CargoModel cargo2 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.create(cargo);
		cargoDAO.create(cargo2);
		ArrayList<CargoModel> lista = cargoDAO.getAll();
		assertEquals(2, lista.size());
	}

	@Test
	public void deleteAll() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoDAO.create(cargo);
		assertEquals(1, cargoDAO.getAll().size());
		cargoDAO.deleteAll();
		assertEquals(0, cargoDAO.getAll().size());
	}

	@Before
	public void limparTabela() throws SQLException {
		cargoDAO.deleteAll();
		assertEquals(0, cargoDAO.getAll().size());
	}
}
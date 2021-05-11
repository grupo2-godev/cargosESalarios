package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.ResultSet;
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
	CargoDaoSql cargoSql = new CargoDaoSql();
	ConnectionPostgres conexao = new ConnectionPostgres();

	@Test
	public void testCreate() {
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoSql.create(cargo);
		assertEquals(1, cargoSql.getAll().size());
	}

	@Test
	public void testRetrieve() {
		String queryCriar = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, "
				+ "cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) "
				+ "VALUES ('CargoParaTesteUnitario', '" + Date.valueOf(LocalDateTime.now().toLocalDate()) + "', '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "', " + cbo2002 + ", " + cbo1994 + ", " + horasmes
				+ ", " + grauinstrucao + ", '12', 'Desenvolvedor', true, 1)";
		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'CargoParaTesteUnitario' AND data_cadastro = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
				+ " AND experiencia_minima = '12'"
				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
		try {
			conexao.conectar();
			ConnectionPostgres.executeUpdate(queryCriar);
			conexao.conectar();
			ResultSet resultSet = ConnectionPostgres.executeQuery(queryConsultaId);
			int idObjetoASerDeletado = 0;
			if (resultSet.next()) {
				idObjetoASerDeletado = resultSet.getInt("id_cargo");
			}
			CargoModel cargoModel = cargoSql.retrieve(idObjetoASerDeletado);
			assertNotNull(cargoModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		String queryCriar = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, "
				+ "cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) "
				+ "VALUES ('CargoParaTesteUnitario', '" + Date.valueOf(LocalDateTime.now().toLocalDate()) + "', '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "', " + cbo2002 + ", " + cbo1994 + ", " + horasmes
				+ ", " + grauinstrucao + ", '12', 'Desenvolvedor', true, 1)";
		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'CargoParaTesteUnitario' AND data_cadastro = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
				+ " AND experiencia_minima = '12'"
				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
		CargoModel novoCargo = new CargoModel("NovoCargoParaTesteUnitario", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		boolean registroAlterado = false;
		try {
			conexao.conectar();
			ConnectionPostgres.executeUpdate(queryCriar);
			conexao.conectar();
			ResultSet resultSet = ConnectionPostgres.executeQuery(queryConsultaId);
			int idObjetoASerAlterado = 0;
			if (resultSet.next()) {
				idObjetoASerAlterado = resultSet.getInt("id_cargo");
			}
			registroAlterado = cargoSql.update(idObjetoASerAlterado, novoCargo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(registroAlterado);
	}
	
	@Test
	public void testDelete() {
		String queryCriar = "INSERT INTO grupo2.cargo (nome_cargo, data_cadastro, data_ultima_revisao, cbo2002, "
				+ "cbo1994, horas_mes, grau_de_instrucao, experiencia_minima, atribuicoes, status, id_permissao) "
				+ "VALUES ('CargoParaTesteUnitario', '" + Date.valueOf(LocalDateTime.now().toLocalDate()) + "', '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "', " + cbo2002 + ", " + cbo1994 + ", " + horasmes
				+ ", " + grauinstrucao + ", '12', 'Desenvolvedor', true, 1)";
		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'CargoParaTesteUnitario' AND data_cadastro = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
				+ " AND experiencia_minima = '12'"
				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
		boolean registroDeletado = false;
		try {
			conexao.conectar();
			ConnectionPostgres.executeUpdate(queryCriar);
			conexao.conectar();
			ResultSet resultSet = ConnectionPostgres.executeQuery(queryConsultaId);
			int idObjetoASerAlterado = 0;
			if (resultSet.next()) {
				idObjetoASerAlterado = resultSet.getInt("id_cargo");
			}
			registroDeletado = cargoSql.delete(idObjetoASerAlterado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(registroDeletado);
	}

	@After
	public void limparTabela() throws SQLException {
		cargoSql.limparTabela();
		assertEquals(0, cargoSql.getAll().size());
	}
}
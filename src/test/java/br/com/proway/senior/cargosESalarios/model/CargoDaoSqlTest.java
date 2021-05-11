package br.com.proway.senior.cargosESalarios.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

public class CargoDaoSqlTest {

	Integer grauinstrucao = 0;
	Integer cbo2002 = 0;
	Integer cbo1994 = 0;
	Integer horasmes = 0;
	CargoDaoSql cargoSql = new CargoDaoSql();
	ConnectionPostgres conexao = new ConnectionPostgres();

	@Test
	public void testCreate() {
		int quantidadeDeRegistrosAntes = cargoSql.getAll().size();
		CargoModel cargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002, cbo1994,
				horasmes, grauinstrucao, "12", "Desenvolvedor", true, 1);
		cargoSql.create(cargo);
		assertEquals(quantidadeDeRegistrosAntes + 1, cargoSql.getAll().size());
		String queryConsultaId = "SELECT * FROM grupo2.cargo WHERE nome_cargo = 'Gerente' AND data_cadastro = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND data_ultima_revisao = '"
				+ Date.valueOf(LocalDateTime.now().toLocalDate()) + "' AND cbo2002 = " + cbo2002 + " AND cbo1994 = "
				+ cbo1994 + " AND horas_mes = " + horasmes + " AND grau_de_instrucao = " + grauinstrucao
				+ " AND experiencia_minima = '12'"
				+ " AND atribuicoes = 'Desenvolvedor' AND status = true AND id_permissao = 1";
		try {
			conexao.conectar();
			ResultSet resultSet = conexao.executeQuery(queryConsultaId);
			int idObjetoASerDeletado = 0;
			if (resultSet.next()) {
				idObjetoASerDeletado = resultSet.getInt("id_cargo");
			}
			cargoSql.delete(idObjetoASerDeletado);
			assertEquals(quantidadeDeRegistrosAntes, cargoSql.getAll().size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
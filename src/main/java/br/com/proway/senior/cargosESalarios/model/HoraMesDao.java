package br.com.proway.senior.cargosESalarios.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

/**
 * Classe HoraMesDao
 * 
 * Classe DAO que implementa a interface CRUDInterface para
 * interação com o banco de dados.
 * 
 * TODO Implementar métodos conforme InterfaceDaCrud
 * 
 * @author Lorran Santos, lorran.santos@senior.com.br
 */
public class HoraMesDao {

	/**
	 * * Inserir horas trabalhadas por mês.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param id
	 * @param horaMes
	 * @throws SQLException
	 */
	public void create(int id, double horaMes) throws SQLException {
		String insert1 = "INSERT INTO horas_mes (id_horas_mes, quantidade) VALUES (" + id + ", " + horaMes + ")";
		ConnectionPostgres.executeUpdate(insert1);
	}

	/**
	 * Quantidade de horas registradas
	 * 
	 * É feita uma consulta SQL para contar a quantidade de linhas que há na tabela horas_mes,
	 * a qual retornará a quantidade de horas que foram trabalhadas por mês
	 * 
	 * @return qtdBD int
	 * @throws SQLException
	 */
	public int getAmountOfLines() throws SQLException {
		String qtd = "SELECT COUNT(id_horas_mes) as quantidade FROM horas_mes";
		ResultSet colunas = ConnectionPostgres.executeQuery(qtd);
		colunas.next();
		int qtdBD = colunas.getInt("quantidade");
		return qtdBD;
	}

	/**
	 * Apaga tudo
	 * 
	 * É feito um comando para apagar todos os registros no banco de dados
	 */
	public void deleteAll() {
		String query = "DELETE FROM horas_mes";
		try {
			ConnectionPostgres.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

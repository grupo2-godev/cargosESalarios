package br.com.proway.senior.cargosESalarios.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionPostgres;

public class HoraMesDao implements CRUDInterface<HorasMesModel> {

	public void create(int id, double horaMes) throws SQLException {
		String insert1 = "INSERT INTO horas_mes (id_horas_mes, quantidade) VALUES (" + id + ", " + horaMes + ")";
		ConnectionPostgres.executeUpdate(insert1);
	}

	public int getAmountOfLines() throws SQLException {
		String qtd = "SELECT COUNT(id_horas_mes) as quantidade FROM horas_mes";
		ResultSet colunas = ConnectionPostgres.executeQuery(qtd);
		colunas.next();
		int qtdBD = colunas.getInt("quantidade");
		return qtdBD;
	}

	public void deleteAll() {
		String query = "DELETE FROM horas_mes";
		try {
			ConnectionPostgres.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int create(HorasMesModel obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HorasMesModel retrieve(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(HorasMesModel obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HorasMesModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM horas_mes WHERE id_horas_mes =" + id;
		try {
			ConnectionPostgres.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

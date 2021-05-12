package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe HorasMesDao
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 * @author Lorran Santos, lorran.santos@senior.com.br - Sprint 4
 */
public class HorasMesDAO implements InterfaceDAOCRUD<HorasMesModel> {

	private static HorasMesDAO instance;
	private Session session;

	/**
	 * Singleton da classe HorasMesDAO.
	 * 
	 * @param session
	 * @return
	 */
	public static HorasMesDAO getInstance(Session session) {
		if (instance == null)
			instance = new HorasMesDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe HorasMesDAO, utilizado no Singleton.
	 * 
	 * @param session
	 */
	private HorasMesDAO(Session session) {
		this.session = session;
	}

	/**
	 * Inserir horas trabalhadas por mes.
	 * 
	 * Recebe um objeto HorasMesModel para inserir no banco de dados.
	 * 
	 * @param HorasMesModel horasMes Objeto a ser inserido.
	 * @return int id Id do registro.
	 */
	public int create(HorasMesModel horasMes) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}

		Integer idCadastrado = (Integer) session.save(horasMes);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Quantidade de horas registradas
	 * 
	 * � feita uma consulta SQL para contar a quantidade de linhas que h� na tabela
	 * horas_mes, a qual retornar� a quantidade de horas que foram trabalhadas por
	 * m�s
	 * 
	 * @return qtdBD int
	 * @throws SQLException
	 */
	public int getAmountOfLines() throws SQLException {
		String qtd = "SELECT COUNT(id_horas_mes) as quantidade FROM grupo2.horas_mes";
		ResultSet colunas = ConnectionPostgres.executeQuery(qtd);
		colunas.next();
		int qtdBD = colunas.getInt("quantidade");
		return qtdBD;
	}

	/**
	 * Apaga tudo
	 * 
	 * � feito um comando para apagar todos os registros no banco de dados
	 */
	public void deleteAll() {
		String query = "DELETE FROM grupo2.horas_mes";
		try {
			ConnectionPostgres.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HorasMesModel retrieve(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(int id, HorasMesModel horasMes) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

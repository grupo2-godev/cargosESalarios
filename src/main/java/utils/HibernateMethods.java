package utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;

/**
 * Classe Generica com Metodos de interacao com a HibernateConnection
 * @author Willian Kenji Nishizawa
 *
 * @param <T> : Classe que serve de base para a Tabela do Hibernate (@Entity)
 */
public class HibernateMethods<T> {

	/**
	 * Retorna todas as linhas da coluna 'nomeTabela' desejada.
	 * 
	 * 
	 * @param nomeTabela : String que representa o nome da tabela representada 
	 * no banco de dados;
	 * @return 
	 */
	public List<T> listarPorTabela(Class<T> classeTabela) {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		criteria.from(classeTabela);
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	public List<T> listarPorValorDeColunaComStringIncompleta(
			Class<T> classeTabela, String nomeColuna, String valorColuna) 
		{
			Session session = ConnectionHibernate.getSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
			
			Root<T> root = criteria.from(classeTabela);
			Expression<String> selectedColumn = root.get(nomeColuna);
			
			String filter = "%" + valorColuna + "%";
			criteria.select(root)
				.where(criteriaBuilder.like(selectedColumn, filter));
				
			Query<T> query = session.createQuery(criteria);
			List<T> results = query.getResultList();
			return new ArrayList<T>(results);
		}
	
	
	/**
	 * Funcoes e suas respectivas Overloads para poder selecionar entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * <br>
	 * ex: 
	 * <br>
	 * <br>
	 * HibernateMethods<HorasMesModel> instancia = new HibernateMethods()<HorasMesModel>
	 * <br>
	 * instancia.listarPorValorDeColima(HorasMesModel.class, "quantidade", 2)
	 * <br>
	 * <br>
	 * retorna todas as entradas da Tabela HorasMesModel com quantidade=2;
	 * 
	 * @param classeTabela: XXXModel.class
	 * @param String : nomeColuna
	 * @param Integer : valorColuna
	 * @return
	 */
	public List<T> listarPorValorDeColunaExato(
		Class<T> classeTabela, String nomeColuna, Integer valorColuna) 
	{
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		Root<T> root = criteria.from(classeTabela);
		Expression<T> selectedColumn = root.get(nomeColuna);
		criteria.select(root)
			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
		
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	/**
	 * Funcoes e suas respectivas Overloads para poder selecionar entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * <br>
	 * ex: 
	 * <br>
	 * <br>
	 * HibernateMethods<HorasMesModel> instancia = new HibernateMethods()<HorasMesModel>
	 * <br>
	 * instancia.listarPorValorDeColima(HorasMesModel.class, "quantidade", 2)
	 * <br>
	 * <br>
	 * retorna todas as entradas da Tabela HorasMesModel com quantidade=2;
	 * 
	 * @param classeTabela: XXXModel.class
	 * @param String : nomeColuna
	 * @param String : valorColuna
	 * @return
	 */
	public List<T> listarPorValorDeColunaExato(
		Class<T> classeTabela, String nomeColuna, String valorColuna) 
	{
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		Root<T> root = criteria.from(classeTabela);
		Expression<T> selectedColumn = root.get(nomeColuna);
		criteria.select(root)
			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
			
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	/**
	 * Funcoes e suas respectivas Overloads para poder selecionar entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * <br>
	 * ex: 
	 * <br>
	 * <br>
	 * HibernateMethods<HorasMesModel> instancia = new HibernateMethods()<HorasMesModel>
	 * <br>
	 * instancia.listarPorValorDeColima(HorasMesModel.class, "quantidade", 2)
	 * <br>
	 * <br>
	 * retorna todas as entradas da Tabela HorasMesModel com quantidade=2;
	 * 
	 * @param classeTabela: XXXModel.class
	 * @param String : nomeColuna
	 * @param char : valorColuna
	 * @return
	 */
	public List<T> listarPorValorDeColunaExato(
		Class<T> classeTabela, String nomeColuna, char valorColuna) 
	{
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		Root<T> root = criteria.from(classeTabela);
		Expression<T> selectedColumn = root.get(nomeColuna);
		criteria.select(root)
			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
			
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	/**
	 * Funcoes e suas respectivas Overloads para poder selecionar entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * <br>
	 * ex: 
	 * <br>
	 * <br>
	 * HibernateMethods<HorasMesModel> instancia = new HibernateMethods()<HorasMesModel>
	 * <br>
	 * instancia.listarPorValorDeColima(HorasMesModel.class, "quantidade", 2)
	 * <br>
	 * <br>
	 * retorna todas as entradas da Tabela HorasMesModel com quantidade=2;
	 * 
	 * @param classeTabela: XXXModel.class
	 * @param String : nomeColuna
	 * @param boolean : valorColuna
	 * @return
	 */
	public List<T> listarPorValorDeColunaExato(
			Class<T> classeTabela, String nomeColuna, boolean valorColuna) 
		{
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		Root<T> root = criteria.from(classeTabela);
		Expression<T> selectedColumn = root.get(nomeColuna);
		criteria.select(root)
			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
			
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	/**
	 * Funcoes e suas respectivas Overloads para poder selecionar entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * <br>
	 * ex: 
	 * <br>
	 * <br>
	 * HibernateMethods<HorasMesModel> instancia = new HibernateMethods()<HorasMesModel>
	 * <br>
	 * instancia.listarPorValorDeColima(HorasMesModel.class, "quantidade", 2)
	 * <br>
	 * <br>
	 * retorna todas as entradas da Tabela HorasMesModel com quantidade=2;
	 * 
	 * @param classeTabela: XXXModel.class
	 * @param String : nomeColuna
	 * @param Double : valorColuna
	 * @return
	 */
	public List<T> listarPorValorDeColunaExato(
		Class<T> classeTabela, String nomeColuna, Double valorColuna) 
	{
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		Root<T> root = criteria.from(classeTabela);
		Expression<T> selectedColumn = root.get(nomeColuna);
		criteria.select(root)
			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
			
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
}

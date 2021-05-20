package br.com.proway.senior.cargosESalarios.utilidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;

/**
 * Classe Generica com Metodos de interacao com a HibernateConnection
 * @author Willian Kenji Nishizawa
 *
 * @param <T> : Classe que serve de base para a Tabela do Hibernate (@Entity)
 */
public class HibernateMethods<T> {
	
	private HibernateMethods<T> hibernateMethods;
	
	public HibernateMethods<T> getInstance() {
		if(hibernateMethods == null) {
			hibernateMethods = new HibernateMethods<T>();
		}
		return this.hibernateMethods;
	}
	
	private HibernateMethods() {}
	
	/***
	 * Insere no banco de dados o registro de um objeto.
	 *
	 * @param obj Objeto a ser inserido.
	 * @return int Id do objeto inserido.
	 */
	public int criar(T entidade) {
		Session sessao = ConexaoHibernate.getSessao();
		if (!sessao.getTransaction().isActive())
			sessao.beginTransaction();

		Integer idCadastrado = (Integer) sessao.save(entidade);
		sessao.getTransaction().commit();
		return idCadastrado;
	}
	
	/***
	 * Realiza uma busca no banco de dados pelo ID informado e retorna a 
	 * tupla com os dados correspondentes.
	 * 
	 * @param int Id do cargo a ser consultado.
	 * @param classeTabela Class classe da entidade
	 * @return Objeto encontrado no banco de dados.
	 */
	public T buscar(Class<T> classeTabela, int id) {
		return ConexaoHibernate.getSessao().get(classeTabela, id);
	}
	
	/**
	 * Deleta do banco de dados um objeto.
	 * 
	 * 
	 * @param int Id do objeto a ser deletado.
	 * @param classeTabela Class classe da entidade
	 * @return boolean Retorna true caso o banco de dados encontre um objeto com o
	 *         id recebido. Retorna false caso ocorra algum erro durante o método.
	 */
	public boolean deletar(Class<T> classeTabela,int id) {
		T cargo = buscar(classeTabela,id);

		if (!ConexaoHibernate.getSessao().getTransaction().isActive()) {
			ConexaoHibernate.getSessao().beginTransaction();
		}
		ConexaoHibernate.getSessao().delete(cargo);
		ConexaoHibernate.getSessao().getTransaction().commit();
		return true;
	}
	
	/**
	 * Retorna todas as linhas da coluna 'nomeTabela' desejada.
	 * 
	 * 
	 * @param classeTabela Class classe da entidade
	 * @return 
	 */
	public List<T> listarPorTabela(Class<T> classeTabela) {
		Session session = ConexaoHibernate.getSessao();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
		criteria.from(classeTabela);
		Query<T> query = session.createQuery(criteria);
		List<T> results = query.getResultList();
		return new ArrayList<T>(results);
	}
	
	/**
	 * Seleciona entradas de 
	 * tabelas utilizando uma de suas colunas e seu valor como filtro.
	 * 
	 * A variavel valorColuna pode ser uma string parcial do resultado desejado.
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
	public List<T> listarPorValorDeColunaComStringIncompleta(
			Class<T> classeTabela, String nomeColuna, String valorColuna) 
		{
			Session session = ConexaoHibernate.getSessao();
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
		Session session = ConexaoHibernate.getSessao();
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
		Session session = ConexaoHibernate.getSessao();
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
//	public List<T> listarPorValorDeColunaExato(
//		Class<T> classeTabela, String nomeColuna, char valorColuna) 
//	{
//		Session session = ConexaoHibernate.getSessao();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(classeTabela);
//		Root<T> root = criteria.from(classeTabela);
//		Expression<T> selectedColumn = root.get(nomeColuna);
//		criteria.select(root)
//			.where(criteriaBuilder.equal(selectedColumn, valorColuna));
//			
//		Query<T> query = session.createQuery(criteria);
//		List<T> results = query.getResultList();
//		return new ArrayList<T>(results);
//	}
	
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
		Session session = ConexaoHibernate.getSessao();
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
	 * ex: =
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
		Session session = ConexaoHibernate.getSessao();
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

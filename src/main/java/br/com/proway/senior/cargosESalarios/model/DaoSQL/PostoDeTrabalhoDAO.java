package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe PostoDeTrabalhoDAO
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 4 e 5
 * @author Lorran Santos, lorran.santos@senior.com.br - Sprint 4
 * @author Samuel Levi, samuel.levi@senior.com.br - Sprint 4
 */

public class PostoDeTrabalhoDAO implements InterfaceDAOCRUD<PostoDeTrabalhoModel> {

	private static PostoDeTrabalhoDAO instance;
	private Session session;

	/**
	 * Singleton da classe PostoDeTrabalhoDAO.
	 * 
	 * @param session
	 * @return PostoDeTrabalhoDAO
	 */
	public static PostoDeTrabalhoDAO getInstance(Session session) {
		if (instance == null) {
			instance = new PostoDeTrabalhoDAO(session);
		}
		return instance;
	}

	/**
	 * Contrutor da classe PostoDeTrabalhoDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private PostoDeTrabalhoDAO(Session session) {
		this.session = session;
	}

	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return Id do posto de trabalho cadastrado
	 */
	public int create(PostoDeTrabalhoModel postoModel) {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Integer idCadastrado = (Integer) session.save(postoModel);
		session.getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Metodo retrieve por idPosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme idPosto
	 * informada.
	 * 
	 * @param int idPosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(int idPosto) {
		return session.get(PostoDeTrabalhoModel.class, idPosto);
	}

	/**
	 * Metodo retrieve por nomePosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme
	 * nomePosto informado. O nome pode ser parcial, pois realizara a busca de todos
	 * os postos que contenham determinado texto.
	 * 
	 * @param String nomePosto
	 * @return PostoDeTrabalhoModel
	 */
	public ArrayList<PostoDeTrabalhoModel> retrieveByName(String nomePosto) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PostoDeTrabalhoModel> criteria = criteriaBuilder.createQuery(PostoDeTrabalhoModel.class);
		Root<PostoDeTrabalhoModel> root = criteria.from(PostoDeTrabalhoModel.class);
		Query query = session.createQuery(criteria);
		Expression registroSetor = (Expression) root.get("nomePosto");
		criteria.select(root).where(criteriaBuilder.like(registroSetor, "'%" + nomePosto + "%'"));
		List<PostoDeTrabalhoModel> resultado = query.getResultList();
		return new ArrayList<PostoDeTrabalhoModel>(resultado);
	}

	/**
	 * Metodo upadate
	 * 
	 * Metodo realiza a atualizacao dos dados no banco de dados para o posto
	 * informado, conforme idPosto.
	 * 
	 * @param int                  idPosto
	 * @param PostoDeTrabalhoModel postoModel
	 * @return boolean
	 */
	public boolean update(int idPosto, PostoDeTrabalhoModel postoAtualizado) {
		PostoDeTrabalhoModel original = retrieve(idPosto);
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		original.setNomePosto(postoAtualizado.getNomePosto());
		original.setIdCargo(postoAtualizado.getIdCargo());
		original.setIdSetor(postoAtualizado.getIdSetor());
		original.setIdNivel(postoAtualizado.getIdNivel());
		original.setSalario(postoAtualizado.getSalario());
		session.update(original);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo delete
	 * 
	 * Realiza a exclusao do posto de trabalho informado em idPosto.
	 * 
	 * @param int idPosto
	 * @return boolean
	 */
	public boolean delete(int idPosto) {
		PostoDeTrabalhoModel entry = retrieve(idPosto);

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.delete(entry);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo getAll
	 * 
	 * Metodo realiza a busca de todos os postos de trabalho cadastrados no banco e
	 * armazena em um ArrayList.
	 * 
	 * @return ArrayList<PostoDeTrabalhoModel>
	 */
	public ArrayList<PostoDeTrabalhoModel> getAll() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PostoDeTrabalhoModel> criteria = criteriaBuilder.createQuery(PostoDeTrabalhoModel.class);
		Root<PostoDeTrabalhoModel> root = criteria.from(PostoDeTrabalhoModel.class);
		Query query = session.createQuery(criteria);
		List<PostoDeTrabalhoModel> results = query.getResultList();
		return new ArrayList<PostoDeTrabalhoModel>(results);
	}

	/**
	 * Deletar todos os postos de trabalho.
	 * 
	 * Metodo limpa a tabela posto de trabalho no banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deleteAll() {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		int modificados = session.createSQLQuery("DELETE FROM posto_de_trabalho")
				.executeUpdate();
		session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}

}

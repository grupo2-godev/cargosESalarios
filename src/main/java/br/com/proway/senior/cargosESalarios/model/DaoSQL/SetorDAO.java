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
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe SetoroDaoSql
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAO implements InterfaceDAOCRUD<SetorModel> {

	private static SetorDAO instance;
	private Session session;
	
	/**
	 * Singleton da classe SetorDAO.
	 * 
	 * @param Session session
	 * @return SetorDAO instance
	 */
	public static SetorDAO getInstance(Session session) {
		if (instance == null)
			instance = new SetorDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe SetorDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private SetorDAO(Session session) {
		this.session = session;
	}
	
	/***
	 * Inserir setor.
	 * 
	 * Recebe um objeto setor para inserir no banco de dados.
	 * 
	 * @param SetorModel setorModel
	 * @return id do setor cadastrado
	 */
	public int create(SetorModel novoSetor) {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}

		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(novoSetor);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Buscar setor por idSetor.
	 * 
	 * Mwtodo realiza a busca dos dados do setor no banco de dados, conforme idSetor
	 * informada.
	 * 
	 * @param int idSetor
	 * @return SetorModel
	 */
	public SetorModel retrieve(int idSetor) {
		return ConnectionHibernate.getSession().get(SetorModel.class, idSetor);
	}

	/**
	 * Buscar setor por nome.
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme
	 * nomeSetor informado.
	 * 
	 * @param String nomeSetor
	 * @return SetorModel
	 */
	public ArrayList<SetorModel> retrieveByName(String nomeSetor) {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SetorModel> criteria = criteriaBuilder.createQuery(SetorModel.class);
		Root<SetorModel> root = criteria.from(SetorModel.class);
		Query query = session.createQuery(criteria);
		Expression registroSetor = (Expression) root.get("nomeSetor");
		criteria.select(root).where(criteriaBuilder.like(registroSetor, "'%" + nomeSetor + "%'"));
		List<SetorModel> resultado = query.getResultList();
		return new ArrayList<SetorModel> (resultado);
	}

	/**
	 * Atualizar setor.
	 * 
	 * Metodo realiza a atualizacao no banco de dados para o setor informado,
	 * conforme idSetor.
	 * 
	 * @param int        idSetor Identificacao do setor que sera atualizado
	 * @param SetorModel setorModel
	 * @return boolean
	 */
	public boolean update(int idSetor, SetorModel setorAtualizado) {
		SetorModel original = retrieve(idSetor);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setNomeSetor(setorAtualizado.getNomeSetor());
		original.setIdPermissao(setorAtualizado.getIdPermissao());
		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Deletar setor.
	 * 
	 * Realiza a exclusao do setor informado em idSetor.
	 * 
	 * @param int idSetor identificacao do setor que sera deletado
	 * @return boolean
	 */
	public boolean delete(int idSetor) {
		SetorModel entry = retrieve(idSetor);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Listar todos os setores.
	 * 
	 * Metodo realiza a busca de todos os setores cadastrados no banco e armazena em
	 * um ArrayList.
	 * 
	 * @return ArrayList SetorModel
	 */
	public ArrayList<SetorModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SetorModel> criteria = criteriaBuilder.createQuery(SetorModel.class);
		Root<SetorModel> root = criteria.from(SetorModel.class);
		Query query = session.createQuery(criteria);
		List<SetorModel> results = query.getResultList();
		return new ArrayList<SetorModel>(results);
	}

	/**
	 * Deletar todos os setores.
	 * 
	 * Metodo limpa a tabela setor no banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}

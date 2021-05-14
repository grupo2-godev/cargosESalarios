package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

public class NivelDAO  implements InterfaceDAOCRUD<NivelModel>{

	private static NivelDAO instance;
	private Session session;
	
	/** Palavras chaves
	 * 
	 * private - public   <- Define quem pode acessar - OBRIGATORIO
	 * Static <- por onde o acesso é feito (classe ou objeto) : OPCIONAL ... NivelDAO.getInstance
	 * Void - Boolean - int - String - etc.... <- O que a funcao retorna - OBRIGATORIO
	 *
	 * se nao fosse static teriaos que fazer:
	 * 
	 * NiveoDAO objeto = NivelDAO.getInstance() -< funcao estatica que nos retorna o objeto
	 * 
	 * objeto.funcaoSemStatic() - com o objeto em maos podemos chamar as funcoes nao estaticas
	 */
	public static NivelDAO getInstance(Session session) {
		if(instance == null) {
			instance = new NivelDAO(session);
		}
		return instance;
	}
	
	private NivelDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Cria uma nova entrada na tabela NivelModel.
	 *
	 * 
	 * @param NivelModel : Objeto que vai ser salvo no banco de dados
	 * @return int : id do objeto cadastrado no banco de dados
	 */
	public int create(NivelModel nivelModel) {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(nivelModel);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}
	
	/**
	 * Retorna o registro de NivelModel com o id providenciado ou null caso nao
	 * exista
	 * 
	 * @param int id Identificacao do registro desejado
	 * @return NivelModel objeto requisitado / null
	 */
	public NivelModel retrieve(int id) {
		return ConnectionHibernate.getSession().get(NivelModel.class, id);
	}

	/**
	 * Atualizar um registro de NivelModel.
	 * 
	 * Realiza a atualizacao de um registro NivelModel, conforme a Id informada
	 * como parametro e o objetoAlterado com os valores a serem modificados.
	 * 
	 * @param int id Identificacao do registro que será alterado
	 * @param NivelModel objetoAlterado objeto com os dados a serem inseridos.
	 * @return boolean : sucesso da operacao
	 */
	public boolean update(int id, NivelModel objetoAlterado) {
		NivelModel original = retrieve(id);
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setNome(objetoAlterado.getNome());
		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}
	
	/**
	 * Deleta o registro do banco de dados com a id informada.
	 * 
	 * @param int id Identificacao do registro que será removido
	 * @return boolean : sucesso da operacao
	 */
	public boolean delete(int id) {
		NivelModel entry = retrieve(id);
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	public ArrayList<NivelModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<NivelModel> criteria = criteriaBuilder.createQuery(NivelModel.class);
		
		Root<NivelModel> root = criteria.from(NivelModel.class);
		Query query = session.createQuery(criteria);
		
		List<NivelModel> results = query.getResultList();
		return new ArrayList<NivelModel>(results);
	}

	public boolean deleteAll() {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int modificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM nivelmodel").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		return modificados > 0 ? true : false;
	}
	
}

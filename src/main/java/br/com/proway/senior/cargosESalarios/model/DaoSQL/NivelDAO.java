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
	
	/**
	 * 
	 * @param session
	 */
	private NivelDAO(Session session) {
		this.session = session;
	}
	public int create(NivelModel nivelModel) {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(nivelModel);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}
	

	public NivelModel retrieve(int id) {
		return ConnectionHibernate.getSession().get(NivelModel.class, id);
	}

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

	public boolean delete(int id) {
		NivelModel entry = retrieve(id);
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * <h1> Obtem todos os registros da Tabela.</h1>
	 * 
	 * Abre uma conecao
	 * Cria uma 'criteriaBuilder', para ter acesso as funcionalidades de uma criteria
	 * Cria uma 'criteria', utilizando uma funcionalidade de referencia a objetos da classe NivelModel
	 * Determinada de qual tabela deseja fazer algo, aos referidos objetos NvelModel
	 * Cria uma 'query' a partir das criterias desejadas, para poder ter acesso aos dados (poder retorna-os)
	 * Cria uma lista que contem em cada posicao uma entrada contida na tabela
	 * Retorna a lista no formato ArrayList
	 * 
	 * @return ArrayList<NivelModel> contendo as entradas da tabela.
	 */
	public ArrayList<NivelModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<NivelModel> criteria = criteriaBuilder.createQuery(NivelModel.class);
		
		Root<NivelModel> root = criteria.from(NivelModel.class);
		Query query = session.createQuery(criteria);
		
		List<NivelModel> results = query.getResultList();
		return new ArrayList<NivelModel>(results);
	}

	/** <h1>Remove todas as entradas da Tabela</h1>
	 * 
	 * Verifica se ha uma conexão aberta, caso nao, abre uma
	 * Deleta da tabela 'nivelmodel' todos os dados, e "pega" a quantidade de linhas que foram deletadas
	 * Retorna o sucesso caso uma ou mais entradas tenham sido deletadas
	 * 
	 * @return Boolean : true/false para itens deletados.
	 */
	public boolean deleteAll() {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		int modificados = ConnectionHibernate.getSession().createSQLQuery("DELETE FROM nivelmodel").executeUpdate();
		ConnectionHibernate.getSession().getTransaction().commit();
		return modificados > 0 ? true : false;
	}
	
}

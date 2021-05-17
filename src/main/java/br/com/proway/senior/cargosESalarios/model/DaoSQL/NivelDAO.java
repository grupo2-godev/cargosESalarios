package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe DAO para a tabela de NivelModel
 * 
 *  @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 *  @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 *
 */
public class NivelDAO  implements InterfaceDAOCRUD<NivelModel>{

	private static NivelDAO instance;
	private Session session;
	
	/**
	 * Obtem a instancia do Singleton DAO.
	 * @param session : HibernateSession a ser utilizada
	 * @return
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
	
	/**
	 * Cria uma nova entrada na tabela NivelModel.
	 *
	 * 
	 * @param NivelModel : Objeto que vai ser salvo no banco de dados
	 * @return int : id do objeto cadastrado no banco de dados
	 */
	public int create(NivelModel nivelModel) {
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Integer idCadastrado = (Integer) session.save(nivelModel);
		session.getTransaction().commit();
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
		return session.get(NivelModel.class, id);
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
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		original.setNome(objetoAlterado.getNome());
		session.update(original);
		session.getTransaction().commit();
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
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.delete(entry);
		session.getTransaction().commit();
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
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		int modificados = session.createSQLQuery("DELETE FROM nivelmodel").executeUpdate();
		session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
	
}

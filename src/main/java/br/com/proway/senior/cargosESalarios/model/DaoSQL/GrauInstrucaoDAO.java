package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe grau de instrucao que implementa a {@link InterfaceDAOCRUD} para
 * interação com o banco de dados.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i> - Sprint 4
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i> - Sprint 4
 */

public class GrauInstrucaoDAO implements InterfaceDAOCRUD<GrauInstrucaoModel> {
	private static GrauInstrucaoDAO instance;
	private Session session;

	/**
	 * Singleton da classe GrauInstrucaoDAO
	 * 
	 * @param session Session
	 * @return instance GrauInstrucaoDAO
	 */
	public static GrauInstrucaoDAO getInstance(Session session) {
		if (instance == null)
			instance = new GrauInstrucaoDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe GrauInstrucaoDAO, utilizado no Singleton.
	 * 
	 * @param session Session
	 */
	private GrauInstrucaoDAO(Session session) {
		this.session = session;
	}

	/**
	 * Cadastra um novo grau de instrucao.
	 * 
	 * @param grauInstrucao
	 * @return id do objetoCriado
	 */
	public int create(GrauInstrucaoModel grauInstrucao) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive())
			ConnectionHibernate.getSession().beginTransaction();

		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(grauInstrucao);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Busca um objeto do tipo {@link GrauInstrucaoModel} atraves do Id.
	 * 
	 * Consulta no banco de dados grupo2.grau_instrucao um objeto do tipo
	 * {@link GrauInstrucaoModel} que contenha o ID igual ao id recebido no
	 * parametro.
	 * 
	 * @param id int Id do objeto a ser consultado.
	 */
	public GrauInstrucaoModel retrieve(int id) {
		GrauInstrucaoModel grauInstrucao = ConnectionHibernate.getSession().get(GrauInstrucaoModel.class, id);
		return grauInstrucao;
	}

	/**
	 * busca o Grau de Instrucao pelo nome.
	 * 
	 * Verifica todos os graus de instrucoes e se o nome dele for igual ao passado
	 * como parametro, retorna o objeto.
	 * 
	 * @param nome String Nome do Grau de Instrucao
	 */
//	public GrauInstrucaoModel retrieve(String nome) {
//		return null;
//	}

	/***
	 * Atualizar um objeto do tipo {@link GrauInstrucaoModel}.
	 * 
	 * Recebe um objeto do tipo {@link GrauInstrucaoModel} que sera a atualizacao do
	 * objeto no banco de dados que possui o id recebido no parametro.
	 * 
	 * @param grauInstrucao GrauInstrucaoModel Novo objeto que sera inserido no
	 *                      banco de dados.
	 * @param id            int Id do objeto a ser atualizado.
	 * @return boolean Retorna true caso o objeto seja localizado no banco e
	 *         atualizado com sucesso. Retorna false caso ocorra algum tipo de erro
	 *         durante a atualizacao.
	 */
	public boolean update(int id, GrauInstrucaoModel grauInstrucaoNovo) {
		GrauInstrucaoModel grauInstrucao = retrieve(id);
		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		grauInstrucao.setNome(grauInstrucaoNovo.getNome());
		ConnectionHibernate.getSession().update(grauInstrucao);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Deleta do banco de dados um objeto do tipo {@link GrauInstrucaoModel}.
	 * 
	 * Consulta no banco de dados um objeto do tipo {@link GrauInstrucaoModel} cujo
	 * id eh igual ao id recebido no parametro.
	 * 
	 * @param id int Id do objeto a ser deletado.
	 * @return boolean Retorna true caso o banco de dados encontre um objeto com o
	 *         id recebido. Retorna false caso ocorra algum erro durante o método.
	 */
	public boolean delete(int id) {
		GrauInstrucaoModel grauIntrucao = retrieve(id);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(grauIntrucao);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Retorna uma lista de objetos do tipo {@link GrauInstrucaoModel}.
	 * 
	 * Busca no banco de dados todos os objetos do tipo {@link GrauInstrucaoModel} e
	 * nos retorna em um ArrayList.
	 * 
	 * @return listaDeGrauDeInstrucao ArrayList<GrauInstrucaoModel> Lista com objetos do tipo {@link GrauInstrucaoModel}.
	 */
	public ArrayList<GrauInstrucaoModel> getAll() {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<GrauInstrucaoModel> criteria = criteriaBuilder.createQuery(GrauInstrucaoModel.class);
		Root<GrauInstrucaoModel> root = criteria.from(GrauInstrucaoModel.class);
		Query query = session.createQuery(criteria);
		List<GrauInstrucaoModel> listaDeGrauDeInstrucao = query.getResultList();
		return new ArrayList<GrauInstrucaoModel>(listaDeGrauDeInstrucao);
	}

	/**
	 * Limpar ArrayList de Graus de instrucao
	 * 
	 * M�todo realiza a limpeza do ArrayList de garuInstrucao na classe Dados.
	 * Utilizado para os testes unit�rios.
	 *
	 * @return void
	 */
	public void limparArray() {
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}

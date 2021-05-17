package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
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
	 * Singleton da classe GrauInstrucaoDAO.
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
	 * @return int Id do objeto inserido.
	 */
	public int criar(GrauInstrucaoModel grauInstrucao) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();

		Integer idCadastrado = (Integer) session.save(grauInstrucao);
		session.getTransaction().commit();
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
	public GrauInstrucaoModel buscar(int id) {
		GrauInstrucaoModel grauInstrucao = session.get(GrauInstrucaoModel.class, id);
		return grauInstrucao;
	}

	/**
	 * Busca um objeto do tipo {@link GrauInstrucaoModel} atraves do nome.
	 * 
	 * Consulta no banco de dados grupo2.grau_instrucao um objeto do tipo
	 * {@link GrauInstrucaoModel} que contenha o nome igual ao nome recebido no
	 * parametro, adiciona em uma lista e retorna.
	 * 
	 * @param nome String Nome do objeto a ser consultado.
	 * @return lista ArrayList<GrayIndtrucaoModel> Lista dos objetos localizados.
	 */
	public ArrayList<GrauInstrucaoModel> retrieveNameCountains(String nomeASerConsultado) {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<GrauInstrucaoModel> criteria = criteriaBuilder.createQuery(GrauInstrucaoModel.class);
		Root<GrauInstrucaoModel> root = criteria.from(GrauInstrucaoModel.class);
		
		Expression nome = (Expression) root.get("instrucao");
		criteria.select(root).where(criteriaBuilder.like(nome, "%" + nomeASerConsultado + "%"));
		Query<GrauInstrucaoModel> query = session.createQuery(criteria);
		List<GrauInstrucaoModel> lista = query.getResultList();
		return (ArrayList<GrauInstrucaoModel>)lista;
		
	}

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
	public boolean atualizar(int id, GrauInstrucaoModel grauInstrucaoNovo) {
		GrauInstrucaoModel grauInstrucao = buscar(id);
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		grauInstrucao.setNome(grauInstrucaoNovo.getNome());
		session.update(grauInstrucao);
		session.getTransaction().commit();
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
	public boolean deletar(int id) {
		GrauInstrucaoModel grauIntrucao = buscar(id);

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.delete(grauIntrucao);
		session.getTransaction().commit();
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
	public ArrayList<GrauInstrucaoModel> buscarTodos() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<GrauInstrucaoModel> criteria = criteriaBuilder.createQuery(GrauInstrucaoModel.class);
		Root<GrauInstrucaoModel> root = criteria.from(GrauInstrucaoModel.class);
		Query query = session.createQuery(criteria);
		List<GrauInstrucaoModel> listaDeGrauDeInstrucao = query.getResultList();
		return new ArrayList<GrauInstrucaoModel>(listaDeGrauDeInstrucao);
	}

	/**
	 * Deleta todos os objetos da tabela {@link GrauInstrucaoModel}.
	 * 
	 * @return boolean Retorna true caso algum registro seja deletado, se der algum erro ou se nao houverem registros, retorna false.
	 */
	public boolean deletarTodos() {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		int registrosModificados = session.createSQLQuery("DELETE FROM grau_instrucao").executeUpdate();
		session.getTransaction().commit();
		return registrosModificados > 0 ? true : false;
	}

}

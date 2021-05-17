package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

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

	private static PostoDeTrabalhoDAO instancia;
	private Session sessao;

	/**
	 * Singleton da classe PostoDeTrabalhoDAO.
	 * 
	 * @param sessao
	 * @return PostoDeTrabalhoDAO
	 */
	public static PostoDeTrabalhoDAO getInstancia(Session sessao) {
		if (instancia == null) {
			instancia = new PostoDeTrabalhoDAO(sessao);
		}
		return instancia;
	}

	/**
	 * Contrutor da classe PostoDeTrabalhoDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private PostoDeTrabalhoDAO(Session sessao) {
		this.sessao = sessao;
	}

	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return Id do posto de trabalho cadastrado
	 */
	public int criar(PostoDeTrabalhoModel postoModel) {
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		Integer idCadastrado = (Integer) this.sessao.save(postoModel);
		this.sessao.getTransaction().commit();
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
	public PostoDeTrabalhoModel buscar(int idPosto) {
		return this.sessao.get(PostoDeTrabalhoModel.class, idPosto);
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
	public ArrayList<PostoDeTrabalhoModel> buscarPorNome(String nomePosto) {
		CriteriaBuilder criteriaBuilder = this.sessao.getCriteriaBuilder();
		CriteriaQuery<PostoDeTrabalhoModel> criteria = criteriaBuilder.createQuery(PostoDeTrabalhoModel.class);
		Root<PostoDeTrabalhoModel> root = criteria.from(PostoDeTrabalhoModel.class);
		Query query = this.sessao.createQuery(criteria);
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
	public boolean atualizar(int idPosto, PostoDeTrabalhoModel postoAtualizado) {
		PostoDeTrabalhoModel original = buscar(idPosto);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setNomePosto(postoAtualizado.getNomePosto());
		original.setCargo(postoAtualizado.getCargo());
		original.setSetor(postoAtualizado.getSetor());
		original.setNivel(postoAtualizado.getNivel());
		original.setSalario(postoAtualizado.getSalario());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
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
	public boolean deletar(int idPosto) {
		PostoDeTrabalhoModel entry = buscar(idPosto);

		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		this.sessao.delete(entry);
		this.sessao.getTransaction().commit();
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
	public ArrayList<PostoDeTrabalhoModel> buscarTodos() {
		CriteriaBuilder criteriaBuilder = this.sessao.getCriteriaBuilder();
		CriteriaQuery<PostoDeTrabalhoModel> criteria = criteriaBuilder.createQuery(PostoDeTrabalhoModel.class);
		Root<PostoDeTrabalhoModel> root = criteria.from(PostoDeTrabalhoModel.class);
		Query query = this.sessao.createQuery(criteria);
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
	public boolean deletarTodos() {
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		int modificados = this.sessao.createSQLQuery("DELETE FROM posto_de_trabalho")
				.executeUpdate();
		this.sessao.getTransaction().commit();
		return modificados > 0 ? true : false;
	}

}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe SetorDAO
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAO implements InterfaceDAOCRUD<SetorModel> {

	private static SetorDAO instancia;
	private Session sessao;
	
	/**
	 * Singleton da classe SetorDAO.
	 * 
	 * @param Session session
	 * @return SetorDAO instance
	 */
	public static SetorDAO getInstancia(Session sessao) {
		if (instancia == null)
			instancia = new SetorDAO(sessao);
		return instancia;
	}
	
	/**
	 * Construtor da classe SetorDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private SetorDAO(Session sessao) {
		this.sessao = sessao;
	}
	
	/***
	 * Inserir setor.
	 * 
	 * Recebe um objeto setor para inserir no banco de dados.
	 * 
	 * @param SetorModel setorModel
	 * @return id do setor cadastrado
	 */
	public int criar(SetorModel novoSetor) {
		if(!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}

		Integer idCadastrado = (Integer) this.sessao.save(novoSetor);
		this.sessao.getTransaction().commit();
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
	public SetorModel buscar(int idSetor) {
		return this.sessao.get(SetorModel.class, idSetor);
	}

	/**
	 * Buscar setor por nome.
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme
	 * nomeSetor informado. O nome pode ser parcial, pois realizara a busca de
	 * todos os setores que contenham determinado texto.
	 * 
	 * @param String nomeSetor
	 * @return SetorModel
	 */
	public ArrayList<SetorModel> buscarPorNome(String nomeSetor) {
		CriteriaBuilder criteriaBuilder = this.sessao.getCriteriaBuilder();
		CriteriaQuery<SetorModel> criteria = criteriaBuilder.createQuery(SetorModel.class);
		Root<SetorModel> root = criteria.from(SetorModel.class);
		Query query = this.sessao.createQuery(criteria);
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
	public boolean atualizar(int idSetor, SetorModel setorAtualizado) {
		SetorModel original = buscar(idSetor);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setNomeSetor(setorAtualizado.getNomeSetor());
		original.setIdPermissao(setorAtualizado.getIdPermissao());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
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
	public boolean deletar(int idSetor) {
		SetorModel entry = buscar(idSetor);

		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		this.sessao.delete(entry);
		this.sessao.getTransaction().commit();
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
	public ArrayList<SetorModel> buscarTodos() {
		CriteriaBuilder criteriaBuilder = this.sessao.getCriteriaBuilder();
		CriteriaQuery<SetorModel> criteria = criteriaBuilder.createQuery(SetorModel.class);
		Root<SetorModel> root = criteria.from(SetorModel.class);
		Query query = this.sessao.createQuery(criteria);
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
	public boolean deletarTodos() {
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		int modificados = this.sessao.createSQLQuery("DELETE FROM setor").executeUpdate();
		this.sessao.getTransaction().commit();
		return modificados > 0 ? true : false;
	}

}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Implementar os metodos CRUD para o DB
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DAO implements InterfaceDAOCRUD<CBO1994Model> {

	private static CBO1994DAO instancia;
	private Session sessao;

	/**
	 * Singleton da classe CBO1994DAO
	 * 
	 * @param Session session
	 * @return CBO1994DAO instance
	 */
	public static CBO1994DAO getInstancia(Session sessao) {
		if (instancia == null)
			instancia = new CBO1994DAO(sessao);
		return instancia;
	}

	/**
	 * Construtor da classe CBO1994DAO, utilizado no Singleton
	 * 
	 * @param Session session
	 */
	private CBO1994DAO(Session sessao) {
		this.sessao = sessao;
	}

	/**
	 * Inserir CBO1994.
	 * 
	 * Recebe um objeto CBO1994Model para inserir no banco de dados.
	 * 
	 * @param CBO1994Model CBO1994
	 * @return int codigoCBO
	 */
	public int criar(CBO1994Model CBO1994) {
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		Integer codigoCBO = (Integer) sessao.save(CBO1994);
		sessao.getTransaction().commit();
		return codigoCBO;
	}

	/**
	 * Busca CBO1994 pelo seu codigo
	 * 
	 * Metodo busca o objeto CBO1994 no banco de dados conforme codigo informado
	 * 
	 * @param int codigo_CBO1994
	 * @return results retorna objeto CBO1994Model
	 */
	public CBO1994Model buscar(int codigo_CBO1994) {
		CBO1994Model results = sessao.get(CBO1994Model.class, codigo_CBO1994);
		//System.out.println(results.toString());
		return results;
	}

	/**
	 * Atualiza um CBO1994
	 * 
	 * Realiza a atualizacao de um CBO1994Model, conforme codigo informado como
	 * parametro
	 * 
	 * @param int          codigo_CBO1994
	 * @param CBO1994Model objetoAlterado
	 */
	public boolean atualizar(int codigo_CBO1994, CBO1994Model objetoAlterado) {
		CBO1994Model original = buscar(codigo_CBO1994);
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		original.setCodigo_cbo(objetoAlterado.getCodigo_cbo());
		original.setDescricao(objetoAlterado.getDescricao());
		original.setPercentualInsalubridade(objetoAlterado.getPercentualInsalubridade());
		original.setPercentualPericulosidade(objetoAlterado.getPercentualPericulosidade());

		sessao.update(original);
		sessao.getTransaction().commit();
		return true;
	}

	/**
	 * Deletar um CBO1994
	 * 
	 * Metodo deleta um CBO1994, conforme codigo CBO1994 informado
	 * 
	 * @param int codigo_CBO1994
	 * @return boolean
	 */
	public boolean deletar(int codigo_CBO1994) {
		CBO1994Model objeto_deletar = buscar(codigo_CBO1994);

		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}

		sessao.delete(objeto_deletar);
		sessao.getTransaction().commit();
		return true;
	}

	/**
	 * Busca todos os CBO1994 cadastrados
	 * 
	 * Metodo busca todos os CBO1994 cadastrados que constam no banco de dados e retorna no formate de ArrayList
	 * 
	 * @return ArrayList<Cbo1994Model>
	 */
	public ArrayList<CBO1994Model> buscarTodos() {	
		CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
		CriteriaQuery<CBO1994Model> criteria = criteriaBuilder.createQuery(CBO1994Model.class);
		
		Root<CBO1994Model> root = criteria.from(CBO1994Model.class);
		
		Query query = sessao.createQuery(criteria);
		
		List<CBO1994Model> results = query.getResultList();
		
		return new ArrayList<CBO1994Model>(results);
	}

	/**
	 * Deleta todos os CBO1994 no banco de dados
	 * 
	 * Metodo remove todos os CBO1994 presentes na tabela no banco de dados
	 * 
	 * @return boolean
	 */
	public boolean deletarTodos() {
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		int modificados = sessao.createSQLQuery("DELETE FROM cbo1994").executeUpdate();
		sessao.getTransaction().commit();
		sessao.clear();
		return modificados > 0 ? true : false;
	}

}

package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe DAO que extende a classe HybernateMethods para interacao com o
 * banco de dados.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994DAO extends HibernateMethods<CBO1994Model>{

	private static CBO1994DAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();

	/**
	 * Singleton da classe CBO1994DAO
	 * 
	 * @param Session session
	 * @return CBO1994DAO instance
	 */
	public static CBO1994DAO getInstancia() {
		if (instancia == null)
			instancia = new CBO1994DAO();
		return instancia;
	}

	/**
	 * Construtor da classe CBO1994DAO, utilizado no Singleton
	 * 
	 * @param Session session
	 */
	private CBO1994DAO() {
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
		CBO1994Model original = buscar(CBO1994Model.class, codigo_CBO1994);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setCodigo_cbo(objetoAlterado.getCodigo_cbo());
		original.setDescricao(objetoAlterado.getDescricao());
		original.setPercentualInsalubridade(objetoAlterado.getPercentualInsalubridade());
		original.setPercentualPericulosidade(objetoAlterado.getPercentualPericulosidade());

		this.sessao.update(original);
		this.sessao.getTransaction().commit();
		return true;
	}


}

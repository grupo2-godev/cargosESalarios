package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe CBO2002DAO
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Samuel Alves <samuel.levi@senior.com.br> - Sprint 4
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class CBO2002DAO extends HibernateMethods<CBO2002Model> {

	private static CBO2002DAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();

	/**
	 * Singleton da classe CBO2002DAO.
	 * 
	 * @param Session session
	 * @return CBO2002DAO instance
	 */
	public static CBO2002DAO getInstancia() {
		if (instancia == null)
			instancia = new CBO2002DAO();
		return instancia;
	}

	/**
	 * Construtor da classe CBO2002DAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private CBO2002DAO() {
	}

	/**
	 * Atualizar um registro de CBO 2002.
	 * 
	 * Realiza a atualizacao de um registro CBO 2002, conforme o codigo informado
	 * como parametro.
	 * 
	 * @param int          codigoCBO2002 Identificacao do registro que sera alterado
	 * @param CBO2002Model cbo2002Alterado novo objeto com os dados alterados.
	 * @return boolean
	 */
	public boolean atualizar(int codigoCBO2002, CBO2002Model cbo2002Alterado) {
		CBO2002Model original = buscar(CBO2002Model.class, codigoCBO2002);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setDescricao(cbo2002Alterado.getDescricao());
		original.setPercentualInsalubridade(cbo2002Alterado.getPercentualInsalubridade());
		original.setPercentualPericulosidade(cbo2002Alterado.getPercentualPericulosidade());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
		return true;
	}
}

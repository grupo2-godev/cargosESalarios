package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe SetorDAO
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

public class SetorDAO extends HibernateMethods<SetorModel> {

	private static SetorDAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();
	
	/**
	 * Singleton da classe SetorDAO.
	 * 
	 * @param Session session
	 * @return SetorDAO instance
	 */
	public static SetorDAO getInstancia() {
		if (instancia == null)
			instancia = new SetorDAO();
		return instancia;
	}
	
	/**
	 * Construtor da classe SetorDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private SetorDAO() {
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
		SetorModel original = buscar(SetorModel.class, idSetor);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setNomeSetor(setorAtualizado.getNomeSetor());
		original.setIdPermissao(setorAtualizado.getIdPermissao());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
		return true;
	}

}

package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe DAO para a tabela de NivelModel
 * 
 *  @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 *  @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 *
 */
public class NivelDAO extends HibernateMethods<NivelModel>{

	private static NivelDAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();
	
	/**
	 * Obtem a instancia do Singleton DAO.
	 * @param sessao : HibernateSession a ser utilizada
	 * @return
	 */
	public static NivelDAO getInstancia() {
		if(instancia == null) {
			instancia = new NivelDAO();
		}
		return instancia;
	}
	
	/**
	 * 
	 * @param sessao
	 */
	private NivelDAO() {
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
	public boolean atualizar(int id, NivelModel objetoAlterado) {
		NivelModel original = buscar(NivelModel.class, id);
		if(!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setNome(objetoAlterado.getNome());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
		return true;
	}	
}

package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

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

public class PostoDeTrabalhoDAO extends HibernateMethods<PostoDeTrabalhoModel> {

	private static PostoDeTrabalhoDAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();

	/**
	 * Singleton da classe PostoDeTrabalhoDAO.
	 * 
	 * @param sessao
	 * @return PostoDeTrabalhoDAO
	 */
	public static PostoDeTrabalhoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PostoDeTrabalhoDAO();
		}
		return instancia;
	}

	/**
	 * Contrutor da classe PostoDeTrabalhoDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private PostoDeTrabalhoDAO() {
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
		PostoDeTrabalhoModel original = buscar(PostoDeTrabalhoModel.class, idPosto);
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

}

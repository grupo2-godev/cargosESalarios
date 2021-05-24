package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe HorasMesDao
 * 
 * Classe DAO que implementa a interface InterfaceDAOCRUD para interacao com o
 * banco de dados.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 * @author Lorran Santos, <b>lorran.santos@senior.com.br<b> - Sprint 4
 */
public class HorasMesDAO extends HibernateMethods<HorasMesModel> {

	private static HorasMesDAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();

	/**
	 * Singleton da classe HorasMesDAO.
	 * 
	 * @param Session session
	 * @return HorasMesDAO instance
	 */
	public static HorasMesDAO getInstancia() {
		if (instancia == null)
			instancia = new HorasMesDAO();
		return instancia;
	}

	/**
	 * Construtor da classe HorasMesDAO, utilizado no Singleton.
	 */
	private HorasMesDAO() {
	}

	/**
	 * Atualizar um registro de horas mes.
	 * 
	 * Realiza a atualizacao de um registro HorasMesModel, conforme a Id informada
	 * como parametro.
	 * 
	 * @param int           id Identificacao do registro que serÃ¡ alterado
	 * @param HorasMesModel objetoAlterado novo objeto com os dados alterados.
	 * @return boolean
	 */
	public boolean atualizar(int id, HorasMesModel objetoAlterado) {
		HorasMesModel original = buscar(HorasMesModel.class, id);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		original.setQuantidade(objetoAlterado.getQuantidade());
		this.sessao.update(original);
		this.sessao.getTransaction().commit();
		return true;
	}

}

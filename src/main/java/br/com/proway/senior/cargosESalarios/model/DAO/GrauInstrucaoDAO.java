package br.com.proway.senior.cargosESalarios.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.utilidades.HibernateMethods;

/**
 * Classe grau de instrucao que implementa a {@link InterfaceDAOCRUD} para
 * interação com o banco de dados.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i> - Sprint 4
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i> - Sprint 4
 */

public class GrauInstrucaoDAO extends HibernateMethods<GrauInstrucaoModel>{
	
	private static GrauInstrucaoDAO instancia;
	private Session sessao = ConexaoHibernate.getSessao();

	/**
	 * Singleton da classe GrauInstrucaoDAO.
	 * 
	 * @param sessao Session
	 * @return instance GrauInstrucaoDAO
	 */
	public static GrauInstrucaoDAO getInstancia() {
		if (instancia == null)
			instancia = new GrauInstrucaoDAO();
		return instancia;
	}

	/**
	 * Construtor da classe GrauInstrucaoDAO, utilizado no Singleton.
	 * 
	 * @param sessao Session
	 */
	private GrauInstrucaoDAO() {
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
		GrauInstrucaoModel grauInstrucao = buscar(GrauInstrucaoModel.class, id);
		if (!this.sessao.getTransaction().isActive()) {
			this.sessao.beginTransaction();
		}
		grauInstrucao.setNome(grauInstrucaoNovo.getNome());
		this.sessao.update(grauInstrucao);
		this.sessao.getTransaction().commit();
		return true;
	}
}

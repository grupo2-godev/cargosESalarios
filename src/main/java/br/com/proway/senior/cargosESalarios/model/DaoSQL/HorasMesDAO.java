package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

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
 * @author Lorran Santos, lorran.santos@senior.com.br - Sprint 4
 */
public class HorasMesDAO implements InterfaceDAOCRUD<HorasMesModel> {

	private static HorasMesDAO instancia;
	private Session sessao;

	/**
	 * Singleton da classe HorasMesDAO.
	 * 
	 * @param Session session
	 * @return HorasMesDAO instance
	 */
	public static HorasMesDAO getInstancia(Session sessao) {
		if (instancia == null)
			instancia = new HorasMesDAO(sessao);
		return instancia;
	}

	/**
	 * Construtor da classe HorasMesDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private HorasMesDAO(Session sessao) {
		this.sessao = sessao;
	}

	/**
	 * Inserir horas trabalhadas por mes.
	 * 
	 * Recebe um objeto HorasMesModel para inserir no banco de dados.
	 * 
	 * @param HorasMesModel horasMes Objeto a ser inserido.
	 * @return int id Id do registro.
	 */
	public int criar(HorasMesModel horasMes) {
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}

		Integer idCadastrado = (Integer) sessao.save(horasMes);
		sessao.getTransaction().commit();
		return idCadastrado;
	}

	

	/**
	 * Buscar horas mes por ID.
	 * 
	 * Metodo busca o objeto horas mes no banco de dados conforme parametro
	 * informado.
	 * 
	 * @param int id
	 * @return results retorna um objeto HorasMesModel
	 */
	public HorasMesModel buscar(int id) {
		return sessao.get(HorasMesModel.class, id);
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
		HorasMesModel original = buscar(id);
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		original.setQuantidade(objetoAlterado.getQuantidade());
		sessao.update(original);
		sessao.getTransaction().commit();
		return true;
	}

	/**
	 * Deletar um registro de horas mes.
	 * 
	 * MÃ©todo deleta um registro de horas mes no banco de dados, conforme Id
	 * informada.
	 * 
	 * @param int id Identificao do registro a ser deletado
	 * @return boolean
	 */
	public boolean deletar(int id) {
		HorasMesModel entry = buscar(id);

		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		sessao.delete(entry);
		sessao.getTransaction().commit();
		return true;
	}

	/**
	 * Buscar todos os registros de horas mes.
	 * 
	 * MÃ©todo busca todos os registros de horas mes que constam no banco de dados e
	 * retorna em um ArrayList.
	 * 
	 * @return ArrayList HorasMesModel
	 */
	public ArrayList<HorasMesModel> buscarTodos() {
		CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
		CriteriaQuery<HorasMesModel> criteria = criteriaBuilder.createQuery(HorasMesModel.class);
		Root<HorasMesModel> root = criteria.from(HorasMesModel.class);
		Query query = sessao.createQuery(criteria);
		List<HorasMesModel> results = query.getResultList();
		return new ArrayList<HorasMesModel>(results);
	}

	/**
	 * Deletar todos os registros do banco de dados.
	 * 
	 * Comando limpa a tabela de horas mes no banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deletarTodos() {
		if (!sessao.getTransaction().isActive()) {
			sessao.beginTransaction();
		}
		int modificados = sessao.createSQLQuery("DELETE FROM horas_mes").executeUpdate();
		sessao.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
}

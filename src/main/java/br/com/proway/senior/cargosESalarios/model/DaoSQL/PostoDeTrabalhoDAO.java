package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.connection.antigo.ConnectionPostgres;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryConexao;
import br.com.proway.senior.cargosESalarios.connection.antigo.FactoryPostgres;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

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

public class PostoDeTrabalhoDAO implements InterfaceDAOCRUD<PostoDeTrabalhoModel> {

	private static PostoDeTrabalhoDAO instance;
	private Session session;
	
	/**
	 * Singleton da classe PostoDeTrabalhoDAO.
	 * 
	 * @param session
	 * @return PostoDeTrabalhoDAO
	 */
	public static PostoDeTrabalhoDAO getInstance(Session session) {
		if (instance == null) {
			instance = new PostoDeTrabalhoDAO(session);
		}
		return instance;
	}
	
	/**
	 * Contrutor da classe PostoDeTrabalhoDAO, utilizado no Singleton.
	 * 
	 * @param Session session
	 */
	private PostoDeTrabalhoDAO(Session session) {
		this.session = session;
	}
	

	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir no banco de dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return Id do posto de trabalho cadastrado
	 */
	public int create(PostoDeTrabalhoModel postoModel) {
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(postoModel);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Metodo retrieve por idPosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme idPosto
	 * informada.
	 * 
	 * @param int idPosto
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(int idPosto) {
		return ConnectionHibernate.getSession().get(PostoDeTrabalhoModel.class, idPosto);
	}

	/**
	 * Metodo retrieve por nomePosto
	 * 
	 * Metodo realiza a busca dos dados do posto no banco de dados, conforme
	 * nomePosto informado. O nome pode ser parcial, pois realizara a busca de
	 * todos os postos que contenham determinado texto.
	 * 
	 * @param String nomePosto
	 * @return PostoDeTrabalhoModel
	 */
	public ArrayList<PostoDeTrabalhoModel> retrieveByName(String nomePosto) {
		Session session = ConnectionHibernate.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PostoDeTrabalhoModel> criteria = criteriaBuilder.createQuery(PostoDeTrabalhoModel.class);
		Root<PostoDeTrabalhoModel> root = criteria.from(PostoDeTrabalhoModel.class);
		Query query = session.createQuery(criteria);
		Expression registroSetor = (Expression) root.get("nomePosto");
		criteria.select(root).where(criteriaBuilder.like(registroSetor, "'%" + nomePosto + "%'"));
		List<PostoDeTrabalhoModel> resultado = query.getResultList();
		return new ArrayList<PostoDeTrabalhoModel> (resultado);
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
	public boolean update(int idPosto, PostoDeTrabalhoModel postoAtualizado) {
		PostoDeTrabalhoModel original = retrieve(idPosto);
		if(!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		original.setNomePosto(postoAtualizado.getNomePosto());
		original.setIdCargo(postoAtualizado.getIdCargo());
		original.setIdSetor(postoAtualizado.getIdSetor());
		original.setIdNivel(postoAtualizado.getIdNivel());
		original.setSalario(postoAtualizado.getSalario());
		ConnectionHibernate.getSession().update(original);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Metodo delete
	 * 
	 * Realiza a exclus�o do posto de trabalho informado em idPosto.
	 * 
	 * @param int idPosto
	 * @return boolean
	 */
	public boolean delete(int idPosto) {
		SetorModel entry = retrieve(idPosto);

		if (!ConnectionHibernate.getSession().getTransaction().isActive()) {
			ConnectionHibernate.getSession().beginTransaction();
		}
		ConnectionHibernate.getSession().delete(entry);
		ConnectionHibernate.getSession().getTransaction().commit();
		return true;
	}

	/**
	 * Metodo getAll
	 * 
	 * Metodo realiza a busca de todos os postos de trabalho cadastrados no banco e
	 * armazena em um ArrayList.
	 * 
	 * @return ArrayList<PostoDeTrabalhoModel>
	 */
	public ArrayList<PostoDeTrabalhoModel> getAll() {
		ArrayList<PostoDeTrabalhoModel> results = new ArrayList<PostoDeTrabalhoModel>();
		String sqlSelectAll = "SELECT * FROM grupo2.posto_de_trabalho";
		try {
			Statement stmt = conexao.criarConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel();
			while (rs.next()) {
				posto.setIdCargo(rs.getInt(1));
				posto.setIdNivel(rs.getInt(2));
				posto.setIdSetor(rs.getInt(3));
				posto.setNomePosto(rs.getString(4));
				posto.setSalario(rs.getDouble(5));
				posto.setIdPosto(rs.getInt(6));
				System.out.println(posto.toString());
				results.add(posto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Metodo limparTabela
	 * 
	 * Metodo realiza a limpeza da tabela no banco de dados, deletando os registros
	 * e resetando a PrimaryKey. O foco eh ser utilizado nos testes. É necessário
	 * criar as sequences no banco, pois eh partir delas que a Primary Key é
	 * resetada.
	 * 
	 * @throws SQLException
	 * @return void
	 */
	public void limparTabela() throws SQLException {
		String limpar = "delete from grupo2.posto_de_trabalho";
		String removerIncremento = "ALTER SEQUENCE grupo2.posto_de_trabalho_increment RESTART";
		conexao.criarConexao().createStatement().executeUpdate(limpar);
		conexao.criarConexao().createStatement().executeUpdate(removerIncremento);
		System.out.println("Limpeza realizada.");
	}

}

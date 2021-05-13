package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;

/**
 * Classe grau de instrucao que implementa a {@link InterfaceDAOCRUD} para
 * interação com o banco de dados.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i> - Sprint 4
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i> - Sprint 4
 */

public class GrauInstrucaoDAO implements InterfaceDAOCRUD<GrauInstrucaoModel> {
	private static GrauInstrucaoDAO instance;
	private Session session;

	/**
	 * Singleton da classe GrauInstrucaoDAO
	 * 
	 * @param session Session
	 * @return instance GrauInstrucaoDAO
	 */
	public static GrauInstrucaoDAO getInstance(Session session) {
		if (instance == null)
			instance = new GrauInstrucaoDAO(session);
		return instance;
	}

	/**
	 * Construtor da classe GrauInstrucaoDAO, utilizado no Singleton.
	 * 
	 * @param session Session
	 */
	private GrauInstrucaoDAO(Session session) {
		this.session = session;
	}

	/**
	 * Cadastra um novo grau de instrucao.
	 * 
	 * @param grauInstrucao
	 * @return id do objetoCriado
	 */
	public int create(GrauInstrucaoModel grauInstrucao) {
		if (!ConnectionHibernate.getSession().getTransaction().isActive())
			ConnectionHibernate.getSession().beginTransaction();

		Integer idCadastrado = (Integer) ConnectionHibernate.getSession().save(grauInstrucao);
		ConnectionHibernate.getSession().getTransaction().commit();
		return idCadastrado;
	}

	/**
	 * Busca um objeto do tipo {@link GrauInstrucaoModel} atraves do Id.
	 * 
	 * Consulta no banco de dados grupo2.grau_instrucao um objeto do tipo
	 * {@link GrauInstrucaoModel} que contenha o ID igual ao id recebido no
	 * parametro.
	 * 
	 * @param id int Id do objeto a ser consultado.
	 */
	public GrauInstrucaoModel retrieve(int id) {
		GrauInstrucaoModel grauInstrucao = ConnectionHibernate.getSession().get(GrauInstrucaoModel.class, id);
		return grauInstrucao;
	}

	/**
	 * busca o Grau de Instrucao pelo nome
	 * 
	 * Verifica todos os graus de instrucoes e se o nome dele for igual ao passado
	 * como parametro, retorna o objeto
	 * 
	 * @param nome Do Grau de instrucao
	 */
	public GrauInstrucaoModel retrieve(String nome) {
		return null;
	}

	/***
	 * Atualizar GrauInstrucao.
	 * 
	 * Recebe um objeto GrauInstrucao, procura dentro da lista de niveis existentes
	 * baseados no ID do id informado ao encontrar atribui um objeto GrauInstrucao
	 * no objeto com ID encontrato.
	 * 
	 * @param GrauInstrucao
	 * @return boolean
	 */
	public boolean update(int id, GrauInstrucaoModel gi) {
		return false;
	}

	/**
	 * Deleta um grau de instrucao
	 * 
	 * Deleta o respectivo Grau de Instrucao passado como parametro o seu id
	 * 
	 * @param id do Grau desejado
	 * @return true/false caso consiga excluir
	 */
	public boolean delete(int id) {
		return false;
	}

	/**
	 * Busca todos os graus de instrucao
	 * 
	 * @return lista com todos os graus de instrucao
	 */
//	public ArrayList<InterfaceModel> getAll() {
//		return null;
//	}
//	
	/**
	 * Limpar ArrayList de Graus de instrucao
	 * 
	 * M�todo realiza a limpeza do ArrayList de garuInstrucao na classe Dados.
	 * Utilizado para os testes unit�rios.
	 *
	 * @return void
	 */
	public void limparArray() {
	}

	public ArrayList<GrauInstrucaoModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}

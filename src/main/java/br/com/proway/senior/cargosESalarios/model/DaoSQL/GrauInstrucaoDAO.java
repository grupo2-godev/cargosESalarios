package br.com.proway.senior.cargosESalarios.model.DaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.Interface.InterfaceDAOCRUD;
/**
 * Classe de do grau de instru��o que implementa um crud e recebe o 
 * modelo de grau de instru��o. Criando uma variavel de conex�o para
 * criar a conex�o postgres e abrindo o pstm para a query
 * 
 * @author David Hildebrandt <i>david.hildebrandt@senior.com.br</i>
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 */

public class GrauInstrucaoDAO implements InterfaceDAOCRUD<GrauInstrucaoModel> {

	private  Connection db;
	
	public GrauInstrucaoDAO(Connection ps){
		this.db = ps;
	}
	
	/**
	 * Cadastra um novo grau de instrucao
	 * 
	 * Cria o novo id para o grau de instrucao e adiciona ele
	 * como um novo grau de instrucao no banco
	 * 
	 * @param newGI
	 * @return id do grau de instrucao ou null caso nao de para criar
	 */
	public int create(GrauInstrucaoModel newGI) {
		String sql1 = "INSERT INTO grupo2.grau_de_instrucao (descricao) VALUES (?)";
		try {
			PreparedStatement pstmt = db.prepareStatement(sql1);
			pstmt.setString(1, newGI.getNome());
			pstmt.execute();
			System.out.println("Grau Instrucao");
		} catch (SQLException e) {
			System.out.println("erro!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return Integer.getInteger(sql1);
		
	};
	
	/**
	 * busca o Grau de Instrucao pelo id
	 * 
	 * Verifica todos os graus de instrucoes e se o id dele for
	 * igual ao passado como parametro, retorna o objeto
	 * 
	 * @param id Do Grau de instrucao
	 */
	public GrauInstrucaoModel retrieve(int id) {
		return null;
	}
	
	/**
	 * busca o Grau de Instrucao pelo nome
	 * 
	 * Verifica todos os graus de instrucoes e se o nome dele for
	 * igual ao passado como parametro, retorna o objeto
	 * 
	 * @param nome Do Grau de instrucao
	 */
	public GrauInstrucaoModel retrieve(String nome) {
		return null;
	}
	
	/***
	 * Atualizar GrauInstrucao.
	 * 
	 * Recebe um objeto GrauInstrucao, procura dentro da lista de niveis existentes baseados
	 * no ID do id informado ao encontrar atribui um objeto GrauInstrucao no objeto com
	 * ID encontrato.
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
	 * Deleta o respectivo Grau de Instrucao passado como parametro
	 * o seu id
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
	 * M�todo realiza a limpeza do ArrayList de garuInstrucao
	 * na classe Dados.	Utilizado para os testes unit�rios. 
	 *
	 * @return void
	 */
	public void limparArray() {
	}

	public ArrayList<GrauInstrucaoModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

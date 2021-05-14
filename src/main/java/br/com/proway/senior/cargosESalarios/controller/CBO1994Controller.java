package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO1994DAO;
import utils.Insalubridade;
import utils.Periculosidade;

/** Controller que interage com o CBO1994DAO.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994Controller {

	private static CBO1994Controller instance;
	/**
	 * Singleton da classe CBO1994Controller
	 * 
	 * @return CBO1994Controller instance
	 */
	public static CBO1994Controller getInstance() {
		if (instance == null)
			instance = new CBO1994Controller();
		return instance;
	}

		CBO1994DAO CBO1994Dao = CBO1994DAO.getInstance(ConnectionHibernate.getSession());
	
	/**
	 * Cria um novo objeto CBO1994Model e o passa para o DAO para que seja inserido no BD.
	 * Faz a validacao dos campos do Objeto, caso invalidos retorna uma excessao.
	 * 
	 * @param Integer codigo_cbo
	 * @param String descricao			
	 * @param Double percentualInsalubridade
	 * @param Double percentualPericulosidade
	 * @return int codigo_CBO
	 * @throws Exception
	 */
	public Integer cadastrarCBO1994(Integer codigo_CBO1994, String descricao, Insalubridade percentualInsalubridade,
			Periculosidade percentualPericulosidade) throws Exception {
//		if(!Validators.onlyValidChars(nome)) {
//			throw(new Exception("Nome invalido para o CBO1994"));
//		}
		CBO1994Model CBO1994Model = new CBO1994Model(codigo_CBO1994, descricao, percentualInsalubridade.getValor(), percentualPericulosidade.getValor());
		return CBO1994Dao.create(CBO1994Model);
	} 
	
	/**
	 * Retorna um objeto CBO1994Model do BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int codigo_CBO1994 ou primary key da entrada no BD
	 * @return CBO1994Model objeto retornado
	 * @throws Exception
	 */
	public CBO1994Model buscarCBO1994(int codigo_CBO1994) throws Exception {
		if(CBO1994Dao.retrieve(codigo_CBO1994) == null) {
			throw(new Exception("Entrada com o codigo_CBO1994 requisitado nao existe!"));
		}
		return CBO1994Dao.retrieve(codigo_CBO1994);
	}
	
	/**
	 * Atualiza os atributos de um objeto CBO1994Model no BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * Se os novos atributos sao iguais os antigos, a funcao retorna false.
	 * 
	 * @param int codigo_CBO1994 ou primary key do objeto original no BD
	 * @param CBO1994Model : objetoAlterado - Objeto com os atributos a serem substituidos no BD
	 * @return boolean : true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizarCBO1994(int codigo_CBO1994, CBO1994Model objetoAlterado) throws Exception {
		CBO1994Model original = CBO1994Dao.retrieve(codigo_CBO1994);
		
		if(original == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		
		if(original.getCodigo_cbo() == objetoAlterado.getCodigo_cbo() &&
		   original.getDescricao() == objetoAlterado.getDescricao() &&
		   original.getPercentualInsalubridade() == objetoAlterado.getPercentualInsalubridade() &&
		   original.getPercentualPericulosidade() == objetoAlterado.getPercentualInsalubridade()) {
			return false;
		}
		
		return CBO1994Dao.update(codigo_CBO1994, objetoAlterado);
	}
	
	/**
	 * Deleta um objeto CBO1994Model no BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int codigo_CBO1994 ou primary key da entrada no BD
	 * @return boolean : true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarCBO1994(int codigo_CBO1994) throws Exception {
		if(CBO1994Dao.retrieve(codigo_CBO1994) == null) {
			throw(new Exception("Entrada com o codigo_CBO1994 requisitado nao existe!"));
		}
		return CBO1994Dao.delete(codigo_CBO1994);
	}
	
	/**
	 * Retorna todas as entradas de CBO1994Models no BD em uma ArrayList;
	 * 
	 * @return ArrayList<CBO1994Model> : lista de entradas
	 */
	public ArrayList<CBO1994Model> buscarTodosCBO1994(){
		return CBO1994Dao.getAll();
	}
	
	/**
	 * Deleta todas as entradas de CBO1994Models no BD;
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosCBO1994() {
		return CBO1994Dao.deleteAll();
	}	
}

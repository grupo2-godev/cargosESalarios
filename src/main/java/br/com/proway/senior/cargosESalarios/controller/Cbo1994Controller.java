package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO1994DAO;
import utils.Validators;

/** Controller que interage com o NivelDAO.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class Cbo1994Controller {

	NivelDAO nivelDAO = NivelDAO.getInstance(ConnectionHibernate.getSession());
	
	/**
	 * Cria um novo objeto NivelModel e o passa para o DAO para que seja inserido no BD.
	 * Faz a validacao dos campos do Objeto, caso invalidos retorna uma excessao.
	 * 
	 * @param nome : String
	 * @return Integer : id do objeto correspondente no BD
	 * @throws Exception
	 */
	public Integer cadastrarNivel(String nome) throws Exception {
		if(!Validators.onlyValidChars(nome)) {
			throw(new Exception("Nome invalido para o Nivel"));
		}
		NivelModel nivelModel = new NivelModel(nome);
		return nivelDAO.create(nivelModel);
	} 
	
	/**
	 * Retorna um objeto NivelModel do BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id ou primary key da entrada no BD
	 * @return NivelModel : objeto retornado
	 * @throws Exception
	 */
	public NivelModel buscarNivel(int id) throws Exception {
		if(nivelDAO.retrieve(id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return nivelDAO.retrieve(id);
	}
	
	/**
	 * Atualiza os atributos de um objeto NivelModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * Se os novos atributos sao iguais os antigos, a funcao retorna false.
	 * 
	 * @param int : id ou primary key do objeto original no BD
	 * @param NivelModel : objetoAlterado - Objeto com os atributos a serem substituidos no BD
	 * @return boolean : true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizarNivel(int id, NivelModel objetoAlterado) throws Exception {
		NivelModel original = nivelDAO.retrieve(id);
		if(original == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		
		if(original.getNome() == objetoAlterado.getNome()) {
			return false;
		}
		return nivelDAO.update(id, objetoAlterado);
	}
	
	/**
	 * Deleta um objeto NivelModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id ou primary key da entrada no BD
	 * @return boolean : true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarNivel(int id) throws Exception {
		if(nivelDAO.retrieve(id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return nivelDAO.delete(id);
	}
	
	/**
	 * Retorna todas as entradas de NivelModels no BD em uma ArrayList;
	 * 
	 * @return ArrayList<NivelModel> : lista de entradas
	 */
	public ArrayList<NivelModel> buscarTodosNiveis(){
		return nivelDAO.getAll();
	}
	
	/**
	 * Deleta todas as entradas de NivelModels no BD;
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosNiveis() {
		return nivelDAO.deleteAll();
	}
	
	
}

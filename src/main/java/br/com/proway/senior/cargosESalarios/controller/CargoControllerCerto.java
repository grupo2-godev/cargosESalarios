package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CRUDInterface;
import br.com.proway.senior.cargosESalarios.model.InterfaceModel;

public class CargoControllerCerto<T> {

	CRUDInterface<T> dao;
	
	CargoControllerCerto (CRUDInterface<T> obj) {
		this.dao = obj;		
	}
	
	/**
	 * Cadastra um novo objeto
	 * 
	 * Verifica se já existe um objeto com o mesmo nome
	 * e se não exister cria o objeto e envia para o Dao do objeto
	 * 
	 * @param nome
	 * @return Integer/null
	 */
	public Integer cadastrarObj(String nome) {
		for (T  obj: dao.getAll()) {
			if (obj.equals(nome)) {
				return null;
			}
		}
		InterfaceModel newObj;
		return dao.create((T) newObj);
	}
	
	/**
	 * Deleta um objeto
	 * 
	 * Envia o id do objeto para o dao deletar 
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deletarObj(Integer id) {
		return dao.delete(id);
	}
	
	/**
	 * Atualizar Objeto
	 * 
	 * Método realiza a atualização do objeto
	 *  
	 * @param id
	 * @param nome
	 * @return boolean
	 */
	public boolean atualizarObj(Integer id, String nome) {
		InterfaceModel obj = (InterfaceModel) dao.retrieve(id);
		obj.setNome(nome);
		return dao.update((T) obj);
	}
	
	public ArrayList<InterfaceModel> buscarTodosObjetos(){
		return (ArrayList<InterfaceModel>) dao.getAll();
	}
	
	/**
	 * Buscar ibjeto por ID
	 * 
	 * Realiza a busca do objeto conforme Id informada
	 * e retorna o objeto do mesmo.
	 * 
	 * @param id
	 * @return InterfaceModel
	 */
	public InterfaceModel buscarObj(Integer id) {
		return (InterfaceModel) dao.retrieve(id);
	}
	
}

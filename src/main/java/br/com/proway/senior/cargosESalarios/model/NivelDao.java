package br.com.proway.senior.cargosESalarios.model;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Classe NivelDao
 * 
 * Classe está em desenvolvimento para atribuir as funções de banco de dados,
 * é necessário revisar as funcionalidades.
 * 
 * @author Sprint 4
 *
 */

public class NivelDao implements CRUDInterface<NivelModel>{

	private Connection db;
	
	public NivelDao(Connection crud){
		this.db = crud;
	}
	
	public NivelDao() {
		
	}
	
	/**
	 * Adiciona um novo nivel
	 * 
	 * Adiciona um novo nível no banco 
	 * 
	 * @param newNivel
	 * @return NivelModel
	 */
	public Integer create(NivelModel newNivel) {
		return null;
		
	}
	
	/**
	 * Limpar ArrayList de Níveis
	 * 
	 * Método realiza a limpeza do ArrayList de niveis
	 * na classe Dados.	Utilizado para os testes unitários. 
	 *
	 * @return void
	 */
	public void limparArray() {
		((ArrayList<NivelModel>) db).clear();
	}

	/**
	 * busca o nivel pelo id
	 * 
	 * @param id Do nivel
	 */
	public NivelModel retrieve(int id) {
//		for(Connection nivel : (ArrayList<Connection>) db) {
//			if(db == id) {
//				return nivel;
//			}
//		}
		return null;
	}
	
	/**
	 * Deleta um nivel
	 * 
	 * Deleta o nivel com o respectivo id passado de
	 * parametro
	 * 
	 * @param id Do nivel a ser excluido
	 */
	public boolean delete(int id) {
//		for(NivelModel nivel : db) {
//			if(nivel.getId() == id) {
//				((ArrayList<NivelModel>) db).remove(nivel);
//				return true;
//			}
//		}
		return false;
	}

	/**
	 * Pega todos os niveis do banco
	 * 
	 * @return todos os niveis
	 */
	public ArrayList<NivelModel> getAll() {
		return null;
//		return db;
	}

	/***
	 * Atualizar Nivel.
	 * 
	 * Recebe um objeto nivel, procura dentro da lista de niveis existentes baseados
	 * no ID do id informado ao encontrar atribui um objeto nivel no objeto com
	 * ID encontrato.
	 * 
	 * @param NivelModel obj, objeto recebido.
	 * @return boolean
	 */
	public boolean update(NivelModel nivel) {
//		for (NivelModel nivelProcurado : db) {
//			if (nivelProcurado.getId() == nivel.getId()) {
//				nivelProcurado.setNome(nivel.getNome());
//				return true;
//			}
//		}
		return false;
	}
	
}

package br.com.proway.senior.cargosESalarios.model;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Classe NivelDaoSQL
 * 
 * Classe est� em desenvolvimento para atribuir as fun��es de banco de dados,
 * � necess�rio revisar as funcionalidades.
 * 
 * @author Sprint 4
 *
 */

public class NivelDaoSQL implements InterfaceDaoCrud<NivelModel>{

	private Connection db;
	
	public NivelDaoSQL(Connection crud){
		this.db = crud;
	}
	
	public NivelDaoSQL() {
		
	}
	
	/**
	 * Adiciona um novo nivel
	 * 
	 * Adiciona um novo n�vel no banco 
	 * 
	 * @param newNivel
	 * @return NivelModel
	 */
	public int create(NivelModel newNivel) {
		return -1;
		
	}
	
	/**
	 * Limpar ArrayList de N�veis
	 * 
	 * M�todo realiza a limpeza do ArrayList de niveis
	 * na classe Dados.	Utilizado para os testes unit�rios. 
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
	public boolean update(int id, NivelModel nivel) {
//		for (NivelModel nivelProcurado : db) {
//			if (nivelProcurado.getId() == nivel.getId()) {
//				nivelProcurado.setNome(nivel.getNome());
//				return true;
//			}
//		}
		return false;
	}
	
}

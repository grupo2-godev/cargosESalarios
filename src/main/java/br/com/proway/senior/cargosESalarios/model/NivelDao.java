package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

public class NivelDao {

	ArrayList<NivelModel> db = Dados.getInstance().getListaNiveis();
	
	/**
	 * Adiciona um novo nivel
	 * 
	 * Adiciona um novo nível no banco 
	 * 
	 * @param newNivel
	 * @return NivelModel
	 */
	public int create(NivelModel newNivel) {
		int size = db.size();
		int novoNivelId;
		if (size > 0) {
			novoNivelId =  db.get(size-1).getIdNivel();
		}
		else {
			novoNivelId = 0;
		}
		newNivel.setIdNivel(novoNivelId);
		db.add(newNivel);
		return novoNivelId;
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
		db.clear();
	}

	/**
	 * busca o nivel pelo id
	 * 
	 * @param id Do nivel
	 */
	public NivelModel retrieve(int id) {
		for(NivelModel nivel : db) {
			if(nivel.getIdNivel() == id) {
				return nivel;
			}
		}
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
		for(NivelModel nivel : db) {
			if(nivel.getIdNivel() == id) {
				db.remove(nivel);
				return true;
			}
		}
		return false;
	}

	public ArrayList<NivelModel> getAll() {
		return db;
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
		for (NivelModel nivelProcurado : db) {
			if (nivelProcurado.getIdNivel() == nivel.getIdNivel()) {
				nivelProcurado.setNomeNivel(nivel.getNomeNivel());
				return true;
			}
		}
		return false;
	}
	
}

/**
 * 
 */
package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 *
 */
public class Cbo1994DaoAl implements CRUDInterface<Cbo1994Model> {

	/***
	 * Criar Cbo1994.
	 * 
	 * Recebe um objeto cargo para inserir na lista.
	 * 
	 * @param obj insere na lista.
	 * @return int com novo id
	 * 
	 */
	public int create(Cbo1994Model obj) {
		int size = Dados.getInstance().getListaCbo1994().size();
		int novoCboId;
		if (size > 0) {
			novoCboId = Dados.getInstance().getListaCbo1994().get(size - 1).getCodigoId();
		} else {
			novoCboId = 0;
		}
		obj.setCodigoId(novoCboId);
		Dados.getInstance().getListaCbo1994().add(obj);
		return novoCboId;
	}

	/**
	 * Procura cbo1994 pelo id e retorna nulo caso não encontrado
	 * 
	 * @param id do cbo1994
	 * @return null/Cbo1994Model
	 */
	public Cbo1994Model retrieve(int id) {
		for (Cbo1994Model cbo1994 : Dados.getInstance().getListaCbo1994()) {
			if (cbo1994.getCodigoId() == id)
				return cbo1994;
		}
		return null;
	}

	/**
	 * Procura cargo pelo nome e retorna nulo caso não encontrado
	 * 
	 * @param nomeCbo1994
	 * @return null/Cbo1994Model
	 */
	public Cbo1994Model retrieve(String nomeCbo1994) {
		for (Cbo1994Model cbo1994 : Dados.getInstance().getListaCbo1994()) {
			if (cbo1994.getDescricao() == nomeCbo1994)
				return cbo1994;
		}
		return null;
	}

	/***
	 * Atualizar cbo1994.
	 * 
	 * Recebe um objeto cbo1994, procura dentro da lista de CBOS existentes baseados
	 * no ID do cbo informado ao encontrar atribui um objeto cargo no objeto com ID
	 * encontrado.
	 * 
	 * @param CargoModel obj, objeto recebido.
	 */
	public boolean update(Cbo1994Model obj) {
		ArrayList<Cbo1994Model> lista = Dados.getInstance().getListaCbo1994();
		for (Cbo1994Model cbo1994 : lista) {
			if (cbo1994.getCodigoId() == obj.getCodigoId()) {
				int idDoProcurado = lista.indexOf(cbo1994);
				lista.set(idDoProcurado, obj);
				return true;
			}
		}
		return false;
	}

	/***
	 * Deleta objeto
	 *
	 * Remove id selecionado.
	 * 
	 * @param id
	 * @return true/false
	 */
	public boolean delete(int id) {
		for (Cbo1994Model cbo1994 : Dados.getInstance().getListaCbo1994()) {
			if (this.retrieve(id).getCodigoId() == id) {
				Dados.getInstance().getListaCbo1994().remove(cbo1994);
				return true;
			}
		}
		return false;
	}

	/***
	 * 
	 * Lista todos os dados registrados.
	 * 
	 * @return ArrayList<Cbo1994Model>
	 */

	public ArrayList<Cbo1994Model> getAll() {
		return Dados.getInstance().getListaCbo1994();
	}

	/**
	 * Limpar ArrayList de Cbo
	 * 
	 * Método realiza a limpeza do ArrayList de cbo na classe Dados. Utilizado para
	 * os testes unitários.
	 *
	 * @return void
	 */
	public void limparArray() {
		Dados.getInstance().getListaCbo1994().clear();
	}

}

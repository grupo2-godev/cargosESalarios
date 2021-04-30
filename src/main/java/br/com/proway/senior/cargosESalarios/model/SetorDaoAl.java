package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;


/**
 * Classe DAO do Setor para persistência dos dados em ArrayList.
 * @author Gabriel Simon, Guilherme Ezequiel
 * @version Sprint3:
 * 	- Criação e implementação dos métodos.
 *  - Implementação dos testes.
 */
public class SetorDaoAl implements CRUDInterface<SetorModel> {
	/**
	 * Popula setor no ArrayList.
	 * 
	 * @param String obj
	 */
	public boolean create(SetorModel obj) {
		Dados.getInstance().getListaSetores().add(obj);
		return true;
	}

	/**
	 * Retorna um setor do ArrayList(ListaSetores) pelo id.
	 * 
	 * @param int id
	 * @return Retorna o setor procurado ou nulo se não encontrado
	 */
	public SetorModel retrieve(int id) {
		for (SetorModel setorProcurado : Dados.getInstance().getListaSetores()) {
			if (setorProcurado.getId() == id) {
				return setorProcurado;
			}
		}
		return null;
	}

	/**
	 * Procura o setor pela id no ArrayList. Altera setor procurado pelo id.
	 * 
	 * @param String obj
	 * 
	 */
	public boolean update(SetorModel obj) {
		ArrayList<SetorModel> lista = Dados.getInstance().getListaSetores();
		for (SetorModel setorProcurado : lista) {
			if (setorProcurado.getId() == obj.getId()) {
				int posSetorProcurado = lista.indexOf(setorProcurado);
				lista.set(posSetorProcurado, obj);
				return true;
			}
		}
		return false;
	}

	/** 
	 * Procura o setor pelo id no ArrayList. Deleta o setor procurado pelo id.
	 * 
	 * @param int id
	 */
	public boolean delete(int id) {

		for (SetorModel setorDeletado : Dados.getInstance().getListaSetores()) {
			if (setorDeletado.getId() == id) {
				Dados.getInstance().getListaSetores().remove(setorDeletado);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * Retorna todos os setores.
	 * 
	 * @return Retorna um ArrayList<Setor> com todos os setores
	 */
	public ArrayList<SetorModel> getAll() {
		return Dados.getInstance().getListaSetores();
	}
}

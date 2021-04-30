package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;


/**
 * Classe DAO do Setor para persistência dos dados em ArrayList.
 * @author Gabriel Simon, Guilherme Ezequiel
 * @version Sprint3:
 * 	- Criação e implementação dos métodos.
 *  - Implementação dos testes.
 */
public class SetorDaoAl implements CRUDInterface<Setor> {
	/**
	 * Popula setor no ArrayList.
	 * 
	 * @param String obj
	 */
	public boolean create(Setor obj) {
		Dados.getInstance().getListaSetores().add(obj);
		return true;
	}

	/**
	 * Retorna um setor do ArrayList(ListaSetores) pelo id.
	 * 
	 * @param int id
	 * @return Retorna o setor procurado ou nulo se não encontrado
	 */
	public Setor retrieve(int id) {
		for (Setor setorProcurado : Dados.getInstance().getListaSetores()) {
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
	public boolean update(Setor obj) {
		ArrayList<Setor> lista = Dados.getInstance().getListaSetores();
		for (Setor setorProcurado : lista) {
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

		for (Setor setorDeletado : Dados.getInstance().getListaSetores()) {
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
	public ArrayList<Setor> getAll() {
		return Dados.getInstance().getListaSetores();
	}
}

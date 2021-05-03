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
	ArrayList<SetorModel> db = Dados.getInstance().getListaSetores();

	
	/**
	 * Popula setor no ArrayList.
	 * 
	 * @param String obj
	 */
	public int create(SetorModel obj) {
		int size = db.size();
		int novoSetorId;
		if (size > 0) {
			novoSetorId =  db.get(size-1).getId();
		}
		else {
			novoSetorId = 0;
		}
		obj.setId(novoSetorId);
		db.add(obj);
		return obj.getId();
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
	 * Retorna um setor do ArrayList(ListaSetores) pelo id.
	 * 
	 * @param int id
	 * @return Retorna o setor procurado ou nulo se não encontrado
	 */
	public SetorModel retrieve(String nome) {
		for (SetorModel setorProcurado : Dados.getInstance().getListaSetores()) {
			if (setorProcurado.getNomeSetor() == nome) {
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
	
	/**
	 * Limpar ArrayList de Setores
	 * 
	 * Método realiza a limpeza do ArrayList de setores
	 * na classe Dados.	Utilizado para os testes unitários. 
	 *
	 * @return void
	 */
	public void limparArray() {
		db.clear();
	}
	
}

package br.com.proway.senior.cargosESalarios.Setor;

import java.util.ArrayList;
import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

/**
 * 
 * @author Gabriel Simon
 * @author Guilherme 
 *
 */

public class SetorDaoAl implements CRUDInterface<Setor> {

	
	/**
	 * 
	 * Popula setor no ArrayList.
	 * 
	 * @param String obj
	 * 
	 */
	public void Create(Setor obj) {
		Dados.getInstance().getListaSetores().add(obj);
	}

	/**
	 * 
	 * Retorna um setor do ArrayList(ListaSetores) pelo id.
	 * 
	 * @param int id
	 * @return Retorna o setor procurado ou nulo se não encontrado
	 */
	public Setor Retrieve(int id) {
		for(Setor setorProcurado : Dados.getInstance().getListaSetores()) {
			if(setorProcurado.getId() == id) {
				return setorProcurado;
			}			
		}
		return null;
	}
	
	/**
	 * 
	 * Procura o setor pela id no ArrayList.
	 * Altera setor procurado pelo id.
	 * 
	 * @param String obj
	 * 
	 */
	public void Update(Setor obj) {
		ArrayList<Setor> lista = Dados.getInstance().getListaSetores();
		for(Setor setorProcurado : lista) {
			if(setorProcurado.getId() == obj.getId()) {
				int posSetorProcurado = lista.indexOf(setorProcurado);
				lista.set(posSetorProcurado, obj);
			}
		}
	}

	/**
	 * 
	 * Procura o setor pelo id no ArrayList.
	 * Deleta o setor procurado pelo id.
	 * 
	 * 
	 * @param int id
	 */
	public void Delete(int id) {
		
		for(Setor setorDeletado : Dados.getInstance().getListaSetores()) {
			if(setorDeletado.getId() == id) {
				Dados.getInstance().getListaSetores().remove(setorDeletado);
				break;
			}
		}
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

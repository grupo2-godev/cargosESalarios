package br.com.proway.senior.cargosESalarios.Cargo;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

public class CargoDaoAl implements CRUDInterface<Cargo> {

	public void Create(Cargo obj) {
		Dados.getInstance().getListaCargos().add(obj);
	}

	public Cargo Retrieve(int id) {
		for (Cargo cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (cargoProcurado.getIdCargo() == id)
				return cargoProcurado;
		}
		return null;
	}

	/***
	 * Atualizar Cargo.
	 * 
	 * Recebe um objeto cargo, procura dentro da lista de cargos existentes baseados
	 * no ID do cargo informado ao encontrar atribui um objeto cargo no objeto com
	 * ID encontrato.
	 * 
	 * @param Cargo obj, objeto recebido.
	 * 
	 * @author Elton, Samuel
	 * 
	 */
	public void Update(Cargo obj) {
		ArrayList<Cargo> lista = Dados.getInstance().getListaCargos();
		for (Cargo cargoProcurado : lista) {
			if (cargoProcurado.getIdCargo() == obj.getIdCargo()) {				
				int idDoProcurado = lista.indexOf(cargoProcurado);
				lista.set(idDoProcurado, obj);
			}
		}
	}

	/***
	 * Deleta objeto
	 *
	 * Remove id selecionado.
	 * 
	 * @author Elton, Samuel
	 * @param id
	 * @return 
	 */
	public Cargo Delete(int id) {
		for (Cargo cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (cargoProcurado.getIdCargo() == id) {
				Dados.getInstance().getListaCargos().remove(cargoProcurado);
				break;
			}

		}
		return null;

	}

	/***
	 * Lista'
	 * 
	 * Lista todos os dados registrados.
	 * 
	 * @param ArrayList
	 * @author Elton, Samuel
	 */

	public ArrayList<Cargo> getAll() {
		return Dados.getInstance().getListaCargos();
	}
}

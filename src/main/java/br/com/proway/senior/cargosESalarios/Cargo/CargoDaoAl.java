package br.com.proway.senior.cargosESalarios.Cargo;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;
import br.com.proway.senior.cargosESalarios.recursos.Dados;

/**
 * Classe DAO do Cargo para persistência dos dados em ArrayList.
 * @author Elton Oliveira, Samuel Levi
 * @version Sprint3:
 * 	- Criação e implementação dos métodos.
 *  - Implementação dos testes.
 */
public class CargoDaoAl implements CRUDInterface<Cargo> {

	/***
	 * Inserir Cargo.
	 * 
	 * Recebe um objeto cargo para inserior na lista.
	 * 
	 * @param Cargo obj, inserir na lista.
	 * 
	 * @author Elton, Samuel
	 * 
	 */

	public void create(Cargo obj) {
		Dados.getInstance().getListaCargos().add(obj);
	}

	public Cargo retrieve(int id) {
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
	 */
	public void update(Cargo obj) {
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
	 * @author Elton, Guilherme
	 * @param id
	 * @return
	 */
	public void delete(int id) {
		for (Cargo cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (cargoProcurado.getIdCargo() == id) {
				Dados.getInstance().getListaCargos().remove(cargoProcurado);
				break;
			}
		}
	}

	/***
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

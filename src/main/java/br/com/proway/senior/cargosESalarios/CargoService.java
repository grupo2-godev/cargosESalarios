package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

/**
 * 
 * @author Sabrina/Vitor
 * @version 2.0
 *
 */
public class CargoService implements ICargoService {

	/**
	 * Adiciona um cargo à lista de cargos.
	 * 
	 * @param todosCadastrados traz a lista de todos os cargos no arrayList
	 * @param nomeCargo        nome do cargo que vai ser inserido
	 * @param idCargo          id do cargo que vai ser inserido
	 * @return ArrayList de cargos criados
	 */
	public ArrayList<Cargo> cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo) {
		Cargo cargo = new Cargo(id, nomeCargo);
		todosCadastrados.add(cargo);
		return todosCadastrados;
	}

	/**
	 * Remove um cargo da lista de cargos.
	 * 
	 * @param idCargoProcurar id que serve para procurar e então remover os itens da
	 *                        lista
	 * @param listaCargo      Lista que serve para a adição de itens e procurar o id
	 *                        <i>idCargoProcurar</i>
	 * @return boolean que faz a verificação se foi ou não removido
	 */
	public boolean removerCargo(int idCargoProcurar, ArrayList<Cargo> listaCargo) {
		boolean foiRemovido;
		for (int i = 0; i < listaCargo.size(); i++) {
			if (listaCargo.get(i).getIdCargo().equals(idCargoProcurar)) {
				listaCargo.remove(i);
				return foiRemovido = true;

			} else {
				i++;
			}

		}
		return foiRemovido = false;
	}

	/**
	 * Altera um cargo da lista de cargos.
	 * 
	 * @param listaCargo      que serve como base para alteração e inserção de itens
	 * @param idCargoProcurar id que serve para procurar item na lista
	 * @param nomeCargo       nome do cargo a ser alterado
	 * @return boolean que faz a verificação se foi ou não alterado
	 */
	public boolean alterarCargo(ArrayList<Cargo> listaCargo, int idCargoProcurar, String nomeCargo) {
		boolean foiAlterado;
		for (int i = 0; i < listaCargo.size(); i++) {
			if (listaCargo.get(i).getIdCargo().equals(idCargoProcurar)) {
				listaCargo.get(i).setNomeCargo(nomeCargo);
				return foiAlterado = true;
			} else {
				i++;
			}
		}
		return foiAlterado = false;
	}

	/**
	 * 
	 * @return String retorna a mensagem com os dados contidos na lista
	 */
	public String visualizarTodosOsCargos(ArrayList<Cargo> listaCargo) {
		return listaCargo.toString();
	}

	/**
	 * 
	 * @return String retorna a mensagem com os dados contidos na lista
	 */
	public String visualizarCargo(ArrayList<Cargo> listaCargo, int id) {
			return listaCargo.get(id).toString();
		
	}
}
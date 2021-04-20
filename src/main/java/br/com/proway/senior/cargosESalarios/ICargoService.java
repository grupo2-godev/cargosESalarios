package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public interface ICargoService {

	/**
	 * Adiciona um cargo à lista de cargos.
	 * 
	 * @param todosCadastrados traz a lista de todos os cargos no  arrayList
	 * @param nomeCargo        nome do cargo que vai ser inserido
	 * @param idCargo          id do cargo que vai ser inserido
	 * @return ArrayList de cargos criados
	 */
	public ArrayList<Cargo> cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo);

	/**
	 * Remove um cargo da lista de cargos.
	 * 
	 * @param idCargoProcurar id que serve para procurar e então remover os itens da lista
	 * @param listaCargo      Lista que serve para a adição de itens e procurar o id
	 *                        <i>idCargoProcurar</i>
	 * @return boolean        que faz a verificação se foi ou não removido
	 */
	public boolean removerCargo(int idCargoProcurar, ArrayList<Cargo> listaCargo);

	/**
	 * Altera um cargo da lista de cargos.
	 * 
	 * @param listaCargo      que serve como base para alteração e inserção de itens
	 * @param idCargoProcurar id que serve para procurar item na lista 
	 * @param nomeCargo       nome do cargo a ser alterado
	 * @return boolean        que faz a verificação se foi ou não alterado
	 */
	public boolean alterarCargo(ArrayList<Cargo> listaCargo, int idCargoProcurar, String nomeCargo);

	/**
	 * 
	 * @return String retorna a mensagem com os dados contidos na lista
	 */
	public String visualizarTodosOsCargos(ArrayList<Cargo> listaCargo);
	
	/**
	 * 
	 * @return String retorna a mensagem com os dados contidos na lista
	 */
	public String visualizarCargo(ArrayList<Cargo> listaCargo, int id);

}
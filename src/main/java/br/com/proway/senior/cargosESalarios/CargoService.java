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
	 * * Cadastrar setores.
	 * Recebe o nome do cargo (String), id do cargo (int) e a ArrayList à ser populado 
	   com um objeto da classe Cargo.
	 * Popula a lista com o objeto.
	 * 
	 * @param todosCadastrados
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo) {
		Cargo cargo = new Cargo(id, nomeCargo);
		todosCadastrados.add(cargo);
	}
	/**
	 * Cadastra cargo.
	 * 
	 * Método de sobrecarga que recebe uma lista de setores e um id (int) de setor e
	 * adiciona a informação de setor ao cargo cadastrado
	 * 
	 * 
	 * @param todosCadastrados
	 * @param id
	 * @param nomeCargo
	 * @param listaConsultada
	 * @param idSetor
	 * @return ArrayList de cargos 
	 */
	public void cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo, ArrayList<Setor> listaConsultada, int idSetor) {
		Cargo cargo = new Cargo(id, nomeCargo, idSetor);
		SetorServico sv = new SetorServico();
		Setor setor = new Setor();
		
		setor = sv.consultarSetor(listaConsultada, idSetor);
		
		cargo.setSetor(setor);
		
		todosCadastrados.add(cargo);
	}
	/**
	 * Recebe ArrayList e objeto da classe 	Cargo.
	 * Popula a lista com objeto.
	 * 
	 * @param cargos
	 * @return void
	 */
	public void cadastrarCargo(ArrayList<Cargo> cargos, Cargo cargoASerCadastrado) {
		
		cargos.add(cargoASerCadastrado);
	}
	/**
	 *Remove um cargo da lista de cargos. 
	 *Procura o Id (int) recebido na lista e remove. 
	 *Lista os cargos para procurar o id.
	 *
	 * @param idCargoProcurar
	 * @return void   
	 */
	public void removerCargo(int idCargoProcurar, ArrayList<Cargo> listaCargo) {
		for (int i = 0; i < listaCargo.size(); i++) {
			if (listaCargo.get(i).getIdCargo() == idCargoProcurar) {
				listaCargo.remove(i);
			} 
		}
	}
	/**
	 * Altera parametros de um cargo da lista.
	 * Lista os cargos para a alteração.
	 * Recebe idCargoProurar (int) e nomeCargo(String).
	 * 
	 * @param listaCargo      
	 * @param idCargoProcurar  
	 * @param nomeCargo       
	 * @return void       
	 */
	public void alterarCargo(ArrayList<Cargo> listaCargo, int idCargoProcurar, String nomeCargo) {
		for (int i = 0; i < listaCargo.size(); i++) {
			if (listaCargo.get(i).getIdCargo() == idCargoProcurar) {
				listaCargo.get(i).setNomeCargo(nomeCargo);
			} else {
				i++;
			}
		}
	}
	/**
	 * Retorna todos os cargos contidos na lista.
	 * @return String 
	 */
	public String visualizarTodosOsCargos(ArrayList<Cargo> listaCargo) {
		return listaCargo.toString();
	}
	
	/**
	 * Retorna todos os cargos contidos na lista
	 * @return String 
	 */
	public String visualizarCargo(ArrayList<Cargo> listaCargo, int id) {
		for (Cargo cargo : listaCargo) {
			if(cargo.getIdCargo() == id) {
				return cargo.getNomeCargo();
			}
	}
}

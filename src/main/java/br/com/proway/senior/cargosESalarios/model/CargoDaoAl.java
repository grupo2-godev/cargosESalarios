package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * Classe DAO do Cargo para persistência dos dados em ArrayList.
 * @author Elton Oliveira, Samuel Levi
 * @version Sprint3:
 * 	- Criação e implementação dos métodos.
 *  - Implementação dos testes.
 */

public class CargoDaoAl implements CRUDInterface<CargoModel> {

	/***
	 * Inserir Cargo.
	 * 
	 * Recebe um objeto cargo para inserior na lista.
	 * 
	 * @param CargoModel obj, inserir na lista.
	 * 
	 * @author Elton, Samuel
	 * 
	 */

	public Integer create(CargoModel obj) {
		int size = Dados.getInstance().getListaCargos().size();
		int novoCargoId;
		if (size > 0) {
			novoCargoId =  Dados.getInstance().getListaCargos().get(size-1).getIdCargo();
		}
		else {
			novoCargoId = 0;
		}
		obj.setIdCargo(novoCargoId);
		Dados.getInstance().getListaCargos().add(obj);
		return novoCargoId;
	}
	
	/**
	 * Ler Cargo por ID
	 * 
	 * Procura cargo pelo id e retorna nulo caso não encontrado
	 * 
	 * @param id Do cargo
	 * @return null/Cargo
	 */
	public CargoModel retrieve(int id) {
		for (CargoModel cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (cargoProcurado.getIdCargo() == id)
				return cargoProcurado;
		}
		return null;
	}
	
	/**
	 * Ler Cargo por nome
	 * 
	 * Procura cargo pelo nome e retorna nulo caso não encontrado
	 * 
	 * @param nomeCargo
	 * @return null/Cargo
	 */
	public CargoModel retrieve(String nomeCargo) {
		for (CargoModel cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (cargoProcurado.getNomeCargo() == nomeCargo)
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
	 * @param CargoModel obj, objeto recebido.
	 * 
	 * @author Elton, Samuel
	 */
	public boolean update(CargoModel obj) {
		ArrayList<CargoModel> lista = Dados.getInstance().getListaCargos();
		for (CargoModel cargoProcurado : lista) {
			if (cargoProcurado.getIdCargo() == obj.getIdCargo()) {
				int idDoProcurado = lista.indexOf(cargoProcurado);
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
	 * @author Elton, Guilherme
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		for (CargoModel cargoProcurado : Dados.getInstance().getListaCargos()) {
			if (this.retrieve(id).getIdCargo() == id) {
				Dados.getInstance().getListaCargos().remove(cargoProcurado);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Deleta um cargo
	 * 
	 * Deleta um cargo do banco de dados que é igual ao passado como
	 * parametro
	 * 
	 * @param cargo A ser excluido
	 * @return boolean
	 */
	public boolean delete(CargoModel cargo) {
		Dados.getInstance().getListaCargos().remove(cargo);
		return true;
	}

	/***
	 * 
	 * Lista todos os dados registrados.
	 * 
	 * @param ArrayList
	 * @author Elton, Samuel
	 */

	public ArrayList<CargoModel> getAll() {
		return Dados.getInstance().getListaCargos();
	}
	
	/**
	 * Limpar ArrayList de Cargos
	 * 
	 * Método realiza a limpeza do ArrayList de cargos
	 * na classe Dados.	Utilizado para os testes unitários. 
	 *
	 * @return void
	 */
	public void limparArray() {
		Dados.getInstance().getListaCargos().clear();
	}
}

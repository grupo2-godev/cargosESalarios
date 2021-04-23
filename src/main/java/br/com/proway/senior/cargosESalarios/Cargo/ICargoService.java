package br.com.proway.senior.cargosESalarios.Cargo;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.Setor.Setor;

public interface ICargoService {


	public void cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo);
	
	public void cadastrarCargo(ArrayList<Cargo> todosCadastrados, int id, String nomeCargo, ArrayList<Setor> listaConsultada, int idSetor);
	
	public void cadastrarCargo(ArrayList<Cargo> cargos, Cargo cargoASerCadastrado);

	public void removerCargo(int idCargoProcurar, ArrayList<Cargo> listaCargo);

	public void alterarCargo(ArrayList<Cargo> listaCargo, int idCargoProcurar, String nomeCargo);

	public String visualizarTodosOsCargos(ArrayList<Cargo> listaCargo);
	
	public String visualizarCargo(ArrayList<Cargo> listaCargo, int id);

}
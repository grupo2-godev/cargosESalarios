package br.com.proway.senior.cargosESalarios;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Setor> listaSetores = new ArrayList<Setor>();
		ArrayList<Cargo> listaCargos = new ArrayList<Cargo>();
		SetorServico setorSvc = new SetorServico();
		CargoService cargoSvc = new CargoService();
		
		setorSvc.cadastrarSetor(listaSetores, "Recursos humanos", 3521, 20, 1524);
		setorSvc.cadastrarSetor(listaSetores, "Comercial", 3522, 20, 1525);
		setorSvc.cadastrarSetor(listaSetores, "Financeiro", 3523, 20, 1526);
		setorSvc.cadastrarSetor(listaSetores, "Contabilidade", 3524, 20, 1527);
		setorSvc.cadastrarSetor(listaSetores, "Administracao", 3525, 20, 1528);
		
		cargoSvc.cadastrarCargo(listaCargos, 2, "Auxiliar de Contabilidade", listaSetores, 3524);
		cargoSvc.cadastrarCargo(listaCargos, 3, "Auxiliar", listaSetores, 3524);
	}
}
package br.com.proway.senior.cargosESalarios;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Setor> listaSetores = new ArrayList<Setor>();
		SetorServico svc = new SetorServico();
		
		svc.cadastrarSetor(listaSetores, "Recursos humanos", 3521, 20, 1524);
		svc.cadastrarSetor(listaSetores, "Comercial", 3522, 20, 1525);
		svc.cadastrarSetor(listaSetores, "Financeiro", 3523, 20, 1526);
		svc.cadastrarSetor(listaSetores, "Contabilidade", 3524, 20, 1527);
		svc.cadastrarSetor(listaSetores, "Administracao", 3525, 20, 1528);
	}
}
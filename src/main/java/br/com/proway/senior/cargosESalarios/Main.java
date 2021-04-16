
package br.com.proway.senior.cargosESalarios;



import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		int capacidade = 10;
		int id = 123;
		String nomeSetor = "O brabooo";
		SetorServico sv = new SetorServico();
		ArrayList<Setor> listaSetor = new ArrayList<Setor>();	
		
		sv.cadastrarSetor(listaSetor, nomeSetor, id, capacidade);
		System.out.println("alguma coisa");
	}
}

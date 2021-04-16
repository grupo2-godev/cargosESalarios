package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public class SetorServico {
	
	
	
	/**
	 * Cadastrar setores.
	 * Recebe: String - int - ArrayList.
	 * Instancia obejto setor com os parametros String e int. 
	 * Popula a lista com o objeto.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade) {
		Setor setor = new Setor();
		
		setor.id = id;
		setor.nomeSetor = nomeSetor;
		setor.capacidade = capacidade;
		listaSetores.add(setor);
	}
}

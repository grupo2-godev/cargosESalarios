package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public interface ISetorServico {
	
	public void cadastrarSetor(ArrayList<Setor> listaSetores,
							   String nomeSetor, 
							   int id, 
							   int capacidade, 
							   int idPermissao);
	public void alterarSetor(ArrayList<Setor> listaSetores, 
			                 String nomeSetor, 
			                 int id, 
			                 int capacidade, 
			                 int idPermissao);
	
	public Setor consultarSetor(ArrayList<Setor> listaSetores, 
			                    int idSetor);
	
	public ArrayList<Setor> consultarTodosOsSetores(ArrayList<Setor> listaSetores);
	
	public void deletarSetor(ArrayList<Setor> listaSetores, 
            				 int id);
}
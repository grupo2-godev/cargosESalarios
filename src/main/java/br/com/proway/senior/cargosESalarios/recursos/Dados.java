package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.Cargo.Cargo;
import br.com.proway.senior.cargosESalarios.Setor.Setor;

public final class Dados {
	private static Dados instance;
	private ArrayList<Cargo> listaCargos;	
	private ArrayList<Setor> listaSetores;
	
	/**
	 *Armazena os dados cadastrados do Setor em ArrayList. 
	 * Armazena os dados cadastrados do Cargo em ArrayList. 
	 *
	 *@author Guilherme Silva e Gabriel.
	 */
	
	private Dados() {
		listaCargos = new ArrayList<Cargo>();
		listaSetores = new ArrayList<Setor>();
	}
	/**
	 * Retorna uma referencia para o objeto Dados.
	 * Garante que o objeto Dados seja instanciado apenas uma vez.
	 * 
	 * 
	 * 
	 * @return Dados
	 */
	public static Dados getInstance() {
		if(instance == null) {
			instance = new Dados();
		}
		return instance;
	}
	
	public ArrayList<Cargo> getListaCargos() {
		return listaCargos;
	}
	
	public ArrayList<Setor> getListaSetores() {
		return listaSetores;
	}
	
}

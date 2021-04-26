package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.Cargo.Cargo;
import br.com.proway.senior.cargosESalarios.Setor.Setor;

public final class Dados {
	private static Dados instance;
	private ArrayList<Cargo> listaCargos;	
	private ArrayList<Setor> listaSetores;
	
	private Dados() {
		listaCargos = new ArrayList<Cargo>();
		listaSetores = new ArrayList<Setor>();
	}
	
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

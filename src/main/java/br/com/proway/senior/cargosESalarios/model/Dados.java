package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * Classe Dados para realizar a persistência em ArrayList.
 * Utiliza o padrão de projeto Singleton.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi 
 * @version Sprint3
 * - Criação e implementação da classe.
 * - Teste dos getListas.
 */
public final class Dados {
	private static Dados instance;
	private ArrayList<CargoModel> listaCargos;	
	private ArrayList<SetorModel> listaSetores;
	private ArrayList<Cbo2002Model> listaCbo2002;
	private ArrayList<PostoDeTrabalhoModel> listaPostos;
	private ArrayList<NivelModel> listaNiveis;
	
	/**
	 *Armazena os dados cadastrados do Setor em ArrayList. 
	 * Armazena os dados cadastrados do Cargo em ArrayList. 
	 *
	 *@author Guilherme Silva e Gabriel.
	 */
	private Dados() {
		listaCargos = new ArrayList<CargoModel>();
		listaSetores = new ArrayList<SetorModel>();
		listaCbo2002 = new ArrayList<Cbo2002Model>();
		listaPostos = new  ArrayList<PostoDeTrabalhoModel>();
		listaNiveis = new ArrayList<NivelModel>();
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
	
	public ArrayList<CargoModel> getListaCargos() {
		return listaCargos;
	}
	
	public ArrayList<SetorModel> getListaSetores() {
		return listaSetores;
	}
	public ArrayList<Cbo2002Model> getListaCbo2002() {
		return listaCbo2002;
	}
	
	public ArrayList<PostoDeTrabalhoModel> getListaPostos() {
		return listaPostos;
	}
  
	public ArrayList<NivelModel> getListaNiveis() {
		return listaNiveis;
	}
}

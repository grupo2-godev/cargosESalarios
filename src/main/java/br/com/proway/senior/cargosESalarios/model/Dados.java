package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * Classe Dados para realizar a persist�ncia em ArrayList.
 * Utiliza o padr�o de projeto Singleton.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grij�, Samuel Levi 
 * @version Sprint3
 * - Cria��o e implementa��o da classe.
 * - Teste dos getListas.
 */
public final class Dados {
	private static Dados instance;
	private ArrayList<CargoModel> listaCargos;	
	private ArrayList<SetorModel> listaSetores;
	private ArrayList<PostoDeTrabalhoModel> listaPostos;
	
	/**
	 *Armazena os dados cadastrados do Setor em ArrayList. 
	 * Armazena os dados cadastrados do Cargo em ArrayList. 
	 *
	 *@author Guilherme Silva e Gabriel.
	 */
	
	private Dados() {
		listaCargos = new ArrayList<CargoModel>();
		listaSetores = new ArrayList<SetorModel>();
		listaPostos = new  ArrayList<PostoDeTrabalhoModel>();
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
	
	public ArrayList<PostoDeTrabalhoModel> getListaPostos() {
		return listaPostos;
	}
	
}

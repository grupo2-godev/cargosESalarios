package br.com.proway.senior.cargosESalarios.antigos;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Cbo2002Model;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

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
	private ArrayList<Cbo1994Model> listaCbo1994;
	private ArrayList<Cbo2002Model> listaCbo2002;
	private ArrayList<PostoDeTrabalhoModel> listaPostos;
	private ArrayList<NivelModel> listaNiveis;
	private ArrayList<HorasMesModel> listaHorasMesModel;
	private ArrayList<GrauInstrucaoModel> listaGrauInstrucao;

	
	/**
	 *Armazena os dados cadastrados do Setor em ArrayList. 
	 * Armazena os dados cadastrados do Cargo em ArrayList. 
	 *
	 *@author Guilherme Silva e Gabriel.
	 */
	private Dados() {
		listaCargos = new ArrayList<CargoModel>();
		listaSetores = new ArrayList<SetorModel>();
		listaCbo1994 = new ArrayList<Cbo1994Model>();
		listaCbo2002 = new ArrayList<Cbo2002Model>();
		listaPostos = new  ArrayList<PostoDeTrabalhoModel>();
		listaNiveis = new ArrayList<NivelModel>();
		listaHorasMesModel = new ArrayList<HorasMesModel>();
		listaGrauInstrucao = new ArrayList<GrauInstrucaoModel>();
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
	public ArrayList<Cbo1994Model> getListaCbo1994() {
		return listaCbo1994;
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
	
	public ArrayList<GrauInstrucaoModel> getListaGrauInstrucao() {
		return listaGrauInstrucao;
	}

	public ArrayList<HorasMesModel> getListaHorasMes() {
		return listaHorasMesModel;
	}
}
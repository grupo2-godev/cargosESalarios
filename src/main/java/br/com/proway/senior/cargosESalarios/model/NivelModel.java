package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NivelModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int idNivel;
	
	private String nomeNivel;
	
	public NivelModel() {}
	
	public NivelModel(String nome) {
		this.nomeNivel = nome;
	}			
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return idNivel;
	}	
	
	/**
	 * @param nome the nome to set
	 */
	public void setId(int id) {
			this.idNivel = id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nomeNivel;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
			this.nomeNivel = nome;
	}
	
}

package br.com.proway.senior.cargosESalarios.model;

public class NivelModel {

	private int idNivel;
	private String nomeNivel;
	
	public NivelModel(String nome) {
		this.nomeNivel = nome;
	}
	
	/**
	 * @return the id
	 */
	public int getIdNivel() {
		return idNivel;
	}
	/**
	 * @param id the id to set
	 */
	public void setIdNivel(int id) {
		this.idNivel = id;
	}
	/**
	 * @return the nome
	 */
	public String getNomeNivel() {
		return nomeNivel;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNomeNivel(String nome) {
		this.nomeNivel = nome;
	}
	
	
	
}

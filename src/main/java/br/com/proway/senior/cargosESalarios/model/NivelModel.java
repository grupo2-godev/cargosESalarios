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
	public Integer getId() {
		return idNivel;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

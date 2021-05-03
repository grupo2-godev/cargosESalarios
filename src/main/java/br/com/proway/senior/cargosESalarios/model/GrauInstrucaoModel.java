package br.com.proway.senior.cargosESalarios.model;

public class GrauInstrucaoModel {

	private Integer idInstrucao;
	private String instrucao;
	
	public GrauInstrucaoModel() {};
	
	public GrauInstrucaoModel(Integer id, String instrucao) {
		this.idInstrucao = id;
		this.instrucao = instrucao;
	}
	
	public GrauInstrucaoModel(String instrucao) {
		this.instrucao = instrucao;
	}

	/**
	 * @return the idInstrucao
	 */
	public Integer getIdInstrucao() {
		return idInstrucao;
	}

	/**
	 * @param idInstrucao the idInstrucao to set
	 */
	public void setIdInstrucao(Integer idInstrucao) {
		this.idInstrucao = idInstrucao;
	}

	/**
	 * @return the instrucao
	 */
	public String getInstrucao() {
		return instrucao;
	}

	/**
	 * @param instrucao the instrucao to set
	 */
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	
	
	
}

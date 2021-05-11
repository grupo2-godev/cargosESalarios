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
	public Integer getId() {
		return idInstrucao;
	}

	/**
	 * @param idInstrucao the idInstrucao to set
	 */
	public void setId(Integer idInstrucao) {
		this.idInstrucao = idInstrucao;
	}

	/**
	 * @return the instrucao
	 */
	public String getNome() {
		return instrucao;
	}

	/**
	 * @param instrucao the instrucao to set
	 */
	public void setNome(String instrucao) {
		this.instrucao = instrucao;
	}
	
	
	
}

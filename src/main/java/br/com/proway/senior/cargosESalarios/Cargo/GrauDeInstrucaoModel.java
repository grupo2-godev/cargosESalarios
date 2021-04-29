package br.com.proway.senior.cargosESalarios.Cargo;

/**
 * Classe de apoio para persistência via banco de dados. Será chamado seu
 * ID na classe Cargo.
 * 
 * @author Sarah Brito
 *
 */

public class GrauDeInstrucaoModel {
	
	private Integer idGrauDeInstrucao;
	private String descricao;
	
	public GrauDeInstrucaoModel(Integer idGrauDeInstrucao, String descricao) {
		this.idGrauDeInstrucao = idGrauDeInstrucao;
		this.descricao = descricao;
	}

	public Integer getIdGrauDeInstrucao() {
		return idGrauDeInstrucao;
	}

	public void setIdGrauDeInstrucao(Integer idGrauDeInstrucao) {
		this.idGrauDeInstrucao = idGrauDeInstrucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

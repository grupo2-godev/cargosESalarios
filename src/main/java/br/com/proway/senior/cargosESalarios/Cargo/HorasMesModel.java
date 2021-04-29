package br.com.proway.senior.cargosESalarios.Cargo;

/**
 * Classe de apoio para persistência via banco de dados. Será chamado seu
 * ID na classe Cargo.
 * 
 * @author Sarah Brito
 */

public class HorasMesModel {
	
	private Integer idGrauDeInstrucao;
	private Double quantidade;
	
	public HorasMesModel(Integer idGrauDeInstrucao, Double quantidade) {
		this.idGrauDeInstrucao = idGrauDeInstrucao;
		this.quantidade = quantidade;
	}

	public Integer getIdGrauDeInstrucao() {
		return idGrauDeInstrucao;
	}

	public void setIdGrauDeInstrucao(Integer idGrauDeInstrucao) {
		this.idGrauDeInstrucao = idGrauDeInstrucao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	

}

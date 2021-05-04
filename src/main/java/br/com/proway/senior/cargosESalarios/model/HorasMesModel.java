package br.com.proway.senior.cargosESalarios.model;

/**
 * Classe de apoio para persistência via banco de dados. Registra o grau de instrução e a
 * quantidade de horas trabalhadas por mês.
 * 
 * @author Lorran P. Santos
 */

public class HorasMesModel {
	
	private Integer idGrauDeInstrucao;
	private Double quantidade;

	public HorasMesModel() {
	}

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

	@Override
	public String toString() {
		return "HorasMesModel [idGrauDeInstrucao=" + idGrauDeInstrucao + ", quantidade=" + quantidade + "]";
	}

}

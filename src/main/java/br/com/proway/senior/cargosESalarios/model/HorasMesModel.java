package br.com.proway.senior.cargosESalarios.model;

/**
 * Classe de apoio para persistência via banco de dados. Registra a quantidade de horas
 * trabalhadas por mês.
 * 
 * @author Lorran P. Santos
 */

public class HorasMesModel {
	
	// TODO Corrigir documentação

	private Integer idGrauDeInstrucao;
	private Double quantidade;

	public HorasMesModel() {
	}

	/**
	 * 
	 * @param idGrauDeInstrucao
	 * @param quantidade
	 */
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

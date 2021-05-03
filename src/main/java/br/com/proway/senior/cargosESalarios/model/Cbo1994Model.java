package br.com.proway.senior.cargosESalarios.model;

/**
 * Classe de apoio para persistência via banco de dados. Será chamado seu
 * ID na classe Cargo.
 * 
 * @author Sarah Brito
 *
 */

public class Cbo1994Model {
	
	private Integer codigoId;
	private String descricao;
	private Double percentualInsalubridade;
	public Double percentualPericulosidade;
	
	public Cbo1994Model() {}
	
	public Cbo1994Model(Integer codigoId, String descricao, Double percentualInsalubridade,
			Double percentualPericulosidade) {
		this.codigoId = codigoId;
		this.descricao = descricao;
		this.percentualInsalubridade = percentualInsalubridade;
		this.percentualPericulosidade = percentualPericulosidade;
	}

	public Integer getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(Integer codigoId) {
		this.codigoId = codigoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}

	public void setPercentualInsalubridade(Double percentualInsalubridade) {
		this.percentualInsalubridade = percentualInsalubridade;
	}

	public Double getPercentualPericulosidade() {
		return percentualPericulosidade;
	}

	public void setPercentualPericulosidade(Double percentualPericulosidade) {
		this.percentualPericulosidade = percentualPericulosidade;
	}

}

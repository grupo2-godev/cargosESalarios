package br.com.proway.senior.cargosESalarios.model;

/**
 * Classe de apoio para persistência via banco de dados. Será chamado seu
 * ID na classe Cargo.
 * 
 * @author Sarah Brito
 *
 */

public class Cbo2002Model {
	
	private Integer codigoId;
	private String descricao;
	private Double percentualInsalubridade;
	public Double percentualPericulosidade;
	
	public Cbo2002Model() {}
	
	public Cbo2002Model(Integer codigoId, String descricao, Double percentualInsalubridade,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoId == null) ? 0 : codigoId.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cbo2002Model other = (Cbo2002Model) obj;
		if (codigoId == null) {
			if (other.codigoId != null)
				return false;
		} else if (!codigoId.equals(other.codigoId))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	
		

}

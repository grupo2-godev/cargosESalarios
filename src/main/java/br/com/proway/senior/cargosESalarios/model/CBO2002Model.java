package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de apoio para persistencia via banco de dados. Sera chave estrangeira
 * na classe Cargo {@link CargoModel}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

@Entity
@Table(name = "CBO2002")
public class CBO2002Model {

	/**
	 * A identificacao do CBO não é auto incrementada. O proprio 
	 * codigo do CBO sera a PrimaryKey.
	 */
	@Id
	private Integer codigoId;
	private String descricao;
	private Double percentualInsalubridade;
	private Double percentualPericulosidade;

	public CBO2002Model() {
	}

	public CBO2002Model(Integer codigoId, String descricao, Double percentualInsalubridade,
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
	public String toString() {
		return "Cbo2002Model [codigoId=" + codigoId + ", descricao=" + descricao + ", percentualInsalubridade="
				+ percentualInsalubridade + ", percentualPericulosidade=" + percentualPericulosidade + "]";
	}

}

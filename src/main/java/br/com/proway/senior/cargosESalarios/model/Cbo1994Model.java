package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de apoio para persistencia via banco de dados. Sera chamado seu
 * ID na classe Cargo.
 * 
 * @author Sarah Brito - Sprint 4
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */

@Entity
@Table(name = "cbo1994")
public class Cbo1994Model{
	
	@Id	
	private Integer codigo_cbo;
	private String descricao;
	private Double percentualInsalubridade;
	public Double percentualPericulosidade;
	
	public Cbo1994Model() {}
	
	public Cbo1994Model(Integer codigo_cbo, String descricao, Double percentualInsalubridade,
			Double percentualPericulosidade) {
		this.codigo_cbo = codigo_cbo;
		this.descricao = descricao;
		this.percentualInsalubridade = percentualInsalubridade;
		this.percentualPericulosidade = percentualPericulosidade;
	}

	public Integer getCodigo_cbo() {
		return codigo_cbo;
	}

	public void setCodigo_cbo(Integer codigo_cbo) {
		this.codigo_cbo = codigo_cbo;
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

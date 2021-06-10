package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que cuida do grau de instrucaoo, no banco eh referenciada pela classe
 * {@link CargoModel}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */

@Entity
@Table(name = "grau_instrucao")
public class GrauInstrucaoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInstrucao;
	private String instrucao;

	public GrauInstrucaoModel() {

	}

	public GrauInstrucaoModel(Integer id, String instrucao) {
		this.idInstrucao = id;
		this.instrucao = instrucao;
	}

	/**
	 * Construtor secundario sem o ID, que eh auto 
	 * incrementado no banco de dados.
	 * 
	 * @param instrucao
	 */
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

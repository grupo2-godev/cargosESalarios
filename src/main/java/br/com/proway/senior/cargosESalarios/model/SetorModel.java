package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe SetorModel
 * 
 * Cria os atributos necessarios para um setor, que sera vinculado ao um
 * PostodeTrabalhoModel {@link PostoDeTrabalhoModel} e recebe uma chave
 * estrangeira para identificar a permissao de acesso de um usuario para acessar
 * as informacoes da tabela setor.
 * 
 * @author Sprint 1
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */

@Entity
@Table(name = "setor")
public class SetorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSetor;
	private String nomeSetor;
	private Integer idPermissao;

	/**
	 * @param id
	 * @param nomeSetor
	 * @param idPermissao
	 */
	public SetorModel(String nomeSetor, Integer idPermissao) {
		this.nomeSetor = nomeSetor;
		this.idPermissao = idPermissao;
	}

	public SetorModel() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return idSetor;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.idSetor = id;
	}

	/**
	 * @return the nomeSetor
	 */
	public String getNomeSetor() {
		return nomeSetor;
	}

	/**
	 * @param nomeSetor the nomeSetor to set
	 */
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	/**
	 * @return the idPermissao
	 */
	public Integer getIdPermissao() {
		return idPermissao;
	}

	/**
	 * @param idPermissao the idPermissao to set
	 */
	public void setIdPermissao(Integer idPermissao) {
		this.idPermissao = idPermissao;
	}

}
package br.com.proway.senior.cargosESalarios;


public class Setor {
	int id;
	String nomeSetor;
	int capacidade;
	int idPermissao;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the capacidade
	 */
	public int getCapacidade() {
		return capacidade;
	}
	/**
	 * @param capacidade the capacidade to set
	 */
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	/**
	 * @return the idPermissao
	 */
	public int getIdPermissao() {
		return idPermissao;
	}
	/**
	 * @param idPermissao the idPermissao to set
	 */
	public void setIdPermissao(int idPermissao) {
		this.idPermissao = idPermissao;
	}
	/**
	 * @param id
	 * @param nomeSetor
	 * @param capacidade
	 * @param idPermissao
	 */
	public Setor(int id, String nomeSetor, int capacidade, int idPermissao) {
		super();
		this.id = id;
		this.nomeSetor = nomeSetor;
		this.capacidade = capacidade;
		this.idPermissao = idPermissao;
	}
	/**
	 * 
	 */
	public Setor() {
		super();
	}
	
	
	
}
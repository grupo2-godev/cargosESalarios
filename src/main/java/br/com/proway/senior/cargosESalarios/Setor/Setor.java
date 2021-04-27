package br.com.proway.senior.cargosESalarios.Setor;

public class Setor {
	private Integer idSetor;
	private String nomeSetor;
	private Integer capacidade;
	private Integer idPermissao;

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
	 * @return the capacidade
	 */
	public Integer getCapacidade() {
		return capacidade;
	}

	/**
	 * @param capacidade the capacidade to set
	 */
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
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

	/**
	 * @param id
	 * @param nomeSetor
	 * @param capacidade
	 * @param idPermissao
	 */
	public Setor(Integer id, String nomeSetor, Integer capacidade, Integer idPermissao) {
		super();
		this.idSetor = id;
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

	@Override
	public String toString() {
		return "Setor [idSetor=" + idSetor + ", nomeSetor=" + nomeSetor + ", capacidade=" + capacidade
				+ ", idPermissao=" + idPermissao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + idPermissao;
		result = prime * result + idSetor;
		result = prime * result + ((nomeSetor == null) ? 0 : nomeSetor.hashCode());
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
		Setor other = (Setor) obj;
		if (capacidade != other.capacidade)
			return false;
		if (idPermissao != other.idPermissao)
			return false;
		if (idSetor != other.idSetor)
			return false;
		if (nomeSetor == null) {
			if (other.nomeSetor != null)
				return false;
		} else if (!nomeSetor.equals(other.nomeSetor))
			return false;
		return true;
	}


	
	
}
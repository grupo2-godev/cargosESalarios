package br.com.proway.senior.cargosESalarios.model;

/**
 * Classe de modelo Setor.
 * @author Sprint 1
 * @version Sprint3:
 * 	- Altera��o dos tipo primitivo int para Integer.
 * 	- Adi��o do hash e Equals.
 */
public class SetorModel {
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

	@Override
	public String toString() {
		return "Setor [idSetor=" + idSetor + ", nomeSetor=" + nomeSetor
				+ ", idPermissao=" + idPermissao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPermissao == null) ? 0 : idPermissao.hashCode());
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
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
		SetorModel other = (SetorModel) obj;
		if (idPermissao == null) {
			if (other.idPermissao != null)
				return false;
		} else if (!idPermissao.equals(other.idPermissao))
			return false;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		if (nomeSetor == null) {
			if (other.nomeSetor != null)
				return false;
		} else if (!nomeSetor.equals(other.nomeSetor))
			return false;
		return true;
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
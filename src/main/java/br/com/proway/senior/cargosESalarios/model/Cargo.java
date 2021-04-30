package br.com.proway.senior.cargosESalarios.model;

import java.time.LocalDateTime;

/**
 * Classe de modelo Cargo.
 * @author Sprint 1
 * @version Sprint3:
 * 	- Alteração dos tipo primitivo int para Integer.
 * 	- Adição do hash e Equals.
 */
public class Cargo {

	private Integer idCargo;
	private String nomeCargo;
	private Integer idSetor;
	private String hierarquia;
	private Double salario;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataUltimaRevisao;
	private String cbo2002;
	private String cbo94;
	private Integer horaMes;
	private String grauDeInstrucao;
	private String experienciaMinima;
	private String atribuicoes;
	private Boolean status;
	private Integer idPermissao;
	private Double insalubridade;

	/**
	 * @param idCargo
	 * @param nomeCargo
	 * @param idSetor
	 * @param hierarquia
	 * @param salario
	 * @param dataCadastro
	 * @param dataUltimaRevisao
	 * @param cbo2002
	 * @param cbo94
	 * @param horaMes
	 * @param grauDeInstrucao
	 * @param experienciaMinima
	 * @param atribuicoes
	 * @param status
	 * @param idPermissao
	 */
	public Cargo(Integer idCargo, String nomeCargo, Integer idSetor, String hierarquia, Double salario,
			LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao, String cbo2002, String cbo94, Integer horaMes,
			String grauDeInstrucao, String experienciaMinima, String atribuicoes, Boolean status,
			Integer idPermissao, Double insalubridade) {
		super();
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
		this.idSetor = idSetor;
		this.hierarquia = hierarquia;
		this.salario = salario;
		this.dataCadastro = dataCadastro;
		this.dataUltimaRevisao = dataUltimaRevisao;
		this.cbo2002 = cbo2002;
		this.cbo94 = cbo94;
		this.horaMes = horaMes;
		this.grauDeInstrucao = grauDeInstrucao;
		this.experienciaMinima = experienciaMinima;
		this.atribuicoes = atribuicoes;
		this.status = status;
		this.idPermissao = idPermissao;
		this.insalubridade = insalubridade;
	}

	public Cargo(Integer idCargo, String nomeCargo) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}

	public Cargo(Integer idCargo, String nomeCargo, Integer idSetor) {
		this.idCargo = idCargo;
		this.idSetor = idSetor;
		this.nomeCargo = nomeCargo;
	}

	/**
	 * 
	 */
	public Cargo() {
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", nomeCargo=" + nomeCargo + ", idSetor=" + idSetor + "" + ", hierarquia="
				+ hierarquia + ", salario=" + salario + ", dataCadastro=" + dataCadastro + ", dataUltimaRevisao="
				+ dataUltimaRevisao + ", cbo2002=" + cbo2002 + ", cbo94=" + cbo94 + ", horaMes=" + horaMes
				+ ", grauDeInstrucao=" + grauDeInstrucao + ", experienciaMinima=" + experienciaMinima + ", atribuicoes="
				+ atribuicoes + ", status=" + status + ", idPermissao=" + idPermissao + "Insalubridade=" + insalubridade
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atribuicoes == null) ? 0 : atribuicoes.hashCode());
		result = prime * result + ((cbo2002 == null) ? 0 : cbo2002.hashCode());
		result = prime * result + ((cbo94 == null) ? 0 : cbo94.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataUltimaRevisao == null) ? 0 : dataUltimaRevisao.hashCode());
		result = prime * result + ((experienciaMinima == null) ? 0 : experienciaMinima.hashCode());
		result = prime * result + ((grauDeInstrucao == null) ? 0 : grauDeInstrucao.hashCode());
		result = prime * result + ((hierarquia == null) ? 0 : hierarquia.hashCode());
		result = prime * result + ((horaMes == null) ? 0 : horaMes.hashCode());
		result = prime * result + ((idCargo == null) ? 0 : idCargo.hashCode());
		result = prime * result + ((idPermissao == null) ? 0 : idPermissao.hashCode());
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((insalubridade == null) ? 0 : insalubridade.hashCode());
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
		Cargo other = (Cargo) obj;
		if (atribuicoes == null) {
			if (other.atribuicoes != null)
				return false;
		} else if (!atribuicoes.equals(other.atribuicoes))
			return false;
		if (cbo2002 == null) {
			if (other.cbo2002 != null)
				return false;
		} else if (!cbo2002.equals(other.cbo2002))
			return false;
		if (cbo94 == null) {
			if (other.cbo94 != null)
				return false;
		} else if (!cbo94.equals(other.cbo94))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataUltimaRevisao == null) {
			if (other.dataUltimaRevisao != null)
				return false;
		} else if (!dataUltimaRevisao.equals(other.dataUltimaRevisao))
			return false;
		if (experienciaMinima == null) {
			if (other.experienciaMinima != null)
				return false;
		} else if (!experienciaMinima.equals(other.experienciaMinima))
			return false;
		if (grauDeInstrucao == null) {
			if (other.grauDeInstrucao != null)
				return false;
		} else if (!grauDeInstrucao.equals(other.grauDeInstrucao))
			return false;
		if (hierarquia == null) {
			if (other.hierarquia != null)
				return false;
		} else if (!hierarquia.equals(other.hierarquia))
			return false;
		if (horaMes == null) {
			if (other.horaMes != null)
				return false;
		} else if (!horaMes.equals(other.horaMes))
			return false;
		if (idCargo == null) {
			if (other.idCargo != null)
				return false;
		} else if (!idCargo.equals(other.idCargo))
			return false;
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
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (insalubridade == null) {
			if (other.insalubridade != null)
				return false;
		} else if (!insalubridade.equals(other.insalubridade))
			return false;
		return true;
	}

	/**
	 * @return the idCargo
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * @param idCargo the idCargo to set
	 */
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	/**
	 * @return the nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}

	/**
	 * @param nomeCargo the nomeCargo to set
	 */
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	/**
	 * @return the idSetor
	 */
	public Integer getIdSetor() {
		return idSetor;
	}

	/**
	 * @param idSetor the idSetor to set
	 */
	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	/**
	 * @return the hierarquia
	 */
	public String getHierarquia() {
		return hierarquia;
	}

	/**
	 * @param hierarquia the hierarquia to set
	 */
	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	/**
	 * @return the dataCadastro
	 */
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataUltimaRevisao
	 */
	public LocalDateTime getDataUltimaRevisao() {
		return dataUltimaRevisao;
	}

	/**
	 * @param dataUltimaRevisao the dataUltimaRevisao to set
	 */
	public void setDataUltimaRevisao(LocalDateTime dataUltimaRevisao) {
		this.dataUltimaRevisao = dataUltimaRevisao;
	}

	/**
	 * @return the cbo2002
	 */
	public String getCbo2002() {
		return cbo2002;
	}

	/**
	 * @param cbo2002 the cbo2002 to set
	 */
	public void setCbo2002(String cbo2002) {
		this.cbo2002 = cbo2002;
	}

	/**
	 * @return the cbo94
	 */
	public String getCbo94() {
		return cbo94;
	}

	/**
	 * @param cbo94 the cbo94 to set
	 */
	public void setCbo94(String cbo94) {
		this.cbo94 = cbo94;
	}

	/**
	 * @return the horaMes
	 */
	public Integer getHoraMes() {
		return horaMes;
	}

	/**
	 * @param horaMes the horaMes to set
	 */
	public void setHoraMes(Integer horaMes) {
		this.horaMes = horaMes;
	}

	/**
	 * @return the grauDeInstrucao
	 */
	public String getGrauDeInstrucao() {
		return grauDeInstrucao;
	}

	/**
	 * @param grauDeInstrucao the grauDeInstrucao to set
	 */
	public void setGrauDeInstrucao(String grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}

	/**
	 * @return the experienciaMinima
	 */
	public String getExperienciaMinima() {
		return experienciaMinima;
	}

	/**
	 * @param experienciaMinima the experienciaMinima to set
	 */
	public void setExperienciaMinima(String experienciaMinima) {
		this.experienciaMinima = experienciaMinima;
	}

	/**
	 * @return the atribuicoes
	 */
	public String getAtribuicoes() {
		return atribuicoes;
	}

	/**
	 * @param atribuicoes the atribuicoes to set
	 */
	public void setAtribuicoes(String atribuicoes) {
		this.atribuicoes = atribuicoes;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
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
	
	public Double getInsalubridade() {
		return insalubridade;
	}

	public void setInsalubridade(Double insalubridade) {
		this.insalubridade = insalubridade;
	}	
}

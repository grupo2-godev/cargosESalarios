package br.com.proway.senior.cargosESalarios.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe cargo.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 */
@Entity
@Table(name = "cargo")
public class CargoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCargo;
	private String nomeCargo;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataUltimaRevisao;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private CBO2002Model cbo2002;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private CBO1994Model cbo94;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private HorasMesModel horaMes;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private GrauInstrucaoModel grauInstrucao;
	private String experienciaMinima;
	private String atribuicoes;
	private Boolean status;
	private Integer idPermissao;

	public CargoModel() {

	}

	/**
	 * @param idCargo
	 * @param nomeCargo
	 */
	public CargoModel(Integer idCargo, String nomeCargo) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}

	/**
	 * @param nomeCargo
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
	 * @param grauInstrucao
	 */
	public CargoModel(String nomeCargo, LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao,
			CBO2002Model cbo2002, CBO1994Model cbo94, HorasMesModel horaMes, GrauInstrucaoModel grauInstrucao,
			String experienciaMinima, String atribuicoes, Boolean status, Integer idPermissao) {
		this.nomeCargo = nomeCargo;
		this.dataCadastro = dataCadastro;
		this.dataUltimaRevisao = dataUltimaRevisao;
		this.cbo2002 = cbo2002;
		this.cbo94 = cbo94;
		this.horaMes = horaMes;
		this.grauInstrucao = grauInstrucao;
		this.experienciaMinima = experienciaMinima;
		this.atribuicoes = atribuicoes;
		this.status = status;
		this.idPermissao = idPermissao;
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
		result = prime * result + ((grauInstrucao == null) ? 0 : grauInstrucao.hashCode());
		result = prime * result + ((horaMes == null) ? 0 : horaMes.hashCode());
		result = prime * result + ((idCargo == null) ? 0 : idCargo.hashCode());
		result = prime * result + ((idPermissao == null) ? 0 : idPermissao.hashCode());
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CargoModel [idCargo=" + idCargo + ", nomeCargo=" + nomeCargo + ", dataCadastro=" + dataCadastro
				+ ", dataUltimaRevisao=" + dataUltimaRevisao + ", cbo2002=" + cbo2002 + ", cbo94=" + cbo94
				+ ", horaMes=" + horaMes + ", grauDeInstrucao=" + grauInstrucao + ", experienciaMinima="
				+ experienciaMinima + ", atribuicoes=" + atribuicoes + ", status=" + status + ", idPermissao="
				+ idPermissao + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoModel other = (CargoModel) obj;
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
		if (grauInstrucao == null) {
			if (other.grauInstrucao != null)
				return false;
		} else if (!grauInstrucao.equals(other.grauInstrucao))
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
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
	public CBO2002Model getCbo2002() {
		return cbo2002;
	}

	/**
	 * @param cbo2002 the cbo2002 to set
	 */
	public void setCbo2002(CBO2002Model cbo2002) {
		this.cbo2002 = cbo2002;
	}

	/**
	 * @return the cbo94
	 */
	public CBO1994Model getCbo94() {
		return cbo94;
	}

	/**
	 * @param cbo94 the cbo94 to set
	 */
	public void setCbo94(CBO1994Model cbo94) {
		this.cbo94 = cbo94;
	}

	/**
	 * @return the horaMes
	 */
	public HorasMesModel getHoraMes() {
		return horaMes;
	}

	/**
	 * @param horaMes the horaMes to set
	 */
	public void setHoraMes(HorasMesModel horaMes) {
		this.horaMes = horaMes;
	}

	/**
	 * @return the grauInstrucao
	 */
	public GrauInstrucaoModel getGrauInstrucao() {
		return grauInstrucao;
	}

	/**
	 * @param grauInstrucao the grauInstrucao to set
	 */
	public void setGrauInstrucao(GrauInstrucaoModel grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
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

}

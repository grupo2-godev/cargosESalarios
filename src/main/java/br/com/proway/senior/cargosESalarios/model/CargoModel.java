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
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
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

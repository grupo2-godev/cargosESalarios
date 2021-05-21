package br.com.proway.senior.cargosESalarios.model.DTO; 

import java.time.LocalDateTime;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

/**
 * Classe cargo.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6 
 */

public class CargoModelDTO {

	private Integer idCargo;
	private String nomeCargo;
	private LocalDateTime dataUltimaRevisao;
	private CBO2002Model cbo2002;
	private CBO1994Model cbo94;
	private HorasMesModel horaMes;
	private GrauInstrucaoModel grauInstrucao;
	private String experienciaMinima;
	private Boolean status;
	
	
	public CargoModelDTO(CargoModel cargoModel) {
		this.idCargo = cargoModel.getIdCargo();
		this.nomeCargo = cargoModel.getNomeCargo();
		this.dataUltimaRevisao = cargoModel.getDataUltimaRevisao();
		this.cbo2002 = cargoModel.getCbo2002();
		this.cbo94 = cargoModel.getCbo94();
		this.horaMes = cargoModel.getHoraMes();
		this.grauInstrucao = cargoModel.getGrauInstrucao();
		this.experienciaMinima = cargoModel.getExperienciaMinima();
		this.status = cargoModel.getStatus();
	}

	/**
	 * @return the idCargo
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * @return the nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}

	/**
	 * @return the dataUltimaRevisao
	 */
	public LocalDateTime getDataUltimaRevisao() {
		return dataUltimaRevisao;
	}

	/**
	 * @return the cbo2002
	 */
	public CBO2002Model getCbo2002() {
		return cbo2002;
	}

	/**
	 * @return the cbo94
	 */
	public CBO1994Model getCbo94() {
		return cbo94;
	}

	/**
	 * @return the horaMes
	 */
	public HorasMesModel getHoraMes() {
		return horaMes;
	}

	/**
	 * @return the grauInstrucao
	 */
	public GrauInstrucaoModel getGrauInstrucao() {
		return grauInstrucao;
	}

	/**
	 * @return the experienciaMinima
	 */
	public String getExperienciaMinima() {
		return experienciaMinima;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}	
}

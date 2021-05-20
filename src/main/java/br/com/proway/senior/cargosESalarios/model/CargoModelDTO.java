package br.com.proway.senior.cargosESalarios.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class CargoModelDTO {

	private Integer id;
	private String nomeCargo;
	private String cbo2002;
	private CBO1994Model cbo94;
	private HorasMesModel horaTrabalhoMes;
	private String atribuicoes;
	private Boolean status;
	private Integer idPermissao;

	public CargoModelDTO(CargoModel cargoModel) {
		this.id = cargoModel.getIdCargo();
		this.nomeCargo = cargoModel.getNomeCargo();
		this.cbo2002 = cargoModel.getCbo2002().getDescricao();
		this.cbo94 = cargoModel.getCbo94();
		this.horaTrabalhoMes = cargoModel.getHoraMes();
		this.atribuicoes = cargoModel.getAtribuicoes();
		this.status = cargoModel.getStatus();
		this.idPermissao = cargoModel.getIdPermissao();
	}

	public Integer getId() {
		return id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public CBO2002Model getCbo2002() {
		return cbo2002;
	}

	public CBO1994Model getCbo94() {
		return cbo94;
	}

	public HorasMesModel getHoraMes() {
		return horaTrabalhoMes;
	}

	public String getAtribuicoes() {
		return atribuicoes;
	}

	public Boolean getStatus() {
		return status;
	}

	public Integer getIdPermissao() {
		return idPermissao;
	}
	
	

}

package br.com.proway.senior.cargosESalarios.model.DTO; 

import java.time.LocalDateTime;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

/**
 * <h1>Classe responsável pelo DTO do {@link CargoModel}</h1>
 * 
 * <p>Classe que disponibiliza
 * os recursos que serão visivel
 * ao usuário da API do cargo.</p>
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
 * 
 *  @see CargoModel
 */

public class CargoModelDTO {

	private Integer idCargo;
	private String nomeCargo;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataUltimaRevisao;
	private CBO2002Model cbo2002;
	private CBO1994Model cbo94;
	private HorasMesModel horaMes;
	private GrauInstrucaoModel grauInstrucao;
	private String experienciaMinima;
	private Boolean status;
	
	/**
	 * <h1>Construtor da classe {@link CargoModelDTO}</h1>
	 * 
	 * <p>Construtor da classe {@link CargoModelDTO}
	 * que seta todos as variaveis da classe {@link CargoModelDTO}
	 * atraves do {@link CargoModel}.</p>
	 * 
	 * @param cargoModel {@link CargoModel} - Referente ao objeto
	 * utilizado para contruir os atributos visiveis
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 */
	public CargoModelDTO(CargoModel cargoModel) {
		this.idCargo = cargoModel.getIdCargo();
		this.nomeCargo = cargoModel.getNomeCargo();
		this.dataCadastro = cargoModel.getDataCadastro();
		this.dataUltimaRevisao = cargoModel.getDataUltimaRevisao();
		this.cbo2002 = cargoModel.getCbo2002();
		this.cbo94 = cargoModel.getCbo94();
		this.horaMes = cargoModel.getHoraMes();
		this.grauInstrucao = cargoModel.getGrauInstrucao();
		this.experienciaMinima = cargoModel.getExperienciaMinima();
		this.status = cargoModel.getStatus();
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#idCargo}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#idCargo}}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return Integer - Referente ao {@link CargoModelDTO#idCargo} da classe {@link CargoModelDTO}
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#idCargo
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#nomeCargo}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#nomeCargo}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return String - Referente ao {@link CargoModelDTO#nomeCargo} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}

	/**
	 * <h1>Pega a {@link CargoModelDTO#dataUltimaRevisao}.</h1>
	 * 
	 * <p>Pega a {@link CargoModelDTO#dataUltimaRevisao}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return LocalDateTime - Referente a {@link CargoModelDTO#dataUltimaRevisao} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#dataUltimaRevisao
	 */
	public LocalDateTime getDataUltimaRevisao() {
		return dataUltimaRevisao;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#cbo2002}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#cbo2002}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return {@link CBO2002Model} - Referente a {@link CargoModelDTO#cbo2002} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#cbo2002
	 * @see CBO2002Model
	 */
	public CBO2002Model getCbo2002() {
		return cbo2002;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#cbo94}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#cbo94}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return {@link CBO1994Model} - Referente a {@link CargoModelDTO#cbo94} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#cbo94
	 * @see CBO1994Model
	 */
	public CBO1994Model getCbo94() {
		return cbo94;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#horaMes}.</h1>
	 * 
	 * <p>Pega a {@link CargoModelDTO#horaMes}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return {@link HorasMesModel} - Referente a {@link CargoModelDTO#horaMes} da classe {@link CargoModelDTO}
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#horaMes
	 * @see HorasMesModel
	 */
	public HorasMesModel getHoraMes() {
		return horaMes;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#grauInstrucao}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#grauInstrucao}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return {@link GrauInstrucaoModel} - Referente a {@link CargoModelDTO#grauInstrucao} da classe {@link CargoModelDTO}
	 * 
	 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 6
	 * @author Lucas Nunes <b>lucas.nunes@senior.com.br</b> - Sprint 6
	 * @author Vitor Nathan Goncalves <b>vitor.goncalves@senior.com.br</b> - Sprint 6
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#grauInstrucao
	 * @see GrauInstrucaoModel
	 */
	public GrauInstrucaoModel getGrauInstrucao() {
		return grauInstrucao;
	}

	/**
	 * <h1>Pega a {@link CargoModelDTO#experienciaMinima}.</h1>
	 * 
	 * <p>Pega a {@link CargoModelDTO#experienciaMinima}
	 * da classe {@link CargoModelDTO.</p>
	 * 
	 * @return String - Referente a {@link CargoModelDTO#experienciaMinima} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#experienciaMinima
	 */
	public String getExperienciaMinima() {
		return experienciaMinima;
	}

	/**
	 * <h1>Pega o {@link CargoModelDTO#status}.</h1>
	 * 
	 * <p>Pega o {@link CargoModelDTO#status}
	 * da classe {@link CargoModelDTO}.</p>
	 * 
	 * @return Boolean - Referente a {@link CargoModelDTO#status} da classe {@link CargoModelDTO}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModelDTO
	 * @see CargoModelDTO#status
	 */
	public Boolean getStatus() {
		return status;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
}
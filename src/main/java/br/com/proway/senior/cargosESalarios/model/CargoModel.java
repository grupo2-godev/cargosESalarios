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
 * <h1>Classe cargo.</h1>
 * 
 * <p>Classe responsável pela representação do
 * cargo de um colaborador.</p>
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
	private HorasMesModel horasMes;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private GrauInstrucaoModel grauInstrucao;
	private String experienciaMinima;
	private String atribuicoes;
	private Boolean status;
	private Integer idPermissao;

	/**
	 * <h1>Construtor vazio do {@link CargoModel}.</h1>
	 * 
	 * <p>Construtor sem parametros da classe {@link CargoModel}</p>
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 */
	public CargoModel() {
	}

	/**
	 * <h1>Construtor com paramêtros do {@link CargoModel}.</h1>
	 * 
	 * <p>Recebe um id do cargo e um nome do cargo
	 * e constroi um {@link CargoModel} com os mesmos.</p>
	 * 
	 * @param idCargo Integer - Referente ao id do {@link CargoModel}
	 * @param nomeCargo String - Referente ao nome do {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 */
	public CargoModel(Integer idCargo, String nomeCargo) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}

	/**
	 * <h1>Construtor com paramêtros do {@link CargoModel}.</h1>
	 * 
	 * <p>Recebe todos os atributos necessários para
	 * contruir o {@link CargoModel}.</p>
	 * 
	 * @param nomeCargo String - Referente ao {@link CargoModel#nomeCargo} do {@link CargoModel}
	 * @param dataCadastro LocalDateTime - Referente a {@link CargoModel#dataCadastro} do {@link CargoModel}
	 * @param dataUltimaRevisao LocalDateTime - Referente a {@link CargoModel#dataUltimaRevisao} do {@link CargoModel}
	 * @param cbo2002 {@link CBO2002Model} - Referente ao {@link CargoModel#cbo2002} do {@link CargoModel}
	 * @param cbo94 {@link CBO1994Model} - Referente ao {@link CargoModel#cbo94} do {@link CargoModel}
	 * @param horaMes {@link HorasMesModel} - Referente as {@link CargoModel#horasMes} do {@link CargoModel}
	 * @param grauInstrucao {@link GrauInstrucaoModel} - Referente ao {@link CargoModel#grauInstrucao} do {@link CargoModel}
	 * @param experienciaMinima String - Referente a {@link CargoModel#experienciaMinima} do {@link CargoModel}
	 * @param atribuicoes String - Referente as {@link CargoModel#atribuicoes} do {@link CargoModel}
	 * @param status Boolean - Referente ao {@link CargoModel#status} do {@link CargoModel}
	 * @param idPermissao Integer - Referente a {@link CargoModel#idPermissao} do {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#nomeCargo
	 * @see CargoModel#dataCadastro
	 * @see CargoModel#dataUltimaRevisao
	 * @see CargoModel#cbo2002
	 * @see CargoModel#cbo94
	 * @see CargoModel#horasMes
	 * @see CargoModel#grauInstrucao
	 * @see CargoModel#experienciaMinima
	 * @see CargoModel#atribuicoes
	 * @see CargoModel#status
	 * @see CargoModel#idPermissao
	 */
	public CargoModel(String nomeCargo, LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao,
			CBO2002Model cbo2002, CBO1994Model cbo94, HorasMesModel horasMes, GrauInstrucaoModel grauInstrucao,
			String experienciaMinima, String atribuicoes, Boolean status, Integer idPermissao) {
		this.nomeCargo = nomeCargo;
		this.dataCadastro = dataCadastro;
		this.dataUltimaRevisao = dataUltimaRevisao;
		this.cbo2002 = cbo2002;
		this.cbo94 = cbo94;
		this.horasMes = horasMes;
		this.grauInstrucao = grauInstrucao;
		this.experienciaMinima = experienciaMinima;
		this.atribuicoes = atribuicoes;
		this.status = status;
		this.idPermissao = idPermissao;
	}
	
	public CargoModel(String nomeCargo, CBO2002Model cbo2002, CBO1994Model cbo94, HorasMesModel horasMes, GrauInstrucaoModel grauInstrucao,
			String experienciaMinima, String atribuicoes, Boolean status, Integer idPermissao) {
		this.nomeCargo = nomeCargo;
		this.cbo2002 = cbo2002;
		this.cbo94 = cbo94;
		this.horasMes = horasMes;
		this.grauInstrucao = grauInstrucao;
		this.experienciaMinima = experienciaMinima;
		this.atribuicoes = atribuicoes;
		this.status = status;
		this.idPermissao = idPermissao;
	}

	/**
	 * <h1>Pega o {@link CargoModel#idCargo}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#idCargo}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return Integer - Referente ao {@link CargoModel#idCargo} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#idCargo
	 */
	public Integer getIdCargo() {
		return this.idCargo;
	}

	/**
	 * <h1>Seta o {@link CargoModel#idCargo}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#idCargo}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param idCargo Integer - Referente ao {@link CargoModel#idCargo} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#idCargo
	 */
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	/**
	 * <h1>Pega o {@link CargoModel#nomeCargo}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#nomeCargo}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return String - Referente ao {@link CargoModel#nomeCargo} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#nomeCargo
	 */
	public String getNomeCargo() {
		return this.nomeCargo;
	}

	/**
	 * <h1>Seta o {@link CargoModel#nomeCargo}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#nomeCargo}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param nomeCargo String - Referente ao {@link CargoModel#nomeCargo} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#nomeCargo
	 */
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	/**
	 * <h1>Pega a {@link CargoModel#dataCadastro}.</h1>
	 * 
	 * <p>Pega a {@link CargoModel#dataCadastro}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return LocalDateTime - Referente a {@link CargoModel#dataCadastro} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#dataCadastro
	 */
	public LocalDateTime getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * <h1>Seta a {@link CargoModel#dataCadastro}.</h1>
	 * 
	 * <p>Seta um valor para a {@link CargoModel#dataCadastro}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param dataCadastro LocalDateTime - Referente a {@link CargoModel#dataCadastro} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#dataCadastro
	 */
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * <h1>Pega a {@link CargoModel#dataUltimaRevisao}.</h1>
	 * 
	 * <p>Pega a {@link CargoModel#dataUltimaRevisao}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return LocalDateTime - Referente a {@link CargoModel#dataUltimaRevisao} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#dataUltimaRevisao
	 */
	public LocalDateTime getDataUltimaRevisao() {
		return this.dataUltimaRevisao;
	}

	/**
	 * <h1>Seta a {@link CargoModel#dataCadastro}.</h1>
	 * 
	 * <p>Seta um valor para a {@link CargoModel#dataCadastro}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param dataCadastro LocalDateTime - Referente a {@link CargoModel#dataCadastro} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#dataCadastro
	 */
	public void setDataUltimaRevisao(LocalDateTime dataUltimaRevisao) {
		this.dataUltimaRevisao = dataUltimaRevisao;
	}

	/**
	 * <h1>Pega o {@link CargoModel#cbo2002}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#cbo2002}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return {@link CBO2002Model} - Referente a {@link CargoModel#cbo2002} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#cbo2002
	 * @see CBO2002Model
	 */
	public CBO2002Model getCbo2002() {
		return this.cbo2002;
	}

	/**
	 * <h1>Seta o {@link CargoModel#cbo2002}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#cbo2002}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param cbo2002 {@link CBO2002Model} - Referente a {@link CargoModel#cbo2002} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#cbo2002
	 * @see CBO2002Model
	 */
	public void setCbo2002(CBO2002Model cbo2002) {
		this.cbo2002 = cbo2002;
	}

	/**
	 * <h1>Pega o {@link CargoModel#cbo94}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#cbo94}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return {@link CBO1994Model} - Referente a {@link CargoModel#cbo94} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#cbo94
	 * @see CBO1994Model
	 */
	public CBO1994Model getCbo94() {
		return this.cbo94;
	}

	/**
	 * <h1>Seta o {@link CargoModel#cbo94}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#cbo94}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param cbo94 {@link CBO1994Model} - Referente a {@link CargoModel#cbo94} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#cbo94
	 * @see CBO1994Model
	 */
	public void setCbo94(CBO1994Model cbo94) {
		this.cbo94 = cbo94;
	}

	/**
	 * <h1>Pega o {@link CargoModel#horasMes}.</h1>
	 * 
	 * <p>Pega a {@link CargoModel#horasMes}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return {@link HorasMesModel} - Referente a {@link CargoModel#horasMes} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#horasMes
	 * @see HorasMesModel
	 */
	public HorasMesModel getHorasMes() {
		return this.horasMes;
	}

	/**
	 * <h1>Seta o {@link CargoModel#horasMes}.</h1>
	 * 
	 * <p>Seta um valor para a {@link CargoModel#horasMes}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param horaMes {@link HorasMesModel} - Referente a {@link CargoModel#horasMes} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#horasMes
	 * @see HorasMesModel
	 */
	public void setHorasMes(HorasMesModel horasMes) {
		this.horasMes = horasMes;
	}

	/**
	 * <h1>Pega o {@link CargoModel#grauInstrucao}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#grauInstrucao}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return {@link GrauInstrucaoModel} - Referente a {@link CargoModel#grauInstrucao} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#grauInstrucao
	 * @see GrauInstrucaoModel
	 */
	public GrauInstrucaoModel getGrauInstrucao() {
		return this.grauInstrucao;
	}

	/**
	 * <h1>Seta o {@link CargoModel#grauInstrucao}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#grauInstrucao}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param grauInstrucao {@link GrauInstrucaoModel} - Referente a {@link CargoModel#grauInstrucao} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#grauInstrucao
	 * @see GrauInstrucaoModel
	 */
	public void setGrauInstrucao(GrauInstrucaoModel grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	/**
	 * <h1>Pega a {@link CargoModel#experienciaMinima}.</h1>
	 * 
	 * <p>Pega a {@link CargoModel#experienciaMinima}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return String - Referente a {@link CargoModel#experienciaMinima} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#experienciaMinima
	 */
	public String getExperienciaMinima() {
		return this.experienciaMinima;
	}

	/**
	 * <h1>Seta a {@link CargoModel#experienciaMinima}.</h1>
	 * 
	 * <p>Seta um valor para a {@link CargoModel#experienciaMinima}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param experienciaMinima String - Referente a {@link CargoModel#experienciaMinima} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#experienciaMinima
	 */
	public void setExperienciaMinima(String experienciaMinima) {
		this.experienciaMinima = experienciaMinima;
	}

	/**
	 * <h1>Pega a {@link CargoModel#atribuicoes}.</h1>
	 * 
	 * <p>Pega a {@link CargoModel#atribuicoes}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return String - Referente a {@link CargoModel#atribuicoes} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#atribuicoes
	 */
	public String getAtribuicoes() {
		return this.atribuicoes;
	}

	/**
	 * <h1>Seta a {@link CargoModel#atribuicoes}.</h1>
	 * 
	 * <p>Seta um valor para a {@link CargoModel#atribuicoes}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param atribuicoes String - Referente a {@link CargoModel#atribuicoes} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#atribuicoes
	 */
	public void setAtribuicoes(String atribuicoes) {
		this.atribuicoes = atribuicoes;
	}

	/**
	 * <h1>Pega o {@link CargoModel#status}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#status}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return Boolean - Referente a {@link CargoModel#status} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#status
	 */
	public Boolean getStatus() {
		return this.status;
	}

	/**
	 * <h1>Seta o {@link CargoModel#status}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#status}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param status Boolean - Referente a {@link CargoModel#status} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * <h1>Pega o {@link CargoModel#idPermissao}.</h1>
	 * 
	 * <p>Pega o {@link CargoModel#idPermissao}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @return Integer - Referente a {@link CargoModel#idPermissao} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#idPermissao
	 */
	public Integer getIdPermissao() {
		return this.idPermissao;
	}

	/**
	 * <h1>Seta o {@link CargoModel#idPermissao}.</h1>
	 * 
	 * <p>Seta um valor para o {@link CargoModel#idPermissao}
	 * da classe {@link CargoModel}.</p>
	 * 
	 * @param idPermissao Integer - Referente a {@link CargoModel#idPermissao} da classe {@link CargoModel}
	 * 
	 * @author Sprint 6: Lucas Nunes <lucasnunes.ln365@gmail.com>
	 * 
	 * @see CargoModel
	 * @see CargoModel#idPermissao
	 */
	public void setIdPermissao(Integer idPermissao) {
		this.idPermissao = idPermissao;
	}

	@Override
	public String toString() {
		return "CargoModel [idCargo=" + idCargo + ", nomeCargo=" + nomeCargo + ", dataCadastro=" + dataCadastro
				+ ", dataUltimaRevisao=" + dataUltimaRevisao + ", cbo2002=" + cbo2002 + ", cbo94=" + cbo94
				+ ", horasMes=" + horasMes + ", grauInstrucao=" + grauInstrucao + ", experienciaMinima="
				+ experienciaMinima + ", atribuicoes=" + atribuicoes + ", status=" + status + ", idPermissao="
				+ idPermissao + "]";
	}
	
	
}
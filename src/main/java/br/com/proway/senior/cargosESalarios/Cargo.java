package br.com.proway.senior.cargosESalarios;

import java.time.LocalDateTime;

public class Cargo {

	private Integer idCargo;
	private String nomeCargo;
	private Integer idSetor;
	private String hierarquia;                 // Exemplo: Supervisão/Gerência
	private Double salario;
	private LocalDateTime dataCadastro;      // Editar o cadastro
	private LocalDateTime dataUltimaRevisao; 
	private String cbo2002;                // Vide http://www.mtecbo.gov.br/ CBO - Classificação Brasileira de Ocupações
	private String cbo94;                 // Verificar
	private Integer horaMes;
	private String grauDeInstrucao;     // Exemplo: Superior Completo
	private String experienciaMinima;  // Exemplo: 2 anos.
	private String atribuicoes;       // Exemplo: Programação em Java, Criação de Banco de Dados, etc...
	private String bonificacao;      // Exemplo: ???
	private Integer status;         // Status do Cargo Cadastrado - 1 Ativo 2 Bloqueado 3 Inativo.
	private int idPermissao; 


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
	 * @param bonificacao
	 * @param status
	 * @param idPermissao
	 */
	public Cargo(Integer idCargo, String nomeCargo, Integer idSetor, String hierarquia, Double salario,
			LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao, String cbo2002, String cbo94, Integer horaMes,
			String grauDeInstrucao, String experienciaMinima, String atribuicoes, String bonificacao, Integer status,
			int idPermissao) {
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
		this.bonificacao = bonificacao;
		this.status = status;
		this.idPermissao = idPermissao;
	}

	public Cargo(Integer idCargo, String nomeCargo) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}

	/**
	 * 
	 */
	public Cargo() {

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
	 * @return the bonificacao
	 */
	public String getBonificacao() {
		return bonificacao;
	}

	/**
	 * @param bonificacao the bonificacao to set
	 */
	public void setBonificacao(String bonificacao) {
		this.bonificacao = bonificacao;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
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

	
	@Override
	public String toString() {
		return "Cargo - idCargo =" + idCargo + ", nomeCargo =" + nomeCargo + ", idSetor =" + idSetor + ", hierarquia ="
				+ hierarquia + ", salario =" + salario + ", dataCadastro =" + dataCadastro + ", dataUltimaRevisao ="
				+ dataUltimaRevisao + ", cbo2002 =" + cbo2002 + ", cbo94 =" + cbo94 + ", horaMes =" + horaMes
				+ ", grauDeInstrucao =" + grauDeInstrucao + ", experienciaMinima =" + experienciaMinima + ", atribuicoes ="
				+ atribuicoes + ", bonificacao =" + bonificacao + ", status =" + status;
	}

}

package br.com.proway.senior.cargosESalarios.model;

/**
 * 
 * Classe PostoDeTrabalhoModel
 * 
 * Classe posto de trabalho, cria os atributos necessários para
 * um posto de trabalho, que posteriormente será vinculado a um
 * colaborador com os dados de cargo e setor necessários para
 * os demais módulos.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 *
 */

public class PostoDeTrabalhoModel {
	
	private Integer idPosto;
	private String nomePosto;
	private Integer idCargo;
	private Integer idSetor;
	private Integer idNivel;
	private Double salario;
	
	public PostoDeTrabalhoModel(Integer idPosto, String nomePosto, Integer idCargo, Integer idSetor, Integer idNivel,
			Double salario) {
		super();
		this.idPosto = idPosto;
		this.nomePosto = nomePosto;
		this.idCargo = idCargo;
		this.idSetor = idSetor;
		this.idNivel = idNivel;
		this.salario = salario;
	}

	/**
	 * Construtor secundário onde a Id não é obrigatória para criação do posto.
	 * A Id será auto incrementada no banco de dados.
	 * 
	 * @param nomePosto
	 * @param idCargo
	 * @param idSetor
	 * @param idNivel
	 * @param salario
	 */
	public PostoDeTrabalhoModel(String nomePosto, Integer idCargo, Integer idSetor, Integer idNivel, Double salario) {
		super();
		this.nomePosto = nomePosto;
		this.idCargo = idCargo;
		this.idSetor = idSetor;
		this.idNivel = idNivel;
		this.salario = salario;
	}

	public Integer getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(Integer idPosto) {
		this.idPosto = idPosto;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public Integer getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "PostoDeTrabalhoModel [idPosto=" + idPosto + ", nomePosto=" + nomePosto + ", idCargo=" + idCargo
				+ ", idSetor=" + idSetor + ", idNivel=" + idNivel + ", salario=" + salario + "]";
	}	

}

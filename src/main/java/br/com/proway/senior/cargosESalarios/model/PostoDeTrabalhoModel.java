package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Classe PostoDeTrabalhoModel
 * 
 * Classe posto de trabalho, cria os atributos necessarios para
 * um posto de trabalho, que posteriormente sera vinculado a um
 * colaborador com os dados de cargo e setor necessarios para
 * os demais modulos.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 *
 */

@Entity
@Table (name = "posto_de_trabalho")
public class PostoDeTrabalhoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPosto;
	private String nomePosto;
	
	@OneToOne(mappedBy = "idCargo")
	private Integer idCargo;
	
	@OneToOne(mappedBy = "idSetor")
	private Integer idSetor;
	
	@OneToOne(mappedBy = "idNivel")
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
	 * Construtor secundario onde a Id nao eh obrigatoria para criacao do posto.
	 * A Id sera auto incrementada no banco de dados.
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

	public PostoDeTrabalhoModel() {
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

package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private CargoModel cargo;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private SetorModel setor;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private NivelModel nivel;
	
	private Double salario;
	
	public PostoDeTrabalhoModel() {}
	
	public PostoDeTrabalhoModel(Integer idPosto, String nomePosto, CargoModel cargo, SetorModel setor, NivelModel nivel,
			Double salario) {
		super();
		this.idPosto = idPosto;
		this.nomePosto = nomePosto;
		this.cargo = cargo;
		this.setor = setor;
		this.nivel = nivel;
		this.salario = salario;
	}
	
	/**
	 * Construtor secundario onde a Id nao eh obrigatoria para criacao do posto.
	 * A Id sera auto incrementada no banco de dados.
	 * 
	 * @param nomePosto
	 * @param cargo
	 * @param setor
	 * @param nivel
	 * @param salario
	 */
	public PostoDeTrabalhoModel(String nomePosto, CargoModel cargo, SetorModel setor, NivelModel nivel,
			Double salario) {
		super();
		this.nomePosto = nomePosto;
		this.cargo = cargo;
		this.setor = setor;
		this.nivel = nivel;
		this.salario = salario;
	}

	/**
	 * @return the idPosto
	 */
	public Integer getIdPosto() {
		return idPosto;
	}


	/**
	 * @param idPosto the idPosto to set
	 */
	public void setIdPosto(Integer idPosto) {
		this.idPosto = idPosto;
	}


	/**
	 * @return the nomePosto
	 */
	public String getNomePosto() {
		return nomePosto;
	}


	/**
	 * @param nomePosto the nomePosto to set
	 */
	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}


	/**
	 * @return the cargo
	 */
	public CargoModel getCargo() {
		return cargo;
	}


	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(CargoModel cargo) {
		this.cargo = cargo;
	}


	/**
	 * @return the setor
	 */
	public SetorModel getSetor() {
		return setor;
	}


	/**
	 * @param setor the setor to set
	 */
	public void setSetor(SetorModel setor) {
		this.setor = setor;
	}


	/**
	 * @return the nivel
	 */
	public NivelModel getNivel() {
		return nivel;
	}


	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(NivelModel nivel) {
		this.nivel = nivel;
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


	@Override
	public String toString() {
		return "PostoDeTrabalhoModel [idPosto=" + idPosto + ", nomePosto=" + nomePosto + ", cargo=" + cargo
				+ ", setor=" + setor + ", nivel=" + nivel + ", salario=" + salario + "]";
	}	

}

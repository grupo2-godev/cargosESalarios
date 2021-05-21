package br.com.proway.senior.cargosESalarios.model.DTO;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

public class PostoDeTrabalhoModelDTO {
	
	private String nomePosto;
	private CargoModel cargo;
	private SetorModel setor;
	private NivelModel nivel;
	private Double salario;
	
	/**
	 * Construtor PostoDeTrabalhoDTO
	 * 
	 * Construtor que pega as informações do {@link PostoDeTrabalhoModel} e aplica ao DTO para exibir
	 * as informações para o usuário.
	 * 
	 * @param postoDeTrabalhoModel
	 * @author Bruno Marques
	 * @author Vanderlei Kleinschmidt
	 */
	public PostoDeTrabalhoModelDTO(PostoDeTrabalhoModel postoDeTrabalhoModel) {
		this.nomePosto = postoDeTrabalhoModel.getNomePosto();
		this.cargo = postoDeTrabalhoModel.getCargo();
		this.setor = postoDeTrabalhoModel.getSetor();
		this.nivel = postoDeTrabalhoModel.getNivel();
		this.salario = postoDeTrabalhoModel.getSalario();
	}


	public String getNomePosto() {
		return nomePosto;
	}


	public CargoModel getCargo() {
		return cargo;
	}


	public SetorModel getSetor() {
		return setor;
	}


	public NivelModel getNivel() {
		return nivel;
	}


	public Double getSalario() {
		return salario;
	}
	
	
	

}

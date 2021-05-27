package br.com.proway.senior.cargosESalarios.model.DTO;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;

/**
 * Classe PostoDeTrabalhoModelDTO
 * 
 * Classe DTO que transfere os dados do posto de trabalho para exibir informações ao usuáro.
 * 
 * @author Bruno Marques
 * @author Vanderlei Kleinschmidt
 *
 */
public class PostoDeTrabalhoModelDTO {
	
	private String nomePosto;
	private CargoModelDTO cargoDTO;
	private SetorModel setor;
	private NivelModel nivel;
	private Double salario;
	
	/**
	 * Construtor PostoDeTrabalhoDTO
	 * 
	 * Construtor que pega as informações do {@link PostoDeTrabalhoModel} e aplica ao DTO para
	 * exibir as informações para o usuário.
	 * 
	 * @param postoDeTrabalhoModel
	 * 
	 */
	public PostoDeTrabalhoModelDTO(PostoDeTrabalhoModel postoDeTrabalhoModel) {
		this.nomePosto = postoDeTrabalhoModel.getNomePosto();
		this.cargoDTO = new CargoModelDTO(postoDeTrabalhoModel.getCargo());
		this.setor = postoDeTrabalhoModel.getSetor();
		this.nivel = postoDeTrabalhoModel.getNivel();
		this.salario = postoDeTrabalhoModel.getSalario();
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public CargoModelDTO getCargo() {
		return cargoDTO;
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

	public CargoModelDTO getCargoDTO() {
		return cargoDTO;
	}

}

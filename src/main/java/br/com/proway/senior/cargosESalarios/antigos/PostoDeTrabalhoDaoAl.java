package br.com.proway.senior.cargosESalarios.antigos;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CRUDInterface;
import br.com.proway.senior.cargosESalarios.model.Dados;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;

/**
 * Classe PostoDeTrabalhoDao
 * 
 * Classe DAO que implementa a interface CRUDInterface para
 * interação com o banco de dados.
 * 
 * @author Sarah Brito, sarah.brito@senior.com.br
 *
 */

public class PostoDeTrabalhoDaoAl implements CRUDInterface<PostoDeTrabalhoModel> {

	
	/***
	 * Inserir Posto de Trabalho.
	 * 
	 * Recebe um objeto cargo para inserir na lista.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return novoPostoId
	 */
	public Integer create(PostoDeTrabalhoModel postoModel) {
		int size = Dados.getInstance().getListaPostos().size();
		int novoPostoId;
		if (size > 0) {
			novoPostoId =  Dados.getInstance().getListaPostos().get(size-1).getIdPosto();
		}
		else {
			novoPostoId = 0;
		}
		postoModel.setIdPosto(novoPostoId);
		Dados.getInstance().getListaPostos().add(postoModel);
		return novoPostoId;
	}

	
	/**
	 * Ler Posto de Trabalho por ID
	 * 
	 * Procura posto de trabalho pelo id e retorna nulo caso não encontrado.
	 * 
	 * @param int idPosto
	 * @return null ou PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(int idPosto) {
		for (PostoDeTrabalhoModel postoProcurado : Dados.getInstance().getListaPostos()) {
			if (postoProcurado.getIdPosto() == idPosto)
				return postoProcurado;
		}
		return null;
	}

	/**
	 * Ler Posto de Trabalho por nome
	 * 
	 * Procura posto de trabalho pelo id e retorna nulo caso não encontrado.
	 * 
	 * @param nomePosto
	 * @return null ou PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel retrieve(String nomePosto) {
		for (PostoDeTrabalhoModel postoProcurado : Dados.getInstance().getListaPostos()) {
			if (postoProcurado.getNomePosto() == nomePosto)
				return postoProcurado;
		}
		return null;
	}
	
	
	/***
	 * Atualizar Posto de Trabalho.
	 * 
	 * Recebe um objeto Posto de Trabalho, procura na lista de postos existentes baseados
	 * no ID do posto informado. Ao encontrar, atribui um novo objeto posto (sobrepondo os 
	 * os dados anteriores), realizando a atualização dos dados.
	 * 
	 * @param PostoDeTrabalhoModel postoModel
	 * @return boolean
	 *
	 */
	public boolean update(PostoDeTrabalhoModel postoModel) {
		ArrayList<PostoDeTrabalhoModel> listaPostos = Dados.getInstance().getListaPostos();
		for (PostoDeTrabalhoModel postoProcurado : listaPostos) {
			if (postoProcurado.getIdCargo() == postoModel.getIdPosto()) {
				int idDoProcurado = listaPostos.indexOf(postoProcurado);
				listaPostos.set(idDoProcurado, postoModel);
				return true;
			}
		}
		return false;
	}

	/***
	 * Deletar Posto de Trabalho
	 *
	 * Remove o posto conforme Id informado.
	 * 
	 * @param int idPosto
	 * @return boolean
	 */
	public boolean delete(int idPosto) {
		for (PostoDeTrabalhoModel postoProcurado : Dados.getInstance().getListaPostos()) {
			if (this.retrieve(idPosto).getIdPosto() == idPosto) {
				Dados.getInstance().getListaPostos().remove(postoProcurado);
				return true;
			}
		}
		return false;
	}

	/***
	 * 
	 * Lista todos os postos de trabalho registrados.
	 * 
	 * @param ArrayList
	 * @return ArrayList<PostoDeTrabalhoModel>
	 */

	public ArrayList<PostoDeTrabalhoModel> getAll() {
		return Dados.getInstance().getListaPostos();
	}
	
	/**
	 * Limpar ArrayList de Postos de Trabalhp
	 * 
	 * Método realiza a limpeza do ArrayList de postos
	 * na classe Dados.	Utilizado para os testes unitários. 
	 *
	 * @return void
	 */
	public void limparArray() {
		Dados.getInstance().getListaPostos().clear();
	}

}

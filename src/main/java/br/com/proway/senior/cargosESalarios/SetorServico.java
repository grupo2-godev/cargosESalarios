package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public class SetorServico implements ISetorServico {

	/**
	 * Cadastrar setores. Recebe String com o nome do setor, int com a id do setor e
	 * um ArrayList à ser populado com um objeto da classe Setor. Instancia obejto
	 * setor com os parametros String e int. Popula a lista com o objeto.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade,
			int idPermissao) {
		Setor setor = new Setor(id, nomeSetor, capacidade, idPermissao);
		listaSetores.add(setor);
	}

	/**
	 * Altera o setor.
	 * 
	 * Procura na lista o obejto com id selecionado e atribui os parametros.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @param capacidade
	 * @Return void
	 */
	public void alterarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade, int idPermissao) {
		Setor setor = new Setor();

		for (Setor setorSelecionado : listaSetores) {
			if (setorSelecionado.getId() == id) {

				setor.setNomeSetor(nomeSetor);
				setor.setCapacidade(capacidade);
				setor.setIdPermissao(idPermissao);
				break;
			}
		}
	}

	/**
	 * Busca um setor específicoe em uma lista de setores; Recebe a Id do setor e
	 * retorna um objeto Setor; Se o Id nao for encontrado, retorna null;
	 * 
	 * @param listaSetores
	 * @param idSetor
	 * @param setor
	 * @return setor
	 */
	public Setor consultarSetor(ArrayList<Setor> listaSetores, int idSetor) {
		Setor setor = new Setor();

		for (Setor itemConsulta : listaSetores) {
			if (itemConsulta.getId() == idSetor) {
				setor.setNomeSetor(itemConsulta.getNomeSetor());
				setor.setCapacidade(itemConsulta.getCapacidade());
				setor.setId(itemConsulta.getId());
				setor.setIdPermissao(itemConsulta.getIdPermissao());

				return setor;
			}
		}
		return null;
	}

	/**
	 * Cosulta todos os setores cadastrados. Recebe um ArrayList de objeto Setor.
	 * 
	 * 
	 * @param listaSetores
	 * @return listaSetores
	 */

	public ArrayList<Setor> consultarTodosOsSetores(ArrayList<Setor> listaSetores) {
		return listaSetores;
	}

	/**
	 * Deleta setor cadastrado. Busca setor no ArrayList pela id;
	 * 
	 * 
	 * @param listaSetores
	 * @param id
	 * @return void
	 */
	public void deletarSetor(ArrayList<Setor> listaSetores, int id) {
		for (Setor setorSelecionado : listaSetores) {
			if (setorSelecionado.getId() == id) {
				listaSetores.remove(setorSelecionado);
				break;
			}
		}
	}
}

package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public class SetorServico implements ISetorServico{
	/**
	 * Cadastrar setores.
	 * Recebe o nome do setor (String), id do setor (int) e a ArrayList à ser populado 
	   com um objeto da classe Setor.
	 * Popula a lista com o objeto.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade, int idPermissao) {
		Setor setor = new Setor(id, nomeSetor, capacidade, idPermissao);
		listaSetores.add(setor);
	}
	/**
	 * Recebe ArrayList e objeto da classe Setor.
	 * Popula a lista com objeto.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarSetor(ArrayList<Setor> listaSetores, Setor setor) {
		listaSetores.add(setor);
	}
	
	/**
	 * Altera o setor.
	 * Procura na lista o obejto com id selecionado e atribui novos parametros.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @param capacidade
	 * @Return void
	 */
	public void alterarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade, int idPermissao) {
		
		for(Setor setorSelecionado : listaSetores) {
			if ((int) setorSelecionado.getId() == (int) id) {
				
				if (!(nomeSetor == setorSelecionado.getNomeSetor())) {
				setorSelecionado.setNomeSetor(nomeSetor);
				}
				
				if (!((int) capacidade == setorSelecionado.getCapacidade())) {
				setorSelecionado.setCapacidade(capacidade);	
				}
				
				if (!((int) idPermissao == setorSelecionado.getIdPermissao())) {
				setorSelecionado.setIdPermissao(idPermissao);
				}
				break;
			}
		}	
	}
	
	/**
	 * Busca um setor específico em uma lista de setores.
	 * Recebe Id do setor e retorna um objeto Setor.
	 * Se o Id nao for encontrado, retorna null.
	 * 
	 * @param ArrayList<Setor>
	 * @param int
	 * @return Setor
	 */
	public Setor consultarSetor(ArrayList<Setor> listaSetores, int idSetor) {
		Setor setor = new Setor();
		
		for(Setor itemConsulta : listaSetores) {
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
	 * Cosulta todos os setores cadastrados.
	 * Recebe um ArrayList de objeto Setor.
	 * 
	 * 
	 * @param ArrayList<Setor>.
	 * @return ArrayList.
	 */
	
	public ArrayList<Setor> consultarTodosOsSetores(ArrayList<Setor> listaSetores) {
		return listaSetores;
	}
	/**
	 * Deleta setor cadastrado.
	 * Busca setor no ArrayList pela id.                                                                                                    
	 * 
	 * 
	 * @param ArrayList<Setor>.
	 * @param int.
	 * @return void
	 */
	public void deletarSetor(ArrayList<Setor> listaSetores, int id) {
		for(Setor setorSelecionado : listaSetores) {
			if (setorSelecionado.getId() == id) {	
			listaSetores.remove(setorSelecionado);
				break;
			}
		}	
	}
}
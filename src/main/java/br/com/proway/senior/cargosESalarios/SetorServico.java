package br.com.proway.senior.cargosESalarios;

import java.util.ArrayList;

public class SetorServico {
	
	/**
	 * Cadastrar setores.
	 * Recebe: String - int - ArrayList.
	 * Instancia obejto setor com os parametros String e int. 
	 * Popula a lista com o objeto.
	 * 
	 * @param listaSetores
	 * @param nomeSetor
	 * @param id
	 * @return void
	 */
	public void cadastrarSetor(ArrayList<Setor> listaSetores, String nomeSetor, int id, int capacidade, int idPermissao) {
		Setor setor = new Setor();
		
		setor.setId(id);
		setor.setNomeSetor(nomeSetor);
		setor.setCapacidade(capacidade);
		setor.setIdPermissao(idPermissao);
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
		
		for(Setor setorSelecionado : listaSetores) {
			if (setorSelecionado.getId() == id) {
				
				setor.setNomeSetor(nomeSetor);
				setor.setCapacidade(capacidade);
				setor.setIdPermissao(idPermissao);
				break;
			}
		}	
	}
	/**
	 * Busca um setor específicoe em uma lista de setores;
	 * Recebe a Id do setor e retorna um objeto Setor;
	 * Se o Id nao for encontrado, retorna null;
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
}

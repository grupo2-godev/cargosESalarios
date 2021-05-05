package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

/**
 * @author Samuel Levi <samuel.levi@senior.com.br>
 * @version Sprint 4:
 *  - Implementa os métodos de CRUD da interface genérica.
 */
public class Cbo2002DAO implements CRUDInterface<Cbo2002Model>{
	
	/**
	 * Criar um novo objeto do tipo CBO padrão 2002.
	 * 
	 * Verifica o tamanho da lista antes de criar o objeto, para atribuir o valor do Id.
	 */
	public Integer create(Cbo2002Model obj) {
		int size = Dados.getInstance().getListaCbo2002().size();
		int novoCbo2002Id;
		if (size > 0) {
			novoCbo2002Id =  Dados.getInstance().getListaCbo2002().get(size-1).getCodigoId();
		}
		else {
			novoCbo2002Id = 0;
		}
		obj.setCodigoId(novoCbo2002Id);
		Dados.getInstance().getListaCbo2002().add(obj);
		return novoCbo2002Id;
	}
	
	/**
	 * Busca um CBO pelo Id
	 * 
	 * Procura se pelo id e retorna nulo caso não encontrado
	 * 
	 * @param id Do CBO
	 * @return null/CBO
	 */
	public Cbo2002Model retrieve(int id) {
		for (Cbo2002Model cbo2002Procurado : Dados.getInstance().getListaCbo2002()) {
			if (cbo2002Procurado.getCodigoId() == id)
				return cbo2002Procurado;
		}
		return null;
	}

	/***
	 * Atualizar CBO padrão 2002.
	 * 
	 * Recebe um objetoC CBO2002, procura dentro da lista de CBO2002 existentes baseados
	 * no ID do CBO2002 informado ao encontrar atribui um objeto CBO2002 no objeto com
	 * ID encontrato.
	 * 
	 * @param Cbo2002Model obj, objeto recebido.
	 * 
	 * @author Samuel
	 */
	public boolean update(Cbo2002Model obj) {
		ArrayList<Cbo2002Model> lista = Dados.getInstance().getListaCbo2002();
		for (Cbo2002Model cbo2002Procurado : lista) {
			if (cbo2002Procurado.getCodigoId() == obj.getCodigoId()) {
				int idDoProcurado = lista.indexOf(cbo2002Procurado);
				lista.set(idDoProcurado, obj);
				return true;
			}
		}
		return false;
	}

	/***
	 * Deleta um objeto CBO2002
	 *
	 * Remove o objeto com o id selecionado.
	 * 
	 * @author Samuel
	 * @param id Integer
	 * @return
	 */
	public boolean delete(int id) {
		for (Cbo2002Model cbo2002Procurado : Dados.getInstance().getListaCbo2002()) {
			if (this.retrieve(id).getCodigoId() == id) {
				Dados.getInstance().getListaCargos().remove(cbo2002Procurado);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Deleta um CBO2002
	 * 
	 * Deleta um objeto do ArrayList que é igual ao objeto passado como
	 * parametro
	 * 
	 * @param obj Objeto do tipo CBO 2002 a ser excluido
	 * @return boolean
	 */
	public boolean delete(Cbo2002Model obj) {
		Dados.getInstance().getListaCbo2002().remove(obj);
		return true;
	}

	public ArrayList<Cbo2002Model> getAll() {
		return Dados.getInstance().getListaCbo2002();
	}
	
	public void limparArray() {
		Dados.getInstance().getListaCbo2002().clear();
	}

}

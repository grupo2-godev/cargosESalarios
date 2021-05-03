package br.com.proway.senior.cargosESalarios.model;

import java.util.ArrayList;

public class GrauInstrucaoDao {

	ArrayList<GrauInstrucaoModel> db = Dados.getInstance().getListaGrauInstrucao();
	
	/**
	 * Cadastra um novo grau de instrucao
	 * 
	 * Cria o novo id para o grau de instrucao e adiciona ele
	 * como um novo grau de instrucao no banco
	 * 
	 * @param newGI
	 * @return id do grau de instrucao ou null caso nao de para criar
	 */
	public Integer create(GrauInstrucaoModel newGI) {
		int size = db.size();
		int novoGIId;
		for (GrauInstrucaoModel gi : db) {
			if (gi.getInstrucao() == newGI.getInstrucao()) {
				return null;
			}
		}
		if (size > 0) {
			novoGIId =  db.get(size-1).getIdInstrucao() + 1;
		}
		else {
			novoGIId = 0;
		}
		newGI.setIdInstrucao(novoGIId);
		db.add(newGI);
		return novoGIId; 
	};
	
	/**
	 * busca o Grau de Instrucao pelo id
	 * 
	 * Verifica todos os graus de instrucoes e se o id dele for
	 * igual ao passado como parametro, retorna o objeto
	 * 
	 * @param id Do Grau de instrucao
	 */
	public GrauInstrucaoModel retrieve(Integer id) {
		for(GrauInstrucaoModel gi : db) {
			if(gi.getIdInstrucao().equals(id)) {
				return gi;
			}
		}
		return null;
	}
	
	/**
	 * busca o Grau de Instrucao pelo nome
	 * 
	 * Verifica todos os graus de instrucoes e se o nome dele for
	 * igual ao passado como parametro, retorna o objeto
	 * 
	 * @param nome Do Grau de instrucao
	 */
	public GrauInstrucaoModel retrieve(String nome) {
		for(GrauInstrucaoModel gi : db) {
			if(gi.getInstrucao() == nome) {
				return gi;
			}
		}
		return null;
	}
	
	/***
	 * Atualizar GrauInstrucao.
	 * 
	 * Recebe um objeto GrauInstrucao, procura dentro da lista de niveis existentes baseados
	 * no ID do id informado ao encontrar atribui um objeto GrauInstrucao no objeto com
	 * ID encontrato.
	 * 
	 * @param GrauInstrucao
	 * @return boolean
	 */
	public boolean update(GrauInstrucaoModel gi) {
		for (GrauInstrucaoModel giProcurado : db) {
			if (giProcurado.getIdInstrucao() == gi.getIdInstrucao()) {
				giProcurado.setInstrucao(gi.getInstrucao());;
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(int id) {
		for(GrauInstrucaoModel gi : db) {
			if(gi.getIdInstrucao() == id) {
				db.remove(gi);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Busca todos os graus de instrucao
	 * 
	 * @return lista com todos os graus de instrucao
	 */
	public ArrayList<GrauInstrucaoModel> getAll() {
		return db;
	}
	
	/**
	 * Limpar ArrayList de Graus de instrucao
	 * 
	 * Método realiza a limpeza do ArrayList de garuInstrucao
	 * na classe Dados.	Utilizado para os testes unitários. 
	 *
	 * @return void
	 */
	public void limparArray() {
		db.clear();
	}
	
}

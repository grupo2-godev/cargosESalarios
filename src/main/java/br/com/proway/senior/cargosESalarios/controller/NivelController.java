package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.DAO.NivelDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/** Controller que interage com o NivelDAO.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5*
 */
public class NivelController {

	NivelDAO nivelDAO = NivelDAO.getInstancia();
	
	/**
	 * Cria um novo objeto NivelModel e o passa para o DAO para que seja inserido no BD.
	 * Faz a validacao dos campos do Objeto, caso invalidos retorna uma excessao.
	 * 
	 * @param nome : String
	 * @return Integer : id do objeto correspondente no BD
	 * @throws Exception
	 */
	public Integer cadastrarNivel(String nome) throws Exception {
		if(!Validadores.apenasCaracteresValidos(nome)) {
			throw(new Exception("Nome invalido para o Nivel"));
		}
		NivelModel nivelModel = new NivelModel(nome);
		return nivelDAO.criar(nivelModel);
	} 
	
	/**
	 * Retorna um objeto NivelModel do BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id ou primary key da entrada no BD
	 * @return NivelModel : objeto retornado
	 * @throws Exception
	 */
	public NivelModel buscarNivel(int id) throws Exception {
		if(nivelDAO.buscar(NivelModel.class, id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return nivelDAO.buscar(NivelModel.class, id);
	}
	
	/**
	 * Atualiza os atributos de um objeto NivelModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * Se os novos atributos sao iguais os antigos, a funcao retorna false.
	 * 
	 * @param int : id ou primary key do objeto original no BD
	 * @param NivelModel : objetoAlterado - Objeto com os atributos a serem substituidos no BD
	 * @return boolean : true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizar(int id, String novoNomeNivel) throws Exception {
		if(!Validadores.apenasCaracteresValidos(novoNomeNivel)) {
			throw new Exception ("Novo nome informado é inválido");
		}
		
		NivelModel objetoParaAtualizar = nivelDAO.buscar(NivelModel.class, id);
				
		if(Validadores.ehObjetoNulo(objetoParaAtualizar)) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		
		if(objetoParaAtualizar.getNome() == novoNomeNivel) {
			return false;
		}
		return nivelDAO.atualizar(objetoParaAtualizar);
	}
	
	/**
	 * Deleta um objeto NivelModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id ou primary key da entrada no BD
	 * @return boolean : true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarNivel(int id) throws Exception {
		if(nivelDAO.buscar(NivelModel.class, id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return nivelDAO.deletar(NivelModel.class, id);
	}
	
	/**
	 * Retorna todas as entradas de NivelModels no BD em uma ArrayList;
	 * 
	 * @return ArrayList<NivelModel> : lista de entradas
	 */
	public ArrayList<NivelModel> buscarTodosNiveis(){
		return (ArrayList<NivelModel>) nivelDAO.listarPorTabela(NivelModel.class);
	}
	
	/**
	 * Deleta todas as entradas de NivelModels no BD;
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosNiveis() {
		return nivelDAO.deletarTodos("nivelmodel");
	}
	
	
}

package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CBO1994DAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/** Controller que interage com o CBO1994DAO.
 * 
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 */
public class CBO1994Controller {
	
	CBO1994DAO CBO1994Dao = CBO1994DAO.getInstancia();
	
	/**
	 * Cria um novo objeto CBO1994Model e o passa para o DAO para que seja inserido no BD.
	 * Faz a validacao dos campos do Objeto, caso invalidos retorna uma excessao.
	 * 
	 * @param Integer codigo_cbo
	 * @param String descricao			
	 * @param Double percentualInsalubridade
	 * @param Double percentualPericulosidade
	 * @return int codigo_CBO
	 * @throws Exception
	 */
	public Integer cadastrarCBO1994(Integer codigo_CBO1994, String descricao, Insalubridade percentualInsalubridade,
			Periculosidade percentualPericulosidade) throws Exception {
		
		if(!Validadores.ehValidoCBO1994(codigo_CBO1994) || !Validadores.ehValidoCBODescricao(descricao)) {
			throw(new Exception("Codigo e/ou descricao invalidos para o CBO1994"));
		}
		
		if(!(CBO1994Dao.buscar(CBO1994Model.class, codigo_CBO1994) == null)) {
			throw(new Exception("CBO1994 já existe no banco de dados"));
		}
		
		CBO1994Model CBO1994Model = new CBO1994Model(codigo_CBO1994, descricao, percentualInsalubridade.getValor(), 
				percentualPericulosidade.getValor());
		return CBO1994Dao.criar(CBO1994Model);
	} 
	
	/**
	 * Retorna um objeto CBO1994Model do BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int codigo_CBO1994 ou primary key da entrada no BD
	 * @return CBO1994Model objeto retornado
	 * @throws Exception
	 */
	public CBO1994Model buscarCBO1994(int codigo_CBO1994) throws Exception {
		
		if(CBO1994Dao.buscar(CBO1994Model.class, codigo_CBO1994) == null) {
			throw(new Exception("Entrada com o codigo_CBO1994 requisitado nao existe!"));
		}
		return CBO1994Dao.buscar(CBO1994Model.class, codigo_CBO1994);
	}
	
	/**
	 * Atualiza os atributos de um objeto CBO1994Model no BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * Se os novos atributos sao iguais os antigos, a funcao retorna false.
	 * 
	 * @param int codigo_CBO1994 ou primary key do objeto original no BD
	 * @param CBO1994Model : objetoAlterado - Objeto com os atributos a serem substituidos no BD
	 * @return boolean : true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizarCBO1994(Integer codigo_CBO1994, String novaDescricao, Insalubridade novoPercentualInsalubridade,
			Periculosidade novoPercentualPericulosidade) throws Exception {

		if(!Validadores.ehValidoCBODescricao(novaDescricao)) {
			throw(new Exception("Descricao invalida para atualizacao do CBO1994"));
		}
		
		CBO1994Model objetoParaAtualizar = CBO1994Dao.buscar(CBO1994Model.class, codigo_CBO1994);
		
		if(Validadores.ehObjetoNulo(objetoParaAtualizar)) {
			throw(new Exception("Entrada com o codigo CBO1994 requisitado nao existe!"));
		}
		
		if(objetoParaAtualizar.getDescricao() == novaDescricao &&
		   (double) objetoParaAtualizar.getPercentualInsalubridade() == (double) novoPercentualInsalubridade.getValor() &&
		   (double) objetoParaAtualizar.getPercentualPericulosidade() == (double) novoPercentualPericulosidade.getValor()) {
			return false;
		}
		
		objetoParaAtualizar.setCodigo_cbo(codigo_CBO1994);
		objetoParaAtualizar.setDescricao(novaDescricao);
		objetoParaAtualizar.setPercentualInsalubridade(novoPercentualInsalubridade.getValor());
		objetoParaAtualizar.setPercentualPericulosidade(novoPercentualPericulosidade.getValor());
				
		return CBO1994Dao.atualizar(codigo_CBO1994, objetoParaAtualizar);
	}
	
	/**
	 * Deleta um objeto CBO1994Model no BD.
	 * 
	 * Verifica a existencia da entrada com o codigo_CBO1994 providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int codigo_CBO1994 ou primary key da entrada no BD
	 * @return boolean : true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarCBO1994(int codigo_CBO1994) throws Exception {
		if(Validadores.ehObjetoNulo(CBO1994Dao.buscar(CBO1994Model.class, codigo_CBO1994))) {
			throw(new Exception("Entrada com o codigo_CBO1994 requisitado nao existe!"));
		}
		
		return CBO1994Dao.deletar(CBO1994Model.class, codigo_CBO1994);
	}
	
	/**
	 * Retorna todas as entradas de CBO1994Models no BD em uma ArrayList;
	 * 
	 * @return ArrayList<CBO1994Model> : lista de entradas
	 */
	public ArrayList<CBO1994Model> buscarTodosCBO1994(){
		return (ArrayList<CBO1994Model>) CBO1994Dao.listarPorTabela(CBO1994Model.class);
		
	}
	
	/**
	 * Deleta todas as entradas de CBO1994Models no BD;
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosCBO1994() {
		return CBO1994Dao.deletarTodos("cbo1994");
	}	
}

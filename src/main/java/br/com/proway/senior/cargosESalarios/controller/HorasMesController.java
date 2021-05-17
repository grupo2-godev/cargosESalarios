package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.HorasMesDAO;
import utils.Validators;

/** Controller que interage com o HorasMesDAO.
 * 
* @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5* 
 */
public class HorasMesController {

	HorasMesDAO horasMesDAO = HorasMesDAO.getInstancia(ConexaoHibernate.getSessao());
	
	/**
	 * Cria um novo objeto HorasMesModel e o passa para o DAO para que seja inserido no BD.
	 * () Faz a validacao dos campos do Objeto, caso invalidos retorna uma excessao.
	 * 
	 * @param quantidade : String
	 * @return Integer : id do objeto correspondente no BD
	 * @throws Exception
	 */
	public Integer cadastrarHorasMes(String quantidade) throws Exception {
		quantidade = quantidade.replaceAll( "," , "." );
		if(!Validators.onlyValidNumber(quantidade)) {
			throw(new Exception("Informação passada incorreta"));
		}
		
		Double quantidadeDouble = Double.parseDouble(quantidade);
		HorasMesModel horaMesModel = new HorasMesModel(quantidadeDouble);
		return horasMesDAO.criar(horaMesModel);
	} 
	
	public Integer cadastrarHorasMes(Double quantidade) {			
		HorasMesModel horaMesModel = new HorasMesModel(quantidade);
		return horasMesDAO.criar(horaMesModel);
	} 
	
	/**
	 * Retorna um objeto HoraMesModel do BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id primary key da entrada no BD
	 * @return HoraMesModel : objeto retornado
	 * @throws Exception
	 */
	public HorasMesModel buscarHorasMes(int id) throws Exception {
		if(horasMesDAO.buscar(id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return horasMesDAO.buscar(id);
	}
	
	/**
	 * Atualiza o atributo 'quantidade' de um objeto HoraMesModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * Se o novo atributo é igual ao antigo, a funcao retorna false.
	 * 
	 * @param int : id primary key do objeto original no BD
	 * @param HorasModel : objetoAlterado - Objeto com o atributo a ser substituido no BD
	 * @return boolean : true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizarHorasMes(int id, HorasMesModel objetoAlterado) throws Exception {
		HorasMesModel original = horasMesDAO.buscar(id);
		if(original == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		/**
		 * A funcao Double.compare recebe como argumentos dois Doubles e os compara.
		 * O retorno da funcao é um numero inteiro que pode ser positivo, negativo ou nulo.
		 * Se o retorno for nulo (zero), significa que os doubles sao Iguais
		 * Se o retorno for maior do que zero, significa que o primeiro Double é maior que o segundo
		 * Se o retorno for menor que zero, significa que o primeiro Double é menor que o segundo
		 */
		int compareDouble = Double.compare(original.getQuantidade(),objetoAlterado.getQuantidade()); 
		if(compareDouble == 0) {
			return false;
		}
		return horasMesDAO.atualizar(id, objetoAlterado);
	}
	
	/**
	 * Deleta um objeto HorasMesModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado,
	 * caso nao exista, retorna uma excessao.
	 * 
	 * @param int : id primary key da entrada no BD
	 * @return boolean : true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarHorasMes(int id) throws Exception {
		if(horasMesDAO.buscar(id) == null) {
			throw(new Exception("Entrada com o id requisitado nao existe!"));
		}
		return horasMesDAO.deletar(id);
	}
	
	/**
	 * Retorna todas as entradas de HorasMesModels no BD em uma ArrayList;
	 * 
	 * @return ArrayList<HorasMesModel> : lista de entradas
	 */
	public ArrayList<HorasMesModel> buscarTodosHorasMes(){
		return horasMesDAO.buscarTodos();
	}
	
	/**
	 * Deleta todas as entradas de HorasMesModels no BD;
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosHorasMes() {
		return horasMesDAO.deletarTodos();
	}
	
	
}
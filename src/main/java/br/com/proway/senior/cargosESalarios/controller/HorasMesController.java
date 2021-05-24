package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DAO.HorasMesDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Controller que interage com o HorasMesDAO.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 */
public class HorasMesController {

	HorasMesDAO horasMesDAO = HorasMesDAO.getInstancia();

	/**
	 * Cria um novo objeto HorasMesModel e o passa para o DAO para que seja inserido
	 * no BD. Faz a validacao dos campos do Objeto, caso invalidos lança uma
	 * excessao.
	 * 
	 * @param quantidade String
	 * @return Integer id do objeto correspondente no BD
	 * @throws Exception
	 */
	public Integer cadastrarHorasMes(String quantidade) throws Exception {
		quantidade = quantidade.replaceAll(",", ".");
		if (!Validadores.apenasNumerosValidos(quantidade)) {
			throw (new Exception("Informação passada incorreta"));
		}

		Double quantidadeDouble = Double.parseDouble(quantidade);
		HorasMesModel horaMesModel = new HorasMesModel(quantidadeDouble);
		return this.horasMesDAO.criar(horaMesModel);
	}

	/**
	 * Cria um novo objeto HorasMesModel e o passa para o DAO para que seja inserido
	 * no BD. Faz a validacao dos campos do Objeto, caso invalidos lança uma
	 * excessao.
	 * 
	 * @param quantidade Double
	 * @return Integer id do objeto correspondente no BD
	 * @throws Exception
	 */
	public Integer cadastrarHorasMes(Double quantidade) {
		HorasMesModel horaMesModel = new HorasMesModel(quantidade);
		return this.horasMesDAO.criar(horaMesModel);
	}

	/**
	 * Retorna um objeto HoraMesModel do BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado, caso nao exista,
	 * retorna uma excessao.
	 * 
	 * @param int id primary key da entrada no BD
	 * @return HoraMesModel objeto retornado
	 * @throws Exception
	 */
	public HorasMesModel buscarHorasMes(int id) throws Exception {
		if (this.horasMesDAO.buscar(HorasMesModel.class, id) == null) {
			throw (new Exception("Entrada com o id requisitado nao existe!"));
		}
		return this.horasMesDAO.buscar(HorasMesModel.class, id);
	}

	/**
	 * Atualiza o atributo 'quantidade' de um objeto HoraMesModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado, caso nao exista,
	 * retorna uma excessao.
	 * 
	 * Se o novo atributo é igual ao antigo, a funcao retorna false.
	 * 
	 * @param int        id primary key do objeto original no BD
	 * @param HorasModel objetoAlterado - Objeto com o atributo a ser substituido no
	 *                   BD
	 * @return boolean true/false para sucesso da operacao
	 * @throws Exception
	 */
	public boolean atualizarHorasMes(int id, Double novaQuantidade) throws Exception {
		HorasMesModel objetoParaAtualizar = this.horasMesDAO.buscar(HorasMesModel.class, id);

		if (Validadores.ehObjetoNulo(objetoParaAtualizar)) {
			throw new Exception("O código informado não consta na base de dados, informe um valor válido.");
		}

		/*
		 * A funcao Double.compare recebe como argumentos dois Doubles e os compara. O
		 * retorno da funcao é um numero inteiro que pode ser positivo, negativo ou
		 * nulo. Se o retorno for nulo (zero), significa que os doubles sao Iguais Se o
		 * retorno for maior do que zero, significa que o primeiro Double é maior que o
		 * segundo Se o retorno for menor que zero, significa que o primeiro Double é
		 * menor que o segundo
		 */
		int compareDouble = Double.compare(objetoParaAtualizar.getQuantidade(), novaQuantidade);
		if (compareDouble == 0) {
			return false;
		}
		return this.horasMesDAO.atualizar(objetoParaAtualizar);
	}

	/**
	 * Deleta um objeto HorasMesModel no BD.
	 * 
	 * Verifica a existencia da entrada com o id providenciado, caso nao exista,
	 * retorna uma excessao.
	 * 
	 * @param int id primary key da entrada no BD
	 * @return boolean true para sucesso da operacao
	 * @throws Exception
	 */
	public boolean deletarHorasMes(int id) throws Exception {
		if (this.horasMesDAO.buscar(HorasMesModel.class, id) == null) {
			throw (new Exception("Entrada com o id requisitado nao existe!"));
		}
		return this.horasMesDAO.deletar(HorasMesModel.class, id);
	}

	/**
	 * Retorna todas as entradas de HorasMesModels no BD em uma ArrayList.
	 * 
	 * @return ArrayList<HorasMesModel> : lista de entradas
	 */
	public ArrayList<HorasMesModel> buscarTodosHorasMes() {
		return (ArrayList<HorasMesModel>) this.horasMesDAO.listarPorTabela(HorasMesModel.class);
	}

	/**
	 * Deleta todas as entradas de HorasMesModels no BD.
	 * 
	 * @return boolean : true/false para sucesso da operacao
	 */
	public boolean deletarTodosHorasMes() {
		return this.horasMesDAO.deletarTodos("horas_mes");
	}

}
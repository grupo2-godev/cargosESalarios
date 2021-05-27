package br.com.proway.senior.cargosESalarios.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sun.xml.txw2.Document;

import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CargoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.CargoModelDTO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * <h1>Controller que interage com o {@link CargoDAO}.</h1>
 * 
 * <p>Classe responsável pela interação com
 * a classe {@link CargoDAO}</p>
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 * 
 * @see CargoDAO
 */
public class CargoController {

	CargoDAO cargoDAO = CargoDAO.getInstancia();

	/**
	 * <h1>Valida os atributos do objeto a ser criado.</h1>
	 * 
	 * <p>Valida se é vazio ou nulo: nomeCargo, experienciaMinima, atribuicoes e
	 * status. Valida se eh nullo ou igual a zero: cbo2002, cbo94, horasMes,
	 * grauInstrucao, idPermissao.</p>
	 * 
	 * @param nomeCargo String - Referente ao nome do cargo.
	 * @param dataCadastro LocalDateTime - Referente a data de cadastro do cargo.
	 * @param dataUltimaRevisao LocalDateTime - Referente a data da ultima alteracao do cargo.
	 * @param cbo2002 CBO2002Model - Referente a definicao do CBO (Classificacao Brasileira de Ocupacoes) de 2002.
	 * @param cbo94 CBO1994Model - Referente a definicao CBO (Classificacao Brasileira de Ocupacoes) de 1994.
	 * @param horasMes HorasMesModel - Referente a quantidade de horas trabalhadas por mes.
	 * @param grauInstrucao GrauInstrucaoModel - Referente ao grau de instrucao do cargo.
	 * @param experienciaMinima Integer - Referente a experiencia minima em anos.
	 * @param atribuicoes String - Referente a descricao das atividades que serao executadas.
	 * @param status Boolean - Referente ao {@link CargoModel} ativo(true) ou inativo(false).
	 * @param idPermissao Integer - Referente ao Id do nivel de acesso permitido para esse tipo de colaborador.
	 * 
	 * @return {@link CargoModel}
	 * 
	 * @throws Exception Retorna uma excessao caso algum dos valores recebidos no
	 *                   parametro nao estejam de acordo conforme validacoes.
	 *                   
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public CargoModel construirCargo(String nomeCargo, LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao,
			CBO2002Model cbo2002, CBO1994Model cbo94, HorasMesModel horasMes, GrauInstrucaoModel grauInstrucao,
			String experienciaMinima, String atribuicoes, Boolean status, Integer idPermissao) throws Exception {

		if (Validadores.ehObjetoNulo(nomeCargo) || nomeCargo.isEmpty())
			throw (new Exception("O nome do cargo não foi informado."));
		if (Validadores.ehObjetoNulo(cbo2002))
			throw (new Exception("O cbo2002 não foi informado."));
		if (Validadores.ehObjetoNulo(cbo94))
			throw (new Exception("O cbo94 não foi informado."));
		if (Validadores.ehObjetoNulo(horasMes))
			throw (new Exception("A quantidade de horas trabalhadas por mês não pode ser igual a zero."));
		if (Validadores.ehObjetoNulo(grauInstrucao))
			throw (new Exception("O grau de instrução não foi informado."));
		if (Validadores.ehObjetoNulo(experienciaMinima) || experienciaMinima.isEmpty())
			throw (new Exception("A experiencia mínima não foi informada."));
		if (Validadores.ehObjetoNulo(atribuicoes) || atribuicoes.isEmpty())
			throw (new Exception("As atribuicoes não foram informadas."));
		if (Validadores.ehObjetoNulo(status))
			throw (new Exception("O status não foi informado."));
		if (Validadores.ehZeroOuNulo(idPermissao))
			throw (new Exception("A permissao não foi informada."));

		CargoModel cargo = new CargoModel();
		cargo.setNomeCargo(nomeCargo);
		cargo.setDataCadastro(dataCadastro);
		cargo.setDataUltimaRevisao(dataUltimaRevisao);
		cargo.setCbo2002(cbo2002);
		cargo.setCbo94(cbo94);
		cargo.setHoraMes(horasMes);
		cargo.setGrauInstrucao(grauInstrucao);
		cargo.setExperienciaMinima(experienciaMinima);
		cargo.setAtribuicoes(atribuicoes);
		cargo.setStatus(status);
		cargo.setIdPermissao(idPermissao);

		return cargo;
	}

	/**
	 * <h1>Cadastra um objeto do tipo {@link CargoModel} no banco de dados.</h1>
	 * 
	 * <p>Recebe um objeto {@link CargoModel} para ser cadastrado
	 * no banco de dados.</p>
	 * 
	 * <p><b style = "color: red">Atenção:</b> Para cadastrar um {@link CargoModel} é necessário chamar
	 * o metodo {@link CargoDAO#criar(CargoModel)} primeiro,
	 * para validacao e criacao do objeto {@link CargoModel}</p> 
	 * 
	 * @param cargo CargoModel - Referente a {@link CargoModel} a ser cadastrado
	 * 
	 * @return Integer - Referente ao id do {@link CargoModel}
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 * @see CargoDAO#criar
	 */
	public Integer cadastrarCargo(CargoModel cargo) {
		Integer idCargoCadastrado = cargoDAO.criar(cargo);
		return idCargoCadastrado;
	}

	/**
	 * <h1>Busca um {@link CargoModel} pelo seu id.</h1>
	 * 
	 * <p>Recebe um id e busca o {@link CargoModel}
	 * correspondente ao id informado. Retorna o
	 * {@link CargoModel} do id informado.</p>
	 * 
	 * @param id Integer - Referente ao Id do objeto a ser consultado
	 * @return {@link CargoModel} - Referente ao objeto encontrado no banco de dados
	 * 
	 * @throws Exception Caso o id seja zero ou nulo
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public CargoModel buscarCargoPorID(Integer id) throws Exception {
		if (Validadores.ehZeroOuNulo(id))
			throw (new Exception("O id não pode ser nulo ou zero."));
		return cargoDAO.buscar(CargoModel.class, id);
	}

	/**
	 * <h1>Altera {@link CargoModel} com o id correspondente</h1>
	 * 
	 * <p>Verifica se existe no banco de dados um {@link CargoModel} 
	 * com o id informado, e verifica também se o {@link CargoModel}
	 * recebido no parametro nao é nulo. Localizando o objeto no
	 * banco, efetua a alteracao para o {@link CargoModel}
	 * recebido no parametro.</p>
	 * 
	 * @param idObjetoASerAlterado Integer - Referente ao Id do {@link CargoModel} a ser alterado
	 * @param novoCargo {@link CargoModel} - Referente ao {@link CargoModel} que possui as alteracoes srem feitas
	 * 
	 * @return boolean - Retorna true caso nao encontre erro durante a validacao, inclusive a busca pelo objeto no banco de dados pelo id
	 * 
	 * @throws Exception Caso o objeto não exista, seja zero ou nulo
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public boolean atualizarCargo(Integer idObjetoASerAlterado, CargoModel novoCargo) throws Exception {
		if (Validadores.ehObjetoNulo(this.buscarCargoPorID(idObjetoASerAlterado)))
			throw (new Exception("O objeto não existe no banco de dados."));
		if (Validadores.ehObjetoNulo(novoCargo))
			throw (new Exception("O objeto não pode ser nulo."));
		novoCargo.setIdCargo(idObjetoASerAlterado);
		cargoDAO.atualizar(novoCargo);
		return true;
	}

	/**
	 * <h1>Deleta o {@link CargoModel} que corresponde ao id recebido</h1>
	 * 
	 * <p>Verifica se o id é válido (diferente de zero, diferente de nulo).
	 * Verifica se existe um objeto no banco de dados
	 * com o id recebido no parametro.</p>
	 * 
	 * @param id Integer - Referente ao Id do {@link CargoModel} a ser deletado
	 * 
	 * @return boolean - Retorna true caso o {@link CargoModel} exista e retorna
	 * false caso o id seja invalido conforme validação
	 *         
	 * @throws Exception Caso o id seja nulo ou igual a zero, ou o 
	 * objeto não exista no banco de dados
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public boolean deletarCargoPorID(Integer id) throws Exception {
		if (Validadores.ehZeroOuNulo(id))
			throw (new Exception("O id não pode ser nulo ou igual a zero."));
		if (Validadores.ehObjetoNulo(this.buscarCargoPorID(id)))
			throw (new Exception("O objeto não existe no banco de dados."));

		cargoDAO.deletar(CargoModel.class, id);
		return true;
	}

	/**
	 * <h1>Busca todos os {@link CargoModel}</h1>
	 * 
	 * <p>Busca todos os {@link CargoModel}
	 * e retorna um ArrayList com todos os 
	 * registros da tabela.</p>
	 * 
	 * @return ArrayList<CargoModel> - Referente a lista com todos os {@link CargoModel}
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public ArrayList<CargoModel> buscarTodosCargos() {
		return (ArrayList<CargoModel>) cargoDAO.listarPorTabela(CargoModel.class);
	}

	/**
	 * <h1>Deleta todos os {@link CargoModel} do banco.</h1>
	 * 
	 * <p>Exclui todos os registros da tabela
	 * cargo referente ao {@link CargoModel}.</p>
	 * 
	 * @return boolean - Referente
	 * 
	 * @author Janaina Mai <<b>janaina.mai@senior.com.br</b>> - Sprint 5
	 * 
	 * @see CargoModel
	 */
	public boolean deletarTodosCargos() {
		return cargoDAO.deletarTodos("cargo");
	}
	
	/**
	 * <h1>Busca {@link CargoModelDTO} pelo nome.</h1>
	 * 
	 * <p>Recebe um nome e exibe os 
	 * {@link CargoModel} referente a esse nome.
	 * Retorna um {@link ArrayList} {@link CargoModel}
	 * com todos os {@link CargoModel} encontrados
	 * com o nome informado. Faz isso atráves do
	 * {@link CargoDAO#listarPorValorDeColunaComStringIncompleta(Class, String, String)}.</p>
	 * 
	 * @param nomeCargo String - Referente ao nome informado
	 * 
	 * @return {@link ArrayList} {@link CargoModel} - Referente
	 * a todos os {@link CargoModel} encontrados
	 * 
	 * @throws Exception - Caso o nome for inválido
	 * 
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong>
	 * 
	 * @version sprint7
	 * 
	 * @see CargoModel
	 * @see CargoDAO#listarPorValorDeColunaComStringIncompleta(Class, String, String)
	 */
	public ArrayList<CargoModel> buscarCargoPorNomeCargo(String nomeCargo) throws Exception {
		if (!Validadores.apenasCaracteresValidos(nomeCargo))
			throw (new Exception("Nome procurado invalido."));
		return (ArrayList<CargoModel>) cargoDAO.listarPorValorDeColunaComStringIncompleta(CargoModel.class, "nomeCargo", nomeCargo);
	}
}

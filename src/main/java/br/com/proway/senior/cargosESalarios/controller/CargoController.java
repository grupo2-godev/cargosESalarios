/**
 * 
 */
package br.com.proway.senior.cargosESalarios.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.connection.ConnectionHibernate;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;
import utils.Validators;

/**
 * Controller que interage com o CargoDAO.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class CargoController {

	CargoDAO cargoDAO = CargoDAO.getInstance(ConnectionHibernate.getSession());

	/**
	 * Valida os atributos do objeto a ser criado.
	 * 
	 * Valida se eh vazio ou nulo: nomeCargo, experienciaMinima, atribuicoes e
	 * status. Valida se eh nullo ou igual a zero: cbo2002, cbo94, horasMes,
	 * grauInstrucao, idPermissao.
	 * 
	 * @param nomeCargo         String Nome do cargo.
	 * @param dataCadastro      LocalDateTime Data de cadastro do cargo.
	 * @param dataUltimaRevisao LocalDateTime Data da ultima alteracao do cargo.
	 * @param cbo2002           Integer Definicao CBO (Classificacao Brasileira de
	 *                          Ocupacoes) de 2002.
	 * @param cbo94             Integer Definicao CBO (Classificacao Brasileira de
	 *                          Ocupacoes) de 1994.
	 * @param horasMes          Integer Quantidade de horas trabalhada por mes.
	 * @param grauInstrucao     Integer Id do {@link GrauInstrucaoModel}.
	 * @param experienciaMinima Integer Experiencia minima em anos.
	 * @param atribuicoes       String Descricao das atividades que serao
	 *                          executadas.
	 * @param status            Boolean Cargo ativo(true) ou inativo(false).
	 * @param idPermissao       Integer Id do nivel de acesso permitido para esse
	 *                          tipo de colaborador.
	 * 
	 * @return Id do objeto cadastrado.
	 * @throws Exception Retorna uma excessao caso algum dos valores recebidos no
	 *                   parametro nao estejam de acordo conforme validacoes.
	 */
	public CargoModel construir(String nomeCargo, LocalDateTime dataCadastro, LocalDateTime dataUltimaRevisao,
			Integer cbo2002, Integer cbo94, Integer horasMes, Integer grauInstrucao, String experienciaMinima,
			String atribuicoes, Boolean status, Integer idPermissao) throws Exception {

		if (Validators.isNullObject(nomeCargo) || nomeCargo.isEmpty())
			throw (new Exception("O nome do cargo não foi informado."));
		if (Validators.isZeroOrNull(cbo2002))
			throw (new Exception("O cbo2002 não foi informado."));
		if (Validators.isZeroOrNull(cbo94))
			throw (new Exception("O cbo94 não foi informado."));
		if (Validators.isZeroOrNull(horasMes))
			throw (new Exception("A quantidade de horas trabalhadas por mês não pode ser igual a zero."));
		if (Validators.isZeroOrNull(grauInstrucao))
			throw (new Exception("O grau de instrução não foi informado."));
		if (Validators.isNullObject(experienciaMinima) || experienciaMinima.isEmpty())
			throw (new Exception("A experiencia mínima não foi informada."));
		if (Validators.isNullObject(atribuicoes) || atribuicoes.isEmpty())
			throw (new Exception("As atribuicoes não foram informadas."));
		if (Validators.isNullObject(status))
			throw (new Exception("O status não foi informado."));
		if (Validators.isZeroOrNull(idPermissao))
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
	 * Cadastra um objeto do tipo {@link CargoModel} no banco de dados.
	 * 
	 * @param cargo CargoModel Objeto a ser cadastrado.
	 * @return Integer: id do objeto cadastrado.
	 */
	public Integer cadastrar(CargoModel cargo) {
		Integer idCargoCadastrado = cargoDAO.create(cargo);
		return idCargoCadastrado;
	}

	/**
	 * Retorna um objeto do tipo {@link CargoModel} que contenha o id igual ao id
	 * recebido no parameto.
	 * 
	 * @param id Integer Id do objeto a ser consultado.
	 * @return CargoModel: objeto encontrado no banco de dados.
	 * @throws Exception
	 */
	public CargoModel buscarPorId(Integer id) throws Exception {
		if (Validators.isZeroOrNull(id))
			throw (new Exception("O id não pode ser nulo ou zero."));
		return cargoDAO.retrieve(id);
	}

	/**
	 * Altera o objeto no banco de dados que possui o id recebido no parametro.
	 * 
	 * Verifica se existe no banco de dados um objeto com o id informado e verifica
	 * tambem se o objeto recebido no parametro nao eh nulo. Localizando o objeto no
	 * banco, efetua a alteracao para o objeto recebido no parametro.
	 * 
	 * @param idObjetoASerAlterado Integer Id do objeto a ser alterado.
	 * @param novoCargo            CargoModel Objeto que possui as alteracoes que
	 *                             substituirao o objeto do banco de dados.
	 * @return boolean: Retorna true caso nao encontre erro durante a validacao,
	 *         inclusive a busca pelo objeto no banco de dados pelo id.
	 * @throws Exception
	 */
	public boolean alterar(Integer idObjetoASerAlterado, CargoModel novoCargo) throws Exception {
		if (Validators.isNullObject(novoCargo))
			throw (new Exception("O objeto não pode ser nulo."));
		if (Validators.isNullObject(this.buscarPorId(idObjetoASerAlterado)))
			throw (new Exception("O objeto não existe no banco de dados."));
		
		cargoDAO.update(idObjetoASerAlterado, novoCargo);
		return true;
	}

	/**
	 * Retorna um ArrayList com todos os registros da tabela {@link CargoModel}.
	 * 
	 * @return ArrayList<CargoModel> Lista de ojetos do tipo {@link CargoModel}.
	 */
	public ArrayList<CargoModel> buscarTodos() {
		return cargoDAO.getAll();
	}

	/**
	 * Deleta todos os registros da tabela {@link CargoModel}.
	 */
	public void deletarTodos() {
		cargoDAO.deleteAll();
	}

}

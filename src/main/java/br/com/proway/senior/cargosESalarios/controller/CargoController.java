/**
 * 
 */
package br.com.proway.senior.cargosESalarios.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.conexao.ConexaoHibernate;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.DaoSQL.CargoDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Controller que interage com o CargoDAO.
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 * @author Lucas Ivan <b>lucas.ivan@senior.com.br</b> - Sprint 5
 *
 */
public class CargoController {

	CargoDAO cargoDAO = CargoDAO.getInstancia(ConexaoHibernate.getSessao());

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
	 * @param cbo2002           CBO2002Model Definicao CBO (Classificacao Brasileira
	 *                          de Ocupacoes) de 2002.
	 * @param cbo94             CBO1994Model Definicao CBO (Classificacao Brasileira
	 *                          de Ocupacoes) de 1994.
	 * @param horasMes          HorasMesModel Quantidade de horas trabalhadas por
	 *                          mes.
	 * @param grauInstrucao     GrauInstrucaoModel Grau de instrucao do cargo.
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
	 * Cadastra um objeto do tipo {@link CargoModel} no banco de dados.
	 * <p>
	 * <b>Atenção:</b> Para cadastrar um cargo eh necessario chamar o metodo construir() 
	 * primeiro, para validacao e criacao do objeto CargoModel {@link CargoModel}. 
	 * 
	 * 
	 * @param cargo CargoModel Objeto a ser cadastrado.
	 * @return Integer: id do objeto cadastrado.
	 */
	public Integer cadastrar(CargoModel cargo) {
		Integer idCargoCadastrado = cargoDAO.criar(cargo);
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
		if (Validadores.ehZeroOuNulo(id))
			throw (new Exception("O id não pode ser nulo ou zero."));
		return cargoDAO.buscar(id);
	}

	/**
	 * Altera o objeto no banco de dados que possui o id recebido no parametro.
	 * 
	 * Verifica se existe no banco de dados um objeto com o id informado e verifica
	 * tambem se o objeto recebido no parametro nao eh nulo. Localizando o objeto no
	 * banco, efetua a alteracao para o objeto recebido no parametro.
	 * <p>
	 * <b>Atenção:</b> Para cadastrar um cargo eh necessario chamar o metodo construir() 
	 * primeiro, para validacao e criacao do objeto CargoModel {@link CargoModel}. 
	 * 
	 * @param idObjetoASerAlterado Integer Id do objeto a ser alterado.
	 * @param novoCargo            CargoModel Objeto que possui as alteracoes que
	 *                             substituirao o objeto do banco de dados.
	 * @return boolean: Retorna true caso nao encontre erro durante a validacao,
	 *         inclusive a busca pelo objeto no banco de dados pelo id.
	 * @throws Exception
	 */
	public boolean alterar(Integer idObjetoASerAlterado, CargoModel novoCargo) throws Exception {
		if (Validadores.ehObjetoNulo(this.buscarPorId(idObjetoASerAlterado)))
			throw (new Exception("O objeto não existe no banco de dados."));
		if (Validadores.ehObjetoNulo(novoCargo))
			throw (new Exception("O objeto não pode ser nulo."));

		cargoDAO.atualizar(idObjetoASerAlterado, novoCargo);
		return true;
	}

	/**
	 * Deleta um registro do banco de dados que corresponde ao id recebido no
	 * parametro.
	 * 
	 * Verifica se o id eh valido (diferente de zero, diferente de nulo). Verifica
	 * se existe um objeto no banco de dados com o id recebido no parametro.
	 * 
	 * @param id Integer Id do objeto a ser deletado.
	 * @return boolean Retorna true caso o objeto seja localizado no banco de dados.
	 *         Retorna false caso o id seja invalido conforma validacao.
	 * @throws Exception
	 */
	public boolean deletarPorId(Integer id) throws Exception {
		if (Validadores.ehZeroOuNulo(id))
			throw (new Exception("O id não pode ser nulo ou igual a zero."));
		if (Validadores.ehObjetoNulo(this.buscarPorId(id)))
			throw (new Exception("O objeto não existe no banco de dados."));

		cargoDAO.deletar(id);
		return true;
	}

	/**
	 * Retorna um ArrayList com todos os registros da tabela {@link CargoModel}.
	 * 
	 * @return ArrayList<CargoModel> Lista de ojetos do tipo {@link CargoModel}.
	 */
	public ArrayList<CargoModel> buscarTodos() {
		return cargoDAO.buscarTodos();
	}

	/**
	 * Deleta todos os registros da tabela {@link CargoModel}.
	 */
	public void deletarTodos() {
		cargoDAO.deletarTodos();
	}

}

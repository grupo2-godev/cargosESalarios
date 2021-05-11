package br.com.proway.senior.cargosESalarios.antigos;
/**
 * REFATORAR, ESSA É A VERSAO ANTIGA COM ARRAY LISTS
 */
package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.Cbo1994Dao;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;

/**
 * @author Sabrina Schmidt <i>sabrina.schmidt@senior.com.br</i>
 * @author Samuel Levi <i>samuel.levi@senior.com.br</i>
 * @author Lorran <i>lorran.santos@senior.com.br</i>
 *
 */
public class Cbo1994Controller {

	Cbo1994DaoAl cbo1994 = new Cbo1994DaoAl();

	/**
	 * 
	 * Cadastro Cbo
	 * 
	 * Recebe os par�metros necessarios para a criacao de um cbo as valida e envia
	 * para o dao
	 * 
	 * @param codigoId
	 * @param descricao
	 * @param percentualInsalubridade
	 * @param percentualPericulosidade
	 * @return null/idNovoCbo1994
	 */
	public Integer cadastrarCbo1994(Integer codigoId, String descricao, Double percentualInsalubridade,
			Double percentualPericulosidade) {
		if (cbo1994.retrieve(descricao) != null) {
			return null;
		} else {
			Cbo1994Model newCbo = new Cbo1994Model(codigoId, descricao, percentualInsalubridade,
					percentualPericulosidade);
			int idNovoCbo1994 = cbo1994.create(newCbo);
			return idNovoCbo1994;
		}
	}

	/**
	 * Deletar CBO1994
	 * 
	 * Realiza a exclus�o do cbo conforme id de par�metro.
	 * 
	 * @param idCbo1994
	 * @return boolean
	 */
	public boolean deletarCbo1994(Integer idCbo1994) {
		return cbo1994.delete(idCbo1994);
	}

	/**
	 * Atualizar Cbo1994
	 * 
	 * M�todo realiza a atualiza��o do cbo conforme par�metros poss�veis de
	 * altera��o. Para os demais dados, o indicado � criar um novo cbo para manter
	 * hist�rico.
	 * 
	 * @param codigoId
	 * @param descricao
	 * @param percentualInsalubridade
	 * @param percentualPericulosidade
	 * @return
	 */
	public boolean atualizarCbo1994(Integer codigoId, String descricao, Double percentualInsalubridade,
			Double percentualPericulosidade) {
		Cbo1994Model cbo1994Param = cbo1994.retrieve(codigoId);
		cbo1994Param.setCodigoId(codigoId);
		cbo1994Param.setDescricao(descricao);
		cbo1994Param.setPercentualInsalubridade(percentualInsalubridade);
		cbo1994Param.setPercentualPericulosidade(percentualPericulosidade);
		return cbo1994.update(cbo1994Param);
	}

	/**
	 * Buscar cbo por ID
	 * 
	 * Realiza a busca do cbo1994 conforme Id informada e retorna o objeto do mesmo.
	 * 
	 * @param idCbo1994
	 * @return Cbo1994Model
	 */
	public Cbo1994Model buscarCboId(Integer idCbo1994) {
		return cbo1994.retrieve(idCbo1994);
	}

	/**
	 * Buscar cbo por nome
	 * 
	 * Realiza a busca do cargo conforme nome informado e retorna o objeto do mesmo.
	 * 
	 * @param nomeCbo1994
	 * @return Cbo1994Model
	 */
	public Cbo1994Model buscarCboNome(String nomeCbo1994) {
		return cbo1994.retrieve(nomeCbo1994);
	}

	/**
	 * Busca e traz a lista com todos os cbos cadastrados
	 * 
	 * @return ArrayList<Cbo1994Model>
	 */
	public ArrayList<Cbo1994Model> buscarTodosCbos() {
		return cbo1994.getAll();

	}

}

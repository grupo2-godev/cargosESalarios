package br.com.proway.senior.cargosESalarios.controller;

import java.util.ArrayList;

import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.PostoDeTrabalhoDAO;
import br.com.proway.senior.cargosESalarios.utilidades.Validadores;

/**
 * Classe PostoDeTrabalhoController
 * 
 * Implementa os metodos do DAO para as devidas trataivas necessarias
 * 
 * @author Enzo Moura <b>enzo.moura@senior.com.br</b> - Sprint 5
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 * @author Willian Kenji Nishizawa <b>willian.kenji@senior.com.br</b> - Sprint 5
 */
public class PostoDeTrabalhoController {
	
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstancia();
	
	/**
	 * Cadastro Posto de Trabalho
	 * 
	 * Recebe os parametros necessarios para a criacao de um posto de
	 * trabalho, as valida e envia para o DAO.
	 * @param nomePosto nome que sera atribuido ao posto de trabalho.
	 * @param cargo {@link CargoModel}, que sera atrabuido ao posto, eh
	 * chave estrangeira.
	 * @param setor {@link SetorModel}, que sera atribuido ao posto, eh 
	 * chave estrangeira.
	 * @param nivel {@link NivelModel}, que sera atribuido ao posto, eh
	 * chave estrangeira.
	 * @param Double salario correspondente ao posto de trabalho.
	 * @return null nulo ou idNovoPosto a identificao do novo posto de 
	 * trabalho.
	 * @throws Exception 
	 */
	public Integer cadastrarPostoDeTrabalho(String nomePosto, CargoModel cargo, SetorModel setor, NivelModel nivel, 
			Double salario) throws Exception {		
		if (!Validadores.apenasCaracteresValidos(nomePosto)) {
			throw new Exception("Nome invalido para Posto de Trabalho!!!");
		}

		else {
			PostoDeTrabalhoModel novoPosto = new PostoDeTrabalhoModel(nomePosto, cargo, setor, nivel, salario);
			return this.postoDAO.criar(novoPosto);
		}
	}
	
	/**
	 * Deletar Posto de Trabalho
	 * 
	 * Realiza a exclusao do posto de trabalho conforme id de parametro.
	 * 
	 * @param Integer idPosto Identificacao do posto de trabalho que sera 
	 * excluido.
	 * @return boolean
	 */
	public boolean deletarPostoDeTrabalho(Integer idPosto) {
		return this.postoDAO.deletar(PostoDeTrabalhoModel.class, idPosto);
	}
	
	/**
	 * Atualizar Posto de Trabalho
	 * 
	 * Metodo realiza a atualizacao do posto de trabalho conforme parametros.
	 * 
	 * @param Integer idPosto Identificacao do posto de trabalho que sera alterado.
	 * @param String novoNome nome que sera atribuido na atualizacao.
	 * @param CargoModel novoCargo cargo que sera atribuido na atualizacao {@link CargoModel}.
	 * @param SetorModel novoSetor setor que sera atribuido na atualizacao {@link SetorModel}.
	 * @param NivelModel novoNivel nivel que sera atribuido na atualizacao {@link NivelModel}.
	 * @param Double novoSalario novo salario que sera atribuido na atualizacao.
	 * @return boolean
	 */
	public boolean atualizarPostoDeTrabalho(Integer idPosto, String novoNome, CargoModel novoCargo, SetorModel novoSetor,
			NivelModel novoNivel, Double novoSalario) {
		PostoDeTrabalhoModel posto = this.postoDAO.buscar(PostoDeTrabalhoModel.class, idPosto);
		if (Validadores.apenasCaracteresValidos(novoNome)) {
			posto.setNomePosto(novoNome);
		}
		posto.setIdPosto(idPosto);
		posto.setCargo(novoCargo);
		posto.setSetor(novoSetor);
		posto.setNivel(novoNivel);
		posto.setSalario(novoSalario);
		return this.postoDAO.atualizar(posto);
	}
	
	/**
	 * Buscar posto de trabalho por ID.
	 * 
	 * Realiza a busca do posto de trabalho conforme Id informada
	 * e retorna o objeto da mesma.
	 * 
	 * @param Integer idPosto Identificacao do posto de trabalho procurado.
	 * @return PostoDeTrabalhoModel
	 */
	public PostoDeTrabalhoModel buscarPostoDeTrabalhoId(Integer idPosto) {
		return this.postoDAO.buscar(PostoDeTrabalhoModel.class, idPosto);
	}
	
	/**
	 * Buscar posto de trabalho por nome.
	 * 
	 * Realiza a busca do posto de trabalho conforme nome informado via parametro
	 * e retorna o objeto do mesmo.
	 * 
	 * @param String nomePosto nome do posto de trabalho procurado.
	 * @return PostoDeTrabalhoModel
	 */
	public ArrayList<PostoDeTrabalhoModel> buscarPostoDeTrabalhoNome(String nomePosto) {
		return (ArrayList<PostoDeTrabalhoModel>) this.postoDAO.listarPorValorDeColunaComStringIncompleta(PostoDeTrabalhoModel.class, "nomePosto", nomePosto);
	}
	
	/**
	 * Buscar todos os postos de trabalho cadastrados no banco de dados e os
	 * retorna em uma lista.
	 *  
	 * @return ArrayList PostoDeTrabalhoModel
	 */
	public ArrayList<PostoDeTrabalhoModel> buscarTodosPostosDeTrabalho() {
		return (ArrayList<PostoDeTrabalhoModel>) this.postoDAO.listarPorTabela(PostoDeTrabalhoModel.class);
		
	}
	
	/**
	 * Deletar todos os registros de postos de trabalho do banco de dados.
	 * 
	 * @return boolean
	 */
	public boolean deletarTodos() {
		return this.postoDAO.deletarTodos("Posto_de_Trabalho");
	}
}

package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.PostoDeTrabalhoController;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.DAO.PostoDeTrabalhoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.PostoDeTrabalhoModelDTO;

/**
 * <h1>Responsável por receber requisições REST</h1>
 * 
 * <p>
 * Classe responsável por receber requisições REST e executa a ligação entre a
 * API e o serviço.
 * </p>
 * 
 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6
 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> - Sprint 6
 */
@RestController
public class PostoDeTrabalhoControllerAPI {

	PostoDeTrabalhoController postoController = PostoDeTrabalhoController.getInstancia();
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstancia();

	/**
	 * <h1>Busca um {@link PostoDeTrabalhoModelDTO} por id</h1>
	 * 
	 * <p>Recebe um id, busca um {@link PostoDeTrabalhoModel}
	 * atraves do {@link PostoDeTrabalhoController} e 
	 * retorna esse {@link PostoDeTrabalhoModel}.</p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return {@link PostoDeTrabalhoModel} - Referente ao
	 * {@link PostoDeTrabalhoModel} encontrado
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@GetMapping("/postos/{id}")
	public PostoDeTrabalhoModelDTO buscarPorID(@PathVariable Integer id) {
		return new PostoDeTrabalhoModelDTO(postoController.buscarPostoDeTrabalhoId(id));
	}

	/**
	 * <h1>Busca todos os {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>Busca todos os {@link PostoDeTrabalhoModel}
	 * através do {@link PostoDeTrabalhoController}.
	 * Retorna um ArrayList de {@link PostoDeTrabalhoModel}.</p>
	 * 
	 * @return ArrayList {@link PostoDeTrabalhoModel} - Referente
	 * a todos os {@link PostoDeTrabalhoModel} encontrados
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@GetMapping("/postos")
	public ArrayList<PostoDeTrabalhoModelDTO> buscarTodos() {
		ArrayList<PostoDeTrabalhoModelDTO> postosDTO = new ArrayList<PostoDeTrabalhoModelDTO>();
		for (PostoDeTrabalhoModel postoDeTrabalhoModel : postoController.buscarTodosPostosDeTrabalho()) {
			postosDTO.add(new PostoDeTrabalhoModelDTO(postoDeTrabalhoModel));
		}
		return postosDTO;
	}

	/**
	 * <h1>Insere um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>Recebe um {@link PostoDeTrabalhoModel}
	 * e o insere no banco através do {@link PostoDeTrabalhoController}.
	 * Retorna true caso tudo tenha dado certo.</p>
	 * 
	 * @param posto {@link PostoDeTrabalhoModel} - Referente ao
	 * {@link PostoDeTrabalhoModel} informado
	 * 
	 * @return boolean - true caso de certo, false caso
	 * contrário
	 * 
	 * @throws Exception - Caso aconteça algum erro
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@PostMapping("/postos")
	public boolean inserirPosto(@RequestBody PostoDeTrabalhoModel posto) throws Exception {
		postoController.cadastrarPostoDeTrabalho(posto.getNomePosto(), posto.getCargo(), posto.getSetor(),
				posto.getNivel(), posto.getSalario());
		return true;
	}

	/**
	 * <h1>Atualiza um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>Recebe um id e um {@link PostoDeTrabalhoModel},
	 * atualiza o {@link PostoDeTrabalhoModel} referente
	 * ao id informado</p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * @param posto {@link PostoDeTrabalhoModel} - Referente ao
	 * {@link PostoDeTrabalhoModel} informado
	 * 
	 * @return boolean - true caso de certo,
	 * false caso contrário
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@PutMapping("/postos/{id}")
	public boolean atualizarPosto(@PathVariable Integer id, @RequestBody PostoDeTrabalhoModel posto) {
		posto.setIdPosto(id);
		postoController.atualizarPostoDeTrabalho(id, posto.getNomePosto(), posto.getCargo(), posto.getSetor(),
				posto.getNivel(), posto.getSalario());
		return true;
	}

	/**
	 * <h1>Deleta um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>Recebe um id e deleta o
	 * {@link PostoDeTrabalhoModel} referente
	 * ao id informado. Faz isso usando o
	 * {@link PostoDeTrabalhoController}.</p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return boolean - true caso de certo
	 * false caso contrário
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@DeleteMapping("/postos/{id}")
	public boolean deletarPosto(@PathVariable int id) {
		postoController.deletarPostoDeTrabalho(id);
		return true;
	}
}

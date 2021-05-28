package br.com.proway.senior.cargosESalarios.controller.API;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong>
 *         - Sprint 6
 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
 *         - Sprint 6
 */
@RestController
public class PostoDeTrabalhoControllerAPI {

	PostoDeTrabalhoController postoController = PostoDeTrabalhoController.getInstancia();
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstancia();

	/**
	 * <h1>Busca um {@link PostoDeTrabalhoModelDTO} por id</h1>
	 * 
	 * <p>
	 * Recebe um id, busca um {@link PostoDeTrabalhoModel} atraves do
	 * {@link PostoDeTrabalhoController} e retorna esse
	 * {@link PostoDeTrabalhoModel}.
	 * </p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return {@link PostoDeTrabalhoModel} - Referente ao
	 *         {@link PostoDeTrabalhoModel} encontrado
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 *         Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@GetMapping("/postos/{id}")
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		try {
			PostoDeTrabalhoModelDTO posto = new PostoDeTrabalhoModelDTO(postoController.buscarPostoDeTrabalhoId(id));
			return ResponseEntity.ok(posto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link PostoDeTrabalhoModel} através do
	 * {@link PostoDeTrabalhoController}. Retorna um ArrayList de
	 * {@link PostoDeTrabalhoModel}.
	 * </p>
	 * 
	 * @return ArrayList {@link PostoDeTrabalhoModel} - Referente a todos os
	 *         {@link PostoDeTrabalhoModel} encontrados
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 *         Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@GetMapping("/postos/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<PostoDeTrabalhoModelDTO> postosDTO = new ArrayList<PostoDeTrabalhoModelDTO>();
		for (PostoDeTrabalhoModel postoDeTrabalhoModel : postoController.buscarTodosPostosDeTrabalho()) {
			postosDTO.add(new PostoDeTrabalhoModelDTO(postoDeTrabalhoModel));
		}
		if(postosDTO.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum posto de trabalho cadastrado");
		}
		return ResponseEntity.ok(postosDTO);
	}

	/**
	 * <h1>Insere um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>
	 * Recebe um {@link PostoDeTrabalhoModel} e o insere no banco através do
	 * {@link PostoDeTrabalhoController}. Retorna true caso tudo tenha dado certo.
	 * </p>
	 * 
	 * @param posto {@link PostoDeTrabalhoModel} - Referente ao
	 *              {@link PostoDeTrabalhoModel} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @throws Exception - Caso aconteça algum erro
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 *         Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@PostMapping("/postos")
	public ResponseEntity<?> inserirPosto(@RequestBody PostoDeTrabalhoModel posto) throws Exception {
		try {
			Integer postoID = postoController.cadastrarPostoDeTrabalho(posto.getNomePosto(), posto.getCargo(),
					posto.getSetor(), posto.getNivel(), posto.getSalario());
			return ResponseEntity.ok(postoID);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Confira a sintaxe do JSON no corpo da requisição!");
		}
	}

	/**
	 * <h1>Atualiza um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>
	 * Recebe um id e um {@link PostoDeTrabalhoModel}, atualiza o
	 * {@link PostoDeTrabalhoModel} referente ao id informado
	 * </p>
	 * 
	 * @param id    Integer - Referente ao id informado
	 * @param posto {@link PostoDeTrabalhoModel} - Referente ao
	 *              {@link PostoDeTrabalhoModel} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 *         Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@PutMapping("/postos/{id}")
	public ResponseEntity<?> atualizarPosto(@PathVariable Integer id, @RequestBody PostoDeTrabalhoModel posto) {
		try {
			posto.setIdPosto(id);
			boolean atualizou = postoController.atualizarPostoDeTrabalho(id, posto.getNomePosto(), posto.getCargo(),
					posto.getSetor(), posto.getNivel(), posto.getSalario());
			return ResponseEntity.ok(atualizou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Deleta um {@link PostoDeTrabalhoModel}.</h1>
	 * 
	 * <p>
	 * Recebe um id e deleta o {@link PostoDeTrabalhoModel} referente ao id
	 * informado. Faz isso usando o {@link PostoDeTrabalhoController}.
	 * </p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return boolean - true caso de certo false caso contrário
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 *         Sprint 6
	 * 
	 * @see PostoDeTrabalhoModel
	 * @see PostoDeTrabalhoController
	 */
	@DeleteMapping("/postos/{id}")
	public ResponseEntity<?> deletarPosto(@PathVariable int id) {
		try {
			boolean deletou = postoController.deletarPostoDeTrabalho(id);
			return ResponseEntity.ok(deletou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Busca {@link PostoDeTrabalhoModelDTO} pelo nome.</h1>
	 * 
	 * <p>
	 * Recebe uma nome e exibe os registros da tabela selecionados por esse nome do
	 * {@link PostoDeTrabalhoModelDTO}. Faz isso através do
	 * {@link PostoDeTrabalhoController#buscarPostoPorNomeCargo(String)}.
	 * </p>
	 * 
	 * @param nome String - Referente ao nome informado
	 * 
	 * @return {@link ArrayList} {@link PostoDeTrabalhoModelDTO} - Referente aos
	 *         {@link PostoDeTrabalhoModelDTO} encontrados
	 * 
	 * @throws Exception - Caso o nome for inválido
	 * 
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong>
	 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong>
	 * 
	 * @version sprint7
	 * 
	 * @see PostoDeTrabalhoModelDTO
	 * @see PostoDeTrabalhoController#buscarPostoPorNomeCargo(String)
	 */
	@GetMapping("/postos")
	public ResponseEntity<?> buscarPostosPeloNome(@RequestParam String nome) throws Exception {
		if (nome == null) {
			return buscarTodos();
		}
		try {
			ArrayList<PostoDeTrabalhoModelDTO> listaPostosDeTrabalhoModelDTO = new ArrayList<>();
			for (PostoDeTrabalhoModel postoDeTrabalhoModel : postoController.buscarPostoPorNomeCargo(nome)) {
				listaPostosDeTrabalhoModelDTO.add(new PostoDeTrabalhoModelDTO(postoDeTrabalhoModel));
			}
			if(listaPostosDeTrabalhoModelDTO.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há postos de trabalho cadastrados");
			}
			return ResponseEntity.ok(listaPostosDeTrabalhoModelDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome Invalido");
		}
	}
}

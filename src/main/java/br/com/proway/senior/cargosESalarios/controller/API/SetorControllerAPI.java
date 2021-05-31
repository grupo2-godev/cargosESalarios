package br.com.proway.senior.cargosESalarios.controller.API;

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
import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.PostoDeTrabalhoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.PostoDeTrabalhoModelDTO;

@RestController
public class SetorControllerAPI {

	SetorController setorController = SetorController.getInstancia();
	PostoDeTrabalhoDAO setorDAO = PostoDeTrabalhoDAO.getInstancia();

	/**
	 * <h1>Busca um {@link SetorModel} por id</h1>
	 * 
	 * <p>
	 * Recebe um id, busca um {@link SetorModel} atraves do
	 * {@link SetorController} e retorna esse
	 * {@link SetorModel}.
	 * </p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return {@link SetorModel} - Referente ao
	 *         {@link SetorModel} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see SetorModel
	 * @see SetorController
	 */
	@GetMapping("/setores/{id}")
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		try {
			SetorModel posto = setorController.buscarSetorPorId(id);
			return ResponseEntity.ok(posto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link SetorModel}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link SetorModel} através do
	 * {@link SetorController}. Retorna um ArrayList de
	 * {@link SetorModel}.
	 * </p>
	 * 
	 * @return ArrayList {@link SetorModel} - Referente a todos os
	 *         {@link SetorModel} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see SetorModel
	 * @see SetorController
	 */
	@GetMapping("/setores/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<SetorModel> postosDTO = new ArrayList<SetorModel>();
		for (SetorModel setorModel : setorController.buscarTodosSetores()) {
			postosDTO.add(setorModel);
		}
		if(postosDTO.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum setor cadastrado");
		}
		return ResponseEntity.ok(postosDTO);
	}

	/**
	 * <h1>Insere um {@link SetorModel}.</h1>
	 * 
	 * <p>
	 * Recebe um {@link SetorModel} e o insere no banco através do
	 * {@link SetorController}. Retorna true caso tudo tenha dado certo.
	 * </p>
	 * 
	 * @param posto {@link SetorModel} - Referente ao
	 *              {@link SetorModel} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @throws Exception - Caso aconteça algum erro
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see SetorModel
	 * @see SetorController
	 */
	@PostMapping("/setores")
	public ResponseEntity<?> inserirSetor(@RequestBody SetorModel setor) throws Exception {
		try {
			Integer setorID = setorController.cadastrarSetor(setor.getNomeSetor(), setor.getIdPermissao());
			return ResponseEntity.ok(setorID);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Confira a sintaxe do JSON no corpo da requisição!");
		}
	}

	/**
	 * <h1>Atualiza um {@link SetorModel}.</h1>
	 * 
	 * <p>
	 * Recebe um id e um {@link SetorModel}, atualiza o
	 * {@link SetorModel} referente ao id informado
	 * </p>
	 * 
	 * @param id    Integer - Referente ao id informado
	 * @param posto {@link SetorModel} - Referente ao
	 *              {@link SetorModel} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see SetorModel
	 * @see SetorController
	 */
	@PutMapping("/setores/{id}")
	public ResponseEntity<?> atualizarSetor(@PathVariable Integer id, @RequestBody SetorModel setor) {
		try {
			setor.setId(id);
			boolean atualizou = setorController.atualizarSetor(id, setor.getNomeSetor(), setor.getIdPermissao());
			return ResponseEntity.ok(atualizou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Deleta um {@link SetorModel}.</h1>
	 * 
	 * <p>
	 * Recebe um id e deleta o {@link SetorModel} referente ao id
	 * informado. Faz isso usando o {@link SetorController}.
	 * </p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return boolean - true caso de certo false caso contrário
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see SetorModel
	 * @see SetorController
	 */
	@DeleteMapping("/setores/{id}")
	public ResponseEntity<?> deletarSetor(@PathVariable int id) {
		try {
			boolean deletou = setorController.deletarSetor(id);
			return ResponseEntity.ok(deletou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID invalido");
		}
	}

	/**
	 * <h1>Busca {@link SetorModel} pelo nome.</h1>
	 * 
	 * <p>
	 * Recebe uma nome e exibe os registros da tabela selecionados por esse nome do
	 * {@link SetorModel}. Faz isso através do
	 * {@link SetorController#buscarSetorPorNome(String)}.
	 * </p>
	 * 
	 * @param nome String - Referente ao nome informado
	 * 
	 * @return {@link ArrayList} {@link SetorModel} - Referente aos
	 *         {@link SetorModel} encontrados
	 * 
	 * @throws Exception - Caso o nome for inválido
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @version sprint7
	 * 
	 * @see SetorModel
	 * @see SetorController#buscarSetorPorNome(String)
	 */
	@GetMapping("/setores")
	public ResponseEntity<?> buscarSetoresPeloNome(@RequestParam String nome) throws Exception {
		if (nome == null) {
			return buscarTodos();
		}
		try {
			ArrayList<SetorModel> listaSetoresModel = new ArrayList<>();
			for (SetorModel setorModel : setorController.buscarSetorPorNome(nome)) {
				listaSetoresModel.add(setorModel);
			}
			if(listaSetoresModel.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há setores cadastrados");
			}
			return ResponseEntity.ok(listaSetoresModel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome Invalido");
		}
	}
	
}

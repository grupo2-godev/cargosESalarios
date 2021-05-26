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
 * <h1>Responsável por receber requisições RESt</h1>
 * 
 * <p>Classe responsável por receber
 * requisições REST e executa a ligação
 * entre a API e o serviço.</p>
 * 
 * @author Lucas Ivan <strong>lucas.ivan@senior.com.br</strong> - Sprint 6
 * @author Lucas Nunes <strong>lucas.nunes@senior.com.br</strong> - Sprint 6
 * @author Vitor Nathan Goncalves <strong>vitor.goncalves@senior.com.br</strong> - Sprint 6
 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
 *
 */
@RestController
public class PostoDeTrabalhoControllerAPI {
	
	PostoDeTrabalhoController postoController = PostoDeTrabalhoController.getInstancia();
	PostoDeTrabalhoDAO postoDAO = PostoDeTrabalhoDAO.getInstancia();	
	
	/**
	 * <h1>Busca um {@link PostoDeTrabalhoModelDTO} por id</h1>
	 * 
	 * <p></p>
	 * 
	 * Retorna um objeto do tipo {@link PostoDeTrabalhoModel} que contenha o id igual ao id
	 * recebido no parameto.
	 * @param id Integer Id do objeto a ser consultado.
	 * @return PostoDeTrabalhoModelDTO: criado a partir do objeto encontrado no banco de dados.
	 * 
	 * @author Bruno Marques <strong>bruno.marques@senior.com.br</strong> Sprint 6
	 * @author Vanderlei Kleinschmidt <strong>vanderlei.klein@senior.com.br</strong> Sprint 6
	 */
	@GetMapping("/postos/{id}")
	public PostoDeTrabalhoModelDTO buscarPorID(@PathVariable Integer id){
		return new PostoDeTrabalhoModelDTO(postoController.buscarPostoDeTrabalhoId(id));
	}
	
	/**
	 * Retorna um ArrayList com todos os registros da tabela {@link PostoDeTrabalhoModel}.
	 * 
	 * Faz uma busca por todos os objetos do tipo {@link PostoDeTrabalhoModel} na tabela PostoDeTrabalhoModel.class e
	 * adiciona em um ArrayList<PostoDeTrabalhoModelDTO> para retornar ao usuário.
	 * 
	 * @return ArrayList<PostoDeTrabalhoModelDTO> Lista de ojetos do tipo {@link PostoDeTrabalhoModel}.
	 */
	@GetMapping("/postos")
	public ArrayList<PostoDeTrabalhoModelDTO> buscarTodos() {
		ArrayList<PostoDeTrabalhoModelDTO> postosDTO = new ArrayList<PostoDeTrabalhoModelDTO>();
		for (PostoDeTrabalhoModel postoDeTrabalhoModel : postoController.buscarTodosPostosDeTrabalho()) {
			postosDTO.add(new PostoDeTrabalhoModelDTO(postoDeTrabalhoModel));
		}
		return postosDTO;
	}
	
	@PostMapping("/postos")
	public boolean inserirPosto(@RequestBody PostoDeTrabalhoModel postoDeTrabalhoModel) {
		try {
			postoDAO.criar(postoDeTrabalhoModel);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@PutMapping("/postos/{id}")
	public boolean atualizarPosto(@PathVariable Integer id, @RequestBody PostoDeTrabalhoModel postoDeTrabalhoModel) {
		try {
			postoDeTrabalhoModel.setIdPosto(id);
			postoDAO.atualizar(postoDeTrabalhoModel);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@DeleteMapping("/postos/{id}")
	public boolean deletarPosto(@PathVariable int id) {
		postoController.deletarPostoDeTrabalho(id);
		return true;
	}
}

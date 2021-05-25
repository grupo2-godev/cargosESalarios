package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.DAO.PostoDeTrabalhoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.PostoDeTrabalhoModelDTO;

@RestController
public class PostoDeTrabalhoControllerAPI {
	
	PostoDeTrabalhoDAO postoDeTrabalhoDAO = PostoDeTrabalhoDAO.getInstancia();
		
	/**
	 * Retorna um objeto do tipo {@link PostoDeTrabalhoModel} que contenha o id igual ao id
	 * recebido no parameto.
	 * @param id Integer Id do objeto a ser consultado.
	 * @return PostoDeTrabalhoModelDTO: criado a partir do objeto encontrado no banco de dados.
	 * 
	 * @author Bruno Marques
	 * @author Vanderlei Kleinschmidt
	 */
	@GetMapping("/postos/{id}")
	public PostoDeTrabalhoModelDTO buscarPorID(@PathVariable Integer id){
		return new PostoDeTrabalhoModelDTO(postoDeTrabalhoDAO.buscar(PostoDeTrabalhoModel.class, id));
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
		for (PostoDeTrabalhoModel postoDeTrabalhoModel : postoDeTrabalhoDAO.listarPorTabela(PostoDeTrabalhoModel.class)) {
			postosDTO.add(new PostoDeTrabalhoModelDTO(postoDeTrabalhoModel));
		}
		return postosDTO;
	}
}

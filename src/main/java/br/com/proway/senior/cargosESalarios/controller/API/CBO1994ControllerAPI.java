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

import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CBO1994DAO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

@RestController
public class CBO1994ControllerAPI {
	
	CBO1994Controller cbo1994Controller = CBO1994Controller.getInstancia();
	CBO1994DAO cbo1994DAO = CBO1994DAO.getInstancia();

	/**
	 * <h1>Busca um {@link CBO1994Model} por codigo</h1>
	 * 
	 * <p>
	 * Recebe um codigo, busca um {@link CBO1994Model} atraves do
	 * {@link CBO1994Controller} e retorna esse
	 * {@link CBO1994Model}.
	 * </p>
	 * 
	 * @param id Integer - Referente ao id informado
	 * 
	 * @return {@link CBO1994Model} - Referente ao
	 *         {@link CBO1994Model} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see CBO1994Model
	 * @see CBO1994Controller
	 */
	@GetMapping("/CBO1994/{id}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer codigo) {
		try {
			CBO1994Model cbo1994 = cbo1994Controller.buscarCBO1994(codigo);
			return ResponseEntity.ok(cbo1994);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código do CBO1994 invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link CBO1994Model}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link CBO1994Model} através do
	 * {@link CBO1994Controller}. Retorna um ArrayList de
	 * {@link CBO1994Model}.
	 * </p>
	 * 
	 * @return ArrayList {@link CBO1994Model} - Referente a todos os
	 *         {@link CBO1994Model} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see CBO1994Model
	 * @see CBO1994Controller
	 */
	@GetMapping("/CBO1994/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<CBO1994Model> CBO1994 = new ArrayList<CBO1994Model>();
		for (CBO1994Model cbo1994Model : cbo1994Controller.buscarTodosCBO1994()) {
			CBO1994.add(cbo1994Model);
		}
		if(CBO1994.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum CBO1994 cadastrado");
		}
		return ResponseEntity.ok(CBO1994);
	}

	
	/**
	 * <h1>Insere um {@link CBO1994Model}.</h1>
	 * 
	 * <p>
	 * Recebe um {@link CBO1994Model} e o insere no banco através do
	 * {@link CBO1994Controller}. Retorna true caso tudo tenha dado certo.
	 * </p>
	 * 
	 * @param cbo1994Model {@link CBO1994Model} - Referente ao
	 *              {@link CBO1994Model} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @throws Exception - Caso aconteça algum erro
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see CBO1994Model
	 * @see CBO1994Controller
	 */
	@PostMapping("/CBO1994")
	public ResponseEntity<?> inserirCBO1994(@RequestBody CBO1994Model cbo1994Model) throws Exception {
		try {
			Integer setorID = cbo1994Controller.cadastrarCBO1994(cbo1994Model.getCodigo_cbo(), 
					cbo1994Model.getDescricao(), Insalubridade.getValor(cbo1994Model.getPercentualInsalubridade()),
					Periculosidade.getValor(cbo1994Model.getPercentualPericulosidade()));
			return ResponseEntity.ok(setorID);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Confira a sintaxe do JSON no corpo da requisição!");
		}
	}

	/**
	 * <h1>Atualiza um {@link CBO1994Model}.</h1>
	 * 
	 * <p>
	 * Recebe um codigo e um {@link CBO1994Model}, atualiza o
	 * {@link CBO1994Model} referente o codigo informado
	 * </p>
	 * 
	 * @param codigo    Integer - Referente ao codigo informado
	 * @param cbo1994Model {@link CBO1994Model} - Referente ao
	 *              {@link CBO1994Model} informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see CBO1994Model
	 * @see CBO1994Controller
	 */
	@PutMapping("/CBO1994/{id}")
	public ResponseEntity<?> atualizarCBO1994(@PathVariable Integer codigo, @RequestBody CBO1994Model cbo1994) {
		try {
			cbo1994.setCodigo_cbo(codigo);
			boolean atualizou = cbo1994Controller.atualizarCBO1994(codigo, cbo1994.getDescricao(), 
					Insalubridade.getValor(cbo1994.getPercentualInsalubridade()),
					Periculosidade.getValor(cbo1994.getPercentualPericulosidade()));
			return ResponseEntity.ok(atualizou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Codigo do CBO1994 invalido");
		}
	}

	/**
	 * <h1>Deleta um {@link CBO1994Model}.</h1>
	 * 
	 * <p>
	 * Recebe um codigo e deleta o {@link CBO1994Model} referente ao id
	 * informado. Faz isso usando o {@link CBO1994Controller}.
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
			boolean deletou = cbo1994Controller.deletarSetor(id);
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
			for (SetorModel setorModel : cbo1994Controller.buscarSetorPorNome(nome)) {
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

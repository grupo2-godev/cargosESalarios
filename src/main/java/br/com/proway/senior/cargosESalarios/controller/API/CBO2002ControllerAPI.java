package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.CBO2002Controller;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.DAO.CBO2002DAO;

@RestController
@CrossOrigin
public class CBO2002ControllerAPI {

	CBO2002Controller cbo2002Controller = CBO2002Controller.getInstancia();
	CBO2002DAO cbo2002DAO = CBO2002DAO.getInstancia();

	/**
	 * <h1>Busca um {@link CBO2002Model} por codigo</h1>
	 * 
	 * <p>
	 * Recebe um codigo, busca um {@link CBO2002Model} atraves do
	 * {@link CBO2002Controller} e retorna esse {@link CBO2002Model}.
	 * </p>
	 * 
	 * @param codigo Integer - Referente ao id informado
	 * 
	 * @return {@link CBO2002Model} - Referente ao {@link CBO2002Model} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller
	 */
	@GetMapping("/CBO2002/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer codigo) {
		try {
			CBO2002Model cbo2002 = cbo2002Controller.buscarCBO2002PorCodigo(codigo);
			return ResponseEntity.ok(cbo2002);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código do CBO2002 invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link CBO2002Model}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link CBO2002Model} através do {@link CBO2002Controller}.
	 * Retorna um ArrayList de {@link CBO2002Model}.
	 * </p>
	 * 
	 * @return ArrayList {@link CBO2002Model} - Referente a todos os
	 *         {@link CBO2002Model} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller
	 */
	@GetMapping("/CBO2002/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<CBO2002Model> CBO2002Model = new ArrayList<CBO2002Model>();
		for (CBO2002Model cbo2002Model : cbo2002Controller.buscarTodosCBO2002()) {
			CBO2002Model.add(cbo2002Model);
		}
		if (CBO2002Model.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum CBO2002 cadastrado");
		}
		return ResponseEntity.ok(CBO2002Model);
	}

	/**
	 * <h1>Insere um {@link CBO2002Model}.</h1>
	 * 
	 * <p>
	 * Recebe um {@link CBO2002Model} e o insere no banco através do
	 * {@link CBO2002Controller}. Retorna true caso tudo tenha dado certo.
	 * </p>
	 * 
	 * @param cbo2002Model {@link CBO2002Model} - Referente ao {@link CBO2002Model}
	 *                     informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @throws Exception - Caso aconteça algum erro
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller
	 */
	@PostMapping("/CBO2002")
	public ResponseEntity<?> inserirCBO2002(@RequestBody CBO2002Model cbo2002Model) throws Exception {
		try {
			Integer setorID = cbo2002Controller.cadastrarCBO2002(cbo2002Model.getCodigoCBO2002(),
					cbo2002Model.getDescricao(), cbo2002Model.getPercentualInsalubridade(),
					cbo2002Model.getPercentualPericulosidade());
			return ResponseEntity.ok(setorID);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Confira a sintaxe do JSON no corpo da requisição!");
		}
	}

	/**
	 * <h1>Atualiza um {@link CBO2002Model}.</h1>
	 * 
	 * <p>
	 * Recebe um codigo e um {@link CBO2002Model}, atualiza o {@link CBO2002Model}
	 * referente o codigo informado
	 * </p>
	 * 
	 * @param codigo       Integer - Referente ao codigo informado
	 * @param cbo2002 {@link CBO2002Model} - Referente ao {@link CBO2002Model}
	 *                     informado
	 * 
	 * @return boolean - true caso de certo, false caso contrário
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller
	 */
	@PutMapping("/CBO2002/{codigo}")
	public ResponseEntity<?> atualizarCBO2002(@PathVariable Integer codigo, @RequestBody CBO2002Model cbo2002) {
		try {
			cbo2002.setCodigoCBO2002(codigo);
			boolean atualizou = cbo2002Controller.atualizarCBO2002(codigo, cbo2002.getDescricao(),
					cbo2002.getPercentualInsalubridade(),
					cbo2002.getPercentualPericulosidade());
			return ResponseEntity.ok(atualizou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Codigo do CBO2002 invalido");
		}
	}

	/**
	 * <h1>Deleta um {@link CBO2002Model}.</h1>
	 * 
	 * <p>
	 * Recebe um codigo e deleta o {@link CBO2002Model} referente ao id informado.
	 * Faz isso usando o {@link CBO2002Controller}.
	 * </p>
	 * 
	 * @param codigo Integer - Referente ao codigo informado
	 * 
	 * @return boolean - true caso de certo false caso contrário
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller
	 */
	@DeleteMapping("/CBO2002/{codigo}")
	public ResponseEntity<?> deletarCBO2002(@PathVariable int codigo) {
		try {
			boolean deletou = cbo2002Controller.deletarCBO2002(codigo);
			return ResponseEntity.ok(deletou);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Codigo de CBO2002 invalido");
		}
	}

	/**
	 * <h1>Busca {@link CBO2002Model} pelo nome.</h1>
	 * 
	 * <p>
	 * Recebe uma nome e exibe os registros da tabela selecionados por essa
	 * descricao do {@link CBO2002Model}. Faz isso através do
	 * {@link CBO2002Controller#buscarCBO2002PorDescricaoParcial(String)} (String)}.
	 * </p>
	 * 
	 * @param descricao String - Referente a descricao informada
	 * 
	 * @return {@link ArrayList} {@link CBO1994Model} - Referente aos
	 *         {@link CBO1994Model} encontrados
	 * 
	 * @throws Exception - Caso o nome for inválido
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint
	 *         7
	 * 
	 * @version sprint7
	 * 
	 * @see CBO2002Model
	 * @see CBO2002Controller#buscarCBO2002PorDescricaoParcial(String)
	 */
	@GetMapping("/CBO2002")
	public ResponseEntity<?> buscarCBO2002PelaDescricao(@RequestParam String descricao) throws Exception {
		if (descricao == null) {
			return buscarTodos();
		}
		try {
			ArrayList<CBO2002Model> cbo2002Lista = cbo2002Controller.buscarCBO2002PorDescricaoParcial(descricao);
			if (cbo2002Lista.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum CBO2002 cadastrado");
			}
			return ResponseEntity.ok(cbo2002Lista);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Descricao invalida");
		}
	}

}

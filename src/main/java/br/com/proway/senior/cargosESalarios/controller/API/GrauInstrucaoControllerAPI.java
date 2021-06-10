package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.GrauInstrucaoController;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;

@RestController
@CrossOrigin
public class GrauInstrucaoControllerAPI {

	GrauInstrucaoController grauInstrucaoController = GrauInstrucaoController.getInstancia();

	/**
	 * <h1>Busca um {@link GrauInstrucaoModel} por codigo</h1>
	 * 
	 * <p>
	 * Recebe um codigo, busca um {@link GrauInstrucaoModel} atraves do
	 * {@link GrauInstrucaoController} e retorna esse
	 * {@link GrauInstrucaoModel}.
	 * </p>
	 * 
	 * @param codigo Integer - Referente ao id informado
	 * 
	 * @return {@link GrauInstrucaoModel} - Referente ao
	 *         {@link GrauInstrucaoModel} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see GrauInstrucaoModel
	 * @see GrauInstrucaoController
	 */
	@GetMapping("/grauinstrucao/{id}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
		try {
			GrauInstrucaoModel grauInstrucaoModel = grauInstrucaoController.buscarInstrucaoPorID(id);
			return ResponseEntity.ok(grauInstrucaoModel);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID do grau de instrucao invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link GrauInstrucaoModel}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link GrauInstrucaoModel} através do
	 * {@link GrauInstrucaoController}. Retorna um ArrayList de
	 * {@link GrauInstrucaoModel}.
	 * </p>
	 * 
	 * @return ArrayList {@link GrauInstrucaoModel} - Referente a todos os
	 *         {@link GrauInstrucaoModel} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see GrauInstrucaoModel
	 * @see GrauInstrucaoController
	 */
	@GetMapping("/grauinstrucao/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<GrauInstrucaoModel> graus = new ArrayList<GrauInstrucaoModel>();
		for (GrauInstrucaoModel grauInstrucaoModel : grauInstrucaoController.buscarTodasInstrucoes()) {
			graus.add(grauInstrucaoModel);
		}
		if(graus.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum grau de instrucao cadastrado");
		}
		return ResponseEntity.ok(graus);
	}
}

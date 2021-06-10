package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.NivelController;
import br.com.proway.senior.cargosESalarios.model.NivelModel;

@RestController
public class NivelControllerAPI {
	NivelController nivelController = NivelController.getInstancia();

	/**
	 * <h1>Busca um {@link NivelModel} por codigo</h1>
	 * 
	 * <p>
	 * Recebe um codigo, busca um {@link NivelModel} atraves do
	 * {@link NivelController} e retorna esse
	 * {@link NivelModel}.
	 * </p>
	 * 
	 * @param codigo Integer - Referente ao id informado
	 * 
	 * @return {@link NivelModel} - Referente ao
	 *         {@link NivelModel} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see NivelModel
	 * @see NivelController
	 */
	@GetMapping("/nivel/{id}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
		try {
			NivelModel nivel = nivelController.buscarNivel(id);
			return ResponseEntity.ok(nivel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID do nivel de escolaridade invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link NivelModel}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link NivelModel} através do
	 * {@link NivelController}. Retorna um ArrayList de
	 * {@link NivelModel}.
	 * </p>
	 * 
	 * @return ArrayList {@link NivelModel} - Referente a todos os
	 *         {@link NivelModel} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see NivelModel
	 * @see NivelController
	 */
	@GetMapping("/nivel/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<NivelModel> niveis = new ArrayList<NivelModel>();
		for (NivelModel nivelModel : nivelController.buscarTodosNiveis()) {
			niveis.add(nivelModel);
		}
		if(niveis.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhum nivel de escolaridade cadastrado");
		}
		return ResponseEntity.ok(niveis);
	}
}

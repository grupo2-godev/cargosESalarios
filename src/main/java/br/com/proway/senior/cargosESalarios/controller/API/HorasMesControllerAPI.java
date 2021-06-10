package br.com.proway.senior.cargosESalarios.controller.API;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.cargosESalarios.controller.HorasMesController;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

@RestController
@CrossOrigin
public class HorasMesControllerAPI {
	HorasMesController horasMesController = HorasMesController.getInstancia();

	/**
	 * <h1>Busca um {@link HorasMesModel} por codigo</h1>
	 * 
	 * <p>
	 * Recebe um codigo, busca um {@link HorasMesModel} atraves do
	 * {@link HorasMesController} e retorna esse
	 * {@link HorasMesModel}.
	 * </p>
	 * 
	 * @param codigo Integer - Referente ao id informado
	 * 
	 * @return {@link HorasMesModel} - Referente ao
	 *         {@link HorasMesModel} encontrado
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see HorasMesModel
	 * @see HorasMesController
	 */
	@GetMapping("/horasmes/{id}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
		try {
			HorasMesModel nivel = horasMesController.buscarHorasMes(id);
			return ResponseEntity.ok(nivel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID das horas-mês invalido");
		}
	}

	/**
	 * <h1>Busca todos os {@link HorasMesModel}.</h1>
	 * 
	 * <p>
	 * Busca todos os {@link HorasMesModel} através do
	 * {@link HorasMesController}. Retorna um ArrayList de
	 * {@link HorasMesModel}.
	 * </p>
	 * 
	 * @return ArrayList {@link HorasMesModel} - Referente a todos os
	 *         {@link HorasMesModel} encontrados
	 * 
	 * @author Vitor Gonçalves <strong>vitor.goncalves@senior.com.br</strong> Sprint 7
	 * 
	 * @see HorasMesModel
	 * @see HorasMesController
	 */
	@GetMapping("/horasmes/all")
	public ResponseEntity<?> buscarTodos() {
		ArrayList<HorasMesModel> horasMes = new ArrayList<HorasMesModel>();
		for (HorasMesModel horaMes : horasMesController.buscarTodosHorasMes()) {
			horasMes.add(horaMes);
		}
		if(horasMes.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhuma opção de horas-mês cadastrada");
		}
		return ResponseEntity.ok(horasMes);
	}
}

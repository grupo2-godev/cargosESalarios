package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CargoModel;

/**
 * Classe que testa os metodos da classe {@link CargoController}.
 * 
 * @author Janaina Mai <b>janaina.mai@senior.com.br</b> - Sprint 5
 *
 */
public class CargoControllerTest {

	CargoController controller = new CargoController();

	@Test
	public void testCadastrar() {
		assertEquals(0, controller.buscarTodos().size());

		String nomeCargo = "Desenvolvedor 2";
		LocalDateTime dataCadastro = LocalDateTime.now();
		LocalDateTime dataUltimaRevisao = LocalDateTime.now();
		Integer cbo2002 = 0;
		Integer cbo94 = 0;
		Integer horasMes = 220;
		Integer grauInstrucao = 0;
		String experienciaMinima = "1";
		String atribuicoes = "Desenvolvedor";
		Boolean status = true;
		Integer idPermissao = 1;

		assertTrue(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(1, controller.buscarTodos().size());
		controller.deletarTodos();

		String nomeCargoVazio = "";
		assertFalse(controller.cadastrar(nomeCargoVazio, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		Integer cbo2002Zero = 0;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002Zero, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		Integer cbo94Zero = 0;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94Zero, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		Integer horasMesZero = 0;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMesZero,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());

		Integer grauInstrucaoZero = 0;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucaoZero, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		String experienciaMinimaVazio = "";
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinimaVazio, atribuicoes, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		String atribuicoesVazio = "";
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoesVazio, status, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		Boolean statusNulo = null;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, statusNulo, idPermissao));
		assertEquals(0, controller.buscarTodos().size());
		
		Integer idPermissaoZero = 0;
		assertFalse(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissaoZero));
		assertEquals(0, controller.buscarTodos().size());
		
		
	}

}

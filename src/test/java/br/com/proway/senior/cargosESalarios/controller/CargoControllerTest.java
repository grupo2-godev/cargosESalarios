package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

	String nomeCargo = "Desenvolvedor 2";
	LocalDateTime dataCadastro = LocalDateTime.now();
	LocalDateTime dataUltimaRevisao = LocalDateTime.now();
	Integer cbo2002 = 1;
	Integer cbo94 = 1;
	Integer horasMes = 220;
	Integer grauInstrucao = 1;
	String experienciaMinima = "1";
	String atribuicoes = "Desenvolvedor";
	Boolean status = true;
	Integer idPermissao = 1;
	
	@Test
	public void testCadastrar() {
		assertEquals(0, controller.buscarTodos().size());

		assertNotNull(controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao));
		assertEquals(1, controller.buscarTodos().size());
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarNomeInvalido() throws Exception {
		String nomeCargoVazio = "";
	controller.cadastrar(nomeCargoVazio, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarCbo2002Invalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, 0, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
	}

	@Test(expected = Exception.class)
	public void testCadastrarCbo94Invalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, 0, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarHorasMesInvalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, 0,
				grauInstrucao, experienciaMinima, atribuicoes, status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarGrauInstrucaoInvalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				0, experienciaMinima, atribuicoes, status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarExperienciaMinimaInvalida() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, "", atribuicoes, status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarAtribuicoesInvalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, "", status, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarStatusInvalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, null, idPermissao);
	}
	
	@Test(expected = Exception.class)
	public void testCadastrarIdPermissaoInvalido() throws Exception {
		controller.cadastrar(nomeCargo, dataCadastro, dataUltimaRevisao, cbo2002, cbo94, horasMes,
				grauInstrucao, experienciaMinima, atribuicoes, status, 0);
	}
}














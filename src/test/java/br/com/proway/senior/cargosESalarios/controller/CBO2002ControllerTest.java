package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import utils.Insalubridade;
import utils.Periculosidade;

/**
 * Classe CBO2002ControllerTest
 * 
 * Realiza os testes dos metodos da classe CBO2002Controller {@link CBO2002Controller}.
 * 
 * @author Sarah Brito <b>sarah.brito@senior.com.br</b> - Sprint 5
 */
public class CBO2002ControllerTest {

	CBO2002Controller cboController = new CBO2002Controller();

	@Test
	public void testCadastrarCBO2002Correto() throws Exception {
		Integer codigo = cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, 
				Periculosidade.Zero);
		CBO2002Model cboRecuperado = cboController.buscarSetorPorId(codigo);
		assertEquals((Integer) 123456, cboRecuperado.getCodigoCBO2002());
		assertEquals("Gerente de Loja", cboRecuperado.getDescricao());
		assertEquals(0.1, cboRecuperado.getPercentualInsalubridade(), 0.01);
		assertEquals(0.0, cboRecuperado.getPercentualPericulosidade(), 0.01);
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarCBO2002ExceptionJaCadastrado() throws Exception {
		cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, 
				Periculosidade.Zero);
		cboController.cadastrarCBO2002(123456, "Gerente de Estoque", Insalubridade.Dez, 
				Periculosidade.Zero);
	}
	
	@Test (expected = Exception.class)
	public void testCadastrarCBO2002ExceptionCodigoInvalido() throws Exception {
		cboController.cadastrarCBO2002(1234567, "Gerente de Loja", Insalubridade.Dez, 
				Periculosidade.Zero);
	}

	@Test
	public void testBuscarCBO2002PorCodigo() throws Exception {
		Integer codigo = cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, Periculosidade.Zero);
		CBO2002Model cboRecuperado = cboController.buscarSetorPorId(codigo);
		assertEquals((Integer) 123456, cboRecuperado.getCodigoCBO2002());
		assertEquals("Gerente de Loja", cboRecuperado.getDescricao());
		assertEquals(0.1, cboRecuperado.getPercentualInsalubridade(), 0.01);
		assertEquals(0.0, cboRecuperado.getPercentualPericulosidade(), 0.01);
	}
	
	@Test
	public void testBuscarCBO2002PorDescricao() throws Exception {
		cboController.cadastrarCBO2002(375115, "Visual Merchandiser", Insalubridade.Dez, Periculosidade.Zero);
		ArrayList<CBO2002Model> cboRecuperado = cboController.buscarCBO2002PorNome("Mer");
		assertEquals((Integer) 375115, cboRecuperado.get(0).getCodigoCBO2002());
		assertEquals("Visual Merchandiser", cboRecuperado.get(0).getDescricao());
		assertEquals(0.1, cboRecuperado.get(0).getPercentualInsalubridade(), 0.01);
		assertEquals(0.0, cboRecuperado.get(0).getPercentualPericulosidade(), 0.01);
	}
	
}

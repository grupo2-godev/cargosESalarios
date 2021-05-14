package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import utils.Insalubridade;
import utils.Periculosidade;

public class CBO2002ControllerTest {

	CBO2002Controller cboController = new CBO2002Controller();

	@Test
	public void testCadastrarCBO2002() {
		Integer codigo = cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, 
				Periculosidade.Zero);
		CBO2002Model cboRecuperado = cboController.buscarSetorPorId(codigo);
		assertEquals((Integer) 123456, cboRecuperado.getCodigoCBO2002());
		assertEquals("Gerente de Loja", cboRecuperado.getDescricao());
		assertEquals(0.1, cboRecuperado.getPercentualInsalubridade(), 0.01);
		assertEquals(0.0, cboRecuperado.getPercentualPericulosidade(), 0.01);
	}

	@Test
	public void testBuscarCBO2002PorCodigo() {
		Integer codigo = cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, Periculosidade.Zero);
		CBO2002Model cboRecuperado = cboController.buscarSetorPorId(codigo);
		assertEquals((Integer) 123456, cboRecuperado.getCodigoCBO2002());
		assertEquals("Gerente de Loja", cboRecuperado.getDescricao());
		assertEquals(0.1, cboRecuperado.getPercentualInsalubridade(), 0.01);
		assertEquals(0.0, cboRecuperado.getPercentualPericulosidade(), 0.01);
	}
}

package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import utils.Insalubridade;
import utils.Periculosidade;

public class CBO2002ControllerTest {

	CBO2002Controller cboController = new CBO2002Controller();

	@Test
	public void testCadastrarCBO2002() {
		Integer codigo = cboController.cadastrarCBO2002(123456, "Gerente de Loja", Insalubridade.Dez, 
				Periculosidade.Zero);
		
	}

}

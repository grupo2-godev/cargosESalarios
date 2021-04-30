package br.com.proway.senior.cargosESalarios.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.model.CargoDaoAl;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.Cbo1994Model;
import br.com.proway.senior.cargosESalarios.model.Cbo2002Model;
import br.com.proway.senior.cargosESalarios.model.GrauDeInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;

public class CargoControllerTest {

	CargoController controller = new CargoController();
	CargoDaoAl dao = new CargoDaoAl();
	GrauDeInstrucaoModel gi = new GrauDeInstrucaoModel();
	Cbo2002Model cbo2002 = new Cbo2002Model();
	Cbo1994Model cbo1994 = new Cbo1994Model();
	HorasMesModel hm = new HorasMesModel();
	
	@Before
	public void limparArray() {
		dao.limparArray();
		
	}
	
	@Test
	public void testCadastroCargoTrue() {	
		CargoModel cm = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		cm.setIdCargo(0);
		controller.cadastrarCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		assertEquals(cm, dao.retrieve("Gerente"));
	}
	
	@Test
	public void testDeletarCargo() {
		controller.cadastrarCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		assertTrue(controller.deletarCargo(0));
		
	}
	
	@Test
	public void testAtualizarCargo() {
		controller.cadastrarCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);	
		CargoModel cargoAtualizado = dao.retrieve(0);
		controller.atualizarCargo(0, "Analista de Dados", LocalDateTime.now(), true, 1);
		assertEquals("Analista de Dados", cargoAtualizado.getNomeCargo());
		assertEquals(true, cargoAtualizado.getStatus());
		Integer permissao = 2;
		assertNotEquals(permissao, cargoAtualizado.getIdPermissao());		
	}
	
	@Test
	public void testBuscarCargoPorID() {
		CargoModel novoCargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		dao.create(novoCargo);
		controller.cadastrarCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		assertEquals(novoCargo, controller.buscarCargoId(0));
	}
	
	@Test
	public void testBuscarCargoPorNome() {
		CargoModel novoCargo = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		dao.create(novoCargo);
		controller.cadastrarCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		assertEquals(novoCargo, controller.buscarCargoNome("Gerente"));
	}
	
	@Test
	public void testBuscarTodosCargos() {
		CargoModel novoCargo1 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		dao.create(novoCargo1);
		CargoModel novoCargo2 = new CargoModel("Gerente", LocalDateTime.now(), LocalDateTime.now(),
				cbo2002, cbo1994, hm, gi, "12 meses", "Desenvolvedor", true, 1);
		dao.create(novoCargo2);
		
		assertEquals(2, controller.buscarTodosCargos().size());
	}

}
